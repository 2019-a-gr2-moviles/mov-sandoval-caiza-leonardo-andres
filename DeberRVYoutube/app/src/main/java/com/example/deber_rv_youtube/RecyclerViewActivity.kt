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


        lista.add(Video("Silencio en el callejon","Santa Fe Clan"))
        lista.add(Video("Te ire a Buscar","Santa ft Nanpa"))
        lista.add(Video("Fuego","Almas de Barrio ft Santa"))

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
