package modelo;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class FCFS {

    private final Object[][] text;

    public FCFS() {
        this.text = new Object[6][5];

    }
    
    public Object getText(int row, int column) {
        return this.text[row][column];
    }
    
    public void setText(int row, int column, Object object) {
        this.text[row][column] = object;
    }
}
