package com.example.myapplication2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.design.widget.Snackbar
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_list_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()
        }

        btn_adapter.setOnClickListener{
            irAListView()



        }
    }




    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val karen = Usuario("Karen",23, Date(),12.12)
        intentExplicito.putExtra("usuario", karen)


        val cachetes = Mascota("Cachetes", karen)
        intentExplicito.putExtra("mascota", cachetes)
        startActivity(intentExplicito)
    }


    fun irAListView(){
        val intentExplicito2 = Intent(
            this,
            ListViewActivity::class.java

        )
        startActivity(intentExplicito2)
    }




}
