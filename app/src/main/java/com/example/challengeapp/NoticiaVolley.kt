package com.example.challengeapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import layout.Noticia
import org.json.JSONObject

class NoticiaVolley(val url: String, val context: Context, val noticiaAdapter: NoticiaRecyclerAdapter){
    val queue = Volley.newRequestQueue(context)

    fun callNewslAPI(){
        val dataNews = ArrayList<Noticia>()

        val requestNews = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener<JSONObject>{
                    response ->
                val  noticias = response.getJSONArray("articles")

                for(i in 0..noticias.length()-1){
                    val noticiaFull = noticias.getJSONObject(i)

                    val noticia = Noticia(noticiaFull.getString("title"), noticiaFull.getString("description"),  noticiaFull.getString("urlToImage"))

                    dataNews.add(noticia)
                }
                noticiaAdapter.setData(dataNews)
            }, Response.ErrorListener {
                Toast.makeText(context, "Hubo un error", Toast.LENGTH_LONG).show()
                Log.d("noticiavolley", "error ${it.message}")
            })

        queue.add(requestNews)
    }
}