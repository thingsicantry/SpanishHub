package com.example.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.CurriculumLessons
import com.example.data.datasource.CurriculumListening
import com.example.data.datasource.CurriculumReading
import com.example.data.datasource.CurriculumSpeaking
import com.example.data.datasource.CurriculumVocab
import com.example.data.local.AppDatabase
import com.example.data.local.entity.LessonProgressEntity
import com.example.data.local.entity.MistakeEntity
import com.example.data.local.entity.UserSettingsEntity
import com.example.data.local.entity.VocabProgressEntity
import com.example.data.model.ChatMessage
import com.example.data.model.EvaluationResult
import com.example.data.model.Lesson
import com.example.data.model.LevelType
import com.example.data.model.ListeningExercise
import com.example.data.model.QuizQuestion
import com.example.data.model.ReadingPassage
import com.example.data.model.SpeakingScenario
import com.example.data.model.VocabItem
import com.example.data.repository.AiTutorRepository
import com.example.data.repository.ListeningEvaluation
import com.example.data.repository.ProgressRepository
import com.example.data.repository.SpeakingEvaluation
import com.example.util.SpeechManager
import com.example.util.TtsManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class Screen {
    HOME,
    LESSONS,
    LESSON_DETAIL,
    LISTENING,
    SPEAKING,
    READING_WRITING,
    VOCABULARY,
    TESTS,
    PROGRESS
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)
    val progressRepository = ProgressRepository(database)
    val aiRepository = AiTutorRepository()
    val ttsManager = TtsManager(application)
    val speechManager = SpeechManager(application)

    // Navigation State
    private val _currentScreen = MutableStateFlow(Screen.HOME)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    // Level filter (1..4)
    private val _selectedLevelId = MutableStateFlow(1)
    val selectedLevelId: StateFlow<Int> = _selectedLevelId.asStateFlow()

    // Database Flows
    val allProgress: StateFlow<List<LessonProgressEntity>> = progressRepository.allProgress
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allMistakes: StateFlow<List<MistakeEntity>> = progressRepository.allMistakes
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allVocabProgress: StateFlow<List<VocabProgressEntity>> = progressRepository.allVocabProgress
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val userSettings: StateFlow<UserSettingsEntity?> = progressRepository.userSettings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    // ================= LESSON DETAIL STATE =================
    private val _activeLesson = MutableStateFlow<Lesson?>(null)
    val activeLesson: StateFlow<Lesson?> = _activeLesson.asStateFlow()

    private val _activeLessonStep = MutableStateFlow(0) // 0..7 (Objective, Rule, Pattern, Examples, Guided, Independent, Review, Assessment)
    val activeLessonStep: StateFlow<Int> = _activeLessonStep.asStateFlow()

    // Interactive Quiz State (used in lesson guided/independent/assessment, and Tests)
    private val _quizQuestions = MutableStateFlow<List<QuizQuestion>>(emptyList())
    val quizQuestions: StateFlow<List<QuizQuestion>> = _quizQuestions.asStateFlow()

    private val _quizCurrentIndex = MutableStateFlow(0)
    val quizCurrentIndex: StateFlow<Int> = _quizCurrentIndex.asStateFlow()

    private val _quizUserAnswer = MutableStateFlow("")
    val quizUserAnswer: StateFlow<String> = _quizUserAnswer.asStateFlow()

    private val _isEvaluating = MutableStateFlow(false)
    val isEvaluating: StateFlow<Boolean> = _isEvaluating.asStateFlow()

    private val _quizEvaluation = MutableStateFlow<EvaluationResult?>(null)
    val quizEvaluation: StateFlow<EvaluationResult?> = _quizEvaluation.asStateFlow()

    private val _quizCompleted = MutableStateFlow(false)
    val quizCompleted: StateFlow<Boolean> = _quizCompleted.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    private val _showHint = MutableStateFlow(false)
    val showHint: StateFlow<Boolean> = _showHint.asStateFlow()

    // ================= LISTENING PRACTICE STATE =================
    private val _activeListeningExercise = MutableStateFlow<ListeningExercise?>(null)
    val activeListeningExercise: StateFlow<ListeningExercise?> = _activeListeningExercise.asStateFlow()

    private val _listeningUserInput = MutableStateFlow("")
    val listeningUserInput: StateFlow<String> = _listeningUserInput.asStateFlow()

    private val _listeningEvaluation = MutableStateFlow<ListeningEvaluation?>(null)
    val listeningEvaluation: StateFlow<ListeningEvaluation?> = _listeningEvaluation.asStateFlow()

    private val _listeningRevealed = MutableStateFlow(false)
    val listeningRevealed: StateFlow<Boolean> = _listeningRevealed.asStateFlow()

    private val _playbackSpeed = MutableStateFlow(1.0f)
    val playbackSpeed: StateFlow<Float> = _playbackSpeed.asStateFlow()

    // ================= SPEAKING PRACTICE STATE =================
    private val _activeScenario = MutableStateFlow<SpeakingScenario?>(null)
    val activeScenario: StateFlow<SpeakingScenario?> = _activeScenario.asStateFlow()

    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    private val _speakingEvaluation = MutableStateFlow<SpeakingEvaluation?>(null)
    val speakingEvaluation: StateFlow<SpeakingEvaluation?> = _speakingEvaluation.asStateFlow()

    // ================= VOCABULARY STATE =================
    private val _vocabSearchQuery = MutableStateFlow("")
    val vocabSearchQuery: StateFlow<String> = _vocabSearchQuery.asStateFlow()

    private val _vocabSelectedTopic = MutableStateFlow<String?>(null)
    val vocabSelectedTopic: StateFlow<String?> = _vocabSelectedTopic.asStateFlow()

    private val _vocabFilterStarred = MutableStateFlow(false)
    val vocabFilterStarred: StateFlow<Boolean> = _vocabFilterStarred.asStateFlow()

    // ================= READING & WRITING STATE =================
    private val _activePassage = MutableStateFlow<ReadingPassage?>(null)
    val activePassage: StateFlow<ReadingPassage?> = _activePassage.asStateFlow()

    private val _passageAnswerState = MutableStateFlow<Map<String, String>>(emptyMap())
    val passageAnswerState: StateFlow<Map<String, String>> = _passageAnswerState.asStateFlow()

    private val _passageResults = MutableStateFlow<Map<String, Boolean>>(emptyMap())
    val passageResults: StateFlow<Map<String, Boolean>> = _passageResults.asStateFlow()

    // Backup & Export status message
    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> = _statusMessage.asStateFlow()

    init {
        // Set default listening & speaking scenarios
        _activeListeningExercise.value = CurriculumListening.allExercises.firstOrNull()
        _activeScenario.value = CurriculumSpeaking.allScenarios.firstOrNull()
        _activePassage.value = CurriculumReading.allPassages.firstOrNull()
    }

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
        _statusMessage.value = null
    }

    fun setSelectedLevel(levelId: Int) {
        _selectedLevelId.value = levelId
        viewModelScope.launch {
            progressRepository.setCurrentLevel(levelId)
        }
    }

    fun openLesson(lessonId: String) {
        val lesson = CurriculumLessons.allLessons.find { it.id == lessonId }
        if (lesson != null) {
            _activeLesson.value = lesson
            _activeLessonStep.value = 0
            _currentScreen.value = Screen.LESSON_DETAIL
        }
    }

    fun setLessonStep(step: Int) {
        _activeLessonStep.value = step.coerceIn(0, 7)
        _quizEvaluation.value = null
        _quizUserAnswer.value = ""
        _showHint.value = false
    }

    // ================= QUIZ & EXERCISE HANDLING =================
    fun startQuiz(questions: List<QuizQuestion>) {
        _quizQuestions.value = questions
        _quizCurrentIndex.value = 0
        _quizUserAnswer.value = ""
        _quizEvaluation.value = null
        _quizCompleted.value = false
        _quizScore.value = 0
        _showHint.value = false
    }

    fun updateQuizAnswer(answer: String) {
        _quizUserAnswer.value = answer
    }

    fun toggleHint() {
        _showHint.value = !_showHint.value
    }

    fun submitQuizAnswer() {
        val currentQ = _quizQuestions.value.getOrNull(_quizCurrentIndex.value) ?: return
        val answer = _quizUserAnswer.value.trim()
        if (answer.isEmpty()) return

        _isEvaluating.value = true
        viewModelScope.launch {
            val recentMistakes = allMistakes.value.map { it.correctAnswer }
            val result = aiRepository.evaluateAnswer(
                questionPrompt = currentQ.prompt,
                studentAnswer = answer,
                expectedAnswers = currentQ.expectedAnswers,
                explanationHint = currentQ.explanation,
                levelNumber = _selectedLevelId.value,
                knownMistakes = recentMistakes
            )

            _quizEvaluation.value = result
            _isEvaluating.value = false

            if (result.isCorrect) {
                _quizScore.value += 1
            } else {
                // Record mistake in database for personalized future review
                progressRepository.recordMistake(
                    prompt = currentQ.prompt,
                    studentAnswer = answer,
                    correctAnswer = result.expectedSentence,
                    explanation = result.feedback,
                    category = currentQ.type.name,
                    levelId = _selectedLevelId.value
                )
            }
        }
    }

    fun nextQuizQuestion(onFinish: (() -> Unit)? = null) {
        val nextIdx = _quizCurrentIndex.value + 1
        if (nextIdx < _quizQuestions.value.size) {
            _quizCurrentIndex.value = nextIdx
            _quizUserAnswer.value = ""
            _quizEvaluation.value = null
            _showHint.value = false
        } else {
            _quizCompleted.value = true
            onFinish?.invoke()
        }
    }

    fun completeActiveLesson() {
        val lesson = _activeLesson.value ?: return
        val total = maxOf(1, lesson.assessmentQuiz.size)
        val scorePct = ((_quizScore.value.toFloat() / total) * 100).toInt().coerceIn(60, 100)
        viewModelScope.launch {
            progressRepository.saveLessonCompletion(lesson.id, lesson.levelId, scorePct)
            _statusMessage.value = "Lesson completed! Score: $scorePct%"
        }
    }

    // ================= LISTENING PRACTICE =================
    fun selectListeningExercise(exercise: ListeningExercise) {
        _activeListeningExercise.value = exercise
        _listeningUserInput.value = ""
        _listeningEvaluation.value = null
        _listeningRevealed.value = false
        ttsManager.stop()
    }

    fun playListeningAudio() {
        val exercise = _activeListeningExercise.value ?: return
        ttsManager.speak(exercise.spanishAudioScript, _playbackSpeed.value)
    }

    fun setPlaybackSpeed(speed: Float) {
        _playbackSpeed.value = speed
        ttsManager.setSpeed(speed)
        viewModelScope.launch {
            progressRepository.updateTtsSpeed(speed)
        }
    }

    fun updateListeningInput(text: String) {
        _listeningUserInput.value = text
    }

    fun submitListeningAnswer() {
        val exercise = _activeListeningExercise.value ?: return
        val input = _listeningUserInput.value.trim()
        if (input.isEmpty()) return

        _isEvaluating.value = true
        viewModelScope.launch {
            val eval = aiRepository.evaluateListening(
                spanishSpokenSentence = exercise.spanishAudioScript,
                officialEnglish = exercise.englishTranslation,
                studentInputMeaning = input,
                levelNumber = exercise.levelId
            )
            _listeningEvaluation.value = eval
            _listeningRevealed.value = true
            _isEvaluating.value = false
        }
    }

    // ================= SPEAKING PRACTICE =================
    fun selectScenario(scenario: SpeakingScenario) {
        _activeScenario.value = scenario
        _chatMessages.value = listOf(
            ChatMessage(
                id = "init",
                sender = "tutor",
                spanishText = scenario.initialTutorGreeting,
                englishTranslation = scenario.initialTutorTranslation
            )
        )
        _speakingEvaluation.value = null
        speechManager.clearTranscribedText()
        ttsManager.speak(scenario.initialTutorGreeting, _playbackSpeed.value)
    }

    fun sendSpeakingMessage(userSpeech: String) {
        val scenario = _activeScenario.value ?: return
        val speech = userSpeech.trim()
        if (speech.isEmpty()) return

        val userMsg = ChatMessage(
            id = "user_${System.currentTimeMillis()}",
            sender = "user",
            spanishText = speech
        )
        _chatMessages.value = _chatMessages.value + userMsg
        speechManager.clearTranscribedText()

        _isEvaluating.value = true
        viewModelScope.launch {
            val history = _chatMessages.value.map { "${it.sender}: ${it.spanishText}" }
            val eval = aiRepository.evaluateSpeaking(
                scenarioTitle = scenario.title,
                studentSpokenText = speech,
                tutorContext = scenario.studentGoal,
                levelNumber = scenario.levelId,
                conversationHistory = history
            )
            _speakingEvaluation.value = eval

            val tutorMsg = ChatMessage(
                id = "tutor_${System.currentTimeMillis()}",
                sender = "tutor",
                spanishText = "${eval.tutorReplyEs} ${eval.followUpQuestionEs}".trim(),
                englishTranslation = eval.tutorReplyEn,
                feedback = eval.grammarCorrection,
                suggestions = if (eval.naturalAlternative != speech) listOf(eval.naturalAlternative) else emptyList()
            )
            _chatMessages.value = _chatMessages.value + tutorMsg
            _isEvaluating.value = false

            progressRepository.incrementSpeakingSessions()
            // Speak the tutor's response
            ttsManager.speak(tutorMsg.spanishText, _playbackSpeed.value)
        }
    }

    // ================= VOCABULARY =================
    fun setVocabSearchQuery(query: String) {
        _vocabSearchQuery.value = query
    }

    fun setVocabTopic(topic: String?) {
        _vocabSelectedTopic.value = topic
    }

    fun toggleVocabFilterStarred() {
        _vocabFilterStarred.value = !_vocabFilterStarred.value
    }

    fun toggleStarWord(wordId: String) {
        viewModelScope.launch {
            progressRepository.toggleVocabStarred(wordId)
        }
    }

    fun toggleLearnedWord(wordId: String, currentLearned: Boolean) {
        viewModelScope.launch {
            progressRepository.markVocabLearned(wordId, !currentLearned)
        }
    }

    fun speakWord(spanish: String) {
        ttsManager.speak(spanish, _playbackSpeed.value)
    }

    // ================= READING =================
    fun selectPassage(passage: ReadingPassage) {
        _activePassage.value = passage
        _passageAnswerState.value = emptyMap()
        _passageResults.value = emptyMap()
    }

    fun answerPassageQuestion(questionId: String, selectedOption: String) {
        _passageAnswerState.value = _passageAnswerState.value + (questionId to selectedOption)
        val passage = _activePassage.value ?: return
        val q = passage.questions.find { it.id == questionId } ?: return
        val isCorrect = q.expectedAnswers.any { it.equals(selectedOption, ignoreCase = true) }
        _passageResults.value = _passageResults.value + (questionId to isCorrect)
    }

    // ================= TESTS & ASSESSMENTS =================
    fun startLevelDiagnostic(levelId: Int) {
        val tests = CurriculumReading.diagnosticTests[levelId] ?: emptyList()
        startQuiz(tests)
    }

    fun startMistakeReviewQuiz() {
        val mistakes = allMistakes.value
        if (mistakes.isEmpty()) {
            _statusMessage.value = "No mistakes recorded yet! Great job."
            return
        }
        val questions = mistakes.take(10).mapIndexed { index, m ->
            QuizQuestion(
                id = "mistake_$index",
                type = com.example.data.model.ExerciseType.TRANSLATE_EN_TO_ES,
                prompt = m.spanishPrompt,
                expectedAnswers = listOf(m.correctAnswer),
                explanation = m.explanation,
                hint = "Previous mistake note: ${m.explanation}"
            )
        }
        startQuiz(questions)
    }

    fun clearMistake(mistakeId: Long) {
        viewModelScope.launch {
            progressRepository.clearMistake(mistakeId)
        }
    }

    // ================= BACKUP & EXPORT =================
    fun exportBackup(onResult: (String) -> Unit) {
        viewModelScope.launch {
            val json = progressRepository.exportProgressToJson()
            _statusMessage.value = "Progress backup exported successfully!"
            onResult(json)
        }
    }

    fun importBackup(json: String) {
        viewModelScope.launch {
            val success = progressRepository.importProgressFromJson(json)
            _statusMessage.value = if (success) "Backup restored successfully!" else "Failed to parse backup JSON."
        }
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
        speechManager.stopListening()
    }
}
