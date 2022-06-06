package com.example.catterwack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.catterwack.ListAdapter
import com.example.catterwack.data.CatViewModel
import com.example.catterwack.data.CatDatabase
import com.example.catterwack.data.CatDao
import com.example.catterwack.data.Cat
import kotlinx.android.synthetic.main.activity_load_screen.view.*

class LoadScreen : AppCompatActivity() {

    //private lateinit var mCatViewModel: CatViewModel
    //private lateinit var db: CatDatabase;
    //private lateinit var catDao: CatDao;
    //private lateinit var cat: Cat;
    //private lateinit var adapter: ListAdapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_screen);
        //db = CatDatabase.getDatabase(this);
        //catDao = db.catDao();
        //var len = catDao.readAllData();

        //val view = layoutInflater.inflate(R.layout.activity_load_screen, null);
        //adapter = ListAdapter();
        //Log.d("Amount", ListAdapter().itemCount.toString());
        //val recyclerView = view.load_recycler;
        //recyclerView.adapter = adapter;
        // recyclerView.layoutManager = LinearLayoutManager(this);

        // mCatViewModel = ViewModelProvider(this)[CatViewModel::class.java];
        //mCatViewModel.readAllData.observe(this, Observer { cat ->
        //  adapter.setData(cat);
        //})

    }
}