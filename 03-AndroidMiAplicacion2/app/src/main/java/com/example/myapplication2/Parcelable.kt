package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        btn_menu.setOnClickListener {
            regresarMenu()
        }


        val karen:Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
        Log.i("parcelable", "Nombre ${karen?.nombre}")
        Log.i("parcelable", "Edad ${karen?.edad}")
        Log.i("parcelable", "Fecha Nacimiento ${karen?.fechaNacimiento.toString()}")
        Log.i("parcelable", "Salario ${karen?.sueldo}")

        val cachetes:Mascota? = this.intent.getParcelableExtra<Mascota>("mascota")
        Log.i("parcelable", "Nombre mascota ${cachetes?.nombre}")
        Log.i("parcelable", "Nombre duenio ${cachetes?.duenio?.nombre}")

    }

    fun regresarMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
