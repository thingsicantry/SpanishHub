package com.example.data.repository

import com.example.data.local.AppDatabase
import com.example.data.local.entity.LessonProgressEntity
import com.example.data.local.entity.MistakeEntity
import com.example.data.local.entity.UserSettingsEntity
import com.example.data.local.entity.VocabProgressEntity
import kotlinx.coroutines.flow.Flow
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProgressRepository(private val database: AppDatabase) {

    val allProgress: Flow<List<LessonProgressEntity>> = database.lessonProgressDao().getAllProgress()
    val allMistakes: Flow<List<MistakeEntity>> = database.mistakeDao().getAllMistakes()
    val allVocabProgress: Flow<List<VocabProgressEntity>> = database.vocabProgressDao().getAllVocabProgress()
    val userSettings: Flow<UserSettingsEntity?> = database.userSettingsDao().getUserSettings()

    suspend fun saveLessonCompletion(lessonId: String, levelId: Int, score: Int) {
        val existing = database.lessonProgressDao().getProgressForLesson(lessonId)
        val attempts = (existing?.attempts ?: 0) + 1
        val newScore = if (existing != null) maxOf(existing.score, score) else score
        val entity = LessonProgressEntity(
            lessonId = lessonId,
            levelId = levelId,
            isCompleted = true,
            score = newScore,
            attempts = attempts,
            lastAttemptTimestamp = System.currentTimeMillis()
        )
        database.lessonProgressDao().insertOrUpdate(entity)
        checkAndUnlockNextLevel()
        updateStreak()
    }

    suspend fun recordMistake(
        prompt: String,
        studentAnswer: String,
        correctAnswer: String,
        explanation: String,
        category: String,
        levelId: Int
    ) {
        val mistake = MistakeEntity(
            spanishPrompt = prompt,
            studentAnswer = studentAnswer,
            correctAnswer = correctAnswer,
            explanation = explanation,
            category = category,
            levelId = levelId,
            timestamp = System.currentTimeMillis(),
            reviewedCount = 0
        )
        database.mistakeDao().insertMistake(mistake)
    }

    suspend fun markMistakeReviewed(mistakeId: Long) {
        val mistakes = database.mistakeDao().getMistakesForReview(100)
        val target = mistakes.find { it.id == mistakeId }
        if (target != null) {
            database.mistakeDao().updateMistake(target.copy(reviewedCount = target.reviewedCount + 1))
        }
    }

    suspend fun clearMistake(mistakeId: Long) {
        database.mistakeDao().deleteMistake(mistakeId)
    }

    suspend fun toggleVocabStarred(wordId: String) {
        val existing = database.vocabProgressDao().getVocabProgress(wordId)
        val updated = if (existing != null) {
            existing.copy(isStarred = !existing.isStarred)
        } else {
            VocabProgressEntity(wordId = wordId, isStarred = true)
        }
        database.vocabProgressDao().insertOrUpdate(updated)
    }

    suspend fun markVocabLearned(wordId: String, isLearned: Boolean) {
        val existing = database.vocabProgressDao().getVocabProgress(wordId)
        val updated = if (existing != null) {
            existing.copy(
                isLearned = isLearned,
                reviewCount = existing.reviewCount + 1,
                lastReviewedTimestamp = System.currentTimeMillis()
            )
        } else {
            VocabProgressEntity(
                wordId = wordId,
                isLearned = isLearned,
                reviewCount = 1,
                lastReviewedTimestamp = System.currentTimeMillis()
            )
        }
        database.vocabProgressDao().insertOrUpdate(updated)
    }

    suspend fun updateTtsSpeed(speed: Float) {
        val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        database.userSettingsDao().saveUserSettings(current.copy(ttsSpeed = speed))
    }

    suspend fun incrementSpeakingSessions() {
        val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        database.userSettingsDao().saveUserSettings(current.copy(speakingSessionsCount = current.speakingSessionsCount + 1))
        updateStreak()
    }

    private suspend fun updateStreak() {
        val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        val todayStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        if (current.lastActiveDate != todayStr) {
            val newStreak = if (current.lastActiveDate.isEmpty()) 1 else current.streakDays + 1
            database.userSettingsDao().saveUserSettings(
                current.copy(
                    streakDays = newStreak,
                    lastActiveDate = todayStr,
                    completedExercisesCount = current.completedExercisesCount + 1
                )
            )
        } else {
            database.userSettingsDao().saveUserSettings(
                current.copy(
                    completedExercisesCount = current.completedExercisesCount + 1
                )
            )
        }
    }

    private suspend fun checkAndUnlockNextLevel() {
        val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        // Level unlocks can also be manually selected or unlocked when 3+ lessons of the current level are done
        // Ensure default at least Level 1
        if (current.currentLevel < 1) {
            database.userSettingsDao().saveUserSettings(current.copy(currentLevel = 1))
        }
    }

    suspend fun setCurrentLevel(level: Int) {
        val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        database.userSettingsDao().saveUserSettings(current.copy(currentLevel = level.coerceIn(1, 4)))
    }

    suspend fun exportProgressToJson(): String {
        val settings = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
        val mistakes = database.mistakeDao().getMistakesForReview(500)

        val root = JSONObject()
        root.put("version", 1)
        root.put("exportDate", System.currentTimeMillis())

        val settingsJson = JSONObject()
        settingsJson.put("currentLevel", settings.currentLevel)
        settingsJson.put("streakDays", settings.streakDays)
        settingsJson.put("completedExercisesCount", settings.completedExercisesCount)
        settingsJson.put("speakingSessionsCount", settings.speakingSessionsCount)
        root.put("settings", settingsJson)

        val mistakesArray = JSONArray()
        for (m in mistakes) {
            val obj = JSONObject()
            obj.put("prompt", m.spanishPrompt)
            obj.put("studentAnswer", m.studentAnswer)
            obj.put("correctAnswer", m.correctAnswer)
            obj.put("explanation", m.explanation)
            obj.put("category", m.category)
            obj.put("levelId", m.levelId)
            mistakesArray.put(obj)
        }
        root.put("mistakes", mistakesArray)

        return root.toString(2)
    }

    suspend fun importProgressFromJson(jsonString: String): Boolean {
        return try {
            val root = JSONObject(jsonString)
            if (root.has("settings")) {
                val s = root.getJSONObject("settings")
                val current = database.userSettingsDao().getUserSettingsDirect() ?: UserSettingsEntity()
                database.userSettingsDao().saveUserSettings(
                    current.copy(
                        currentLevel = s.optInt("currentLevel", 1),
                        streakDays = s.optInt("streakDays", 1),
                        completedExercisesCount = s.optInt("completedExercisesCount", 0),
                        speakingSessionsCount = s.optInt("speakingSessionsCount", 0)
                    )
                )
            }
            if (root.has("mistakes")) {
                val array = root.getJSONArray("mistakes")
                for (i in 0 until array.length()) {
                    val obj = array.getJSONObject(i)
                    database.mistakeDao().insertMistake(
                        MistakeEntity(
                            spanishPrompt = obj.optString("prompt"),
                            studentAnswer = obj.optString("studentAnswer"),
                            correctAnswer = obj.optString("correctAnswer"),
                            explanation = obj.optString("explanation"),
                            category = obj.optString("category"),
                            levelId = obj.optInt("levelId", 1)
                        )
                    )
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }
}
