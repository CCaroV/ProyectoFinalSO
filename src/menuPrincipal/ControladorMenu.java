/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPrincipal;

import controlador.ControladorFCFS;
import controlador.ControladorSFJ;
import controlador.ControladorSRTF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.FCFS;
import modelo.SFJ;
import modelo.SRTF;
import vista.VistaFCFS;
import vista.VistaSFJ;
import vista.VistaSRTF;

/**
 *
 * @author fedc
 */
public class ControladorMenu implements ActionListener {

    MenuPrincipal menu;
    PanelMenu panel;

    public ControladorMenu(MenuPrincipal vista) {
        menu = vista;
        panel = new PanelMenu();
    }

    public void setUpFrame() {
        menu.setVisible(true);
        menu.placeComp(this.panel, menu.getMainPanel(), 0, 0, 0, 0);
        panel.asignaOyentes(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(panel.getBtnFCFS())) {
            VistaFCFS vistaFCFS = new VistaFCFS();
            FCFS modelo = new FCFS();
            ControladorFCFS controladorFCFS = new ControladorFCFS(vistaFCFS, modelo);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    controladorFCFS.setupFrameFCFS();
                }
            }
            );
        } else if (ae.getSource().equals(panel.getBtnSFJ())) {
            VistaSFJ vistaSFJ = new VistaSFJ();
            SFJ modelo = new SFJ();
            ControladorSFJ controladorSFJ = new ControladorSFJ(vistaSFJ, modelo);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    controladorSFJ.setupFrameSFJ();
                }
            }
            );
        } else if (ae.getSource().equals(panel.getBtnSRTF())) {
            VistaSRTF vistaSRTF = new VistaSRTF();
            SRTF modelo = new SRTF();
            ControladorSRTF controladorSRTF = new ControladorSRTF(vistaSRTF, modelo);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    controladorSRTF.setupFrameSRTF();
                }
            }
            );
        }
    }

}
