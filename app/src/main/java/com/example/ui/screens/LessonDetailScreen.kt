package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Lesson
import com.example.ui.MainViewModel
import com.example.ui.Screen
import com.example.ui.components.QuizExerciseCard

private val STEP_NAMES = listOf(
    "1. Objective",
    "2. Explanation",
    "3. Pattern",
    "4. Examples",
    "5. Guided Practice",
    "6. Independent Practice",
    "7. Review",
    "8. Assessment"
)

@Composable
fun LessonDetailScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    BackHandler {
        viewModel.navigateTo(Screen.LESSONS)
    }

    val lesson = viewModel.activeLesson.collectAsState().value
    val currentStep = viewModel.activeLessonStep.collectAsState().value
    val quizQuestions by viewModel.quizQuestions.collectAsState()
    val quizCurrentIndex by viewModel.quizCurrentIndex.collectAsState()
    val quizUserAnswer by viewModel.quizUserAnswer.collectAsState()
    val isEvaluating by viewModel.isEvaluating.collectAsState()
    val quizEvaluation by viewModel.quizEvaluation.collectAsState()
    val quizCompleted by viewModel.quizCompleted.collectAsState()
    val showHint by viewModel.showHint.collectAsState()

    if (lesson == null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("No active lesson selected.")
            Button(onClick = { viewModel.navigateTo(Screen.LESSONS) }) {
                Text("Return to Lessons")
            }
        }
        return
    }

    // Initialize quiz questions when switching to exercise steps
    LaunchedEffect(currentStep) {
        when (currentStep) {
            4 -> viewModel.startQuiz(lesson.guidedPractice)
            5 -> viewModel.startQuiz(lesson.independentPractice)
            7 -> viewModel.startQuiz(lesson.assessmentQuiz)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("lesson_detail_screen")
    ) {
        // Top Bar Header
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 2.dp
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { viewModel.navigateTo(Screen.LESSONS) },
                        modifier = Modifier.testTag("back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Text(
                            text = STEP_NAMES[currentStep],
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                LinearProgressIndicator(
                    progress = { (currentStep + 1).toFloat() / 8 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = MaterialTheme.colorScheme.primary
                )

                // Scrollable Steps Bar
                ScrollableTabRow(
                    selectedTabIndex = currentStep,
                    edgePadding = 12.dp,
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    STEP_NAMES.forEachIndexed { index, name ->
                        Tab(
                            selected = currentStep == index,
                            onClick = { viewModel.setLessonStep(index) },
                            text = {
                                Text(
                                    text = "${index + 1}",
                                    fontWeight = if (currentStep == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }
        }

        // Main Content Area
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                when (currentStep) {
                    // STEP 1: OBJECTIVE
                    0 -> ObjectiveStep(lesson)

                    // STEP 2: PLAIN ENGLISH EXPLANATION
                    1 -> ExplanationStep(lesson)

                    // STEP 3: PATTERN RECOGNITION
                    2 -> PatternStep(lesson)

                    // STEP 4: EXAMPLES
                    3 -> ExamplesStep(lesson, onSpeak = { viewModel.speakWord(it) })

                    // STEP 5: GUIDED PRACTICE
                    4 -> ExerciseStep(
                        title = "Step 5: Guided Practice",
                        description = "Complete these exercises to practice applying the rule step-by-step.",
                        questions = quizQuestions,
                        currentIndex = quizCurrentIndex,
                        userAnswer = quizUserAnswer,
                        isEvaluating = isEvaluating,
                        evaluation = quizEvaluation,
                        isCompleted = quizCompleted,
                        showHint = showHint,
                        onAnswerChanged = { viewModel.updateQuizAnswer(it) },
                        onToggleHint = { viewModel.toggleHint() },
                        onSubmit = { viewModel.submitQuizAnswer() },
                        onNext = { viewModel.nextQuizQuestion() },
                        onSpeak = { viewModel.speakWord(it) },
                        onContinueToNextStep = { viewModel.setLessonStep(5) }
                    )

                    // STEP 6: INDEPENDENT PRACTICE
                    5 -> ExerciseStep(
                        title = "Step 6: Independent Practice",
                        description = "Test whether you can produce the Spanish sentences without assistance.",
                        questions = quizQuestions,
                        currentIndex = quizCurrentIndex,
                        userAnswer = quizUserAnswer,
                        isEvaluating = isEvaluating,
                        evaluation = quizEvaluation,
                        isCompleted = quizCompleted,
                        showHint = showHint,
                        onAnswerChanged = { viewModel.updateQuizAnswer(it) },
                        onToggleHint = { viewModel.toggleHint() },
                        onSubmit = { viewModel.submitQuizAnswer() },
                        onNext = { viewModel.nextQuizQuestion() },
                        onSpeak = { viewModel.speakWord(it) },
                        onContinueToNextStep = { viewModel.setLessonStep(6) }
                    )

                    // STEP 7: REVIEW
                    6 -> ReviewStep(lesson)

                    // STEP 8: ASSESSMENT
                    7 -> AssessmentStep(
                        lesson = lesson,
                        questions = quizQuestions,
                        currentIndex = quizCurrentIndex,
                        userAnswer = quizUserAnswer,
                        isEvaluating = isEvaluating,
                        evaluation = quizEvaluation,
                        isCompleted = quizCompleted,
                        showHint = showHint,
                        onAnswerChanged = { viewModel.updateQuizAnswer(it) },
                        onToggleHint = { viewModel.toggleHint() },
                        onSubmit = { viewModel.submitQuizAnswer() },
                        onNext = { viewModel.nextQuizQuestion { viewModel.completeActiveLesson() } },
                        onSpeak = { viewModel.speakWord(it) },
                        onFinishLesson = {
                            viewModel.completeActiveLesson()
                            viewModel.navigateTo(Screen.LESSONS)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        // Bottom Navigation Buttons (Prev / Next Step)
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { viewModel.setLessonStep(currentStep - 1) },
                    enabled = currentStep > 0,
                    modifier = Modifier.testTag("prev_step_button"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Previous")
                }

                Text(
                    text = "${currentStep + 1} of 8",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Button(
                    onClick = {
                        if (currentStep < 7) {
                            viewModel.setLessonStep(currentStep + 1)
                        } else {
                            viewModel.completeActiveLesson()
                            viewModel.navigateTo(Screen.LESSONS)
                        }
                    },
                    modifier = Modifier.testTag("next_step_button"),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(if (currentStep < 7) "Next Step" else "Finish", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
private fun ObjectiveStep(lesson: Lesson) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "🎯 Learning Objective",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = lesson.objective,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 26.sp
            )
        }
    }
}

@Composable
private fun ExplanationStep(lesson: Lesson) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "📖 Plain English Rule",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = lesson.plainEnglishRule,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 26.sp
            )
        }
    }
}

@Composable
private fun PatternStep(lesson: Lesson) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "🧩 Pattern Recognition",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(14.dp))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = lesson.patternFormula,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = lesson.patternFormulaExplanation,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
private fun ExamplesStep(lesson: Lesson, onSpeak: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "🔊 Practical Examples",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Tap the audio button to hear native Spanish pronunciation.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        lesson.examples.forEach { example ->
            ElevatedCard(
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = example.spanish,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = example.english,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (example.breakdown != null) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Note: ${example.breakdown}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    IconButton(
                        onClick = { onSpeak(example.spanish) },
                        modifier = Modifier.testTag("speak_example_${example.spanish.take(8)}")
                    ) {
                        Icon(
                            Icons.Default.VolumeUp,
                            contentDescription = "Speak",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExerciseStep(
    title: String,
    description: String,
    questions: List<com.example.data.model.QuizQuestion>,
    currentIndex: Int,
    userAnswer: String,
    isEvaluating: Boolean,
    evaluation: com.example.data.model.EvaluationResult?,
    isCompleted: Boolean,
    showHint: Boolean,
    onAnswerChanged: (String) -> Unit,
    onToggleHint: () -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit,
    onSpeak: (String) -> Unit,
    onContinueToNextStep: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (isCompleted) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFDCFCE7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = "Done",
                        tint = Color(0xFF16A34A),
                        modifier = Modifier.size(54.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Practice Complete!",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF166534)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Great work applying the lesson concepts.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF166534)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onContinueToNextStep) {
                        Text("Continue to Next Step →")
                    }
                }
            }
        } else {
            val q = questions.getOrNull(currentIndex)
            if (q != null) {
                Text(
                    text = "Question ${currentIndex + 1} of ${questions.size}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                QuizExerciseCard(
                    question = q,
                    userAnswer = userAnswer,
                    onAnswerChanged = onAnswerChanged,
                    onSubmit = onSubmit,
                    onNext = onNext,
                    onSpeakPrompt = onSpeak,
                    isEvaluating = isEvaluating,
                    evaluation = evaluation,
                    showHint = showHint,
                    onToggleHint = onToggleHint,
                    isLastQuestion = currentIndex == questions.size - 1
                )
            }
        }
    }
}

@Composable
private fun ReviewStep(lesson: Lesson) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "📝 Lesson Review Summary",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(14.dp))
            lesson.reviewSummary.forEach { point ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = point,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 24.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun AssessmentStep(
    lesson: Lesson,
    questions: List<com.example.data.model.QuizQuestion>,
    currentIndex: Int,
    userAnswer: String,
    isEvaluating: Boolean,
    evaluation: com.example.data.model.EvaluationResult?,
    isCompleted: Boolean,
    showHint: Boolean,
    onAnswerChanged: (String) -> Unit,
    onToggleHint: () -> Unit,
    onSubmit: () -> Unit,
    onNext: () -> Unit,
    onSpeak: (String) -> Unit,
    onFinishLesson: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            text = "🎓 Final Assessment Quiz",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Pass this short check to verify your understanding and record your lesson completion.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (isCompleted) {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFDCFCE7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.EmojiEvents,
                        contentDescription = "Trophy",
                        tint = Color(0xFFEAB308),
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "¡Felicitaciones!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF166534)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "You have completed '${lesson.title}'. Your progress and stats have been saved.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF166534)
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Button(
                        onClick = onFinishLesson,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Back to Lessons", fontWeight = FontWeight.Bold)
                    }
                }
            }
        } else {
            val q = questions.getOrNull(currentIndex)
            if (q != null) {
                Text(
                    text = "Assessment Question ${currentIndex + 1} of ${questions.size}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                QuizExerciseCard(
                    question = q,
                    userAnswer = userAnswer,
                    onAnswerChanged = onAnswerChanged,
                    onSubmit = onSubmit,
                    onNext = onNext,
                    onSpeakPrompt = onSpeak,
                    isEvaluating = isEvaluating,
                    evaluation = evaluation,
                    showHint = showHint,
                    onToggleHint = onToggleHint,
                    isLastQuestion = currentIndex == questions.size - 1
                )
            }
        }
    }
}
