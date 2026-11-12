package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.local.entity.LessonProgressEntity
import com.example.data.local.entity.MistakeEntity
import com.example.data.local.entity.UserSettingsEntity
import com.example.data.local.entity.VocabProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonProgressDao {
    @Query("SELECT * FROM lesson_progress")
    fun getAllProgress(): Flow<List<LessonProgressEntity>>

    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId LIMIT 1")
    suspend fun getProgressForLesson(lessonId: String): LessonProgressEntity?

    @Query("SELECT * FROM lesson_progress WHERE levelId = :levelId")
    fun getProgressForLevel(levelId: Int): Flow<List<LessonProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(progress: LessonProgressEntity)

    @Query("DELETE FROM lesson_progress")
    suspend fun clearAll()
}

@Dao
interface MistakeDao {
    @Query("SELECT * FROM mistakes ORDER BY timestamp DESC")
    fun getAllMistakes(): Flow<List<MistakeEntity>>

    @Query("SELECT * FROM mistakes WHERE levelId = :levelId ORDER BY timestamp DESC")
    fun getMistakesForLevel(levelId: Int): Flow<List<MistakeEntity>>

    @Query("SELECT * FROM mistakes ORDER BY reviewedCount ASC, timestamp DESC LIMIT :limit")
    suspend fun getMistakesForReview(limit: Int = 10): List<MistakeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMistake(mistake: MistakeEntity): Long

    @Update
    suspend fun updateMistake(mistake: MistakeEntity)

    @Query("DELETE FROM mistakes WHERE id = :id")
    suspend fun deleteMistake(id: Long)

    @Query("DELETE FROM mistakes")
    suspend fun clearAll()
}

@Dao
interface VocabProgressDao {
    @Query("SELECT * FROM vocab_progress")
    fun getAllVocabProgress(): Flow<List<VocabProgressEntity>>

    @Query("SELECT * FROM vocab_progress WHERE wordId = :wordId LIMIT 1")
    suspend fun getVocabProgress(wordId: String): VocabProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(progress: VocabProgressEntity)

    @Query("DELETE FROM vocab_progress")
    suspend fun clearAll()
}

@Dao
interface UserSettingsDao {
    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    fun getUserSettings(): Flow<UserSettingsEntity?>

    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    suspend fun getUserSettingsDirect(): UserSettingsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserSettings(settings: UserSettingsEntity)
}
