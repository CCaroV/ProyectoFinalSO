package controlador;

import vista.MainProcess;
import vista.MainTable;
import vista.PanelCanvas;
import vista.SummaryTable;
import vista.TimeTable;
import vista.VistaFCFS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import modelo.FCFS;
import vista.PanelEndBegin;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class ControladorFCFS implements ActionListener {

    VistaFCFS vista;
    FCFS modelo;
    MainProcess process;
    PanelEndBegin panelEndBegin;
    MainTable mainTable;
    PanelCanvas canvas;
    SummaryTable summaryTable;
    TimeTable timeTable;
    Timer timer;

    private int seconds;

    public ControladorFCFS(VistaFCFS frame, FCFS modeloFCFS) {

        this.vista = frame;
        this.modelo = modeloFCFS;
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
        this.panelEndBegin.asignListener(this);
        this.process.asignListener(this);
    }

    public void increaseCellValue() {
        try {
            for (int i = 0; i < 6; i++) {
                if (modelo.getValue(i, 2) != null
                        && !(boolean) modelo.getValue(i, 5) 
                        && (boolean) modelo.getValue(i, 8)) {
                    modelo.setValue(i, 2, (int) modelo.getValue(i, 2) + 1);
                } else if (modelo.getValue(i, 4) != null
                        && (boolean) modelo.getValue(i, 5)) {
                    modelo.setValue(i, 4, (int) modelo.getValue(i, 4) + 1);
                }
            }
        } catch (Exception ee) {
            System.out.println("Objeto vacío");
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

    public int getSecond() {
        return this.seconds;
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
            modelo.setValue(0, 2, modelo.getValue(0, 6));
            modelo.setValue(0, 7, modelo.getValue(0, 4));
            modelo.setValue(0, 5, false);
            modelo.setValue(0, 8, true);
        } else if (ae.getSource().equals(process.getBtnExec(1))) {
            modelo.setValue(1, 2, modelo.getValue(1, 6));
            modelo.setValue(1, 5, false);
            modelo.setValue(1, 8, true);
        } else if (ae.getSource().equals(process.getBtnExec(2))) {
            modelo.setValue(2, 2, modelo.getValue(2, 6));
            modelo.setValue(2, 5, false);
            modelo.setValue(2, 8, true);
        } else if (ae.getSource().equals(process.getBtnExec(3))) {
            modelo.setValue(3, 2, modelo.getValue(3, 6));
            modelo.setValue(3, 5, false);
            modelo.setValue(3, 8, true);
        } else if (ae.getSource().equals(process.getBtnExec(4))) {
            modelo.setValue(4, 2, modelo.getValue(4, 6));
            modelo.setValue(4, 5, false);
            modelo.setValue(4, 8, true);
        } else if (ae.getSource().equals(process.getBtnExec(5))) {
            modelo.setValue(5, 2, modelo.getValue(5, 6));
            modelo.setValue(5, 5, false);
            modelo.setValue(5, 8, true);
        } else if (ae.getSource().equals(process.getBtnBlock(0))) {
            modelo.setValue(0, 3, seconds);
            modelo.setValue(0, 4, modelo.getValue(0, 7));
            modelo.setValue(0, 5, true);
            modelo.setValue(0, 6, modelo.getValue(0, 2));
        } else if (ae.getSource().equals(process.getBtnTerminate(0))) {
            modelo.setValue(0, 5, false);
            modelo.setValue(0, 8, false);
        }
    }

}
