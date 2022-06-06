package com.example.catterwack

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val backButton: Button = findViewById(R.id.about_backButton);
        val ageButton: Button = findViewById(R.id.ageEstimatorButton);
        val genderButton: Button = findViewById(R.id.genderEstimatorLink);
        val pictureButton: Button = findViewById(R.id.catPictureButton);

        backButton.setOnClickListener{
            this.finish();
        }

        genderButton.setOnClickListener{
            intent = Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://genderize.io/"));
            startActivity(intent);
        }

        ageButton.setOnClickListener{
            intent = Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://agify.io/"));
            startActivity(intent);
        }

        pictureButton.setOnClickListener{
            intent = Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://docs.thecatapi.com/"));
            startActivity(intent);
        }
    }
}