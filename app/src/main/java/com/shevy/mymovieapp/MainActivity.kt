package com.shevy.mymovieapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById<Button>(R.id.main_activity_register_button)

        btn_click_me.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "You click me", Toast.LENGTH_SHORT).show()
        }
    }

/*    fun clickBut(view: View) {
        Toast.makeText(this, "You click me", Toast.LENGTH_SHORT).show()
    }*/


}