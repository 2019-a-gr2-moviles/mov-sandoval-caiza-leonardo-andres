import java.io.FileWriter
import java.io.File
import java.io.IOException

class PartesComputadora(var tipo: String, var nombre: String, var descripcion: String, var precio: Double){

    constructor():this(
        "","","",0.0
    )
    companion object {
        val listaPartes = arrayListOf<PartesComputadora>()
        var str: String = ""

        fun agregarPieza(pieza: ArrayList<PartesComputadora>){
            pieza.forEach{
                listaPartes.add(it);
                str+="${it.tipo}; ${it.nombre}; ${it.descripcion}; ${it.precio}\n"
            }
            try {
                val file = FileWriter("src/PartesComputador.csv",true)
                file.write(str)
                file.close()
                str = "";
            }catch (e: IOException){
                println("Error de escritura")
            }
        }

        fun listarPiezas(): ArrayList<PartesComputadora>{
            val listaPiezas = ArrayList<PartesComputadora>()
            try {
                val lineas = File("src/PartesComputador.csv").readLines()
                lineas.forEach{
                    val tokens = it.split(";")
                    val pieza = PartesComputadora(tokens[0],tokens[1],tokens[2],tokens[3].toDouble())
                    listaPiezas.add(pieza)
                }
            }catch (e: IOException){
                println("no se puede leer")
            }
            return listaPiezas
        }




        fun buscar(param: String): List<PartesComputadora>? {
            listarPiezas().forEach {
                when(param){
                    it.tipo -> {
                        return listarPiezas().filter { pieza ->
                            pieza.nombre == param
                        }
                    }
                }
            }
            return null
        }

        fun modificar(){

        }

    }

}