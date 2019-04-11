fun  main(args: Array<String>) {

    // VARIABLES

    // Mutables

    //var nombre = "Adrian"
    nombre = "Vicente"

    //Inmutables -> Es mejor.

    val nombre = "Leonardo"
    //nombre2 = "Leo"


    // TIPOS DE DATOS

    val apellido: String = "Sandoval"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = true
    val profesor: Boolean = true
    val hijos = null

    //DUCK TYPING
    //Si parece un pato, si camina como pato, si suena como pato y si vuela como pato
    //PATO

    //CONDICIONALES

    if (apellido == "Sandoval" || nombre == "Leonardo") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)
    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)
}

//en kotlin no existe switch

fun estaJalado(nota: Double){

    when(nota) {
        7.0 -> {
            println("Pasastec con las justas")
        }
        10.0 -> {
            println("Genial :D Felicitaciones")
        }
        0.0 -> {
            println("Dios mio que vago!")
        }
        else -> {
            println("Tu notas es: $nota")
        }
    }

}