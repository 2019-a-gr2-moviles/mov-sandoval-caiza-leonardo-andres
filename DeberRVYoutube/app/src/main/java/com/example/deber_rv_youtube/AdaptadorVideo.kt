package com.example.deber_rv_youtube

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class AdaptadorVideo(private val listaVideos: List<Video>,
                     private val contexto: RecyclerViewActivity,
                     private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorVideo.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nombreTextView: TextView
        var visualizacionTextView: TextView
        var descripcionTextView: TextView
        var fotoViewImg: ImageView
        //var accionBoton: Button

        init{
            nombreTextView=view.findViewById(R.id.txt_nombre) as TextView
            descripcionTextView=view.findViewById(R.id.txt_descripcion) as TextView
            visualizacionTextView=view.findViewById(R.id.txt_visualizacion) as TextView
            //accionBoton=view.findViewById(R.id.btn_accion) as Button
            fotoViewImg=view.findViewById(R.id.imageView)as ImageView

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout

            layout.setOnClickListener {
                Log.i("recycler-view", "Layout Presionado")
                contexto.cambiarNombreTextView("COMENTARIOS")


            }

        }




    }

    override fun getItemCount(): Int {
        return listaVideos.size
    }

    override fun onBindViewHolder(
        myViewHolder: MyViewHolder,
        position: Int
    ) {

        val video = listaVideos[position]

        myViewHolder.nombreTextView.text = video.nombre
        myViewHolder.descripcionTextView.text = video.descripcion
        myViewHolder.visualizacionTextView.text=video.visualizaciones


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

    val itemView = LayoutInflater
        .from(p0.context)
        .inflate(
            R.layout.layout,
            p0,
            false
        )

    return MyViewHolder(itemView)
}

}
