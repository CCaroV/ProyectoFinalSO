package FCFS;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class VistaFCFS extends JFrame {

    //Definición de scrollpPane
    private final JScrollPane panelScroll;

    //Definición del panel pincipal
    JPanel mainPanel;

    //Definición de la dimensión del Frame
    Dimension screenSize;
    
    //private final Font fontInter;

    public VistaFCFS() throws HeadlessException {
        //Título
        super("Primero en llegar primero en salir");
        
        //Definición de fuentes
        //fontInter = new Font("Inter Medium", Font.PLAIN, 15);

        //Definición de Scroll Pane
        panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //Parámetros del Frame
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width - 500, screenSize.height - 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelScroll);

        //Definición del panel principal
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        mainPanel.add(new MainProcess(), c);
        
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        mainPanel.add(new MainTable(), c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        mainPanel.add(new PanelCanvas(), c);

        //Agrega el panel principal al scroll panel
        panelScroll.getViewport().add(mainPanel);
        panelScroll.setAlignmentY(CENTER_ALIGNMENT);
    }

}
