package com.vajra.musiconmovementsreceiver

import android.content.Context
import android.util.Log
import android.widget.TextView
import javaosc.OSCMessage
import javaosc.OSCPortIn
import java.util.Date

class OscMessageReceiver(
    private val context: Context,
    private val port: Int,
    private val statusTextView: TextView,
    private val xTextView: TextView,
    private val yTextView: TextView
){
    private var oscPortIn: OSCPortIn? = null

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

    private fun handleOscMessage(x: Float, y: Float) {
        (context as MainActivity).runOnUiThread {
            statusTextView.text = "Receiving messages started"
            xTextView.text = "X Value: $x"
            yTextView.text = "Y Value: $y"
        }
    }

    fun stopListening() {
        oscPortIn?.stopListening()
        oscPortIn = null
    }
}