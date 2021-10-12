/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import vista.MainProcess;
import vista.MainTable;
import vista.PanelCanvas;
import vista.SummaryTable;
import vista.TimeTable;
import vista.VistaSFJ;
import vista.PanelEndBegin;
import modelo.SFJ;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class ControladorSFJ implements ActionListener {

    VistaSFJ vista;
    SFJ modelo;
    MainProcess process;
    PanelEndBegin panelEndBegin;
    MainTable mainTable;
    PanelCanvas canvas;
    SummaryTable summaryTable;
    TimeTable timeTable;
    Timer timer;

    private int seconds;
    
    public ControladorSFJ(VistaSFJ frame, SFJ modeloSJF) {

        this.vista = frame;
        this.modelo = modeloSJF;
        this.process = new MainProcess();
        this.panelEndBegin = new PanelEndBegin();
        this.mainTable = new MainTable();
        this.canvas = new PanelCanvas();
        this.summaryTable = new SummaryTable();
        this.timeTable = new TimeTable();

        this.seconds = 0;

        sendTimeToTable();
        sendTimeToTable2();
        //Define el intervalo de tiempo y el evento a escuchar
        this.timer = new Timer(1000, (ActionEvent ae) -> {
            seconds++;
            increaseCellValue();
            sendTimeToTable();
            sendTimeToTable2();
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
        this.panelEndBegin.asignListener(this);
        this.process.asignListener(this);
    }

    public void increaseCellValue() {
        try {
            for (int i = 0; i < 6; i++) {
                if (modelo.getValue(i, 2) != null
                        && !(boolean) modelo.getValue(i, 5)
                        && (boolean) modelo.getValue(i, 8)
                        && (int) modelo.getValue(i, 2) > 0) {
                    modelo.setValue(i, 2, (int) modelo.getValue(i, 2) - 1);
                    modelo.setValue2(i, 1, (int) modelo.getValue2(i, 1) - 1);
                } else if (modelo.getValue(i, 4) != null
                        && (boolean) modelo.getValue(i, 5)) {
                    modelo.setValue(i, 4, (int) modelo.getValue(i, 4) + 1);
                }
            }
        } catch (Exception ee) {
            System.out.println("Objeto vacío");
        }
    }

    public void checkExec(int row){
        if ((int) modelo.getValue(row, 2) == 0 ){
            modelo.setValue(row, 8, false);
            modelo.setValue(row, 5, false);
        }
    }

    public void sendTimeToTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                mainTable.setCell(i, j, modelo.getValue(i, j));
            }
        }
        this.panelEndBegin.setLblTime(seconds);
    }

    public void sendTimeToTable2(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                timeTable.setCell(i, j, modelo.getValue2(i, j));
            }
        }
        this.panelEndBegin.setLblTime(seconds);
    }

    public int getSecond() {
        return this.seconds;
    }

    public void execProcess(int row){
        for (int i = 0; i < 6; i++) {
            if ((boolean) modelo.getValue(i, 8) && (int)modelo.getValue(i, 2)>0) {
                blockProcess(i);
            }
        }
        checkExec(row);
        modelo.setValue(row, 7, modelo.getValue(row, 4));
        modelo.setValue(row, 5, false);
        modelo.setValue(row, 8, true); 
    }

    private void blockProcess(int row) {
        modelo.setValue(row, 3, seconds);
        // modelo.setValue(row, 4, modelo.getValue(row, 7));
        modelo.setValue2(row, 3, modelo.getValue(row, 7));
        System.out.println(modelo.getValue(row, 7));
        modelo.setValue(row, 5, true);
        modelo.setValue(row, 8, false);
        modelo.setValue(row, 6, modelo.getValue(row, 2));
        modelo.setValue(row, 9, (int) modelo.getValue(row, 9) + 1);
        
    }

    private void finishProcess(int row) {
        modelo.setValue(row, 5, false);
        modelo.setValue(row, 8, false);
        int aux = 0;
        for (int i = 0; i < 5; i++) {
            //No funciona como debería
            if ((int) modelo.getValue(i, 9) > (int) modelo.getValue(i + 1, 9) 
                    && (boolean) modelo.getValue(i, 5)) {
                aux = i;
            }
        }
        execProcess(aux);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(panelEndBegin.getBtnStart())) {
            timer.start();
            panelEndBegin.setLblShowStatus("Ejecutando");
        } else if (ae.getSource().equals(panelEndBegin.getBtnFinish())) {
            timer.stop();
            panelEndBegin.setLblShowStatus("Detenido");
        } else if (ae.getSource().equals(process.getBtnAdd(0))) {
            modelo.setValue(0, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnAdd(1))) {
            modelo.setValue(1, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnAdd(2))) {
            modelo.setValue(2, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnAdd(3))) {
            modelo.setValue(3, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnAdd(4))) {
            modelo.setValue(4, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnAdd(5))) {
            modelo.setValue(5, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(0))) {
            execProcess(0);
        } else if (ae.getSource().equals(process.getBtnExec(1))) {
            execProcess(1);
        } else if (ae.getSource().equals(process.getBtnExec(2))) {
            execProcess(2);
        } else if (ae.getSource().equals(process.getBtnExec(3))) {
            execProcess(3);
        } else if (ae.getSource().equals(process.getBtnExec(4))) {
            execProcess(4);
        } else if (ae.getSource().equals(process.getBtnExec(5))) {
            execProcess(5);
        } else if (ae.getSource().equals(process.getBtnBlock(0))) {
            blockProcess(0);
        } else if (ae.getSource().equals(process.getBtnBlock(1))) {
            blockProcess(1);
        } else if (ae.getSource().equals(process.getBtnBlock(2))) {
            blockProcess(2);
        } else if (ae.getSource().equals(process.getBtnBlock(3))) {
            blockProcess(3);
        } else if (ae.getSource().equals(process.getBtnBlock(4))) {
            blockProcess(4);
        } else if (ae.getSource().equals(process.getBtnBlock(5))) {
            blockProcess(5);
        } else if (ae.getSource().equals(process.getBtnTerminate(0))) {
            finishProcess(0);
        } else if (ae.getSource().equals(process.getBtnTerminate(1))) {
            finishProcess(1);
        } else if (ae.getSource().equals(process.getBtnTerminate(2))) {
            finishProcess(2);
        } else if (ae.getSource().equals(process.getBtnTerminate(3))) {
            finishProcess(3);
        } else if (ae.getSource().equals(process.getBtnTerminate(4))) {
            finishProcess(4);
        } else if (ae.getSource().equals(process.getBtnTerminate(5))) {
            finishProcess(5);
        }
    }
}
