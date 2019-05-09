package com.example.proycatalogo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_vendedor.*

class menuVendedor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_vendedor)

        buttonNuevo.setOnClickListener{
        val intent= Intent(this,formInsertar::class.java)
        startActivity(intent)
    }

    }
}
