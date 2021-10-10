package algoritmosplanificacion;

import vista.VistaFCFS;
import controlador.ControladorFCFS;
import modelo.FCFS;

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

        VistaFCFS vistaFCFS = new VistaFCFS();
        FCFS modelo = new FCFS();
        ControladorFCFS controlador = new ControladorFCFS(vistaFCFS, modelo);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controlador.setupFrame();
                controlador.setupListeners();
            }
        });
    }

}
