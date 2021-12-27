package com.example.terminal

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class StartActivityOnBoot : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            val i = Intent(context, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    class service : Service(){
        val Tag = "service"

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            Toast.makeText(this, "I amStarted", Toast.LENGTH_SHORT).show()
            Log.d(Tag,"Destroyed")
            return super.onStartCommand(intent, flags, startId)
        }

        override fun onBind(p0: Intent?): IBinder? {
            return null
        }
    }
}