import javax.swing.*


    fun main() {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        val Opciones: Array<String> = arrayOf("Nuevo", "Modificar", "Eliminar", "Buscar", "Salir")
        val icono = ImageIcon("src/hw.png") // icon



            val x = JOptionPane.showOptionDialog(
                null, " ",
                "Piezas de Computadoras", 2, 1, icono, Opciones, null
            ) // menu options

            when (x) {
                0 -> {

                }
                1 -> {

                }
                2 -> {

                }
                3 -> {

                }
                4 -> { // close the program
                    System.exit(0)
                }
            }

    }

