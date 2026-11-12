package com.example.data.model

data class ChatMessage(
    val id: String,
    val sender: String, // "user" or "tutor"
    val spanishText: String,
    val englishTranslation: String? = null,
    val feedback: String? = null,
    val suggestions: List<String> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
)

data class SpeakingScenario(
    val id: String,
    val levelId: Int,
    val title: String,
    val description: String,
    val tutorRole: String,
    val studentGoal: String,
    val initialTutorGreeting: String,
    val initialTutorTranslation: String,
    val samplePhrases: List<String>
)
