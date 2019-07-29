package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_productos.*

class MenuProductos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_productos)
        val idTienda = this.intent.getIntExtra("idTienda", -1)

        btn_menu_producto.setOnClickListener {
            irAListaProductos(idTienda)
        }


        btn_crear_producto.setOnClickListener {
            irACrearProducto(idTienda)
        }
        btn_mapa.setOnClickListener {
            irMapa(idTienda)
        }


    }


     fun irAListaProductos(idTienda: Int) {
        val intent = Intent(
            this,
            ListaProductos::class.java
        )
        intent.putExtra("idTienda", idTienda)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun irACrearProducto(idTienda: Int) {
        val intent = Intent(
            this,
            CrearProducto::class.java
        )
        intent.putExtra("idTienda", idTienda)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irMapa(idTienda: Int) {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        intent.putExtra("idTienda", idTienda)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
