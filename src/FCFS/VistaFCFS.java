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

    /**
     * Constructor
     *
     * @throws HeadlessException
     */
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
        
        if (checkScreen()) {
            this.setSize(1600, 900);
        } else {
            this.setSize(screenSize.width, screenSize.height);
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelScroll);

        //Definición del panel principal
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.setLayout(new GridBagLayout());
        
        //Primera fila
        placeComp(new MainProcess(), mainPanel, 0, 0, 2, 1);
        placeComp(new MainTable(), mainPanel, 2, 0, 2, 1);
        placeComp(new SummaryTable(), mainPanel, 4, 0, 1, 1);
        
        //Segunda fila
        placeComp(new TimeTable(), mainPanel, 0, 1, 5, 1);
        
        //Tercera fila
        placeComp(new PanelCanvas(), mainPanel, 0, 2, 5, 1);

        //Agrega el panel principal al scroll panel
        panelScroll.getViewport().add(mainPanel);
    }

    /**
     * Posiciona un componente en un pánel
     *
     * @param comp Componente a posicionar
     * @param panel Panel en el que se va a agregar el componente
     * @param x Posición x en el pánel
     * @param y Posición y en el pánel
     * @param w Ancho del componente
     * @param h Alto del componente
     */
    public static void placeComp(Component comp, JPanel panel, int x, int y, int w, int h) {
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = x;
        cons.gridy = y;
        cons.gridwidth = w;
        cons.gridheight = h;
        panel.add(comp, cons);
    }

    public boolean checkScreen() {
        return this.screenSize.width >= 1800;
    }

}
