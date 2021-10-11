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
        this.text = new Object[6][6];

        text[0][0] = "Spotify";
        text[1][0] = "Firefox";
        text[2][0] = "Zoom";
        text[3][0] = "Steam";
        text[4][0] = "Matlab";
        text[5][0] = "Chrome";
        
        text[0][5] = false;
        text[1][5] = false;
        text[2][5] = false;
        text[3][5] = false;
        text[4][5] = false;
        text[5][5] = false;
    }

    public Object getText(int row, int column) {
        return this.text[row][column];
    }

    public void setText(int row, int column, Object object) {
        this.text[row][column] = object;
    }
}
