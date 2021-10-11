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

        text[0][0] = "Firefox";
        text[1][0] = "Spotify";
        text[2][0] = "Chrome";
        text[3][0] = "Matlab";
        text[4][0] = "Steam";
        text[5][0] = "Zoom";
        
        text[0][2] = 13;
        text[1][2] = 5;
        text[2][2] = 7;
        text[3][2] = 2;
        text[4][2] = 4;
        text[5][2] = 11;
    }

    public Object getText(int row, int column) {
        return this.text[row][column];
    }

    public void setText(int row, int column, Object object) {
        this.text[row][column] = object;
    }
}
