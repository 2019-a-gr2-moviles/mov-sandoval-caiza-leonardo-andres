fun  main(args: Array<String>) {

    val numerito=Numero("1")
    // VARIABLES

    // Mutables

    //var nombre = "Leonardo"
    //nombre = "Sandoval"

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

    holaMundo("Leonardo")
    holaMundoAvanzado(2)
    val total=sumarDosNumeros(1,2)
    println(total)

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)

    var arregloTodo: Array<Any> = arrayOf(1,"asd",10.2,true)
    arregloCumpleanos[0]=5
    arregloCumpleanos.set(0,5)

    //INMUYTABLE se puede modificar la clase pero la VARIABLE es la q no se puede reasignar
    arregloTodo= arrayOf(5,2,3,4)

  //  val notas:ArrayList<Int>= arrayListOf<Int>(1,2,3,4,5,6)
    var notas= arrayListOf<Int>(1,2,3,4,5,6)

    // FOR EACH -> Itera el arreglo
    notas.forEachIndexed{indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
               // return Unit
    }

    //MAP -> Itera y modifica el arreglo
    //Impares+1  Pares+2
    val notasDos=notas.map{ nota ->
        nota+1
    }

    notasDos.forEach{
        println("Notas 2: $it")
    }

    val notasTres=notas.map{ nota ->
        if(nota%2==0){
            nota+2
        }else{
            nota+1
        }
    }
/*
    val notasDos = notas.map { nota ->
        val modulo = nota % 2
        val esPar = 0
        when (modulo) {
            esPar -> {
                nota + 1
            }
            else -> {
                nota + 2
            }
        }
    }
*/
    notasTres.forEach{
        println("Notas 3: $it")
    }

    val respuestaFilter=notas //
        .filter{
        it in 3..4
        it>2 && it<5

    }.map{  //Mutar o cambiar el arreglo
        it*2
    }

    respuestaFilter.forEach{println(it)}

    val novias= arrayListOf<Int>(1,2,2,3,4,5)

    val respuestaNovia=novias.any{
        it==3
    }
    println(respuestaNovia)

    val tazos= arrayListOf<Int>(1,2,3,4,5,6,7)
    val respuestaTazos=tazos.all{
        it>1
    }

    println(respuestaTazos)

    //sumar los valores de tazos

    val totalTazos=tazos.reduce{valorAcumulado,tazo->
        valorAcumulado+tazo

    }
    println(totalTazos)



   /* val fecha=Date()
    fecha.time=11231231
    fecha.year=2000
    fecha=Date(year:1995, month:11,day:10)
    */
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


fun holaMundo(mensaje:String):Unit{
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado(mensaje:Any):Unit{
    println("Mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno:Int,numDos:Int):Int{
    return numUno+numDos
}

/*
class Usuario{
    public var nombre:String=""
    public var apellido:String

    constructor(val apellido:String){
        this.apellido=apellido;
    }
}

 */

class Usuario(val cedula:String){
    public var nombre:String=""
    public var apellido:String=""

    constructor(cedula:String, apellido:String):this(cedula){
        this.apellido=apellido;
    }
}


class UsuarioKT(val nombre:String,
                val apellido:String){
    init{
        //Write code
    }
/*
    fun hola(){
        return this.apellido
    }

 */

    private fun hola2(){

    }

    protected fun hola3(){

    }

    companion object {
        val gravedad =9.5
        fun correr(){
            println("Estoy  corriendo en $gravedad")
        }
    }
}

class Numero(var numero:Int){
    constructor(numeroString:String):this(numeroString.toInt())
    {
        println("Constructor")
    }
    init{
        println("init")
    }
}

/*
fun a() {
    val leonardo = UsuarioKT("a","b")
    leonardo.nombre="andres"
}
*/

class BaseDatos{
    companion object {
        val usuario= arrayListOf(1,2,3)

        fun agregarUsuario(usuario:Int){
            this.usuario.add(usuario)
        }

        fun eliminarUsuario(usuario: Int){
            //this.usuarios
        }
    }
}


fun aa() {
    UsuarioKT.gravedad
    UsuarioKT.correr()
}

open class Numeros(var numeroUno:Int,
             var numeroDos:Int){

}

class Suma(numeroUnos: Int,
           numeroDoss:Int):
        Numeros(numeroUno,numeroDos){
}


/*
fun presley(requerido:Int,
            opcional:Int=1,
            nulo:Int?){

}
 */

fun presley(requerido:Int,
            opcional:Int=1,
            nulo:UsuarioKT?){
    if(nulo!=null){
        nulo.nombre
    }

    val nombresito:String?=nulo?.nombre.toString()

    nulo!!.nombre
}


fun cddd(){
    presley(1, nulo=0);
    presley(1, 1,null);
}


