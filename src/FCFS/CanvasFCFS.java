package FCFS;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public class CanvasFCFS extends Canvas{
    
    @Override
    public void paint(Graphics g) {
        g.drawLine(20, 540, 1000, 540);
        g.drawLine(25, 20, 25, 545);
        g.fillRect(25, 25, 25, 25);
    }
    
    
}
