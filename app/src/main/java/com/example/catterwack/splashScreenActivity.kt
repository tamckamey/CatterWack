package com.example.catterwack

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class StartScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashCat: ImageView = findViewById(R.id.startCat);
        val startButton: Button = findViewById(R.id.startButton);
        val heading: TextView = findViewById(R.id.heading);
        val subHeading: TextView = findViewById(R.id.subheading);

        splashCat.alpha = 0f;
        splashCat.translationX = -300f;
        splashCat.animate().setDuration(1000).alpha(1f);
        splashCat.animate().setDuration(1000).translationX(0f);

        startButton.translationY = -300f;
        startButton.alpha = 0f;
        startButton.animate().setDuration(1000).translationY(0f);
        startButton.animate().setDuration(1000).alpha(1f);

        startButton.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(this, R.raw.catmeowing);
            mediaPlayer.setVolume(1.0f, 1.0f);
            mediaPlayer.start();
            splashCat.animate().setDuration(500).alpha(0f);
            heading.animate().setDuration(500).alpha(0f);
            subHeading.animate().setDuration(500).alpha(0f);
            startButton.animate().setDuration(500).alpha(0f).withEndAction{
                val i = Intent(this, MainActivity::class.java)
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                Handler().postDelayed({ // I noticed that when I return to the splash screen, it's all still invisible.
                    startButton.alpha = 1f;
                    splashCat.alpha = 1f;
                    heading.alpha = 1f;
                    subHeading.alpha = 1f;
                }, 1000); //1000ms delay.
            }
        }
    }
}