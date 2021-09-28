package algoritmosplanificacion;

import FCFS.VistaFCFS;

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

        VistaFCFS v = new VistaFCFS();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                v.setVisible(true);
            }
        });

    }

}
