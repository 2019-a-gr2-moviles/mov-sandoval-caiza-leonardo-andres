package com.example.deber_rv_youtube

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val lista = arrayListOf<Video>()
        // val recycler_view = rv_personas
        //val actividad = this //esto es el contexto
        for(num in 1..10) {
            lista.add(Video("Silencio en el callejon", "50M", "Santa Fe Clan", 1))
            lista.add(Video("Te ire a Buscar", "25M", "Santa ft Nanpa", 2))
            lista.add(Video("Fuego", "20M", "Almas de Barrio ft Santa", 3))
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

    fun cambiarNombreTextView(texto: String){
        textView2.text=texto
    }

}
