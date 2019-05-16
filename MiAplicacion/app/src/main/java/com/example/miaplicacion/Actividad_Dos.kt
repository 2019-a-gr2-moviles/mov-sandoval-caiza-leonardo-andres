package com.example.miaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)
    }

    fun irAActividadMain(){
        var intent  = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
    }
}
