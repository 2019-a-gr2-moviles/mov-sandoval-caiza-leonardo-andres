package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_tienda.*

class MenuTienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_tienda)

        btn_menu_tienda.setOnClickListener {
            irAListaTiendas()
        }
        btn_crear_tienda.setOnClickListener {
            irACrearTienda()
        }

        btn_mapa2.setOnClickListener {
            obtenerMedicamentos()
            irAMapa()
        }
    }

    private fun irAListaTiendas() {
        val intent = Intent(
            this,
            ListaTiendas::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irACrearTienda() {
        val intent = Intent(
            this,
            CrearTienda::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        startActivity(intent)
    }

    fun obtenerMedicamentos() {

    }

    private fun irAMapa() {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
