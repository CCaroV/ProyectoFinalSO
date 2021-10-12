package algoritmosplanificacion;

import vista.VistaFCFS;
import vista.VistaSJF;

import javax.tools.StandardJavaFileManager;

import controlador.ControladorFCFS;
import controlador.ControladorSFJ;
import modelo.FCFS;
import modelo.SFJ;

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

        // VistaFCFS vistaFCFS = new VistaFCFS();
        VistaSJF vistaSJF = new VistaSJF();
        // FCFS modelo = new FCFS();
        SFJ modelo = new SFJ();
        // ControladorFCFS controlador = new ControladorFCFS(vistaFCFS, modelo);
        ControladorSFJ controladorSFJ = new ControladorSFJ(vistaSJF, modelo);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controladorSFJ.setupFrame();
                controladorSFJ.setupListeners();
            }
        });
    }

}
