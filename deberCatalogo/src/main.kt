import java.awt.Dimension
import java.awt.Font
import javax.swing.*

val opcionTipo = arrayOf<Any>("Discos Duros", "Memorias", "Procesadores", "Monitores", "Impresoras")
val opTipo = JComboBox(opcionTipo)

fun main() {

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    val Opciones: Array<String> = arrayOf("Nuevo", "Modificar", "Eliminar", "Buscar", "Salir")
    val icono = ImageIcon("src/hw.png") // icon


    val opcion = JOptionPane.showOptionDialog(
        null, " ",
        "Partes de Computadoras", 2, 1, icono, Opciones, null
    ) // menu options

    when (opcion) {
        0 -> {
            insertar();
        }
        1 -> {

        }
        2 -> {

        }
        3 -> {
            listar();
        }
        4 -> {
            System.exit(0)
        }
    }

}

fun insertar() {
    val listaPartes = ArrayList<PartesComputadora>()
    val pieza = PartesComputadora();

    JOptionPane.showMessageDialog(null, opTipo, "Seleccion el tipo de Pieza", JOptionPane.QUESTION_MESSAGE)
    pieza.tipo = opTipo.selectedItem.toString()

    val nombre = JOptionPane.showInputDialog(null, "Nombre:")
    if (nombre.matches("".toRegex())) {
        JOptionPane.showMessageDialog(null, "Ingrese un nombre valido", "Error", 0, null)
    } else {
        pieza.nombre = nombre

    }

    val descripcion = JOptionPane.showInputDialog(null, "Descripcion:")
    if (descripcion.matches("".toRegex())) {
        JOptionPane.showMessageDialog(null, "Ingrese una descripcion valida", "Error", 0, null)
    } else {
        pieza.descripcion = descripcion

    }

    val precio = JOptionPane.showInputDialog(null, "Precio:").toDouble()
    if (precio == null) {
        JOptionPane.showMessageDialog(null, "Ingrese un precio valido", "Error", 0, null)
    } else {
        pieza.precio = precio
    }

    listaPartes.add(pieza)
    PartesComputadora.agregarPieza(listaPartes)
    var items = ""
    listaPartes.forEach {
        items += "Tipo: ${it.tipo}\nNombre: ${it.nombre}\nCaracteristica: ${it.descripcion}\n Precio: ${it.precio}"
    }
}


fun listar() {
    val opciones: Array<String> = arrayOf("Por categoria", "Lista Completa", "Regresar")


    var opcion = JOptionPane.showOptionDialog(
        null, "Seleccione una opcion",
        "Busqueda", 1, 3, null, opciones, null
    )
    when (opcion) {
        0 -> { // show all
            var items = "" // Sumarize new items
            var cont = 0
            PartesComputadora.listarPiezas().forEach {
                items += "Tipo: ${it.tipo}\nNombre: ${it.nombre}\nDescripcion: ${it.descripcion}\n" +
                        "Precio: ${it.precio}\n"
                cont++
            }
            println(items)
            mostrarLista("$items \nTotal diamonds = $cont")

        }
        1 -> {

        }
    }
}


fun mostrarLista(items: String) {

    val txt = JTextArea(items)
    val scr = JScrollPane(txt)
    txt.font = Font("Tahoma", Font.BOLD, 11)
    txt.isEditable = false
    scr.preferredSize = Dimension(220, 300)
    JOptionPane.showMessageDialog(null, scr, "Lista de Partes", 1, null)
}





