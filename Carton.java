import java.util.Random;

public class Carton {
    private static final int FILAS = 3;
    private static final int COLUMNAS = 3;
    private static final int MAXIMO = 30;

    private int[][] numeros = new int[FILAS][COLUMNAS];

    public Carton() {
        Random azar = new Random();
        // usado[n] vale true si el numero n ya esta en el carton
        boolean[] usado = new boolean[MAXIMO + 1];
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                int numero = azar.nextInt(MAXIMO) + 1;
                while (usado[numero]) {
                    numero = azar.nextInt(MAXIMO) + 1;
                }
                usado[numero] = true;
                numeros[fila][columna] = numero;
            }
        }
    }

    public int getTotalNumeros() {
        return FILAS * COLUMNAS;
    }

    public int getTotalFilas() {
        return FILAS;
    }

    public boolean filaCompleta(int fila, int[] bolas) {
        for (int columna = 0; columna < COLUMNAS; columna++) {
            if (!Sala.contiene(bolas, numeros[fila][columna])) {
                return false;
            }
        }
        return true;
    }

    // Devuelve la primera fila completa que aun no se ha cantado, o -1
    public int filaPendiente(int[] bolas, boolean[] cantadas) {
        for (int fila = 0; fila < FILAS; fila++) {
            if (!cantadas[fila] && filaCompleta(fila, bolas)) {
                return fila;
            }
        }
        return -1;
    }

    public int aciertos(int[] bolas) {
        int total = 0;
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (Sala.contiene(bolas, numeros[fila][columna])) {
                    total++;
                }
            }
        }
        return total;
    }

    public void mostrar(int[] bolas) {
        int ultima = -1;
        if (bolas.length > 0) {
            ultima = bolas[bolas.length - 1];
        }
        String separador = Pantalla.CIAN + "+----+----+----+" + Pantalla.RESET;
        System.out.println(separador);
        for (int fila = 0; fila < FILAS; fila++) {
            String linea = Pantalla.CIAN + "|" + Pantalla.RESET;
            for (int columna = 0; columna < COLUMNAS; columna++) {
                int numero = numeros[fila][columna];
                String celda = String.format(" %2d ", numero);
                if (numero == ultima) {
                    celda = Pantalla.FONDO_AMARILLO + celda + Pantalla.RESET;
                } else if (Sala.contiene(bolas, numero)) {
                    celda = Pantalla.FONDO_VERDE + celda + Pantalla.RESET;
                }
                linea = linea + celda + Pantalla.CIAN + "|" + Pantalla.RESET;
            }
            System.out.println(linea);
            System.out.println(separador);
        }
    }
}