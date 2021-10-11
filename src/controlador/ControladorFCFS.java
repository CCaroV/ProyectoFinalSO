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
                for (int j = 3; j < 5; j++) {
                    if (modelo.getText(i, j) != null) {
                        modelo.setText(i, j, (int) modelo.getText(i, j) + 1);
                    }
                }
            }

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public void sendTimeToTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                mainTable.setCell(i, j, modelo.getText(i, j));
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
        } else if (ae.getSource().equals(panelEndBegin.getBtnFinish())) {
            timer.stop();
        } else if (ae.getSource().equals(process.getBtnAdd(0))) {
            modelo.setText(0, 1, seconds);
        }

    }

}
