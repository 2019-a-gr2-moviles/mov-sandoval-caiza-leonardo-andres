package com.example.miaplicacion2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val leonardo: Usuario? = this.intent
            .getParcelableExtra<Usuario>("usuario")


        val cachetes: Mascotas? = this.intent
            .getParcelableExtra<Mascotas>("mascota")

        Log.i("parcelable","Nombre: ${leonardo?.nombre}")
        Log.i("parcelable","Edad: ${leonardo?.edad}")
        Log.i("parcelable","Fecha: ${leonardo?.fechaNacimiento.toString()}")
        Log.i("parcelable","Sueldo: ${leonardo?.sueldo}")

        Log.i("parcelable","Nombre ${cachetes?.nombre}")
        Log.i("parcelable","Nombre ${cachetes?.duenio?.nombre}")



        btnMenu.setOnClickListener{
            regresarMenu();
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
