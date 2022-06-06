package com.example.catterwack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.catterwack.NewCat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Grabbing elements.
        val catPawLeft: ImageView = findViewById(R.id.catPawLeft);
        val catPawRight: ImageView = findViewById(R.id.catPawRight);
        val newCatButton: Button = findViewById(R.id.newCat);
        val loadCatButton: Button = findViewById(R.id.loadCat);
        val whyButton: Button = findViewById(R.id.whyButton);

        //Setting the stage.
        catPawLeft.translationX = -300f;
        catPawRight.translationX = 300f;
        catPawLeft.translationY = -150f;
        catPawRight.translationY = -150f;
        newCatButton.translationX = -500f;
        loadCatButton.translationX = -500f;
        whyButton.translationX = -500f;
        catPawLeft.rotation = 50f;
        catPawRight.rotation = -50f;

        //Animating elements.
        catPawLeft.animate().setDuration(250).translationX(0f);
        catPawRight.animate().setDuration(250).translationX(0f);
        catPawLeft.animate().setDuration(250).translationY(0f);
        catPawRight.animate().setDuration(250).translationY(0f);
        newCatButton.animate().setDuration(300).translationX(0f);
        loadCatButton.animate().setDuration(400).translationX(0f);
        whyButton.animate().setDuration(500).translationX(0f);

        catPawRight.animate().setDuration(300).rotation(0f);
        catPawLeft.animate().setDuration(300).rotation(0f);

        whyButton.setOnClickListener{
            val i = Intent(this, AboutPage::class.java)
            startActivity(i);
        }

        newCatButton.setOnClickListener{
            val i = Intent(this, NewCat::class.java)
            startActivity(i);
        }

        loadCatButton.setOnClickListener{
            val i = Intent(this, previous_cat::class.java)
            startActivity(i);
        }
    }
}