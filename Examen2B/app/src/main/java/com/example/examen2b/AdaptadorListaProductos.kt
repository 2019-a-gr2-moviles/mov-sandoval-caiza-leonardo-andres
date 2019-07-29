package com.example.examen2b

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class AdaptadorListaProductos(
    private val listaProductos: ArrayList<Producto>,
    private val contexto: ListaProductos,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorListaProductos.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var idTiendaTextView: TextView
        var idTextView: TextView
        var nombreTextView: TextView
        var composicionTextView: TextView
        var gramosTextView: TextView
        var pastillasTextView: TextView
        var usoTextView: TextView
        var fechaCaducidadTextView: TextView
        var eliminarBoton: Button
        var actualizarBoton: Button

        init {

            idTiendaTextView = view.findViewById(R.id.txv_id_tienda_producto) as TextView
            idTextView = view.findViewById(R.id.txv_id_producto) as TextView
            nombreTextView = view.findViewById(R.id.txv_nombre_producto) as TextView
            composicionTextView = view.findViewById(R.id.txv_descripcion_producto) as TextView
            gramosTextView = view.findViewById(R.id.txv_precio_producto) as TextView
            pastillasTextView = view.findViewById(R.id.txv_anios_garant_producto) as TextView
            usoTextView = view.findViewById(R.id.txv_numero_producto) as TextView
            fechaCaducidadTextView = view.findViewById(R.id.txv_fecha_lanz_producto) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eliminar_prod) as Button
            actualizarBoton = view.findViewById(R.id.btn_actualizar_prod) as Button


            actualizarBoton.setOnClickListener {
                val producto = Producto(
                    idTextView.text.toString().toInt(),
                    gramosTextView.text.toString().toDouble(),
                    nombreTextView.text.toString(),
                    composicionTextView.text.toString(),
                    usoTextView.text.toString(),
                    fechaCaducidadTextView.text.toString(),
                    pastillasTextView.text.toString().toInt(),
                    idTiendaTextView.text.toString().toInt(),
                    "0", "0"
                )
                contexto.irActualizarProducto(producto)

            }

            eliminarBoton.setOnClickListener {

                contexto.eliminarProducto(idTextView.text.toString().toInt())

            }
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_producto,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val producto: Producto = listaProductos[position]
        myViewHolder.idTextView.text = producto.id.toString()
        myViewHolder.idTiendaTextView.text = producto.idTienda.toString()
        myViewHolder.nombreTextView.text = producto.nombre
        myViewHolder.composicionTextView.text = producto.composicion
        myViewHolder.gramosTextView.text = producto.gramosAIngerir.toString()
        myViewHolder.fechaCaducidadTextView.text = producto.fechaCaducidad
        myViewHolder.pastillasTextView.text = producto.numeroPastillas.toString()
        myViewHolder.usoTextView.text = producto.usadoPara
    }

}