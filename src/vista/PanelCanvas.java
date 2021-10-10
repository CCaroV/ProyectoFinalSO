package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class PanelCanvas extends JScrollPane {

    CanvasFCFS canvas = new CanvasFCFS();

    private final Font fontInter;

    //private JScrollPane scrollPane;
    private JPanel mainPanel;

    /**
     * Constructor
     */
    public PanelCanvas() {

        fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        mainPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.
               createEtchedBorder(), "Gráfico", TitledBorder.LEFT, TitledBorder.TOP, fontInter));
        this.setPreferredSize(new Dimension(1050, 580));
        this.getViewport().add(mainPanel);
        this.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(canvas, BorderLayout.LINE_START);
        canvas.setBounds(20, 20, 1000, 550);

    }

}
