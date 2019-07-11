package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)
        btn_devolver_repuesta.setOnClickListener {
            devolverRespuesta()
        }

    }

    fun devolverRespuesta(){
        val nombre = "Leonardo"
        val edad=23
        val intentRespuesta=Intent()

        intentRespuesta.putExtra("nombreUsuario", nombre)
        intentRespuesta.putExtra("edad", edad)

        this.setResult(
            RESULT_OK,//Se puede enviar tbn RESULT_CANCELED
            intentRespuesta
        )
        this.finish()

    }
}
