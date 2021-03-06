package vista;

import controlador.ControladorFCFS;
import controlador.ControladorSFJ;
import controlador.ControladorSRTF;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    private final JButton[] btnAdd;
    private final JButton[] btnExec;
    private final JButton[] btnBlock;
    private final JButton[] btnTerminate;

    private final Font fontInter;

    public MainProcess() {

        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Procesos", TitledBorder.LEFT, TitledBorder.TOP, fontInter));

        this.setPreferredSize(new Dimension(580, 280));
        this.setBackground(Color.white);

        //Constructor de labels
        lblProcess = new JLabel[6];

        //Constructor de botones
        btnAdd = new JButton[6];
        btnExec = new JButton[6];
        btnBlock = new JButton[6];
        btnTerminate = new JButton[6];
        for (int i = 0; i < btnAdd.length; i++) {
            btnAdd[i] = new JButton("Añadir");
            btnAdd[i].setFont(fontInter);
            this.add(btnAdd[i]);

            btnExec[i] = new JButton("Ejecutar");
            btnExec[i].setFont(fontInter);
            this.add(btnExec[i]);

            btnBlock[i] = new JButton("Bloquear");
            btnBlock[i].setFont(fontInter);
            this.add(btnBlock[i]);

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

        btnBlock[0].setBounds(340, 30, 100, 30);
        btnBlock[1].setBounds(340, 70, 100, 30);
        btnBlock[2].setBounds(340, 110, 100, 30);
        btnBlock[3].setBounds(340, 150, 100, 30);
        btnBlock[4].setBounds(340, 190, 100, 30);
        btnBlock[5].setBounds(340, 230, 100, 30);

        btnTerminate[0].setBounds(460, 30, 100, 30);
        btnTerminate[1].setBounds(460, 70, 100, 30);
        btnTerminate[2].setBounds(460, 110, 100, 30);
        btnTerminate[3].setBounds(460, 150, 100, 30);
        btnTerminate[4].setBounds(460, 190, 100, 30);
        btnTerminate[5].setBounds(460, 230, 100, 30);

    }

    public JButton getBtnAdd (int row) {
        return this.btnAdd[row];
    }
    
    public JButton getBtnExec (int row) {
        return this.btnExec[row];
    }
    
    public JButton getBtnBlock (int row) {
        return this.btnBlock[row];
    }
    
    public JButton getBtnTerminate (int row) {
        return this.btnTerminate[row];
    }
    
    public void asignListener(ControladorFCFS c) {
        for (int i = 0; i < btnAdd.length; i++) {
            btnAdd[i].addActionListener(c);
            btnExec[i].addActionListener(c);
            btnBlock[i].addActionListener(c);
            btnTerminate[i].addActionListener(c);
        }
    }

    public void asignListener(ControladorSFJ c) {
        for (int i = 0; i < btnAdd.length; i++) {
            btnAdd[i].addActionListener(c);
            btnExec[i].addActionListener(c);
            btnBlock[i].addActionListener(c);
            btnTerminate[i].addActionListener(c);
        }
    }
    public void asignListener(ControladorSRTF c) {
        for (int i = 0; i < btnAdd.length; i++) {
            btnAdd[i].addActionListener(c);
            btnExec[i].addActionListener(c);
            btnBlock[i].addActionListener(c);
            btnTerminate[i].addActionListener(c);
        }
    }
}
