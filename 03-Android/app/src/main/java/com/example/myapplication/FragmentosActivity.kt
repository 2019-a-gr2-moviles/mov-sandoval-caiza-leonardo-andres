package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        btn_primer.setOnClickListener {
            abrirPrimerFragmento()
        }

        btn_segundo.setOnClickListener {
            abrirSegundoFragmento()
        }

        btn_tercer.setOnClickListener {
            abrirTercerFragmento()
        }

    }

    fun abrirPrimerFragmento(){
        // 1) Definir el Manager
        val fragmentManager= supportFragmentManager
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction()
        // 3) defnir la instancia del fragmento
        val primerFragmento=PrimerFragment()
        // 4) Reemplazamos el fragmento
       // transaccion.add(R.id.constraint_fragmento,primerFragmento)
        transaccion.replace(R.id.constraint_fragmento,primerFragmento)
        // 5) terminar la transaccion
        transaccion.commit()

    }

    fun abrirSegundoFragmento(){
        // 1) Definir el Manager
        val fragmentManager= supportFragmentManager
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction()
        // 3) defnir la instancia del fragmento
        val primerFragmento=SegundoFragment()
        // 4) Reemplazamos el fragmento
        transaccion.replace(R.id.constraint_fragmento,primerFragmento)
        // 5) terminar la transaccion
        transaccion.commit()

    }

    fun abrirTercerFragmento(){
        // 1) Definir el Manager
        val fragmentManager= supportFragmentManager
        // 2) Empezar transaccion
        val transaccion=fragmentManager.beginTransaction()
        // 3) defnir la instancia del fragmento
        val tercerFragmento=TercerFragment()
        // 4) Reemplazamos el fragmento

        val argumentos = Bundle()
        argumentos.putInt("contador",1)

        tercerFragmento.arguments = argumentos

        transaccion.replace(R.id.constraint_fragmento,tercerFragmento)
        // 5) terminar la transaccion
        transaccion.commit()

    }
}
