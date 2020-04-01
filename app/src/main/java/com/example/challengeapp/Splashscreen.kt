package com.example.challengeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen : AppCompatActivity() {
    private val TIME : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed(
            {startActivity(
                Intent(this, MainActivity::class.java)
            )},
            TIME
        )
    }
}
