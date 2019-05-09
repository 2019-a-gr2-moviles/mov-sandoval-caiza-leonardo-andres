package com.example.proycatalogo

import com.google.gson.annotations.SerializedName

data class Pieza(
    @SerializedName("Tipo") val tipo: String,
    @SerializedName("Nombre") val nombre: String,
    @SerializedName("Descripcion") val descripcion: String,
    @SerializedName("Precio") val precio: Double

)

class FileJson {
    var tipo: String? = null
    var nombre: String? = null
    var descripcion: String? = null
    var precio: Double? = null
    //var postTag: List<String>? = null

    constructor() : super() {}

    constructor(tipo: String,nombre: String,descripcion: String,precio: Double) : super() {
        this.tipo = tipo
        this.nombre = nombre
        this.descripcion = descripcion
        this.precio = precio
    }

}