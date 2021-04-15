package com.example.moedabitcoin.api

import android.accessibilityservice.AccessibilityService
import android.media.AudioManager
import android.media.AudioManager.ADJUST_RAISE
import android.view.accessibility.AccessibilityEvent

class CoinAccessibility : AccessibilityService (){

    private val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

    override fun onAccessibilityEvent(accessibilityEvent: AccessibilityEvent) {
        if (accessibilityEvent.source.text == "Aumentar Volume"){
            audioManager.adjustStreamVolume(AudioManager.STREAM_ACCESSIBILITY, ADJUST_RAISE, 0)
        }

    }

    override fun onInterrupt() {


    }
}