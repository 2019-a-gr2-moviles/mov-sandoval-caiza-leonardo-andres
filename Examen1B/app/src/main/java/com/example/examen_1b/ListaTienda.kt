package com.example.examen_1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar_tiendas.*

class ListaTienda : AppCompatActivity() {

    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_tiendas)
        usuario = intent.getStringExtra("usuario").toString()
        val adapter = ArrayAdapter<Tienda>(
            this,
            android.R.layout.simple_list_item_1,
            BDTienda.mostrarTienda()
        )
        lv_tiendas.adapter = adapter;
        lv_tiendas.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val tiendaSeleccionada = parent.getItemAtPosition(position) as Tienda
            val intentTiendaSeleccionada = Intent(this, ActualizarTienda::class.java)
            intentTiendaSeleccionada.putExtra("Equipo", tiendaSeleccionada)
            intentTiendaSeleccionada.putExtra("usuario", usuario)
            startActivity(intentTiendaSeleccionada)
        }


    }
}
