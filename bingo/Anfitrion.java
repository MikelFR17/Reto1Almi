package bingo;
import java.util.Random;

public class Anfitrion {
    private static final int SEGUNDOS_ENTRE_BOLAS = 2;
    private static final int SEGUNDOS_FINAL = 60;
    private static final int TOTAL_BOLAS = 30;
    private static final String NOMBRE = "Anfitrion";

    private Sala sala;
    private Teclado teclado;
    private Random azar = new Random();
    private Jugador anfitrion;

    public Anfitrion(Sala sala, Teclado teclado) {
        this.sala = sala;
        this.teclado = teclado;
        anfitrion = new Jugador(sala, teclado);
        anfitrion.setNombre(NOMBRE);
    }

    public void jugar() {
        sala.reiniciar();
        sala.agregarJugador(NOMBRE);
        esperarJugadores();
        sala.setEstado("JUGANDO");

        boolean terminado = false;
        while (!terminado) {
            int[] bolas = sala.getBolas();
            if (bolas.length == TOTAL_BOLAS) {
                terminado = true;
            } else {
                int numero = azar.nextInt(TOTAL_BOLAS) + 1;
                while (Sala.contiene(bolas, numero)) {
                    numero = azar.nextInt(TOTAL_BOLAS) + 1;
                }
                sala.agregarBola(numero);
                dibujar(numero);
                esperarSiguienteBola(numero);
                if (sala.getGanador("BINGO") != null) {
                    terminado = true;
                }
            }
        }

        esperarFinal();
        sala.setEstado("FIN");
        dibujarFinal();
    }

    private void esperarJugadores() {
        int anteriores = -1;
        while (!teclado.hayEntrada()) {
            String[] jugadores = sala.getJugadores();
            if (jugadores.length != anteriores) {
                anteriores = jugadores.length;
                Pantalla.limpiar();
                Pantalla.titulo();
                System.out.println(Pantalla.AMARILLO + "Sala abierta. Esperando jugadores..." + Pantalla.RESET);
                System.out.println();
                for (int i = 0; i < jugadores.length; i++) {
                    System.out.println("  * " + jugadores[i]);
                }
                System.out.println();
                System.out.println("Jugadores: " + jugadores.length);
                System.out.println(Pantalla.VERDE + "Pulsa ENTER para empezar la partida" + Pantalla.RESET);
            }
            Pantalla.pausa(500);
        }
        teclado.leerLinea();
    }

    private void esperarSiguienteBola(int ultima) {
        int espera = 0;
        boolean siguiente = false;
        while (!siguiente && espera < SEGUNDOS_ENTRE_BOLAS * 1000 && sala.getGanador("BINGO") == null) {
            if (teclado.hayEntrada()) {
                String orden = teclado.leerLinea().trim().toUpperCase();
                if (orden.equals("L")) {
                    anfitrion.cantarLinea();
                    dibujar(ultima);
                } else {
                    siguiente = true;
                }
            } else {
                Pantalla.pausa(100);
                espera = espera + 100;
            }
        }
    }

    private void esperarFinal() {
        if (sala.getGanador("BINGO") != null) {
            return;
        }
        int[] bolas = sala.getBolas();
        int ultima = bolas[bolas.length - 1];
        dibujar(ultima);
        System.out.println(Pantalla.AMARILLO + "Ya han salido todas las bolas. Teneis " + SEGUNDOS_FINAL
                + " segundos para cantar." + Pantalla.RESET);

        int espera = 0;
        while (espera < SEGUNDOS_FINAL * 1000 && sala.getGanador("BINGO") == null) {
            if (teclado.hayEntrada()) {
                String orden = teclado.leerLinea().trim().toUpperCase();
                if (orden.equals("L")) {
                    anfitrion.cantarLinea();
                }
                dibujar(ultima);
            } else {
                Pantalla.pausa(100);
                espera = espera + 100;
            }
        }
    }

    private void dibujar(int ultima) {
        int[] bolas = sala.getBolas();
        Pantalla.limpiar();
        Pantalla.titulo();
        System.out.println(Pantalla.AMARILLO + Pantalla.NEGRITA);
        System.out.println("      .-------.");
        System.out.println("     /         \\");
        System.out.println(String.format("    |    %2d     |", ultima));
        System.out.println("     \\         /");
        System.out.println("      '-------'" + Pantalla.RESET);
        System.out.println();
        System.out.println("Bolas sacadas: " + bolas.length + "/" + TOTAL_BOLAS
                + "   Jugadores: " + sala.getJugadores().length);
        System.out.println();
        for (int i = 1; i <= TOTAL_BOLAS; i++) {
            if (Sala.contiene(bolas, i)) {
                System.out.print(Pantalla.FONDO_VERDE + String.format(" %2d ", i) + Pantalla.RESET);
            } else {
                System.out.print(String.format(" %2d ", i));
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Tu carton (" + NOMBRE + "):");
        anfitrion.mostrarCarton();
        System.out.println();
        mostrarGanador();
        System.out.println();
        anfitrion.mostrarAvisos();
        System.out.println(Pantalla.CIAN + "ENTER = siguiente bola   |   L + ENTER = cantar linea (al cantar la 3 ganas el bingo)" + Pantalla.RESET);
    }

    private void mostrarGanador() {
        String ganador = sala.getGanador("BINGO");
        if (ganador == null) {
            System.out.println("Ganador del bingo: " + Pantalla.AMARILLO + "todavia nadie" + Pantalla.RESET);
        } else {
            System.out.println("Ganador del bingo: " + Pantalla.VERDE + Pantalla.NEGRITA + ganador + Pantalla.RESET);
        }
    }

    private void dibujarFinal() {
        Pantalla.limpiar();
        Pantalla.titulo();
        System.out.println(Pantalla.MAGENTA + Pantalla.NEGRITA + "FIN DE LA PARTIDA" + Pantalla.RESET);
        System.out.println();
        mostrarGanador();
        System.out.println();
        String[] jugadores = sala.getJugadores();
        System.out.println("Jugadores de la partida (" + jugadores.length + "):");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("  " + (i + 1) + ". " + jugadores[i]);
        }
        System.out.println();
        teclado.vaciar();
        System.out.println("Pulsa ENTER para volver al menu");
        teclado.leerLinea();
    }
}