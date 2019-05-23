package com.example.miaplicacion2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnParcelable.setOnClickListener{
            irAParcelable()
        }
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
    val leonardo= Usuario("Leonardo", 23, Date(), 12.2)
    intentExplicito.putExtra("usuario",leonardo)

        val cachetes = Mascotas("Cachetes", leonardo)
        intentExplicito.putExtra("mascota",cachetes)

        startActivity(intentExplicito)
    }
}
