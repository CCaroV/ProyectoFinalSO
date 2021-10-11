package vista;

import controlador.ControladorFCFS;
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
public class PanelEndBegin extends JPanel {

    //Definición de labels
    private final JLabel lblBegin;
    private final JLabel lblFinish;
    private final JLabel lblSeconds;
    private final JLabel lblTime;
    private final JLabel lblStatus;
    private final JLabel lblShowStatus;

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
        this.lblSeconds = new JLabel("Segundos:");
        this.lblSeconds.setFont(fontInter);
        this.lblTime = new JLabel();
        this.lblTime.setFont(fontInter);
        this.lblStatus = new JLabel("Estado:");
        this.lblStatus.setFont(fontInter);
        this.lblShowStatus = new JLabel();
        this.lblShowStatus.setFont(fontInter);

        this.btnStart = new JButton("Iniciar");
        this.btnStart.setFont(fontInter);
        this.btnFinish = new JButton("Finalizar");
        this.btnFinish.setFont(fontInter);

        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.
                createEtchedBorder(), "Gestión del algotimo", TitledBorder.LEFT, TitledBorder.TOP, fontInter));

        this.setPreferredSize(new Dimension(350, 225));
        this.setBackground(Color.white);

        this.add(lblBegin);
        this.add(lblFinish);
        this.add(btnStart);
        this.add(btnFinish);
        this.add(lblSeconds);
        this.add(lblTime);
        this.add(lblStatus);
        this.add(lblShowStatus);

        this.lblBegin.setBounds(20, 30, 140, 30);
        this.btnStart.setBounds(20, 60, 100, 30);

        this.lblFinish.setBounds(20, 120, 140, 30);
        this.btnFinish.setBounds(20, 150, 100, 30);
        
        this.lblSeconds.setBounds(200, 30, 100, 30);
        this.lblTime.setBounds(200, 60, 100, 30);
        
        this.lblStatus.setBounds(200, 120, 100, 30);
        this.lblShowStatus.setBounds(200, 150, 100, 30);
    }

    public JButton getBtnStart() {
        return this.btnStart;
    }
    
    public JButton getBtnFinish() {
        return this.btnFinish;
    }
    
    public void setLblTime(int time) {
        this.lblTime.setText(String.valueOf(time));
    }
    
    public void setLblShowStatus(String text) {
        this.lblShowStatus.setText(text);
    }

    public void asignListener(ControladorFCFS c) {
        this.btnStart.addActionListener(c);
        this.btnFinish.addActionListener(c);
    }
    
}
