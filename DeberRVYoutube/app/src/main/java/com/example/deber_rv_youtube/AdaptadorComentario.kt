package com.example.deber_rv_youtube

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.layoutc.view.*

class AdaptadorComentario (private val listaComentarios: List<Comentario>,
private val contexto: RecyclerViewActivity,
private val recyclerView: RecyclerView
) :
RecyclerView.Adapter<AdaptadorComentario.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var nombreUuario: TextView
        var comentario: TextView
        var foto: ImageView


        init {

            nombreUuario = view.findViewById(R.id.txt_usuario) as TextView
            comentario = view.findViewById(R.id.txt_comentario) as TextView
            foto = view.findViewById(R.id.img_usuario) as ImageView

            val layout = view.findViewById(R.id.linear_c) as LinearLayout

            layout.btn_like.setOnClickListener {
                Toast.makeText(contexto, "Like ", Toast.LENGTH_SHORT).show()
                layout.btn_like.setImageResource(R.mipmap.likec)
            }

            layout.btn_dislike.setOnClickListener {
                Toast.makeText(contexto, "Dislike ", Toast.LENGTH_SHORT).show()
                layout.btn_dislike.setImageResource(R.mipmap.dislikec)
            }

            layout.btn_responder.setOnClickListener {
                Toast.makeText(contexto, "Ingrese su comentario", Toast.LENGTH_SHORT).show()

            }


        }

    }


    override fun getItemCount(): Int {
        return listaComentarios.size
    }

    override fun onBindViewHolder(
        myViewHolder: MyViewHolder,
        position: Int
    ) {

        val comentario = listaComentarios[position]

        myViewHolder.nombreUuario.text = comentario.usuario
        myViewHolder.comentario.text = comentario.comentario

        when (comentario.foto) {
            1 -> {
                myViewHolder.foto.setImageResource(R.mipmap.usr1)
            }
            2 -> {
                myViewHolder.foto.setImageResource(R.mipmap.usr2)
            }
            3 -> {
                myViewHolder.foto.setImageResource(R.mipmap.usr3)
            }
            4 -> {
                myViewHolder.foto.setImageResource(R.mipmap.usr4)
            }
            5 -> {
                myViewHolder.foto.setImageResource(R.mipmap.usr5)
            }
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layoutc,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

}
