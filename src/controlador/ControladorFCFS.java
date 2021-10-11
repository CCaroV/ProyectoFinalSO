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
            setCellValue();
            sendTimeToModel();
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

    public void setCellValue() {
        mainTable.setCell(0, 2, (int) modelo.getText(0, 2) + 1);
        mainTable.setCell(1, 2, (int) modelo.getText(1, 2) + 1);
        mainTable.setCell(2, 2, (int) modelo.getText(2, 2) + 1);
        mainTable.setCell(3, 2, (int) modelo.getText(3, 2) + 1);
        mainTable.setCell(4, 2, (int) modelo.getText(4, 2) + 1);
        mainTable.setCell(5, 2, (int) modelo.getText(5, 2) + 1);
    }

    public void sendTimeToModel() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                modelo.setText(i, j, mainTable.getCell(i, j));
            }
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


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(panelEndBegin.getBtnStart())) {
            timer.start();
        } else if (ae.getSource().equals(panelEndBegin.getBtnFinish())) {
            timer.stop();
        }
    }

}
