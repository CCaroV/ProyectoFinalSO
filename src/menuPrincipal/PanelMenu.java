/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author fedc
 */
public class PanelMenu extends JPanel {

    private JLabel tittle;
    private JLabel[] text;
    private JButton btnFCFS;
    private JButton btnSFJ;
    private JButton btnSRTF;

    private final Font fontInter;

    public PanelMenu() {
        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);
        this.setLayout(null);

        this.setPreferredSize(new Dimension(330, 330));
        this.setBackground(Color.white);

        this.tittle = new JLabel("Proyecto Final");
        this.tittle.setFont(new Font("Inter Bold", Font.PLAIN, 27));

        text = new JLabel[3];

        for (int i = 0; i < text.length; i++) {
            text[i] = new JLabel();
            text[i].setFont(fontInter);
            this.add(text[i]);
        }

        this.tittle.setBounds(20, 20, 250, 40);

        this.btnFCFS = new JButton("FCFS");
        this.btnFCFS.setFont(fontInter);
        btnFCFS.setBounds(160, 90, 80, 30);

        this.btnSFJ = new JButton("SFJ");
        this.btnSFJ.setFont(fontInter);
        btnSFJ.setBounds(160, 140, 80, 30);

        this.btnSRTF = new JButton("SRTF");
        this.btnSRTF.setFont(fontInter);
        btnSRTF.setBounds(160, 190, 80, 30);

        this.text[0].setText("Algoritmo FCFS");
        this.text[0].setBounds(30, 90, 140, 30);
        this.text[1].setText("Algoritmo SFJ");
        this.text[1].setBounds(30, 140, 140, 30);
        this.text[2].setText("Algoritmo SRTF");
        this.text[2].setBounds(30, 190, 140, 30);
        
        this.add(tittle);
        this.add(btnFCFS);
        this.add(btnSFJ);
        this.add(btnSRTF);
    }

    public void asignaOyentes(ControladorMenu c) {
        this.btnFCFS.addActionListener(c);
        this.btnSFJ.addActionListener(c);
        this.btnSRTF.addActionListener(c);
    }

    public JButton getBtnFCFS() {
        return btnFCFS;
    }

    public JButton getBtnSFJ() {
        return btnSFJ;
    }

    public JButton getBtnSRTF() {
        return btnSRTF;
    }
    
    

}
