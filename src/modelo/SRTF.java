
package modelo;

/**
 *
 * @author Christian Caro Vargas
 * @author Jorge Andrés Bohórquez Castellanos
 * @author Santiago Ríos Valero
 */
public final class SRTF {

    /**
     * Definición de columas de la varible text: Columna 0 (String): Nombre del
     * proceso Columna 1 (int): Instante de llegada Columna 2 (int): Tiempo de
     * ejecución Columna 3 (int): Instante de bloqueo Columna 4 (int): Tiempo de
     * bloqueo Columna 5 (boolean): Estado de bloqueado Columna 6 (int):
     * Variable auxiliar tiempo de ejecución Columna 7 (int): Variable auxiliar
     * tiempo de bloqueo Columna 8 (boolean): Estado de ejecución 
     * Columna 9 (int): Posición en la cola
     * 
     */
    private final Object[][] text;

    public SRTF() {

        this.text = new Object[6][10];

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

        text[0][8] = true;
        text[1][8] = false;
        text[2][8] = false;
        text[3][8] = false;
        text[4][8] = false;
        text[5][8] = false;

        for (int i = 1; i < 10; i++) {
            if (i != 5 && i != 8) {
                text[0][i] = 0;
                text[1][i] = 0;
                text[2][i] = 0;
                text[3][i] = 0;
                text[4][i] = 0;
                text[5][i] = 0;
            }
        }
    }

    public Object getValue(int row, int column) {
        return this.text[row][column];
    }

    public void setValue(int row, int column, Object object) {
        this.text[row][column] = object;
    }
}
