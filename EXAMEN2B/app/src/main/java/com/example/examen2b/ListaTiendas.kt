package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_tiendas.*

class ListaTiendas : AppCompatActivity() {
    private var listaTiendas: ArrayList<Tienda> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obtenerPacientes()
        setContentView(R.layout.activity_lista_tiendas)
    }

    fun iniciarRecyclerView(
        listaTiendas: ArrayList<Tienda>,
        actividad: ListaTiendas,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorCliente = AdaptadorListaTiendas(listaTiendas, actividad, recyclerView)
        rv_tiendas.adapter = adaptadorCliente
        rv_tiendas.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_tiendas.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorCliente.notifyDataSetChanged()
    }

    private fun obtenerPacientes() {

        val url = Conexion.url("tienda")
        Log.i("http", url)
        url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        listaTiendas = Klaxon()
                            .parseArray<Tienda>(data)!! as ArrayList<Tienda>
                        ClassAux.listaProductoCompleta = arrayListOf()
                        listaCompletaMedicamentos(listaTiendas)

                        Log.i("http", "$data")
                        runOnUiThread {
                            iniciarRecyclerView(listaTiendas, this, rv_tiendas)
                        }
                    }
                }
            }
    }

    fun eliminarTienda(idTienda: Int) {
        val url = Conexion.url("tienda") + "?id=${idTienda}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            startActivity(this.intent)
                            Toast.makeText(
                                this,
                                "Tienda eliminada correctamente: ${ClassAux.nombreUsuario}",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                }
            }
    }

    fun irGestionarMedicamentos(idTienda: Int, listaProductos: ArrayList<Producto>?) {
        val intent = Intent(
            this,
            MenuProductos::class.java
        )
        ClassAux.listaProducto = listaProductos!!


        intent.putExtra("idTienda", idTienda)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun listaCompletaMedicamentos(listaTiendas: ArrayList<Tienda>) {
        listaTiendas.forEach { paciente ->
            paciente.productoDeTienda?.forEach { medicamento ->
                ClassAux.listaProductoCompleta.add(medicamento)
            }
        }
    }

    fun irActualizarPaciente(tienda: Tienda) {
        val intent = Intent(
            this,
            ActualizarTienda::class.java
        )
        intent.putExtra("id", tienda.id)
        intent.putExtra("nombres", tienda.nombres)
        intent.putExtra("apellidos", tienda.apellidos)
        intent.putExtra("fechaNacimiento", tienda.fechaNacimiento)
        intent.putExtra("hijos", tienda.hijos)
        intent.putExtra("seguro", tienda.tieneSeguro)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
