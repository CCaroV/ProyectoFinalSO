package algoritmosplanificacion;

import vista.*;
import javax.tools.StandardJavaFileManager;
import controlador.*;
import modelo.*;

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
        // VistaSFJ vistaSFJ = new VistaSFJ();
        VistaSRTF vistaSRTF = new VistaSRTF();
        // FCFS modelo = new FCFS();
        // SFJ modelo = new SFJ();
        SRTF modelo = new SRTF();
        // ControladorFCFS controlador = new ControladorFCFS(vistaFCFS, modelo);
        // ControladorSFJ controladorSFJ = new ControladorSFJ(vistaSFJ, modelo);
        ControladorSRTF ControladorSRTF = new ControladorSRTF(vistaSRTF, modelo);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ControladorSRTF.setupFrame();
                ControladorSRTF.setupListeners();
            }
        });
    }

}
