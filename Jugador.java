public class Jugador {
    private Sala sala;
    private Teclado teclado;
    private BancoPreguntas banco = new BancoPreguntas();
    private Carton carton = new Carton();
    // filasCantadas[i] vale true si la fila i ya esta cantada
    private boolean[] filasCantadas = new boolean[carton.getTotalFilas()];
    private int totalCantadas = 0;
    private String nombre;

    public Jugador(Sala sala, Teclado teclado) {
        this.sala = sala;
        this.teclado = teclado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugar() {
        String estado = sala.getEstado();
        if (estado.equals("") || estado.equals("FIN")) {
            System.out.println(Pantalla.ROJO + "No hay ninguna partida abierta." + Pantalla.RESET);
            Pantalla.pausa(2000);
            return;
        }

        System.out.print("Tu nombre: ");
        nombre = teclado.leerLinea().trim();
        if (nombre.equals("")) {
            nombre = "Jugador";
        }
        sala.agregarJugador(nombre);

        boolean fin = false;
        while (!fin) {
            // Redibujamos la pantalla en cada vuelta (cada medio segundo)
            dibujar();

            if (sala.getEstado().equals("FIN")) {
                System.out.println();
                teclado.vaciar();
                System.out.println("Pulsa ENTER para volver al menu");
                teclado.leerLinea();
                fin = true;
            } else if (teclado.hayEntrada()) {
                String orden = teclado.leerLinea().trim().toUpperCase();
                if (orden.equals("L")) {
                    cantarLinea();
                }
            }
            Pantalla.pausa(500);
        }
    }

    private void dibujar() {
        int[] bolas = sala.getBolas();
        Pantalla.limpiar();
        Pantalla.titulo();
        System.out.println("Jugador: " + Pantalla.NEGRITA + nombre + Pantalla.RESET);
        System.out.println();
        if (sala.getEstado().equals("ESPERANDO")) {
            System.out.println(Pantalla.AMARILLO + "Esperando a que empiece la partida..." + Pantalla.RESET);
        } else if (bolas.length > 0) {
            int ultima = bolas[bolas.length - 1];
            System.out.println("Ultima bola: " + Pantalla.AMARILLO + Pantalla.NEGRITA + ultima + Pantalla.RESET
                    + "   (bolas: " + bolas.length + ")");
        }
        System.out.println();
        mostrarCarton();
        System.out.println();
        mostrarGanador();
        System.out.println();
        mostrarAvisos();
        System.out.println(Pantalla.CIAN + "L + ENTER = cantar linea (al cantar la 3 ganas el bingo)" + Pantalla.RESET);
    }

    public void mostrarCarton() {
        int[] bolas = sala.getBolas();
        carton.mostrar(bolas);
        System.out.println();
        System.out.println("Aciertos: " + carton.aciertos(bolas) + "/" + carton.getTotalNumeros()
                + "   Lineas cantadas: " + totalCantadas + "/" + carton.getTotalFilas());
    }

    public void mostrarAvisos() {
        int[] bolas = sala.getBolas();
        if (carton.filaPendiente(bolas, filasCantadas) != -1) {
            System.out.println(Pantalla.AMARILLO + Pantalla.NEGRITA + "Tienes una LINEA! Escribe L + ENTER para cantarla" + Pantalla.RESET);
        }
    }

    private void mostrarGanador() {
        String ganador = sala.getGanador("BINGO");
        if (ganador == null) {
            System.out.println("Ganador del bingo: todavia nadie");
        } else {
            System.out.println("Ganador del bingo: " + Pantalla.VERDE + ganador + Pantalla.RESET);
        }
    }

    public void cantarLinea() {
        int[] bolas = sala.getBolas();
        System.out.println();
        int fila = carton.filaPendiente(bolas, filasCantadas);
        if (sala.getGanador("BINGO") != null) {
            System.out.println(Pantalla.ROJO + "El bingo ya lo han cantado." + Pantalla.RESET);
        } else if (fila == -1) {
            System.out.println(Pantalla.ROJO + "Todavia no tienes una linea nueva para cantar." + Pantalla.RESET);
        } else {
            validarLinea(fila);
        }
        Pantalla.pausa(3000);
    }

    private void validarLinea(int fila) {
        boolean acierto = false;
        while (!acierto && sala.getGanador("BINGO") == null && !sala.getEstado().equals("FIN")) {
            Pregunta pregunta = banco.elegirUna();
            acierto = pregunta.preguntar(teclado);
            if (!acierto) {
                System.out.println(Pantalla.AMARILLO + "Intentalo de nuevo para avanzar..." + Pantalla.RESET);
                Pantalla.pausa(2000);
            }
        }

        if (!acierto) {
            System.out.println(Pantalla.AMARILLO + "La partida ha terminado." + Pantalla.RESET);
            return;
        }

        filasCantadas[fila] = true;
        totalCantadas++;
        System.out.println(Pantalla.VERDE + Pantalla.NEGRITA + "LINEA " + totalCantadas + "/"
                + carton.getTotalFilas() + " VALIDADA!" + Pantalla.RESET);

        if (totalCantadas == carton.getTotalFilas()) {
            boolean ganador = sala.registrarPremio("BINGO", nombre);
            if (ganador) {
                System.out.println(Pantalla.VERDE + Pantalla.NEGRITA + "BINGO! Has completado las 3 lineas. Eres el ganador!" + Pantalla.RESET);
            } else {
                System.out.println(Pantalla.AMARILLO + "Otro jugador completo antes sus 3 lineas." + Pantalla.RESET);
            }
        }
    }
}