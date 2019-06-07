package com.example.examen_1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_tenda.*

class IngresarTenda : AppCompatActivity() {

    var usuario:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_tenda)
        usuario = intent.getStringExtra("usuario").toString()
        btnAceptar.setOnClickListener { aceptarIngreso() }
        btnCancelar.setOnClickListener { cancelarIngreso()}
    }

    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MenuPrincipal::class.java)
        intentCancelar.putExtra("usuario", usuario)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
           val tienda= Tienda(tiendaID = null,
            nombres=txtNombres2.text.toString(),
            direccion=txtDireccion2.text.toString(),
            fechaApertura=txtFecha2.text.toString(),
            ruc=txtRuc2.text.toString(),
            matriz=txtMatriz2.text.toString())
        BDTienda.agregarTienda(tienda)
        Toast.makeText(this, "Ingreso exitoso "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuPrincipal::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
