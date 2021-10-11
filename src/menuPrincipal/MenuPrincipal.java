package menuPrincipal;

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
public class MenuPrincipal extends JFrame {

    private final JScrollPane panelScroll;

    private JPanel mainPanel;

    private final Dimension screenSize;

    public MenuPrincipal() throws HeadlessException {
        super("Proyecto final");

        this.panelScroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
