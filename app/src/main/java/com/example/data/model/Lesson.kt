package com.example.data.model

data class LessonExample(
    val spanish: String,
    val english: String,
    val breakdown: String? = null
)

data class Lesson(
    val id: String,
    val levelId: Int,
    val title: String,
    val subtitle: String,
    val durationMinutes: Int = 10,
    val objective: String,
    val plainEnglishRule: String,
    val patternFormula: String,
    val patternFormulaExplanation: String,
    val examples: List<LessonExample>,
    val guidedPractice: List<QuizQuestion>,
    val independentPractice: List<QuizQuestion>,
    val reviewSummary: List<String>,
    val assessmentQuiz: List<QuizQuestion>
)
