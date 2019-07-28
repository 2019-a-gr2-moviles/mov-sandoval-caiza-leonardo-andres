package com.example.examen2b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_tienda.*

class MenuTienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_tienda)

        btn_crear_tienda.setOnClickListener {
            irACrearTienda()
        }
    }

    fun irACrearTienda() {
        val intent = Intent(
            this,
            CrearTienda::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
        startActivity(intent)
    }
}
