package vista;

import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class VistaFCFS extends JFrame {

    //Definición de páneles
    private final JPanel panelProcess;
    private final JScrollPane panelGraphs;

    //Definición de labels
    private final JLabel[] lblProcess;
    
    //Definición de botones
    private final JButton[] btnAdd;
    private final JButton[] btnExec;
    private final JButton[] btnTerminate;

    //Definición de tablas
    private JTable tblProcesses;
    private JScrollPane scrollTable;

    //Definición de textos
    private Object[][] text = {
        {"Ejemplo1", "Ejemplo 2", "Ejemplo 3", "Ejemplo 4", "Ejemplo 5"},
        {"Ejemplo1", "Ejemplo 2", "Ejemplo 3", "Ejemplo 4", "Ejemplo 5"}
    };
    private final Object[] tittle = {"Proceso", "Llegada", "Ejecución", "Blq. Inicio", "Blq. Duración"};

    private final Font fontInter;

    public VistaFCFS() throws HeadlessException {
        //Título
        super("Primero en llegar primero en salir");

        fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        //Parámetros del Frame
        this.setSize(1100, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //Constructor de pánel de tablas
        panelProcess = new JPanel();
        panelProcess.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Procesos", TitledBorder.LEFT, TitledBorder.TOP, fontInter));
        this.add(panelProcess);
        panelProcess.setBounds(20, 20, 500, 300);
        panelProcess.setLayout(null);

        //Constructor de pánel de canvas
        panelGraphs = new JScrollPane();
        this.add(panelGraphs);
        panelGraphs.setBounds(20, 350, 1060, 600);
        panelGraphs.setLayout(null);
        panelGraphs.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Gráfico", TitledBorder.LEFT, TitledBorder.TOP, fontInter));
        
        //Constructor de labels
        lblProcess = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            lblProcess[i] = new JLabel("Proceso " + String.valueOf(i + 1));
            lblProcess[i].setFont(fontInter);
            panelProcess.add(lblProcess[i]);
        }
        lblProcess[0].setBounds(10, 30, 100, 30);
        lblProcess[1].setBounds(10, 70, 100, 30);
        lblProcess[2].setBounds(10, 110, 100, 30);
        lblProcess[3].setBounds(10, 150, 100, 30);
        lblProcess[4].setBounds(10, 190, 100, 30);

        //Constructor de botones
        btnAdd = new JButton[5];
        btnExec = new JButton[5];
        btnTerminate = new JButton[5];
        for (int i = 0; i < 5; i++) {
            btnAdd[i] = new JButton("Añadir");
            btnAdd[i].setFont(fontInter);
            panelProcess.add(btnAdd[i]);

            btnExec[i] = new JButton("Ejecutar");
            btnExec[i].setFont(fontInter);
            panelProcess.add(btnExec[i]);

            btnTerminate[i] = new JButton("Terminar");
            btnTerminate[i].setFont(fontInter);
            panelProcess.add(btnTerminate[i]);
        }
        btnAdd[0].setBounds(120, 30, 90, 30);
        btnAdd[1].setBounds(120, 70, 90, 30);
        btnAdd[2].setBounds(120, 110, 90, 30);
        btnAdd[3].setBounds(120, 150, 90, 30);
        btnAdd[4].setBounds(120, 190, 90, 30);

        btnExec[0].setBounds(230, 30, 100, 30);
        btnExec[1].setBounds(230, 70, 100, 30);
        btnExec[2].setBounds(230, 110, 100, 30);
        btnExec[3].setBounds(230, 150, 100, 30);
        btnExec[4].setBounds(230, 190, 100, 30);

        btnTerminate[0].setBounds(350, 30, 100, 30);
        btnTerminate[1].setBounds(350, 70, 100, 30);
        btnTerminate[2].setBounds(350, 110, 100, 30);
        btnTerminate[3].setBounds(350, 150, 100, 30);
        btnTerminate[4].setBounds(350, 190, 100, 30);

        //Definición de tablas
        tblProcesses = new JTable(text, tittle);
        scrollTable = new JScrollPane(tblProcesses);
        tblProcesses.setFont(fontInter);
        tblProcesses.getTableHeader().setFont(fontInter);
        tblProcesses.setEnabled(false);
        this.add(scrollTable);
        scrollTable.setBounds(550, 27, 530, 290);

    }

}
