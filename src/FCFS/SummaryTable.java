package FCFS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class SummaryTable extends JPanel {

    private JTable tblSummary;
    private JScrollPane scrollTable;

    private Object[][] text;
    private String[] header = {"Métrica", "Valor"};

    private final Font fontInter;

    public SummaryTable() {
        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);
        this.text = new Object[7][2];
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(350, 223));
        this.add(getTable(), BorderLayout.CENTER);
        this.setBackground(Color.white);
    }
    
    public JScrollPane getTable() {
        tblSummary = new JTable(text, header);
        tblSummary.setRowHeight(30);
        scrollTable = new JScrollPane(tblSummary);
        tblSummary.setFont(fontInter);
        tblSummary.getTableHeader().setFont(fontInter);
        tblSummary.getTableHeader().setPreferredSize(new Dimension(30, 40));
        //tblSummary.getColumn(0).setPreferredWidth(100);
        tblSummary.setEnabled(false);
        fillText();
        return scrollTable;
    }
    
    public void fillText() {
        text[0][0] = "Tiempo encendido";
        text[1][0] = "Uso total de CPU";
        text[2][0] = "CPU desocupada";
        text[3][0] = "Promedio de retorno";
        text[4][0] = "Promedio de ejecución";
        text[5][0] = "Promedio de espera";
        text[6][0] = "Promedio tiempo perdido";
        
        TableColumn column = tblSummary.getColumnModel().getColumn(0);
        column.setPreferredWidth(110);
        column = tblSummary.getColumnModel().getColumn(1);
        column.setPreferredWidth(30);
    }

}
