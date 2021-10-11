package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class MainTable extends JPanel {

    private JTable tblProcesses;
    private JScrollPane scrollTable;

    private Object[][] text;
    private final String[] header = {"Proceso", "Llegada", "Ejecución",
        "<html><center>Bloqueo <br>inicio", "<html><center>Bloqueo <br>duración"};

    private final Font fontInter;

    /**
     * Constructor
     */
    public MainTable() {
        //Definición de fuentes
        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        this.text = new Object[6][5];

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 223));
        this.setBackground(Color.white);
        this.add(getTable(), BorderLayout.CENTER);
    }

    private JScrollPane getTable() {
        tblProcesses = new JTable(text, header);
        tblProcesses.setRowHeight(30);
        scrollTable = new JScrollPane(tblProcesses);
        tblProcesses.setFont(fontInter);
        tblProcesses.getTableHeader().setFont(fontInter);
        tblProcesses.setEnabled(false);
        tblProcesses.getTableHeader().setPreferredSize(new Dimension(30, 40));

        return scrollTable;
    }

    public Object getCell(int row, int col) {
        return this.text[row][col];
    }

    public void setCell(int row, int col, Object object) {
        this.text[row][col] = object;
        tblProcesses.updateUI();
    }
}
