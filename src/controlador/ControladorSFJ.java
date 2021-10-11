/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.*;
import javax.swing.Timer;
import modelo.*;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class ControladorSFJ implements ActionListener {

    VistaSJF vista;
    MainProcess process;
    PanelEndBegin panelEndBegin;
    MainTable mainTable;
    PanelCanvas canvas;
    SummaryTable summaryTable;
    TimeTable timeTable;
    Timer timer;

    private int seconds;

    public ControladorSFJ(VistaSJF frame, FCFS modeloFCFS) {

        this.vista = frame;
        // this.modelo = modeloFCFS;
        this.process = new MainProcess();
        this.panelEndBegin = new PanelEndBegin();
        this.mainTable = new MainTable();
        this.canvas = new PanelCanvas();
        this.summaryTable = new SummaryTable();
        this.timeTable = new TimeTable();

        this.seconds = 0;

        sendTimeToTable();

        //Define el intervalo de tiempo y el evento a escuchar
        this.timer = new Timer(1000, (ActionEvent ae) -> {
            seconds++;
            increaseCellValue();
            sendTimeToTable();
        });
    }
    public void setupFrame() {
        //Mostrar Frame
        vista.setVisible(true);

        //Primera fila
        vista.placeComp(this.panelEndBegin, vista.getMainPanel(), 0, 0, 1, 1);
        vista.placeComp(this.mainTable, vista.getMainPanel(), 1, 0, 2, 1);

        //Segunda fila
        vista.placeComp(this.timeTable, vista.getMainPanel(), 0, 1, 4, 1);

        //Tercera fila
        //vista.placeComp(this.canvas, vista.getMainPanel(), 0, 2, 5, 1);
        vista.placeComp(this.process, vista.getMainPanel(), 0, 2, 2, 1);
        vista.placeComp(this.summaryTable, vista.getMainPanel(), 2, 2, 2, 1);
    }

    public void setupListeners() {
        // this.panelEndBegin.asignListener(this);
        // this.process.asignListener(this);
    }

    public void increaseCellValue() {
        try {
            for (int i = 0; i < 6; i++) {
                // if (modelo.getValue(i, 2) != null
                //         && !(boolean) modelo.getValue(i, 5)
                //         && (boolean) modelo.getValue(i, 8)) {
                //     modelo.setValue(i, 2, (int) modelo.getValue(i, 2) + 1);
                // } else if (modelo.getValue(i, 4) != null
                //         && (boolean) modelo.getValue(i, 5)) {
                //     modelo.setValue(i, 4, (int) modelo.getValue(i, 4) + 1);
                // }
            }
        } catch (Exception ee) {
            System.out.println("Objeto vacío");
        }
    }

    public void sendTimeToTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                // mainTable.setCell(i, j, modelo.getValue(i, j));
            }
        }
        this.panelEndBegin.setLblTime(seconds);
    }

    public int getSecond() {
        return this.seconds;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
