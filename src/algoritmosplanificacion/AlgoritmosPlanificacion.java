package algoritmosplanificacion;

import vista.MainTable;
import vista.VistaFCFS;
import controlador.controladorFCFS;
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

        VistaFCFS v = new VistaFCFS();
        FCFS modelo = new FCFS();
        controladorFCFS controlador = new controladorFCFS(v, modelo);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controlador.setupFrame();
            }
        });
    }

}
