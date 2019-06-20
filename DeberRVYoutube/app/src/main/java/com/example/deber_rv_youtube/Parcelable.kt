package com.example.deber_rv_youtube

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val leonardo: Usuario = this.intent.getParcelableExtra<Usuario>("usuario")
        Log.i("parcelable","Nombre: ${leonardo.nombre}")
        Log.i("parcelable","Edad: ${leonardo.edad}")
        Log.i("parcelable","Fecha Nacimiento: ${leonardo.fechaNacimiento.toString()}")
        Log.i("parcelable","Sueldo: ${leonardo.sueldo}")

        btn_menu.setOnClickListener {
            regresarMenu()
        }
    }

    fun regresarMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }

}