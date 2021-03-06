package com.example.examen_1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.menu_principal.*

class MenuPrincipal : AppCompatActivity() {

    var usuario :String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)
        usuario = intent.getStringExtra("usuario").toString()
        btnTienda.setOnClickListener {gestionarTienda() }
        btnCrearTienda.setOnClickListener{ crearTienda()}
    }

    fun gestionarTienda(){
        val intentGestionarTienda = Intent(this, ListaTienda::class.java)
        intentGestionarTienda.putExtra("usuario", usuario)
        startActivity(intentGestionarTienda)
    }

    fun crearTienda(){
        val intentCrearTienda = Intent(this, IngresarTenda::class.java)
        intentCrearTienda.putExtra("usuario", usuario)
        startActivity(intentCrearTienda)
    }
}
