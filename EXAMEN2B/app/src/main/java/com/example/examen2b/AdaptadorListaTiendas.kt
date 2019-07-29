package com.example.examen2b

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class AdaptadorListaTiendas(
    private val listaTiendas: ArrayList<Tienda>,
    private val contexto: ListaTiendas,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorListaTiendas.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        //var infoTextView: TextView
        var idTextView: TextView
        var nombresTextView: TextView
        var apellidosTextView: TextView
        var fechaNacimientoTextView: TextView
        var hijosTextView: TextView
        var seguroTextView: TextView
        var eliminarBoton: Button
        var actualizarBoton: Button

        init {

            //infoTextView = view.findViewById(R.id.txv_info_pac) as TextView
            idTextView = view.findViewById(R.id.txv_id_pac) as TextView
            nombresTextView = view.findViewById(R.id.txv_nombres_tienda) as TextView
            apellidosTextView = view.findViewById(R.id.txv_direccion_tienda) as TextView
            fechaNacimientoTextView = view.findViewById(R.id.txv_fecha_apertura_tienda) as TextView
            hijosTextView = view.findViewById(R.id.txv_ruc_tienda) as TextView
            seguroTextView = view.findViewById(R.id.txv_matriz_tienda) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eliminar_tienda) as Button
            actualizarBoton = view.findViewById(R.id.btn_actualizar_tienda) as Button

            val layout = view.findViewById(R.id.lay_tienda) as LinearLayout

            layout.setOnClickListener {
                val tienda: Tienda? = listaTiendas.find { tienda ->
                    idTextView.text.toString().toInt() == tienda.id
                }
                contexto.irGestionarMedicamentos(idTextView.text.toString().toInt(), tienda!!.productoDeTienda)
            }

            actualizarBoton.setOnClickListener {
                var seguro: Boolean = false
                if (seguroTextView.text.toString() == "SI") {
                    seguro = true
                }
                val paciente = Tienda(
                    null,
                    idTextView.text.toString().toInt(),
                    nombresTextView.text.toString(),
                    apellidosTextView.text.toString(),
                    fechaNacimientoTextView.text.toString(),
                    hijosTextView.text.toString().toInt(),
                    seguro
                )
                contexto.irActualizarPaciente(paciente)
            }

                eliminarBoton.setOnClickListener {
                contexto.eliminarTienda(idTextView.text.toString().toInt())

            }
        }

    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_tienda,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaTiendas.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val tienda: Tienda = listaTiendas[position]
        myViewHolder.idTextView.text = tienda.id.toString()
        //myViewHolder.infoTextView.text = "Tienda #${tienda.id}"
        myViewHolder.nombresTextView.text = tienda.nombres
        myViewHolder.apellidosTextView.text = tienda.apellidos
        myViewHolder.fechaNacimientoTextView.text = tienda.fechaNacimiento
        myViewHolder.hijosTextView.text = tienda.hijos.toString()
        if (tienda.tieneSeguro) {
            myViewHolder.seguroTextView.text = "SI"
        } else {
            myViewHolder.seguroTextView.text = "NO"
        }

    }

}