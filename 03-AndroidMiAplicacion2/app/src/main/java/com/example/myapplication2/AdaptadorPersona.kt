package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.miaplicacion2.ReciclerView
import com.example.myapplication2.Persona
import com.example.myapplication2.R
import kotlinx.android.synthetic.main.layout.view.*

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerView,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var cedulaTextView: TextView
        var accionBoton: Button

        init{
            nombreTextView=view.findViewById(R.id.txt_nombre) as TextView
            cedulaTextView=view.findViewById(R.id.txt_cedula) as TextView
            accionBoton=view.findViewById(R.id.btn_accion) as Button

            val layout=view.findViewById(R.id.linear_layout) as LinearLayout

            layout
                .setOnClickListener{
                    Log.i("recycler-view","Layout presionado")
                }
        }

    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: AdaptadorPersona.MyViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):
            p0:ViewGroup,
    p1: Int):
            AdaptadorPersona.MyViewHolder {

    }
}