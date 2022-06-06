package com.example.catterwack.data;

import android.content.Context
import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room

@Database(entities = [Cat::class], version = 1, exportSchema = false)
abstract class CatDatabase: RoomDatabase() {

    abstract fun catDao(): CatDao;

    companion object {
        @Volatile
        private var INSTANCE: CatDatabase? = null;

        fun getDatabase(context: Context): CatDatabase {
            val tempInstance = INSTANCE;
            if(tempInstance != null){
                return tempInstance;
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatDatabase::class.java,
                    "cat_database"
                ).build();
                INSTANCE = instance;
                return instance;
            }
        }
    }
}
