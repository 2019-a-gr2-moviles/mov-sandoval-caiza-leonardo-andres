package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_actualizar_tienda.*
import java.lang.Exception

class ActualizarTienda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_tienda)
        val id: Int = this.intent.getIntExtra("id", -1)
        val nombres: String = this.intent.getStringExtra("nombres")
        val apellidos: String = this.intent.getStringExtra("apellidos")
        val fechaNacimiento: String = this.intent.getStringExtra("fechaNacimiento")
        val hijos: Int = this.intent.getIntExtra("hijos", -1)
        val tieneSeguro: Boolean = this.intent.getBooleanExtra("seguro", false)


        txt_nom_pac_act.setText(nombres)
        txt_ape_pac_act.setText(apellidos)
        fec_nac_pac_act.setText(fechaNacimiento)
        txt_hij_pac_act.setText(hijos.toString())

        btn_act_pac_conf.setOnClickListener {
            try {
                var seguro = false
                if (sw_seg_pac_act.isChecked) {
                    seguro = true
                }
                val tienda = Tienda(
                    null,
                    id,
                    txt_nom_pac_act.text.toString(),
                    txt_ape_pac_act.text.toString(),
                    fec_nac_pac_act.text.toString(),
                    txt_hij_pac_act.text.toString().toInt(),
                    seguro
                )
                actualizarTienda(tienda)
            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "Error de Actualizacion: ${ClassAux.nombreUsuario}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun actualizarTienda(tienda: Tienda) {
        try {
            val url = Conexion.url("tienda") + "/${tienda.id}"
            val json = """
            {
            "nombres": "${tienda.nombres}",
            "apellidos": "${tienda.apellidos}",
            "fechaNacimiento": "${tienda.fechaNacimiento}",
            "hijos": ${tienda.hijos},
            "tieneSeguro" : ${tienda.tieneSeguro}
                                         }
                    """.trimIndent()

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
                }
        } catch (e: Exception) {
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
