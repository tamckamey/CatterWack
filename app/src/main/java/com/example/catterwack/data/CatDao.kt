package com.example.catterwack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query;

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCat(cat: Cat)

    @Query("SELECT * FROM cat_data ORDER BY id ASC")
    fun readAllData(): List<Cat>
}