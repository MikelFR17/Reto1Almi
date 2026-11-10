package bingo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sala {
    // Maximo de lineas que leemos de un fichero (limite de jugadores)
    private static final int MAX_LINEAS = 200;

    private String ruta;

    public Sala(String ruta) {
        this.ruta = ruta;
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    public boolean accesible() {
        File carpeta = new File(ruta);
        if (carpeta.isDirectory() && carpeta.canWrite()) {
            return true;
        }
        return false;
    }

    // Recorre el array de bolas y dice si el numero esta
    public static boolean contiene(int[] bolas, int numero) {
        for (int i = 0; i < bolas.length; i++) {
            if (bolas[i] == numero) {
                return true;
            }
        }
        return false;
    }

    // Lee un fichero y devuelve sus lineas en un array del tamano justo
    private String[] leer(String archivo) {
        String[] temporal = new String[MAX_LINEAS];
        int total = 0;
        try {
            File fichero = new File(ruta, archivo);
            Scanner lector = new Scanner(fichero);
            while (lector.hasNextLine() && total < MAX_LINEAS) {
                temporal[total] = lector.nextLine();
                total++;
            }
            lector.close();
        } catch (FileNotFoundException e) {
            // Si no existe, devolvemos un array vacio
        }
        String[] lineas = new String[total];
        for (int i = 0; i < total; i++) {
            lineas[i] = temporal[i];
        }
        return lineas;
    }

    private void agregar(String archivo, String texto) {
        try {
            File fichero = new File(ruta, archivo);
            FileWriter escritor = new FileWriter(fichero, true);
            escritor.write(texto + "\n");
            escritor.close();
        } catch (IOException e) {
        }
    }

    private void sobrescribir(String archivo, String texto) {
        try {
            File fichero = new File(ruta, archivo);
            FileWriter escritor = new FileWriter(fichero);
            escritor.write(texto);
            escritor.close();
        } catch (IOException e) {
        }
    }

    public void reiniciar() {
        sobrescribir("estado.txt", "ESPERANDO");
        sobrescribir("bolas.txt", "");
        sobrescribir("jugadores.txt", "");
        sobrescribir("premios.txt", "");
    }

    public String getEstado() {
        String[] lineas = leer("estado.txt");
        if (lineas.length == 0) {
            return "";
        }
        return lineas[0].trim();
    }

    public void setEstado(String estado) {
        sobrescribir("estado.txt", estado);
    }

    public int[] getBolas() {
        String[] lineas = leer("bolas.txt");
        int[] temporal = new int[lineas.length];
        int total = 0;
        for (int i = 0; i < lineas.length; i++) {
            try {
                temporal[total] = Integer.parseInt(lineas[i].trim());
                total++;
            } catch (NumberFormatException e) {
                // Linea vacia o rota: la ignoramos
            }
        }
        int[] bolas = new int[total];
        for (int i = 0; i < total; i++) {
            bolas[i] = temporal[i];
        }
        return bolas;
    }

    public void agregarBola(int numero) {
        agregar("bolas.txt", "" + numero);
    }

    public String[] getJugadores() {
        return leer("jugadores.txt");
    }

    public void agregarJugador(String nombre) {
        agregar("jugadores.txt", nombre);
    }

    public String getGanador(String premio) {
        String[] lineas = leer("premios.txt");
        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i];
            if (linea.startsWith(premio + ";")) {
                return linea.substring(premio.length() + 1);
            }
        }
        return null;
    }

    public boolean registrarPremio(String premio, String nombre) {
        if (getGanador(premio) != null) {
            return false;
        }
        agregar("premios.txt", premio + ";" + nombre);
        String ganador = getGanador(premio);
        return nombre.equals(ganador);
    }
}