package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var noticiaAdapter: NoticiaRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
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
