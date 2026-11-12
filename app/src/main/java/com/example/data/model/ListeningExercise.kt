package com.example.data.model

data class ListeningExercise(
    val id: String,
    val levelId: Int,
    val title: String,
    val spanishAudioScript: String,
    val englishTranslation: String,
    val difficulty: String, // e.g. "Slow & Simple", "Conversational"
    val contextNote: String,
    val comprehensionQuestion: String? = null
)
