package com.example.data.model

data class VocabItem(
    val id: String,
    val spanish: String,
    val english: String,
    val levelId: Int,
    val topic: String, // e.g., "Daily Activities", "Food & Dining", "Travel & Directions", "Family & People", "Time & Dates", "Feelings & Opinions"
    val partOfSpeech: String, // "verb", "noun (m)", "noun (f)", "adjective", "connector", "phrase"
    val gender: String? = null, // "masculine", "feminine", null
    val exampleEs: String,
    val exampleEn: String,
    val conjugations: Map<String, String>? = null // e.g. "yo" -> "quiero", "tú" -> "quieres", etc.
)

data class ReadingPassage(
    val id: String,
    val levelId: Int,
    val title: String,
    val spanishText: String,
    val englishTranslation: String,
    val topic: String,
    val questions: List<QuizQuestion>
)
