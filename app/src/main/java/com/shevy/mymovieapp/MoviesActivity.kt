package com.shevy.mymovieapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(com.firebase.ui.auth.R.drawable.common_full_open_on_phone, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        val apiInterface = ApiInterface.create().getMovies()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<TestingDatClass> {
            override fun onResponse(call: Call<TestingDatClass>?, response: Response<TestingDatClass>?) {
                    Log.d("testLogs", "OnResponse success ${response?.body()?.data?.first_name}")
            /*if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)*/
            }

            override fun onFailure(call: Call<TestingDatClass>?, t: Throwable?) {
                Log.d("testLogs", "onFailure ${t?.message}")

            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity();
    }
}