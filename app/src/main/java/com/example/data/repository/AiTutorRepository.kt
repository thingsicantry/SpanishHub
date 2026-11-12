package com.example.data.repository

import android.util.Log
import com.example.data.model.EvaluationResult
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.Schema
import com.google.firebase.ai.type.generationConfig
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import org.json.JSONObject

private const val TAG = "AiTutorRepository"

data class SpeakingEvaluation(
    val isUnderstood: Boolean,
    val grammarCorrection: String,
    val naturalAlternative: String,
    val tutorReplyEs: String,
    val tutorReplyEn: String,
    val followUpQuestionEs: String
)

data class ListeningEvaluation(
    val isCorrect: Boolean,
    val score: Int,
    val feedback: String,
    val accurateEnglish: String
)

class AiTutorRepository {

    private val evalSchema = Schema.obj(
        properties = mapOf(
            "isCorrect" to Schema.boolean("True if the answer communicates the meaning correctly with acceptable grammar"),
            "score" to Schema.integer("Score from 0 to 100 based on accuracy, conjugation, gender agreement"),
            "feedback" to Schema.string("Plain English explanation of any mistakes or encouragement"),
            "correctSentence" to Schema.string("The ideal natural Spanish sentence"),
            "alternativeExpressions" to Schema.array(Schema.string(), "Other acceptable ways to say this in Spanish")
        )
    )

    private val speakingSchema = Schema.obj(
        properties = mapOf(
            "isUnderstood" to Schema.boolean("Whether the spoken Spanish is intelligible"),
            "grammarCorrection" to Schema.string("Clear correction of any grammar or conjugation issues in plain English"),
            "naturalAlternative" to Schema.string("A more native or natural Spanish expression for what the student said"),
            "tutorReplyEs" to Schema.string("Tutor conversational reply in Spanish tailored to the student level"),
            "tutorReplyEn" to Schema.string("English translation of the tutor reply"),
            "followUpQuestionEs" to Schema.string("A natural follow-up question in Spanish to keep the dialogue going")
        )
    )

    private val listeningSchema = Schema.obj(
        properties = mapOf(
            "isCorrect" to Schema.boolean("Whether the student understood the key meaning"),
            "score" to Schema.integer("Score from 0 to 100 on comprehension"),
            "feedback" to Schema.string("Plain English explanation of what was understood and any misunderstood nuances"),
            "accurateEnglish" to Schema.string("Natural full English translation of what was spoken")
        )
    )

