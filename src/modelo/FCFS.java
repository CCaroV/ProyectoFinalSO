package modelo;

import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class FCFS {
    
    //Timer timer = new Timer(0, listener);
    
    TimerTask tarea = new TimerTask() {

        int i = 0;

        @Override
        public void run() {
            i++;
            System.out.println("Segundo: " + i);
        }
    };

    public FCFS() {
    }
    
    

    public void seconds() {    
        //timer.schedule(tarea,0, 1000);
    }

    
}
