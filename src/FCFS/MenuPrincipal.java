/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class MenuPrincipal extends JFrame {

    JTable table;

    String tittle[] = {"Hola, Adios"};

    Object content[][] = {
        {"Primera", "Segunda"}
    };

    public MenuPrincipal() throws HeadlessException {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "My Demo Table", TitledBorder.LEFT,
                TitledBorder.TOP));
        String[][] rec = {
            {"001", "David", "AUS"},
            {"002", "Steve", "AUS"},
            {"003", "Yuvraj", "IND"},
            {"004", "Kane", "NZ"},
            {"005", "Ben", "ENG"},
            {"006", "Eion", "ENG"},
            {"007", "Miller", "SA"},
            {"008", "Rohit", "IND"}
        };
        String[] header = {"Id", "Player", "Team"};
        JTable table = new JTable(rec, header);
        panel.add(new JScrollPane(table));
        this.add(panel);
        this.setSize(550, 400);
        this.setVisible(true);

    }

}
