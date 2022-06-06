package com.example.catterwack.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_data")
data class Cat (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val gender: String,
    val age: Int,
    val image: String
)