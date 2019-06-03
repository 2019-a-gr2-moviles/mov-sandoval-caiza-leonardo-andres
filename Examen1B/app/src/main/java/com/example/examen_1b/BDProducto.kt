package com.example.examen_1b

class BDProducto {
    companion object {
        val listaProductos:ArrayList<Producto> = ArrayList();
        var serial:Int= 1;

        fun agregarProducto(producto: Producto):ArrayList<Producto>{
            producto.ProductoID = serial
            serial++
            listaProductos.add(producto)
            return listaProductos
        }

        fun mostrarProducto(padreId:Int): List<Producto> {
            val lstFiltradaProducto = this.listaProductos.filter { it.tiendaID ==  padreId}
            return lstFiltradaProducto
        }

        fun eliminarProducto(id:Int){
            this.listaProductos.removeAll{ it.ProductoID == id }
        }

        fun actualizarProducto(producto: Producto){
            val indice = this.listaProductos.indexOfFirst { it.ProductoID == producto.ProductoID }
            this.listaProductos[indice] = producto
        }

    }

}