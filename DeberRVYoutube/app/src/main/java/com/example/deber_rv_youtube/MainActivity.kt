package com.example.deber_rv_youtube

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }

        btn_recycler_view.setOnClickListener{
            irArecyclerView()
        }
    }

    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val leonardo = Usuario("Leonardo",23, Date(),12.12)
        intentExplicito.putExtra("usuario", leonardo)

        startActivity(intentExplicito)
    }

    fun irArecyclerView(){
        val intentExplicito = Intent(
            this,
            RecyclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
