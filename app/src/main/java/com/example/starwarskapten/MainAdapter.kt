package com.example.starwarskapten

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val trips = listOf<String>("1","2","3")

    override fun getItemCount(): Int {
        return trips.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0?.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_list,p0,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(handler: CustomViewHolder, postiton: Int) {
        val trips = trips.get(postiton)
        handler.view.textView_item_name.text=trips
    }

}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){

}