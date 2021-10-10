package vista;

import controlador.ControladorFCFS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
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
public class PanelEndBegin extends JPanel {

    //Definición de labels
    private final JLabel lblBegin;
    private final JLabel lblFinish;

    //Definición de botones
    private final JButton btnStart;
    private final JButton btnFinish;

    private final Font fontInter;

    public PanelEndBegin() {

        this.fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        this.lblBegin = new JLabel("Iniciar algoritmo");
        this.lblBegin.setFont(fontInter);
        this.lblFinish = new JLabel("Finalizar algoritmo");
        this.lblFinish.setFont(fontInter);

        this.btnStart = new JButton("Iniciar");
        this.btnStart.setFont(fontInter);
        this.btnFinish = new JButton("Finalizar");
        this.btnFinish.setFont(fontInter);

        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Gestión del algotimo", TitledBorder.LEFT, TitledBorder.TOP, fontInter));

        this.setPreferredSize(new Dimension(200, 225));
        this.setBackground(Color.white);

        this.add(lblBegin);
        this.add(lblFinish);
        this.add(btnStart);
        this.add(btnFinish);

        this.lblBegin.setBounds(20, 30, 140, 30);
        this.btnStart.setBounds(20, 60, 100, 30);

        this.lblFinish.setBounds(20, 120, 140, 30);
        this.btnFinish.setBounds(20, 150, 100, 30);
    }

    public JButton getBtnStart() {
        return this.btnStart;
    }
    
    public JButton getBtnFinish() {
        return this.btnFinish;
    }

    public void asignListener(ControladorFCFS c) {
        this.btnStart.addActionListener(c);
        this.btnFinish.addActionListener(c);
    }

}
