package com.example.catterwack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.catterwack.data.Cat
import com.example.catterwack.data.CatDatabase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class previous_cat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_cat);
        var position = 0;
        var maxNum = 0;

        //Grabbing elements
        val catName: TextView = findViewById(R.id.previous_catNameLabel);
        val catAge: TextView = findViewById(R.id.previous_catAgeLabel);
        val catGender: TextView = findViewById(R.id.previous_catGenderLabel);
        val catPicture: ImageView = findViewById(R.id.previous_catImage);
        val previousButton: Button = findViewById(R.id.previous_previous);
        val nextButton: Button = findViewById(R.id.previous_next);
        val backButton: Button = findViewById(R.id.previous_BackButton);

        fun changeInfo(maxIndex: Int, name: String, age: Int, gender: String, catImageURL: String) {
            GlobalScope.launch(Dispatchers.Main) {
                catName.text = name;
                catAge.text = age.toString();
                catGender.text = gender;
                Picasso.get().load(catImageURL).into(catPicture);
                maxNum = maxIndex;
            }
        }

        fun showCat(index: Int) {
            GlobalScope.launch {
                val db = CatDatabase.getDatabase(application);
                val dao = db.catDao();
                val data = dao.readAllData();
                changeInfo(data.size-1, data[index].name, data[index].age, data[index].gender, data[index].image);
            }
        }

        showCat(position); //Loading first cat.

        //Button presses
        previousButton.setOnClickListener{
            if ( position == 0) {
                position = maxNum;
            } else {
                position -= 1;
            }
            showCat(position);
        }

        nextButton.setOnClickListener{
            if ( position == maxNum) {
                position = 0;
            } else {
                position += 1;
            }
            showCat(position);
        }

        backButton.setOnClickListener{
            this.finish();
        }

    }
}