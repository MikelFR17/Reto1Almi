package bingo;
public class Pantalla {
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String FONDO_VERDE = "\u001B[42m\u001B[30m";
    public static final String FONDO_AMARILLO = "\u001B[43m\u001B[30m";

    public static void limpiar() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
        }
    }

    public static void titulo() {
        System.out.println(VERDE + NEGRITA + "+==========================================+");
        System.out.println("|     BINGO DE LA SOSTENIBILIDAD  (ODS)    |");
        System.out.println("|            ALMINGO S.L.                  |");
        System.out.println("+==========================================+" + RESET);
        System.out.println();
    }
}