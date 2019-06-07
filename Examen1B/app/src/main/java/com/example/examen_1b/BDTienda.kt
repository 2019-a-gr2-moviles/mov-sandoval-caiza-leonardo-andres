package com.example.examen_1b


class BDTienda{
    companion object {
        val listaTiendas:ArrayList<Tienda> = ArrayList();
        var serial:Int= 1;
        var nombreUsuario:String = "";

        fun guardarUsuario(nombre:String){
            this.nombreUsuario = nombre;
        }

        fun agregarTienda(tienda: Tienda):ArrayList<Tienda>{
            tienda.tiendaID = serial
            serial++
            listaTiendas.add(tienda)
            return listaTiendas
        }

        fun mostrarTienda(): List<Tienda> {
            return this.listaTiendas
        }

        fun eliminarTienda(id:Int){
            this.listaTiendas.removeAll{ it.tiendaID == id }
        }

        fun actualizarEquipo(tienda: Tienda){
            val indice = this.listaTiendas.indexOfFirst { it.tiendaID == tienda.tiendaID }
            this.listaTiendas[indice] = tienda
        }

    }

}