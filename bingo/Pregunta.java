package bingo;
import java.util.Random;

public class Pregunta {
    private String texto;
    private String correcta;
    private String mala1;
    private String mala2;
    private Random azar = new Random();

    public Pregunta(String texto, String correcta, String mala1, String mala2) {
        this.texto = texto;
        this.correcta = correcta;
        this.mala1 = mala1;
        this.mala2 = mala2;
    }

    public boolean preguntar(Teclado teclado) {
        String[] opciones = new String[3];
        opciones[0] = correcta;
        opciones[1] = mala1;
        opciones[2] = mala2;

        // Mezclamos intercambiando cada posicion con otra al azarr
        for (int i = opciones.length - 1; i > 0; i--) {
            int j = azar.nextInt(i + 1);
            String guardado = opciones[i];
            opciones[i] = opciones[j];
            opciones[j] = guardado;
        }

        String letras = "ABC";
        String letraCorrecta = "";
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].equals(correcta)) {
                letraCorrecta = letras.substring(i, i + 1);
            }
        }

        teclado.vaciar();

        System.out.println();
        System.out.println(Pantalla.MAGENTA + Pantalla.NEGRITA + "*** PREGUNTA DE SOSTENIBILIDAD ***" + Pantalla.RESET);
        System.out.println();
        System.out.println(Pantalla.NEGRITA + texto + Pantalla.RESET);
        System.out.println();
        for (int i = 0; i < opciones.length; i++) {
            System.out.println("  " + Pantalla.AMARILLO + letras.substring(i, i + 1) + Pantalla.RESET + ") " + opciones[i]);
        }
        System.out.println();
        System.out.print("Tu respuesta (A/B/C): ");
        String respuesta = teclado.leerLinea().trim().toUpperCase();

        if (respuesta.equals(letraCorrecta)) {
            System.out.println(Pantalla.VERDE + Pantalla.NEGRITA + "Correcto!" + Pantalla.RESET);
            return true;
        }
        System.out.println(Pantalla.ROJO + "Fallaste. Era: " + correcta + Pantalla.RESET);
        return false;
    }
}