package com.vajra.musiconmovementsreceiver

interface OnOscMessageReceivedListener {
    fun onOscMessageReceived(x: Float, y: Float)
}