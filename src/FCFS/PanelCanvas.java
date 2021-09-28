package FCFS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    
    public PanelCanvas() {
        
        fontInter = new Font("Inter Medium", Font.PLAIN, 15);
        
        mainPanel = new JPanel();
        
        //this.setContentPane(scrollPane);
        
        //mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.
         //       createEtchedBorder(), "Gráfico", TitledBorder.LEFT, TitledBorder.TOP, fontInter));
        
        this.setPreferredSize(new Dimension(1025, 560));
        this.getViewport().add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(canvas, BorderLayout.LINE_START);
        canvas.setBounds(20, 20, 1000, 550);
        
        
    }
    
    
}
