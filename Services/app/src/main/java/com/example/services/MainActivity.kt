package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R

class NewService : Service() {
    // declaring object of MediaPlayer
    private var player: MediaPlayer? = null

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        // providing the boolean
        // value as true to play
        // the audio on loop
        player.setLooping(true)

        // starting the process
        player.start()

        // returns the status
        // of the program
        return START_STICKY
    }

    // execution of the service will
    // stop on calling this method
    override fun onDestroy() {
        super.onDestroy()

        // stopping the process
        player!!.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    class MainActivity : AppCompatActivity(), View.OnClickListener {
        // declaring objects of Button class
        private var start: Button? = null
        private var stop: Button? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // assigning ID of startButton
            // to the object start
            start = findViewById<View>(R.id.startButton) as Button

            // assigning ID of stopButton
            // to the object stop
            stop = findViewById<View>(R.id.stopButton) as Button

            // declaring listeners for the
            // buttons to make them respond
            // correctly according to the process
            start!!.setOnClickListener(this)
            stop!!.setOnClickListener(this)
        }

        override fun onClick(view: View) {

            // process to be performed
            // if start button is clicked
            if (view === start) {

                // starting the service
                startService(Intent(this, NewService::class.java))
            } else if (view === stop) {

                // stopping the service
                stopService(Intent(this, NewService::class.java))
            }
        }
    }
}
}