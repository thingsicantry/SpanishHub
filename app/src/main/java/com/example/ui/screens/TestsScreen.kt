package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.datasource.CurriculumReading
import com.example.ui.MainViewModel
import com.example.ui.Screen
import com.example.ui.components.QuizExerciseCard

@Composable
fun TestsScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    BackHandler {
        viewModel.navigateTo(Screen.HOME)
    }

    val quizQuestions by viewModel.quizQuestions.collectAsState()
    val quizCurrentIndex by viewModel.quizCurrentIndex.collectAsState()
    val quizUserAnswer by viewModel.quizUserAnswer.collectAsState()
    val isEvaluating by viewModel.isEvaluating.collectAsState()
    val quizEvaluation by viewModel.quizEvaluation.collectAsState()
    val quizCompleted by viewModel.quizCompleted.collectAsState()
    val quizScore by viewModel.quizScore.collectAsState()
    val showHint by viewModel.showHint.collectAsState()
    val allMistakes by viewModel.allMistakes.collectAsState()

    var isQuizActive by remember { mutableStateOf(false) }
    var currentTestTitle by remember { mutableStateOf("") }

    if (isQuizActive && quizQuestions.isNotEmpty()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .testTag("active_test_view"),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = currentTestTitle,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Question ${quizCurrentIndex + 1} of ${quizQuestions.size}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                OutlinedButton(
                    onClick = { isQuizActive = false },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Exit Test")
                }
            }

            if (quizCompleted) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFDCFCE7)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.EmojiEvents,
                            contentDescription = null,
                            tint = Color(0xFFEAB308),
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Assessment Completed!",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF166534)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Score: $quizScore / ${quizQuestions.size} (${(quizScore.toFloat() / quizQuestions.size * 100).toInt()}%)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF166534)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Button(onClick = { isQuizActive = false }) {
                            Text("Back to Assessments")
                        }
                    }
                }
            } else {
                val q = quizQuestions.getOrNull(quizCurrentIndex)
                if (q != null) {
                    QuizExerciseCard(
                        question = q,
                        userAnswer = quizUserAnswer,
                        onAnswerChanged = { viewModel.updateQuizAnswer(it) },
                        onSubmit = { viewModel.submitQuizAnswer() },
                        onNext = { viewModel.nextQuizQuestion() },
                        onSpeakPrompt = { viewModel.speakWord(it) },
                        isEvaluating = isEvaluating,
                        evaluation = quizEvaluation,
                        showHint = showHint,
                        onToggleHint = { viewModel.toggleHint() },
                        isLastQuestion = quizCurrentIndex == quizQuestions.size - 1
                    )
                }
            }
        }
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("tests_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        item {
            Column {
                Text(
                    text = "📝 Tests & Assessments",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Benchmark your knowledge across all four learning levels and conquer your recorded mistakes.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Targeted Mistake Review Card
        item {
            ElevatedCard(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = if (allMistakes.isNotEmpty()) Color(0xFFFEF2F2) else MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFF87171).copy(alpha = 0.2f),
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    Icons.Default.Warning,
                                    contentDescription = null,
                                    tint = Color(0xFFDC2626),
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Personalized Mistake Review",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF991B1B)
                            )
                            Text(
                                text = if (allMistakes.isNotEmpty()) "${allMistakes.size} mistakes recorded from your previous exercises" else "Zero mistakes recorded! Flawless learning so far.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    if (allMistakes.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = {
                                viewModel.startMistakeReviewQuiz()
                                currentTestTitle = "Personalized Mistakes Drill"
                                isQuizActive = true
                            },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFDC2626)
                            ),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("start_mistake_review_button")
                        ) {
                            Text("Start Targeted Mistake Drill →", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        item {
            Text(
                text = "Level Diagnostic Exams",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        // 4 Diagnostic Level Tests
        items(listOf(
            1 to "Level 1: Beginner A1 Foundations Diagnostic",
            2 to "Level 2: Developing A1 Sentence Mastery",
            3 to "Level 3: Past Tenses (Preterite & Imperfect) Test",
            4 to "Level 4: Developing A2 Conversational Exam"
        )) { (level, title) ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.startLevelDiagnostic(level)
                        currentTestTitle = title
                        isQuizActive = true
                    }
                    .testTag("test_level_$level")
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.size(44.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                Icons.Default.Assignment,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Comprehensive evaluation for Level $level",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = "Start Test",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
