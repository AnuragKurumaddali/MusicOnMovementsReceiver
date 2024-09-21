package com.vajra.musiconmovementsreceiver

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var statusTextView: TextView
    private lateinit var frequencyTextView: TextView
    private lateinit var amplitudeTextView: TextView
    private lateinit var oscMessageReceiver: OscMessageReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusTextView = findViewById(R.id.statusTextView)
        frequencyTextView = findViewById(R.id.frequencyTextView)
        amplitudeTextView = findViewById(R.id.amplitudeTextView)

        oscMessageReceiver = OscMessageReceiver(this,8000,statusTextView, frequencyTextView, amplitudeTextView) // Listening on the same port as the Android app
        oscMessageReceiver.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        oscMessageReceiver.stopListening() // Clean up when the activity is destroyed
    }
}