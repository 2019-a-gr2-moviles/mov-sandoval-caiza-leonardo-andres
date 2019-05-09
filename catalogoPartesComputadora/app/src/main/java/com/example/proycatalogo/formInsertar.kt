package com.example.proycatalogo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import java.io.BufferedReader
import java.io.File
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_form_insertar.*

class formInsertar : AppCompatActivity() {
    private var jsonInicial:String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_insertar)



        buttonGuardar.setOnClickListener{
            // val et_tipoInput = findViewById<Snipper>(R.id.spinner)
            val et_nombreInput = findViewById<TextInputEditText>(R.id.textNombre)
            val et_descripcionInput = findViewById<TextInputEditText>(R.id.textDescripcion)
            //val et_precioInput = findViewById<TextInputEditText>(R.id.textPrecio)
            val tipo="Memorias"
            val nombre = et_nombreInput.text.toString()
            val descripcion = et_descripcionInput.text.toString()
            val precio = 22.3
            // val precio = et_precioInput.text.toString().toDouble()
            writeJSONtoFile(tipo,nombre,descripcion,precio)
            println("nombre"+ nombre)
            println("desc"+ descripcion)
    }
    }

    private fun writeJSONtoFile(Tipo:String,Nombre:String,Descripcion:String,Precio:Double) {
        //readJSONfromFile()
        var post = FileJson(Tipo, Nombre, Descripcion,Precio)
        var gson = Gson()
        var jsonString:String = gson.toJson(post)
        var jsonString2:String = jsonInicial.toString()
        var jsonFinal = jsonString.toString()
      //  textView.setText(jsonString)
        val file= File("/data/data/com.example.proycatalogo/files/Piezas.json")
        file.writeText(jsonFinal)
        println(jsonFinal)

    }


     private fun readJSONfromFile() {
        var gson = Gson()
        //val bufferedReader: BufferedReader = File("/data/data/com.example.proycatalogo/files/Piezas.json").bufferedReader()
         val bufferedReader: BufferedReader = File("/data/data/com.example.proycatalogo/files/Piezas.json").bufferedReader()

         val inputString = bufferedReader.use { it.readText() }
        jsonInicial = inputString
    }
}
