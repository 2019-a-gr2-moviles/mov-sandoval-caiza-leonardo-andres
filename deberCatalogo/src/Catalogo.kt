import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Catalogo : JFrame() {
    private val compradorButton: JButton? = null
    private val vendedorButton: JButton? = null
    private val rootPanel: JPanel? = null

    init {

        add(rootPanel)
        title = "Catalogo de Partes"
        setSize(400, 500)


        compradorButton!!.addActionListener { JOptionPane.showMessageDialog(rootPane, "GUIComprador") }
        vendedorButton!!.addActionListener { JOptionPane.showMessageDialog(rootPane, "GUIComprador") }
    }


}
