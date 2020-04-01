package com.example.challengeapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_noticia__layout.view.*
import layout.Noticia

class NoticiaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var noticias: List<Noticia> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoticiaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_noticia__layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noticias.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NoticiaViewHolder -> {
                holder.bind(noticias.get(position))
                holder.itemView.setOnClickListener {
                    val contexto = it.context
                    val intent = Intent(contexto, Noticia_Layout::class.java)
                    intent.putExtra("noticia", noticias[position])
                    contexto.startActivity(intent)
                    //Toast.makeText(contexto,"INSIDE NOTICIA", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun setData(listNews: List<Noticia>){
        noticias = listNews
        notifyDataSetChanged()
    }

    class NoticiaViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.news_title
        val description = itemView.news_description
        val imageNews = itemView.news_image

        fun bind (noticia: Noticia){
            title.text = noticia.title
            description.text = noticia.description
            imageNews.setImage(noticia.image)
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

}