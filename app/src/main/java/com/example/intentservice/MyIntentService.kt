package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    companion object {
        private var instance: MyIntentService? = null
        var isRunning = false

        fun stopService() {
            instance?.let {
                Log.d("IntentService", "Service is stopping...")
                isRunning = false
                it.stopSelf()
            }
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("IntentService", "Service is running...")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}
