package com.example.examen2b

class Conexion {

    companion object {

        private val ip = "192.168.100.228"
        private val puerto = "1337"

        fun url(ruta: String): String {
            var rutaAux = ""
            when (ruta) {
                "tienda" -> rutaAux = "tienda"
                "producto" -> rutaAux = "producto"
                else -> rutaAux = ""
            }
            return "http://$ip:$puerto/${rutaAux}"
        }
    }
}