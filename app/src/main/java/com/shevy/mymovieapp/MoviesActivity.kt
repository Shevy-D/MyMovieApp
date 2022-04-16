package com.shevy.mymovieapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        val apiInterface = ApiInterface.create().getMovies("dac5fe2bb3492da449a9b21a6b075c11")

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                Log.d("testLogs", "OnResponse success ${response?.body()?.results}")

                // This will pass the ArrayList to our Adapter
                val adapter = response?.body()?.results?.let { CustomAdapter(it) }

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter

            /*if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)*/
            }

            override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                Log.d("testLogs", "onFailure ${t?.message}")

            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity();
    }
}