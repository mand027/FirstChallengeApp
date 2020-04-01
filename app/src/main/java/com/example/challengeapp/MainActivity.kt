package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class MainActivity : AppCompatActivity() {

    private lateinit var noticiaAdapter: NoticiaRecyclerAdapter
    var jNews: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        Log.i("Noticias API", getNoticiasApiURL())
        NoticiaVolley(getNoticiasApiURL(), this, noticiaAdapter).callNewslAPI()
    }

    private fun setRecyclerView(){
        recycler_view_noticias.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            noticiaAdapter = NoticiaRecyclerAdapter()
            adapter = noticiaAdapter
        }
    }

    fun getNoticiasApiURL(): String{

        var noticiaAPI : String = "https://newsapi.org/v2/top-headlines?country=mx&apiKey=de962a7a30b64f1eafcae29b75a7f1c2"
        return noticiaAPI
    }

}
