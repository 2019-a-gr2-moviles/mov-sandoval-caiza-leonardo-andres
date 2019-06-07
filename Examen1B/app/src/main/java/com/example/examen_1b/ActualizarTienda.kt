package com.example.examen_1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_tienda.*

class ActualizarTienda : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_tienda)
        usuario = intent.getStringExtra("usuario").toString()
        val tiendaRecibida = intent.getParcelableExtra<Tienda>("Tienda")
        txtNombres.setText(tiendaRecibida.nombres.toString())
        txtDireccion.setText(tiendaRecibida.direccion.toString())
        txtFecha.setText(tiendaRecibida.fechaApertura.toString())
        txtRuc.setText(tiendaRecibida.ruc.toString())
        txtMatriz.setText(tiendaRecibida.matriz.toString())
        padreId = tiendaRecibida.tiendaID!!;

     /*   btnActualizar.setOnClickListener { actualizarTienda() }
        btnEliminar.setOnClickListener { eliminarEquipo() }
        btnCrearJugador.setOnClickListener { crearJugador() }
        btnGestionarJugador.setOnClickListener { gestionarJugador() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }
    fun actualizarEquipo(){
        val actualizarEquipo = EquipoFutbol(id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = txtCampeonAct.text.toString()
        )
        BDEquipoFutbol.actualizarEquipo(actualizarEquipo)
        Toast.makeText(this, "Actualización exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEquipo(){
        BDEquipoFutbol.eliminarEquipo(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearJugador(){
        val equipoRespaldo = EquipoFutbol(id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, IngresarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun gestionarJugador(){
        val equipoRespaldo = EquipoFutbol(id = padreId,
            nombre = txtNombre.text.toString(),
            liga = txtLiga.text.toString(),
            fechaCreacion = txtFechaCreacion.text.toString(),
            numeroCopasInternacionales = txtNumCopInter.text.toString().toInt(),
            campeonActual = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, ConsultarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)

    */}
}
