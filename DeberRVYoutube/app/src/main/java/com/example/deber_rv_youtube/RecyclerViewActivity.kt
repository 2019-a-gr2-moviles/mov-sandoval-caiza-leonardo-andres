package com.example.deber_rv_youtube

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.layout.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val lista = arrayListOf<Video>()
        // val recycler_view = rv_personas
        //val actividad = this //esto es el contexto
        for(num in 1..10) {
            lista.add(Video("Salsa romantica del ayer y hoy", "50M", "Link de descarga. Lista de Canciones", 1))
            lista.add(Video("Salsa romantica ix", "25M", "Las mejores salsa romanticas", 2))
            lista.add(Video("salsas viejitas pero bonitas", "20M", "Espero que les guste, les invito a mi blog", 3))
            lista.add(Video("Salsas mix 100% bailable", "10M", "Top mix para bailar", 4))
            lista.add(Video("salsas para bailar", "25M", "Las mejores mezclas DJ Leo", 5))
            lista.add(Video("Salsa mix del recuerdo", "45M", "Viejitas pero bonitas", 6))

        }


        iniciarRecyclerView(lista, this,rv_videos)

    }

    fun iniciarRecyclerView(lista: List<Video>, actividad:RecyclerViewActivity, recycler_view: RecyclerView){
        val adaptadorPersona = AdaptadorVideo(lista,
            actividad,
            recycler_view)

        rv_videos.adapter = adaptadorPersona
        rv_videos.itemAnimator = DefaultItemAnimator()
        rv_videos.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()

    }

    fun iniciarRecyclerView2(lista: List<Comentario>, actividad:RecyclerViewActivity, recycler_view: RecyclerView){
        val adaptadorPersona = AdaptadorComentario(lista,
            actividad,
            recycler_view)

        rv_videos.adapter = adaptadorPersona
        rv_videos.itemAnimator = DefaultItemAnimator()
        rv_videos.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()

    }


    fun cambiarNombreTextView(texto: String){
        textView2.text=texto
    }

}
