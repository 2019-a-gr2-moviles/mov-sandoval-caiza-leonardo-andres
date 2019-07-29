package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_producto.*
import java.lang.Exception

class CrearProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_producto)
        val idTienda = this.intent.getIntExtra("idTienda", -1)
        btn_ins_med.setOnClickListener {
            try {
                val producto = Producto(
                    -1,
                    txt_gra_med.text.toString().toDouble(),
                    txt_nom_med.text.toString(),
                    txt_comp_med.text.toString(),
                    txt_uso_med.text.toString(),
                    fec_cad_med.text.toString(),
                    txt_num_pas_med.text.toString().toInt(),
                    idTienda,
                    txt_longitud.text.toString(),
                    txt_latitud.text.toString()
                )

                ingresarProducto(producto)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Error al Registrar: ${ClassAux.nombreUsuario}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun ingresarProducto(producto: Producto) {

        try {
            val url = Conexion.url("producto")

            val json = """
            {
            "nombre" : "${producto.nombre}",
            "composicion" : "${producto.composicion}",
            "usadoPara" : "${producto.usadoPara}",
            "gramosAIngerir" : ${producto.gramosAIngerir},
            "fechaCaducidad" : "${producto.fechaCaducidad}",
            "numeroPastillas" : ${producto.numeroPastillas},
            "latitud" : "${producto.latitud}",
            "longitud" : "${producto.longitud}",
            "idTienda": ${producto.idTienda}
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
                                    "Registro Exitoso: ${ClassAux.nombreUsuario}",
                                    Toast.LENGTH_LONG
                                ).show()

                                irAListaTiendas()
                            }
                        }
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Error al Registrar: ${ClassAux.nombreUsuario}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irAListaTiendas() {
        val intent = Intent(
            this,
            ListaTiendas()::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
