package com.example.esraa.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var athletesList: List<Athletes>? = null

    private var recyclerView: RecyclerView? = null
    private var athAdapter: AthletesAdapter? = null

    private val ROOT_URL = "https://gist.githubusercontent.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val builder = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = builder.create<ApiResponce>(ApiResponce::class.java!!)
        val call = api.getMyJSON()

        athletesList = ArrayList<Athletes>()
        call.enqueue(object : Callback<AthletesList> {
            override fun onResponse(call: Call<AthletesList>, response: Response<AthletesList>) {
                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    athletesList = response.body().athlete!!
                    recyclerView = findViewById(R.id.recycleview) as RecyclerView
                    athAdapter = AthletesAdapter(this@MainActivity, athletesList)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.setLayoutManager(eLayoutManager)
                    recyclerView!!.setItemAnimator(DefaultItemAnimator())
                    recyclerView!!.setAdapter(athAdapter)
                }
            }

            override fun onFailure(call: Call<AthletesList>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Download fail",
                    Toast.LENGTH_LONG
                ).show()

            }
        })


    }
}
