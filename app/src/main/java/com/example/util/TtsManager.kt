package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class TtsManager(private val context: Context) {
    private var tts: TextToSpeech? = null
    private var isInitialized = false

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private var speechRate: Float = 1.0f

    init {
        initTts()
    }

    private fun initTts() {
        try {
            tts = TextToSpeech(context.applicationContext) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    val spanishSpain = Locale("es", "ES")
                    val result = tts?.setLanguage(spanishSpain)
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        val genericSpanish = Locale("es")
                        tts?.setLanguage(genericSpanish)
                    }
                    tts?.setSpeechRate(speechRate)
                    tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                        override fun onStart(utteranceId: String?) {
                            _isPlaying.value = true
                        }

                        override fun onDone(utteranceId: String?) {
                            _isPlaying.value = false
                        }

                        override fun onError(utteranceId: String?) {
                            _isPlaying.value = false
                        }
                    })
                    isInitialized = true
                    Log.d("TtsManager", "TTS initialized successfully")
                } else {
                    Log.w("TtsManager", "TTS initialization failed with status $status")
                }
            }
        } catch (e: Exception) {
            Log.e("TtsManager", "Failed to construct TextToSpeech", e)
        }
    }

    fun setSpeed(rate: Float) {
        speechRate = rate
        tts?.setSpeechRate(rate)
    }

    fun speak(text: String, rateOverride: Float? = null) {
        if (!isInitialized) {
            initTts()
        }
        val rate = rateOverride ?: speechRate
        tts?.setSpeechRate(rate)
        val params = android.os.Bundle()
        params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "spanish_tutor_${System.currentTimeMillis()}")
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, params, "spanish_tutor_utterance")
    }

    fun stop() {
        tts?.stop()
        _isPlaying.value = false
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
