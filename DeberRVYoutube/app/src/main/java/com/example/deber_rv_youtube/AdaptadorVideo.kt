package com.example.deber_rv_youtube

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

                val comentarios= arrayListOf<Comentario>()

                for(num in 1..10) {
                    comentarios.add(
                        Comentario(
                            "Mishu Tefhito",
                            "Lo máximo te pasaste me encanta gracias por esto sigue asii",
                            1
                        )
                    )
                    comentarios.add(Comentario("Karen Caiza", "me he quedado sin palabras vacansisimooooo", 2))
                    comentarios.add(
                        Comentario(
                            "Erika Verdezoto",
                            "Buenísimos temas, ojalá sigan asi....felicidades",
                            3
                        )
                    )
                    comentarios.add(
                        Comentario(
                            "Gabriela Alvarez",
                            "Estas son las canciones perfectas❤️ para recordar y beber",
                            4
                        )
                    )
                    comentarios.add(
                        Comentario(
                            "Gissela Vasquez",
                            "Desde que he escuchado este mix de salsa me he vuelto mas borracho y ahora mis amigos toman mas con gusto con esta exelente salsa mix posis",
                            5
                        )
                    )
                }

                contexto.iniciarRecyclerView2(comentarios,contexto,recyclerView)
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

        when (video.foto) {
            1 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa1)
            }
            2 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa2)
            }
            3 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa3)
            }
            4 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa4)
            }
            5 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa5)
            }
            6 -> {
                myViewHolder.fotoViewImg.setImageResource(R.mipmap.salsa6)
            }
        }

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
