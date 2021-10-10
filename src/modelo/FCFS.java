package modelo;

import java.util.*;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class FCFS {

    public Timer timer;
    private final Object[][] text;
    private int seconds;

    public FCFS() {
        this.text = new Object[6][5];
        this.timer = new Timer();
        this.seconds = 0;

        seconds();
    }

    TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            seconds++;
            System.out.println("Segundo: " + seconds);
        }
    };

    public void seconds() {
        //timer.schedule(tarea, 0, 1000);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
