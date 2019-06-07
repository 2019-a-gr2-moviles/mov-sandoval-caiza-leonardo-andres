package com.example.miaplicacion2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.AdaptadorPersona
import com.example.myapplication2.Persona
import com.example.myapplication2.R

class ReciclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)


        val actividad=this


        val lista = arrayListOf<Persona>()
        lista.add(Persona("Leonardo","1723922173"))
        lista.add(Persona("Andres", "1711279111"))
        lista.add(Persona("Mishu","1723902472"))

        val adaptadorPersona=AdaptadorPersona(lista, actividad, recycler_view)

        adaptadorPersona.notifyDataSetChanged()
    }
}
