package com.example.catterwack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class NewCat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_cat)

        // Grabbing elements
        val backButton: Button = findViewById(R.id.new_backButton);
        val createButton: Button = findViewById(R.id.new_createButton);
        val catName: EditText = findViewById(R.id.new_catName);

        // Event listeners
        backButton.setOnClickListener{
            this.finish(); // Go back.
        }

        createButton.setOnClickListener{
            val i = Intent(this, CatPreviewPage::class.java)
            i.putExtra("catsName", catName.text.toString()); // Passing data between screens.
            startActivity(i);
        }
    }
}