
import java.util.*


fun main(args: Array<String>) {
    datosIniciales()

    println("CATALOGO DE PIEZAS DE COMPUTADORES")
    println("Bienvenido/a")

    do {
        val opc = menuPrincipal()
        when (opc) {
            1 -> ejecMenuVendedor()
            2 -> ejecMenuComprador()
            3 -> println("Gracias por usar la aplicación")
            4 -> mostrarCatalogo()
            else -> {
                println("Operación no válida")
            }

        }

    } while (opc != 3)

}

fun datosIniciales() {
    val usuarioInicial = ("Leo")
    val usuarioInicial2 = ("Andy")

    val ciudad1 = ("Quito")
    val ciudad2 = ("Guayaquil")
    //RegistrarPieza(0, usuarioInicial, "Disco Duro Solido 120GB", 59, 2.5, ciudad1)
    //RegistrarPieza(1, usuarioInicial2, "Disco Duro HDD 1TB", 120, 3.5, ciudad2)
}

fun mostrarCatalogo() {

}


fun registroUsuario() {

}

fun registroPieza() {

}


fun listarPiezas() {

}

fun listarPiezasDisponibles() {

}

fun listarCompras() {
}

fun ejecMenuVendedor() {
    loop@ do {
        val opc = menuVendedor()
        when (opc) {
            1 -> break@loop
            2 -> registroPieza()
            3 -> listarPiezas()
            else -> {
                println("Operación no válida")
            }
        }

    } while (opc != 1)
}

fun ejecMenuComprador() {
    loop@ do {
        val opc = menuComprador()
        when (opc) {
            1 -> break@loop
            2 -> {
                val indiceCiudadSeleccionada = seleccionarCiudad() - 1

            }
            3 -> CompraDePiezas()
            4 -> listarCompras()
            else -> {
                println("Operación no válida")
            }
        }
    } while (opc != 1)
}

fun CompraDePiezas() {

    println("Ingrese el codigo pieza")
    val indicePieza = readLine()!!.toInt()
    println("Pieza seleccionada")

    val confirmacion = menuConfirmacion()
    when (confirmacion) {
        1 -> {
            println("Operación exitosa")
        }
        2 -> println("Operación cancelada")
        else -> {
            println("Operación no válida")
        }
    }
}