    private val evalModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = evalSchema
            }
        )
    }

    private val speakingModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = speakingSchema
            }
        )
    }

    private val listeningModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = listeningSchema
            }
        )
    }

    private val explainerModel by lazy {
        Firebase.ai.generativeModel(modelName = "gemini-3.8-flash")
    }

    suspend fun evaluateAnswer(
        questionPrompt: String,
        studentAnswer: String,
        expectedAnswers: List<String>,
        explanationHint: String,
        levelNumber: Int,
        knownMistakes: List<String> = emptyList()
    ): EvaluationResult {
        // Fast path: exact match with one of the pre-configured expected answers
        val normalizedStudent = normalizeSpanish(studentAnswer)
        val matchesExpected = expectedAnswers.any { normalizeSpanish(it) == normalizedStudent }
        if (matchesExpected) {
            return EvaluationResult(
                isCorrect = true,
                score = 100,
                studentAnswer = studentAnswer,
                expectedSentence = expectedAnswers.firstOrNull() ?: studentAnswer,
                feedback = "¡Excelente! Perfectly accurate Spanish.",
                alternativeExpressions = expectedAnswers.filter { normalizeSpanish(it) != normalizedStudent }
            )
        }

        return try {
            withTimeout(30_000L) {
                val prompt = """
                    You are a friendly, encouraging personal Spanish tutor.
                    Student learning level: Level $levelNumber (A1 beginner to A2 developing).
                    Question prompt: "$questionPrompt"
                    Target expected answer(s): ${expectedAnswers.joinToString(" | ")}
                    Grammar note: $explanationHint
                    Student's written answer: "$studentAnswer"
                    Known recent student mistakes: ${knownMistakes.take(3).joinToString("; ")}

                    Evaluate the student's answer.
                    IMPORTANT RULES:
                    1. Distinguish between real errors (wrong conjugation, wrong gender, missing essential words) and acceptable alternative phrasing (e.g. including or omitting subject pronoun 'yo', synonym words like 'carro' vs 'coche', word order variants).
                    2. Accept alternative grammatically correct translations.
                    3. If wrong, explain the mistake in simple, friendly plain English without confusing academic jargon.
                    4. Provide the correct natural Spanish sentence.
                """.trimIndent()

                val response = evalModel.generateContent(prompt)
                val jsonStr = response.text ?: throw IllegalStateException("Empty response")
                val json = JSONObject(jsonStr)

                val altArray = json.optJSONArray("alternativeExpressions")
                val altList = mutableListOf<String>()
                if (altArray != null) {
                    for (i in 0 until altArray.length()) {
                        altList.add(altArray.getString(i))
                    }
                }

                EvaluationResult(
                    isCorrect = json.optBoolean("isCorrect", false),
                    score = json.optInt("score", 70),
                    studentAnswer = studentAnswer,
                    expectedSentence = json.optString("correctSentence", expectedAnswers.firstOrNull() ?: ""),
                    feedback = json.optString("feedback", "Check your verb conjugation and word agreement."),
                    alternativeExpressions = altList
                )
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.w(TAG, "AI evaluation fallback due to: ${e.message}")
            fallbackEvaluate(studentAnswer, expectedAnswers, explanationHint)
        }
    }

    suspend fun evaluateSpeaking(
        scenarioTitle: String,
        studentSpokenText: String,
        tutorContext: String,
        levelNumber: Int,
        conversationHistory: List<String>
    ): SpeakingEvaluation {
        return try {
            withTimeout(35_000L) {
                val prompt = """
                    You are an interactive AI Spanish speaking tutor in a roleplay scenario.
                    Scenario: $scenarioTitle
                    Tutor context & goal: $tutorContext
                    Student level: Level $levelNumber (Level 1=Beginner A1, Level 4=Conversational A2).
                    Conversation history:
                    ${conversationHistory.takeLast(4).joinToString("\n")}

                    Student just said (via microphone): "$studentSpokenText"

                    Task:
                    1. Evaluate intelligibility and grammar.
                    2. If there are mistakes, explain clearly in plain English.
                    3. Suggest a natural native Spanish phrasing.
                    4. Respond in Spanish in your scenario role, using Spanish adapted to Level $levelNumber.
                    5. Ask an engaging follow-up question in Spanish to continue the conversation.
                """.trimIndent()

                val response = speakingModel.generateContent(prompt)
                val jsonStr = response.text ?: throw IllegalStateException("Empty speaking response")
                val json = JSONObject(jsonStr)

                SpeakingEvaluation(
                    isUnderstood = json.optBoolean("isUnderstood", true),
                    grammarCorrection = json.optString("grammarCorrection", "Good effort!"),
                    naturalAlternative = json.optString("naturalAlternative", studentSpokenText),
                    tutorReplyEs = json.optString("tutorReplyEs", "¡Muy bien! Comprendo lo que dices."),
                    tutorReplyEn = json.optString("tutorReplyEn", "Very good! I understand what you say."),
                    followUpQuestionEs = json.optString("followUpQuestionEs", "¿Y qué más?")
                )
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.w(TAG, "Speaking evaluation fallback: ${e.message}")
            SpeakingEvaluation(
                isUnderstood = true,
                grammarCorrection = "Your speech was understood! Keep practicing your accent and verb endings.",
                naturalAlternative = studentSpokenText,
                tutorReplyEs = "¡Comprendo! Es una buena respuesta para esta situación.",
                tutorReplyEn = "I understand! That's a good response for this situation.",
                followUpQuestionEs = "¿Puedes darme un poco más de detalles?"
            )
        }
    }

    suspend fun evaluateListening(
        spanishSpokenSentence: String,
        officialEnglish: String,
        studentInputMeaning: String,
        levelNumber: Int
    ): ListeningEvaluation {
        return try {
            withTimeout(30_000L) {
                val prompt = """
                    You are a Spanish listening comprehension grader.
                    Spanish sentence spoken to student: "$spanishSpokenSentence"
                    Official English translation: "$officialEnglish"
                    Student's typed translation/meaning in English: "$studentInputMeaning"
                    Level: Level $levelNumber

                    Check if the student correctly understood the Spanish sentence they heard.
                    Give a score (0-100) and plain English feedback on what they got right or missed.
                """.trimIndent()

                val response = listeningModel.generateContent(prompt)
                val jsonStr = response.text ?: throw IllegalStateException("Empty listening response")
                val json = JSONObject(jsonStr)

                ListeningEvaluation(
                    isCorrect = json.optBoolean("isCorrect", false),
                    score = json.optInt("score", 75),
                    feedback = json.optString("feedback", "Good listening effort."),
                    accurateEnglish = json.optString("accurateEnglish", officialEnglish)
                )
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.w(TAG, "Listening evaluation fallback: ${e.message}")
            val studentWords = studentInputMeaning.lowercase().split("\\s+".toRegex()).toSet()
            val expectedWords = officialEnglish.lowercase().split("\\s+".toRegex()).toSet()
            val intersection = studentWords.intersect(expectedWords)
            val ratio = if (expectedWords.isNotEmpty()) intersection.size.toFloat() / expectedWords.size else 0.5f
            val isCorrect = ratio >= 0.5f
            ListeningEvaluation(
                isCorrect = isCorrect,
                score = (ratio * 100).toInt().coerceIn(40, 100),
                feedback = if (isCorrect) "Great job! You captured the main idea." else "You missed a few key words. Replay the audio and review the full translation below.",
                accurateEnglish = officialEnglish
            )
        }
    }

    suspend fun explainConcept(conceptTitle: String, studentLevel: Int): String {
        return try {
            withTimeout(25_000L) {
                val prompt = """
                    You are My Spanish Tutor.
                    Explain the following Spanish grammar concept for a Level $studentLevel student:
                    Concept: "$conceptTitle"

                    Format:
                    - 1-2 sentence core rule in plain English
                    - The pattern formula (e.g. Subject + Verb + Object)
                    - 3 practical daily examples with translations
                    - 1 common mistake to avoid
                    Keep it concise, friendly, and practical.
                """.trimIndent()
                val response = explainerModel.generateContent(prompt)
                response.text ?: "Spanish grammar pattern: $conceptTitle. Practice with everyday sentences."
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            "Concept: $conceptTitle\nRule: In Spanish, patterns are consistent once you recognize the root verbs. Use everyday sentences to reinforce the structure."
        }
    }

    private fun fallbackEvaluate(
        studentAnswer: String,
        expectedAnswers: List<String>,
        explanationHint: String
    ): EvaluationResult {
        val normStudent = normalizeSpanish(studentAnswer)
        val bestExpected = expectedAnswers.firstOrNull() ?: ""
        val normExpected = normalizeSpanish(bestExpected)

        // Simple word-overlap comparison
        val sWords = normStudent.split(" ").filter { it.isNotBlank() }
        val eWords = normExpected.split(" ").filter { it.isNotBlank() }
        val matches = sWords.count { eWords.contains(it) }
        val similarity = if (eWords.isNotEmpty()) matches.toFloat() / eWords.size else 0f

        val isPass = similarity >= 0.7f
        val score = (similarity * 100).toInt().coerceIn(20, 95)

        return EvaluationResult(
            isCorrect = isPass,
            score = if (isPass) score else 40,
            studentAnswer = studentAnswer,
            expectedSentence = bestExpected,
            feedback = if (isPass) {
                "Good attempt! $explanationHint"
            } else {
                "Almost! Notice the key pattern: $explanationHint"
            },
            alternativeExpressions = expectedAnswers.drop(1)
        )
    }

    private fun normalizeSpanish(text: String): String {
        return text.trim()
            .lowercase()
            .replace("[¿?¡!.,;:]".toRegex(), "")
            .replace("\\s+".toRegex(), " ")
    }
}
