package FCFS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class MainProcess extends JPanel {

    
    //Definición de labels
    private final JLabel[] lblProcess;

    //Definición de botones
    private JButton[] btnAdd;
    private final JButton[] btnExec;
    private final JButton[] btnTerminate;
    
    private final Font fontInter;
    
    public MainProcess() {
        
        fontInter = new Font("Inter Medium", Font.PLAIN, 15);
        
        //this.setLayout(new GridLayout(6, 3));
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Procesos", TitledBorder.LEFT, TitledBorder.TOP, fontInter));
        
        this.setPreferredSize(new Dimension(470, 280));
        this.setBackground(Color.white);
        
        //Constructor de labels
        lblProcess = new JLabel[6];
        
        //Constructor de botones
        btnAdd = new JButton[6];
        btnExec = new JButton[6];
        btnTerminate = new JButton[6];
        for (int i = 0; i < btnAdd.length; i++) {
            btnAdd[i] = new JButton("Añadir");
            btnAdd[i].setFont(fontInter);
            this.add(btnAdd[i]);

            btnExec[i] = new JButton("Ejecutar");
            btnExec[i].setFont(fontInter);
            this.add(btnExec[i]);

            btnTerminate[i] = new JButton("Terminar");
            btnTerminate[i].setFont(fontInter);
            this.add(btnTerminate[i]);
            
            lblProcess[i] = new JLabel();
            lblProcess[i].setFont(fontInter);
            this.add(lblProcess[i]);
        }
        
        lblProcess[0].setText("Spotify");
        lblProcess[0].setBounds(30, 30, 100, 30);
        lblProcess[1].setText("Firefox");
        lblProcess[1].setBounds(30, 70, 100, 30);
        lblProcess[2].setText("Zoom");
        lblProcess[2].setBounds(30, 110, 100, 30);
        lblProcess[3].setText("Steam");
        lblProcess[3].setBounds(30, 150, 100, 30);
        lblProcess[4].setText("Matlab");
        lblProcess[4].setBounds(30, 190, 100, 30);
        lblProcess[5].setText("Chrome");
        lblProcess[5].setBounds(30, 230, 100, 30);
        
        btnAdd[0].setBounds(110, 30, 90, 30);
        btnAdd[1].setBounds(110, 70, 90, 30);
        btnAdd[2].setBounds(110, 110, 90, 30);
        btnAdd[3].setBounds(110, 150, 90, 30);
        btnAdd[4].setBounds(110, 190, 90, 30);
        btnAdd[5].setBounds(110, 230, 90, 30);

        btnExec[0].setBounds(220, 30, 100, 30);
        btnExec[1].setBounds(220, 70, 100, 30);
        btnExec[2].setBounds(220, 110, 100, 30);
        btnExec[3].setBounds(220, 150, 100, 30);
        btnExec[4].setBounds(220, 190, 100, 30);
        btnExec[5].setBounds(220, 230, 100, 30);

        btnTerminate[0].setBounds(340, 30, 100, 30);
        btnTerminate[1].setBounds(340, 70, 100, 30);
        btnTerminate[2].setBounds(340, 110, 100, 30);
        btnTerminate[3].setBounds(340, 150, 100, 30);
        btnTerminate[4].setBounds(340, 190, 100, 30);
        btnTerminate[5].setBounds(340, 230, 100, 30);
        
    }
    
    
    
}
