package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()
       // val recycler_view = rv_personas
        //val actividad = this //esto es el contexto


        lista.add(Persona("Leonardo","171819134"))
        lista.add(Persona("Andres","0192839495"))
        lista.add(Persona("Sandoval","2003938182"))

        iniciarRecyclerView(lista, this,rv_personas)

    }

    fun iniciarRecyclerView(lista: List<Persona>, actividad:ReciclerViewActivity, recycler_view: RecyclerView){
        val adaptadorPersona = AdaptadorPersona(lista,
            actividad,
            recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()

    }

    fun cambiarNombreTextView(texto: String){
        txv_titulo_rv.text=texto
    }

}
