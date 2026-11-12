package com.example.data.model

enum class ExerciseType {
    TRANSLATE_EN_TO_ES,
    TRANSLATE_ES_TO_EN,
    FILL_IN_BLANK,
    CHOOSE_VERB,
    CORRECT_SENTENCE,
    SENTENCE_BUILDER,
    CONVERSATION_REPLY
}

data class QuizQuestion(
    val id: String,
    val type: ExerciseType,
    val prompt: String,
    val blankSentence: String? = null,
    val options: List<String> = emptyList(),
    val wordsToArrange: List<String> = emptyList(),
    val expectedAnswers: List<String>,
    val hint: String? = null,
    val explanation: String
)

data class EvaluationResult(
    val isCorrect: Boolean,
    val score: Int, // 0 - 100
    val studentAnswer: String,
    val expectedSentence: String,
    val feedback: String,
    val alternativeExpressions: List<String> = emptyList()
)
