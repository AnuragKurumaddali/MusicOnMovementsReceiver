package com.vajra.musiconmovementsreceiver

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import android.widget.TextView
import javaosc.OSCMessage
import javaosc.OSCPortIn
import java.util.Date

class OscMessageReceiver(
    private val context: Context,
    private val port: Int,
    private val statusTextView: TextView,
    private val frequencyTextView: TextView,
    private val amplitudeTextView: TextView
){
    private var oscPortIn: OSCPortIn? = null
    private lateinit var soundPool: SoundPool
    private var soundId: Int = 0
    private var currentVolume: Float = 1.0f

    init {
        setupSoundPool()
    }

    fun startListening() {
        oscPortIn = OSCPortIn(port) //.apply {
        oscPortIn?.addListener { _: Date?, message: OSCMessage, _: Int ->
            when (message.address) {

                "/gesture/coordinates" -> {
                    if(message.arguments.size == 2) {
                        val x = message.arguments[0] as Float
                        val y = message.arguments[1] as Float
                        Log.e("aaa", "X : $x")
                        Log.e("aaa", "Y : $y")
                        handleOscMessage(x,y)
                    }
                }
            }
        }
        oscPortIn?.startListening() // Start listening for incoming messages
    }

    @SuppressLint("SetTextI18n")
    private fun handleOscMessage(x: Float, y: Float) {
        (context as MainActivity).runOnUiThread {
            statusTextView.text = "Receiving messages started"
            frequencyTextView.text = "Frequency Value: $x"
            amplitudeTextView.text = "Amplitude Value: $y"
        }
        soundPool.play(soundId, currentVolume, currentVolume, 1, 0, 1.0f)
    }

    private fun setupSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()

        // Load your sound file from res/raw (e.g., sound1.mp3)
        soundId = soundPool.load(context, R.raw.sound, 1)

        soundPool.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                // Sound loaded successfully
                Log.d("aaa", "Sound loaded")
            } else {
                Log.e("aaa", "Error loading sound")
            }
        }
    }

    fun stopListening() {
        oscPortIn?.stopListening()
        oscPortIn = null
    }
}