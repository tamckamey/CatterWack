package com.example.catterwack.data

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CatRepository(private val catDao: CatDao) {

    var readAllData: List<Cat> = catDao.readAllData();


    fun addCat(cat: Cat) {
        catDao.addCat(cat);
    }
}
