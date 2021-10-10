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
public class TimeTable extends JPanel {

    private JTable tblTime;
    private JScrollPane scrollTable;

    private Object[][] text;
    private final String[] header = {"Proceso", "Ejecución", "Espera", "Bloqueo", 
        "<html><center>Instante <br>final", "Retorno", "<html><center>Tiempo <br>perdido", 
        "Penalidad", "<html><center>Tiempo <br>respuesta"};

    private final Font fontInter;

    public TimeTable() {
        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        this.text = new Object[6][9];

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 223));
        this.add(getTable(), BorderLayout.CENTER);
        this.setBackground(Color.white);
    }

    /**
     * Devuelve el ScrollPanel en donde se encuentra la tabla
     *
     * @return scrollTable
     */
    private JScrollPane getTable() {
        tblTime = new JTable(text, header);
        tblTime.setRowHeight(30);
        scrollTable = new JScrollPane(tblTime);
        tblTime.setFont(fontInter);
        tblTime.getTableHeader().setFont(fontInter);
        tblTime.getTableHeader().setPreferredSize(new Dimension(30, 40));
        tblTime.setEnabled(false);

        return scrollTable;
    }
    
    public Object getCell(int row, int col) {
        return this.text[row][col];
    }

    public void setCell(int row, int col, Object object) {
        this.text[row][col] = object;
        tblTime.updateUI();
    }

}
