package com.example.miaplicacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad__dos.*
import kotlinx.android.synthetic.main.content_main.*

class Actividad_Dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad__dos)

        buttonActividad1.setOnClickListener{
            this.irAActividadMain()
            //irAActividad2()
        }
    }



    fun irAActividadMain(){
        var intent  = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
    }
}
