package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_noticia__layout.*
import kotlinx.android.synthetic.main.activity_splashscreen.*
import kotlinx.android.synthetic.main.activity_splashscreen.news_image
import layout.Noticia

class Noticia_Layout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticia__layout)

        val noticia = intent.getSerializableExtra("noticia") as? Noticia
        news_image.setImage(noticia!!.image)
        news_description.setText(noticia.description)
        news_title.setText(noticia.title)
    }

    fun ImageView.setImage(url:String){
        val options = RequestOptions()
            .error(R.mipmap.ic_launcher_round)
        Glide.with(this)
            .setDefaultRequestOptions(options)
            .load(url)
            .into(this)
    }
}

