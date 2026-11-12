package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.EvaluationResult
import com.example.data.model.ExerciseType
import com.example.data.model.QuizQuestion

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuizExerciseCard(
    question: QuizQuestion,
    userAnswer: String,
    onAnswerChanged: (String) -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit,
    onSpeakPrompt: (String) -> Unit,
    isEvaluating: Boolean,
    evaluation: EvaluationResult?,
    showHint: Boolean,
    onToggleHint: () -> Unit,
    isLastQuestion: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("quiz_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            // Exercise Type Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = when (question.type) {
                            ExerciseType.TRANSLATE_EN_TO_ES -> "Translate to Spanish"
                            ExerciseType.TRANSLATE_ES_TO_EN -> "Translate to English"
                            ExerciseType.FILL_IN_BLANK -> "Fill in the Blank"
                            ExerciseType.CHOOSE_VERB -> "Choose the Correct Form"
                            ExerciseType.CORRECT_SENTENCE -> "Correct the Sentence"
                            ExerciseType.SENTENCE_BUILDER -> "Build the Sentence"
                            ExerciseType.CONVERSATION_REPLY -> "Conversational Reply"
                        },
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                if (question.hint != null) {
                    TextButton(
                        onClick = onToggleHint,
                        modifier = Modifier.testTag("hint_button")
                    ) {
                        Icon(Icons.Default.HelpOutline, contentDescription = "Hint", modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(if (showHint) "Hide Hint" else "Hint", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }

            AnimatedVisibility(visible = showHint && question.hint != null) {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "💡 ${question.hint}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Question Prompt
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = question.prompt,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = { onSpeakPrompt(question.prompt) },
                    modifier = Modifier.testTag("audio_prompt_button")
                ) {
                    Icon(
                        Icons.Default.VolumeUp,
                        contentDescription = "Listen to prompt",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (question.blankSentence != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = question.blankSentence,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exercise Input Area depending on type
            when {
                // Multiple Choice (Options)
                question.options.isNotEmpty() -> {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        question.options.forEach { option ->
                            val isSelected = userAnswer == option
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                        width = if (isSelected) 2.dp else 1.dp,
                                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable(enabled = evaluation == null) {
                                        onAnswerChanged(option)
                                    }
                                    .testTag("option_${option.take(10)}"),
                                color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                            ) {
                                Text(
                                    text = option,
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }

                // Sentence Builder (Word Chips)
                question.wordsToArrange.isNotEmpty() -> {
                    val availableWords = remember(question.id) {
                        mutableStateListOf(*question.wordsToArrange.toTypedArray())
                    }
                    val selectedWords = remember(question.id) {
                        mutableStateListOf<String>()
                    }

                    Column {
                        // Current assembled sentence area
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(12.dp)
                        ) {
                            if (selectedWords.isEmpty()) {
                                Text(
                                    text = "Tap words below to build the sentence...",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            } else {
                                FlowRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    selectedWords.forEachIndexed { index, word ->
                                        Surface(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp),
                                            modifier = Modifier.clickable(enabled = evaluation == null) {
                                                selectedWords.removeAt(index)
                                                availableWords.add(word)
                                                onAnswerChanged(selectedWords.joinToString(" "))
                                            }
                                        ) {
                                            Text(
                                                text = word,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.SemiBold,
                                                color = MaterialTheme.colorScheme.onPrimaryContainer
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Available word bank
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            availableWords.forEachIndexed { index, word ->
                                Surface(
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.clickable(enabled = evaluation == null) {
                                        availableWords.removeAt(index)
                                        selectedWords.add(word)
                                        onAnswerChanged(selectedWords.joinToString(" "))
                                    }
                                ) {
                                    Text(
                                        text = word,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }
                            }
                        }
                    }
                }

                // Free-form text input (Translation / Correction / Conversation reply)
                else -> {
                    OutlinedTextField(
                        value = userAnswer,
                        onValueChange = onAnswerChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("quiz_text_input"),
                        placeholder = { Text("Escribe tu respuesta en español...") },
                        shape = RoundedCornerShape(12.dp),
                        enabled = evaluation == null,
                        singleLine = false,
                        maxLines = 3
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Evaluation Feedback Box (shows only after submitting)
            if (evaluation != null) {
                Surface(
                    color = if (evaluation.isCorrect) Color(0xFFDCFCE7) else Color(0xFFFEE2E2),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .testTag("evaluation_box")
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                if (evaluation.isCorrect) Icons.Default.CheckCircle else Icons.Default.Error,
                                contentDescription = if (evaluation.isCorrect) "Correct" else "Incorrect",
                                tint = if (evaluation.isCorrect) Color(0xFF16A34A) else Color(0xFFDC2626),
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (evaluation.isCorrect) "¡Correcto! (+${evaluation.score} pts)" else "Necesita corrección",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (evaluation.isCorrect) Color(0xFF166534) else Color(0xFF991B1B)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = evaluation.feedback,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF1F2937)
                        )

                        if (!evaluation.isCorrect || evaluation.studentAnswer != evaluation.expectedSentence) {
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Respuesta correcta: ${evaluation.expectedSentence}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1E3A8A)
                            )
                        }

                        if (evaluation.alternativeExpressions.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Otras opciones: ${evaluation.alternativeExpressions.joinToString(" | ")}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF4B5563)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (evaluation == null) {
                    Button(
                        onClick = onSubmit,
                        enabled = userAnswer.isNotBlank() && !isEvaluating,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("submit_answer_button"),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        if (isEvaluating) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Evaluating...")
                        } else {
                            Text("Check Answer", fontWeight = FontWeight.SemiBold)
                        }
                    }
                } else {
                    Button(
                        onClick = onNext,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("next_question_button"),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(if (isLastQuestion) "Finish Exercise" else "Next Question →", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
