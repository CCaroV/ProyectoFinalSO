package algoritmosplanificacion;

import menuPrincipal.ControladorMenu;
import menuPrincipal.MenuPrincipal;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class AlgoritmosPlanificacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuPrincipal vista = new MenuPrincipal();
        ControladorMenu controlador =  new ControladorMenu(vista);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controlador.setUpFrame();
            }
        }
        );
    }

}
