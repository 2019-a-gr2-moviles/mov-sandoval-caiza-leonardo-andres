package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_producto.*
import java.lang.Exception

class ActualizarProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_producto)
        val id: Int = this.intent.getIntExtra("id", -1)
        val numeroPastillas = this.intent.getIntExtra("pastillas", -1)
        val nombre = this.intent.getStringExtra("nombre")
        val fechaCaducidad = this.intent.getStringExtra("fechaCaducidad")
        val gramosAIngerir = this.intent.getDoubleExtra("gramos", -1.0)
        val usadoPara = this.intent.getStringExtra("uso")
        val composicion = this.intent.getStringExtra("composicion")


        txt_num_pas_med_act.setText(numeroPastillas.toString())
        txt_nom_med_act.setText(nombre.toString())
        fec_cad_med_act.setText(fechaCaducidad)
        txt_gra_med_act.setText(gramosAIngerir.toString())
        txt_uso_med_act.setText(usadoPara)
        txt_comp_med_act.setText(composicion)


        btn_act_med_conf.setOnClickListener {
            try {
                val producto = Producto(
                    id,
                    txt_gra_med_act.text.toString().toDouble(),
                    txt_nom_med_act.text.toString(),
                    txt_comp_med_act.text.toString(),
                    txt_uso_med_act.text.toString(),
                    fec_cad_med_act.text.toString(),
                    txt_num_pas_med_act.text.toString().toInt(),
                    -1,
                    txt_lon_act.text.toString(),
                    txt_lat_act.text.toString()
                )

                actualizarProducto(producto)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Error de Actualizacion: ${ClassAux.nombreUsuario}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarProducto(producto: Producto) {
        try{
        val url = Conexion.url("producto") + "/${producto.id}"
        val json = """
            {
             "nombre" : "${producto.nombre}",
            "composicion" : "${producto.composicion}",
            "usadoPara" : "${producto.usadoPara}",
            "gramosAIngerir" : ${producto.gramosAIngerir},
            "fechaCaducidad" : "${producto.fechaCaducidad}",
            "numeroPastillas" : ${producto.numeroPastillas},
            "latitud" : "${producto.latitud}",
            "longitud" : "${producto.longitud}"
                                                     }
                    """.trimIndent()
        Log.i("http", url)
        Log.i("http", json)
        url.httpPut().body(json)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                        Toast.makeText(
                            this,
                            "Error de Actualizacion: ${ClassAux.nombreUsuario}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    is Result.Success -> {

                        runOnUiThread {
                            Toast.makeText(
                                this,
                                "Actualizacion Exitosa: ${ClassAux.nombreUsuario}",
                                Toast.LENGTH_LONG
                            ).show()
                            irAListaTiendas()
                        }
                    }
                }
            }}catch (e:Exception){
            Toast.makeText(
                this,
                "Error de Actualizacion: ${ClassAux.nombreUsuario}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun irAListaTiendas() {
        intent = Intent(
            this,
            ListaTiendas::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}
