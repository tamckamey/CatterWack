package com.example.catterwack

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catterwack.data.Cat
import kotlinx.android.synthetic.main.cat_item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var catList = emptyList<Cat>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false))
    }

    override fun getItemCount(): Int {

        return catList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCat = catList[position];
        holder.itemView.id_name.text = currentCat.name;
        holder.itemView.id_age.text = currentCat.age.toString();
        holder.itemView.id_gender.text = currentCat.gender;
    }

    fun setData(cat: List<Cat>){
        this.catList = cat;
        notifyDataSetChanged();
    }
}