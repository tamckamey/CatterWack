package com.example.catterwack.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch;

class CatViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: List<Cat>
    private val repository: CatRepository

    init {
        val catDao = CatDatabase.getDatabase(application).catDao();
        repository = CatRepository(catDao);
        readAllData = repository.readAllData

    }

    fun addCat(cat: Cat) {
        Log.d("SAVE", "Received request")
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCat(cat);
        }
    }

}