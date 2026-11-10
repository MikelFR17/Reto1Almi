package bingo;
public class Bingo {
    private static final String RUTA_POR_DEFECTO = "C:/bingo";

    public static void main(String[] args) {
        Teclado teclado = new Teclado();

        Pantalla.limpiar();
        Pantalla.titulo();
        System.out.print("Carpeta compartida (ENTER = " + RUTA_POR_DEFECTO + "): ");
        String ruta = teclado.leerLinea().trim();
        if (ruta.equals("")) {
            ruta = RUTA_POR_DEFECTO;
        }

        Sala sala = new Sala(ruta);
        if (!sala.accesible()) {
            System.out.println(Pantalla.ROJO + "No se puede acceder a la carpeta " + ruta + Pantalla.RESET);
            return;
        }

        boolean salir = false;
        while (!salir) {
            Pantalla.limpiar();
            Pantalla.titulo();
            System.out.println("  1) Crear partida (anfitrion)");
            System.out.println("  2) Unirse a una partida (jugador)");
            System.out.println("  3) Salir");
            System.out.print("Opcion: ");
            String opcion = teclado.leerLinea().trim();

            if (opcion.equals("1")) {
                Anfitrion anfitrion = new Anfitrion(sala, teclado);
                anfitrion.jugar();
            } else if (opcion.equals("2")) {
                Jugador jugador = new Jugador(sala, teclado);
                jugador.jugar();
            } else if (opcion.equals("3")) {
                salir = true;
            }
        }
        System.out.println("Hasta pronto!");
    }
}