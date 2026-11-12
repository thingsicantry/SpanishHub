package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey val lessonId: String,
    val levelId: Int,
    val isCompleted: Boolean,
    val score: Int,
    val attempts: Int,
    val lastAttemptTimestamp: Long
)

@Entity(tableName = "mistakes")
data class MistakeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val spanishPrompt: String,
    val studentAnswer: String,
    val correctAnswer: String,
    val explanation: String,
    val category: String,
    val levelId: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val reviewedCount: Int = 0
)

@Entity(tableName = "vocab_progress")
data class VocabProgressEntity(
    @PrimaryKey val wordId: String,
    val isLearned: Boolean = false,
    val isStarred: Boolean = false,
    val reviewCount: Int = 0,
    val lastReviewedTimestamp: Long = 0
)

@Entity(tableName = "user_settings")
data class UserSettingsEntity(
    @PrimaryKey val id: Int = 1,
    val currentLevel: Int = 1,
    val streakDays: Int = 1,
    val lastActiveDate: String = "",
    val ttsSpeed: Float = 1.0f,
    val completedExercisesCount: Int = 0,
    val speakingSessionsCount: Int = 0
)
