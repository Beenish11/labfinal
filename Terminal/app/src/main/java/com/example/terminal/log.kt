package com.example.terminal

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.nfc.Tag
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.security.Provider

class service : Service(){
    val Tag = "service"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "I am Started", Toast.LENGTH_SHORT).show()
        Log.d(Tag,"Started")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "I am Destroyed", Toast.LENGTH_SHORT).show()
        Log.d(Tag,"Destroyed")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}