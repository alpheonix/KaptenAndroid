package com.example.starwarskapten

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(val trips:Array<Trips>): RecyclerView.Adapter<CustomViewHolder>() {


    override fun getItemCount(): Int {
        return trips.size
    }

    override fun onCreateViewHolder(group: ViewGroup, index: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(group?.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_list,group,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(handler: CustomViewHolder, postiton: Int) {
        val trips = trips.get(postiton)
        handler.view.textView_item_name.text=trips.pilot.name
        handler.view.textView_item_drop.text=trips.drop_off.name
        handler.view.textView_item_pick.text=trips.pick_up.name


    }

}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){

}