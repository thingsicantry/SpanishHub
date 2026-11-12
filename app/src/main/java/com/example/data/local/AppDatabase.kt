package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.LessonProgressDao
import com.example.data.local.dao.MistakeDao
import com.example.data.local.dao.UserSettingsDao
import com.example.data.local.dao.VocabProgressDao
import com.example.data.local.entity.LessonProgressEntity
import com.example.data.local.entity.MistakeEntity
import com.example.data.local.entity.UserSettingsEntity
import com.example.data.local.entity.VocabProgressEntity

@Database(
    entities = [
        LessonProgressEntity::class,
        MistakeEntity::class,
        VocabProgressEntity::class,
        UserSettingsEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lessonProgressDao(): LessonProgressDao
    abstract fun mistakeDao(): MistakeDao
    abstract fun vocabProgressDao(): VocabProgressDao
    abstract fun userSettingsDao(): UserSettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "spanish_tutor_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
