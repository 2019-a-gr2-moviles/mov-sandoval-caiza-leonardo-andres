package com.example.examen2b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_tienda.*
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class CrearTienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_tienda)

        btn_insertar_tienda.setOnClickListener {
            try {
                val tienda = Tienda(
                    null,
                    -1,
                    txt_nom_tienda.text.toString(),
                    txt_dir_tienda.text.toString(),
                    txt_fecha_tienda.text.toString(),
                    txt_ruc_tienda.text.toString().toInt(),
                    sw_matriz_tienda.text.toString().toBoolean()
                )
                ingresarPaciente(tienda)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "${Auxiliar.nombreUsuario}: Operación fallida",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarPaciente(tienda: Tienda) {
        try {
            val url = Conexion.url("tienda")
            val json = """
            {
            "nombres": "${tienda.nombres}",
            "direccion": "${tienda.direccion}",
            "fechaApertura": "${tienda.fechaApertura}",
            "ruc": ${tienda.ruc},
            "matriz" : ${tienda.matriz}
                                         }
                    """.trimIndent()

            Log.i("http", json)
            url.httpPost().body(json)
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http", "Error: ${ex.message}")
                        }
                        is Result.Success -> {
                            runOnUiThread {
                                Toast.makeText(
                                    this,
                                    "${Auxiliar.nombreUsuario}: Operación fallida",
                                    Toast.LENGTH_LONG
                                ).show()
                                irListaPacientes()
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "${Auxiliar.nombreUsuario}: Operación fallida",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaPacientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
