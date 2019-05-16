package com.example.starwarskapten

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerView_main.setBackgroundColor(Color.BLUE)
        recyclerView_main.layoutManager= LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter()

        fetchJson()
    }

     fun fetchJson(){
        println("fetch")
         val urlkapten = "https://backup-star-wars.herokuapp.com/trips"
         val otherurl = "https://api.letsbuildthatapp.com/youtube/home_feed"
         val mock = "https://demo2421622.mockable.io/starwars"
         val client = OkHttpClient()
         val request = Request.Builder().url(mock).build()



        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
            }
        })
    }
}
