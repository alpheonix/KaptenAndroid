package com.example.starwarskapten

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import okhttp3.OkHttpClient



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerView_main.setBackgroundColor(Color.BLUE)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        //recyclerView_main.adapter = MainAdapter()
        println("teeeeeeeeest")
        fetchJson()
    }

        fun fetchJson() {
            println("fetch")
            val urlkapten = "https://backup-star-wars.herokuapp.com/trips"
            val otherurl = "https://api.letsbuildthatapp.com/youtube/home_feed"
            val mock = "https://demo2421622.mockable.io/starwars"
            val client = OkHttpClient()
            //cette requette ne marche pas erreur 406
            //val request = Request.Builder().url(urlkapten).addHeader("Content-Type", "application/json").build()
            val request = Request.Builder().url(mock).addHeader("Content-Type", "application/json").build()






            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body()?.string()
                    val gson = GsonBuilder().create()
                    val trips:Array<Trips> = gson.fromJson(body,Array<Trips>::class.java)
                    runOnUiThread{
                        recyclerView_main.adapter = MainAdapter(trips)
                    }
                }
            })
        }
    }

class Trips(val id: Int, val pilot: Pilot,val pick_up: Pick_up,val drop_off: Drop_off)

class Pilot(val name: String,val avatar:String,val rate:Int)
class Pick_up(val name:String,val picture:String,val date:String)
class Drop_off(val name:String,val picture:String,val date:String)

