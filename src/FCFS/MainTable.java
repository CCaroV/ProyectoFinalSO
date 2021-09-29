package FCFS;

import java.awt.BorderLayout;
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
    private final Object[] header = {"Proceso", "Llegada", "Ejecución", "Blq. Inicio", "Blq. Duración"};
    
    private final Font fontInter;
    
    public MainTable() {
        //Definición de fuentes
        fontInter = new Font("Inter Medium", Font.PLAIN, 15);
        
        text = new Object[6][5];
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 290));
        this.add(getTable(), BorderLayout.CENTER);
    }
    
    private JScrollPane getTable() {
        tblProcesses = new JTable(text, header);
        tblProcesses.setRowHeight(30);
        scrollTable = new JScrollPane(tblProcesses);
        tblProcesses.setFont(fontInter);
        tblProcesses.getTableHeader().setFont(fontInter);
        tblProcesses.setEnabled(false);
        
        return scrollTable;
    }
    
}
