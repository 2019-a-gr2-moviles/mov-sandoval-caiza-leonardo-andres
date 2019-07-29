package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_entrar.setOnClickListener {
            ClassAux.nombreUsuario = txt_usuario.text.toString()
            irAMenuTienda()
            Toast.makeText(
                this,
                "Ingreso Exitoso: ${ClassAux.nombreUsuario}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun irAMenuTienda() {
        val intent = Intent(
            this,
            MenuTienda::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
