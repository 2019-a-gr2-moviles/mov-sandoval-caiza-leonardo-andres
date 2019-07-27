package com.example.examen2b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar.setOnClickListener {
            irAMenu()

        }
    }

    fun irAMenu(){

        val intentMenu = Intent(this, MenuActivity::class.java)
        intentMenu.putExtra("usuario", txtNombre.text.toString())
        startActivity(intentMenu)
    }
}
