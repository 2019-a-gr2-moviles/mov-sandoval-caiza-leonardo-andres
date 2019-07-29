package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_productos.*

class ListaProductos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)
        val idTienda = this.intent.getIntExtra("idTienda", -1)
        iniciarRecyclerView(ClassAux.listaProducto, this, rv_productos)

    }

    fun iniciarRecyclerView(
        listaProductos: ArrayList<Producto>,
        actividad: ListaProductos,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorProductos = AdaptadorListaProductos(listaProductos, actividad, recyclerView)
        rv_productos.adapter = adaptadorProductos
        rv_productos.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_productos.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorProductos.notifyDataSetChanged()
    }

    fun eliminarProducto(idProducto: Int) {
        val url = Conexion.url("producto") + "?id=${idProducto}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        ClassAux.listaProductoCompleta = arrayListOf()
                        runOnUiThread {
                            irAListaTiendas()
                        }
                        Toast.makeText(
                            this,
                            "Producto eliminado correctamente: ${ClassAux.nombreUsuario}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
    }

    fun irAListaTiendas() {
        val intent = Intent(
            this,
            ListaTiendas::class.java
        )
        startActivity(intent)
    }


    fun irActualizarProducto(producto: Producto) {
        val intent = Intent(
            this,
            ActualizarProducto::class.java
        )
        intent.putExtra("id", producto.id)
        intent.putExtra("uso", "${producto.usadoPara}")
        intent.putExtra("gramos", producto.gramosAIngerir)
        intent.putExtra("composicion", "${producto.composicion}")
        intent.putExtra("nombre", "${producto.nombre}")
        intent.putExtra("fechaCaducidad", "${producto.fechaCaducidad}")
        intent.putExtra("pastillas", producto.numeroPastillas)
        startActivity(intent)
    }

}
