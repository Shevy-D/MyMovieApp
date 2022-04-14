package com.shevy.mymovieapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

/*    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { resultCallback ->

        this.onSignInResult(resultCallback)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Firebase.database.reference
        database.child("user2").child("userId").setValue("user")
        Log.d("Database Main Activity", "Database2 = $database")

        val btn_click_me = findViewById<Button>(R.id.main_activity_register_button)

        btn_click_me.setOnClickListener{
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
            //Toast.makeText(this, "You click me", Toast.LENGTH_SHORT).show()
        }
    }

/*    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        //
    }*/

/*    fun clickBut(view: View) {
        Toast.makeText(this, "You click me", Toast.LENGTH_SHORT).show()
    }*/


}