package controlador;

import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import modelo.*;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class ControladorSRTF implements ActionListener {

    VistaSRTF vista;
    SRTF modelo;
    MainProcessSRTF process;
    PanelEndBegin panelEndBegin;
    MainTable mainTable;
    PanelCanvas canvas;
    SummaryTable summaryTable;
    TimeTable timeTable;
    Timer timer;

    private int seconds;

    public ControladorSRTF(VistaSRTF frame, SRTF modeloSRTF) {

        this.vista = frame;
        this.modelo = modeloSRTF;
        this.process = new MainProcessSRTF();
        this.panelEndBegin = new PanelEndBegin();
        this.mainTable = new MainTable();
        this.canvas = new PanelCanvas();
        this.summaryTable = new SummaryTable();
        this.timeTable = new TimeTable();

        this.seconds = 0;

        sendTimeToTable();
        sendTimeToTable2();

        // Define el intervalo de tiempo y el evento a escuchar
        this.timer = new Timer(1000, (ActionEvent ae) -> {
            seconds++;
            increaseCellValue();
            sendTimeToTable();
            sendTimeToTable2();

        });
    }

    public void setupFrameSRTF() {
        // Mostrar Frame
        vista.setVisible(true);

        // Primera fila
        vista.placeComp(this.panelEndBegin, vista.getMainPanel(), 0, 0, 1, 1);
        vista.placeComp(this.mainTable, vista.getMainPanel(), 1, 0, 2, 1);

        // Segunda fila
        vista.placeComp(this.timeTable, vista.getMainPanel(), 0, 1, 4, 1);

        // Tercera fila
        // vista.placeComp(this.canvas, vista.getMainPanel(), 0, 2, 5, 1);
        vista.placeComp(this.process, vista.getMainPanel(), 0, 2, 2, 1);
        vista.placeComp(this.summaryTable, vista.getMainPanel(), 2, 2, 2, 1);
        setupListeners();
    }

    public void setupListeners() {
        this.panelEndBegin.asignListener(this);
        this.process.asignListener(this);
    }

    public void increaseCellValue() {
        int aux = 33;
        try {
            for (int i = 0; i < 6; i++) {
                if (modelo.getValue(i, 2) != null
                        && !(boolean) modelo.getValue(i, 5)
                        && (boolean) modelo.getValue(i, 8)
                        && (int) modelo.getValue(i, 2) > 0) {
                    modelo.setValue(i, 2, (int) modelo.getValue(i, 2) - 1);
                    modelo.setValue2(i, 1, (int) modelo.getValue2(i, 1) - 1);
                    if((int)modelo.getValue2(i, 1)==0){
                        
                        for(int j = 0; j < 6; j++){
                            if((boolean)modelo.getValue(j,5) && ((int)(modelo.getValue(j,2))>0)){
                                aux = j; 
                                System.out.println("Este es aux " + aux);
                        
                                break;
                            }
                        }
                        modelo.setValue2(i, 4, seconds);
                        modelo.setValue2(i, 5, seconds - (int)modelo.getValue(i, 1));
                        modelo.setValue2(i, 6, (int)modelo.getValue2(i, 5) - (int)modelo.getValue(i, 10));
                        modelo.setValue2(i, 7, Double.valueOf((int)modelo.getValue2(i, 5)) / Double.valueOf((int)modelo.getValue(i, 10)));
                        // modelo.setValue2(i, 8, (int)modelo.getValue(i, 11) - (int)modelo.getValue(i, 1));
                        modelo.setValue2(i, 8, (int)modelo.getValue(i, 1));
                        if ((int)modelo.getValue2(i, 4) - (int)modelo.getValue(i, 1) - (int)modelo.getValue2(i, 3) - (int)modelo.getValue(i, 11) < 0){
                            modelo.setValue2(i, 2, ((int)modelo.getValue2(i, 4) - (int)modelo.getValue(i, 1)) - (int)modelo.getValue2(i, 3) - (int)modelo.getValue(i, 11)*(-1));
                        }else if ((int)modelo.getValue2(i, 4) - (int)modelo.getValue(i, 1) - (int)modelo.getValue2(i, 3) - (int)modelo.getValue(i, 11) > 0){
                            modelo.setValue2(i, 2, ((int)modelo.getValue2(i, 4) - (int)modelo.getValue(i, 1)) - (int)modelo.getValue2(i, 3) - (int)modelo.getValue(i, 11));
                        }
                        execProcess(aux) ;

                    }                    
                } else if (modelo.getValue(i, 4) != null
                        && (boolean) modelo.getValue(i, 5)) {
                    modelo.setValue(i, 4, (int) modelo.getValue(i, 4) + 1);
                    modelo.setValue2(i, 3, (int) modelo.getValue(i, 4));
                }
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public void checkExec(int row) {
        if ((int) modelo.getValue(row, 2) == 0) {
            modelo.setValue(row, 8, false);
            modelo.setValue(row, 5, false);
        }
        for (int i = 0; i < 6; i ++){
            if((boolean)modelo.getValue(i, 8)){
                execProcess(i);
            }
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

    public void sendTimeToTable2() {
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

    public void execProcess(int row) {
        int aux = (int)modelo.getValue(row,2); 
        for (int i = 0; i < 6; i++) {
            if ((boolean) modelo.getValue(i, 8) && (int) modelo.getValue(i, 2) > 0) {
                blockProcess(i);
                if ((int)modelo.getValue(i, 2) < aux){
                    blockProcess(row);
                    row = i;
                    
                }
            }
        }
        checkExec(row);
        modelo.setValue(row, 7, modelo.getValue(row, 4));
        modelo.setValue(row, 5, false);
        modelo.setValue(row, 8, true);
    }

    private void blockProcess(int row) {
        modelo.setValue(row, 3, seconds);
        modelo.setValue(row, 4, modelo.getValue(row, 7));
        // modelo.setValue2(row, 3, modelo.getValue(row, 7));
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
            // No funciona como debería
            if ((int) modelo.getValue(i, 9) > (int) modelo.getValue(i + 1, 9) && (boolean) modelo.getValue(i, 5)) {
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
        } else if (ae.getSource().equals(process.getBtnExec(0))) {
            execProcess(0);
            modelo.setValue(0, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(1))) {
            execProcess(1);
            modelo.setValue(1, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(2))) {
            execProcess(2);
            modelo.setValue(2, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(3))) {
            execProcess(3);
            modelo.setValue(3, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(4))) {
            execProcess(4);
            modelo.setValue(4, 1, seconds);
        } else if (ae.getSource().equals(process.getBtnExec(5))) {
            execProcess(5);
            modelo.setValue(5, 1, seconds);
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