package com.example.myapplication2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()
        listaNombres.add("Leonardo")
        listaNombres.add("Andres")
        listaNombres.add("Sandoval")
        listaNombres.add("Caiza")
        listaNombres.add("EPN")
        listaNombres.add("Sistemas")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)

        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener{
            parent,view,position,id ->
            Log.i("list-view", "Position $position")

            Snackbar
                .make(view, "Position $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }



    }
}
