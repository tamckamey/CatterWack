package com.example.catterwack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.catterwack.data.Cat
import com.example.catterwack.data.CatViewModel
import com.example.catterwack.network.AgeApi
import com.example.catterwack.network.AgeApiretrofitHelper
import com.example.catterwack.network.GenderApi
import com.example.catterwack.network.GenderApiretrofitHelper
import com.example.catterwack.network.CatImageApi
import com.example.catterwack.network.CatImageApiretrofitHelper
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import kotlin.math.ceil

class CatPreviewPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_preview_page)
        // Getting elements
        val nameField: TextView = findViewById(R.id.preview_nameField);
        val ageField: TextView = findViewById(R.id.preview_ageField);
        val genderField: TextView = findViewById(R.id.preview_genderField);
        val catName: String = (intent.getStringExtra("catsName")).toString();
        val catPicture: ImageView = findViewById(R.id.preview_catPicture);
        val backButton: Button = findViewById(R.id.preview_backButton);
        val saveButton: Button = findViewById(R.id.preview_saveButton);
        // Setting up Retrofit retrieval
        val ageApi = AgeApiretrofitHelper.getAge().create(AgeApi::class.java)
        val genderApi = GenderApiretrofitHelper.getGender().create(GenderApi::class.java)
        val catImageApi = CatImageApiretrofitHelper.getCatImage().create(CatImageApi::class.java)
        var tempImageUrl = "";
        GlobalScope.launch {
            val ageResult = ageApi.getAge(catName);
            val genderResult = genderApi.getGender(catName);
            val imageUrl = catImageApi.getImage();
            if (ageResult != null && genderResult != null) {
                val catName = ageResult.body()?.name.toString();
                //Using a ternary, and also removing the decimal. This really is a pretty interesting language. Useful features for string manipulation.
                var catAge = if (ageResult.body()?.age.toString() != "0" && ageResult.body()?.age.toString() != "null") ageResult.body()?.age.toString() else ceil(Math.random()*100).toString().substringBefore("."); //Ternary :)
                var catGender = if (genderResult.body()?.gender.toString() != "null") genderResult.body()?.gender.toString() else (if (Math.random() >= .5) "Male" else "Female");
                val catImageURL = imageUrl.body()?.get(0)?.url.toString();
                GlobalScope.launch(Dispatchers.Main) { //Editing UI on correct thread.
                    nameField.text = catName;
                    ageField.text = catAge;
                    genderField.text = catGender;
                    //Since I'm not using this for points, I'm using Picasso for images.
                    //Google's way sucks. :(
                    tempImageUrl = catImageURL;
                    Picasso.get().load(catImageURL).into(catPicture);
                }
            }
        }

        backButton.setOnClickListener{ //Back again!
            this.finish();
        }

        saveButton.setOnClickListener{ //Saving cat!
            val cat = Cat(0, catName, genderField.text.toString(), ageField.text.toString().toInt(), tempImageUrl);
            GlobalScope.launch {
                val model by viewModels<CatViewModel>();
                model.addCat(cat);
            }
            this.finish();
            val i = Intent(this, previous_cat::class.java)
            startActivity(i);

        }
    }
}