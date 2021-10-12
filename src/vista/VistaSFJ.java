package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class VistaSFJ extends JFrame {

    //Definición de scrollpPane
    private final JScrollPane panelScroll;

    //Definición del panel pincipal
    private JPanel mainPanel;

    //Definición de la dimensión del Frame
    private final Dimension screenSize;

    public VistaSFJ() throws HeadlessException {
        super("Primero el trabajo más corto");

        //Definición de Scroll Pane
        this.panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Parámetros del Frame
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        if (checkScreen()) {
            this.setSize(1200, 800);
        } else {
            this.setSize(screenSize.width, screenSize.height);
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelScroll);

        //Definición del panel principal
        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.mainPanel.setLayout(new GridBagLayout());
        this.mainPanel.setBackground(Color.white);

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
    public void placeComp(Component comp, JPanel panel, int x, int y, int w, int h) {
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = x;
        cons.gridy = y;
        cons.gridwidth = w;
        cons.gridheight = h;
        panel.add(comp, cons);
    }

    public boolean checkScreen() {
        return this.screenSize.height >= 800;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

}
