package bingo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
    private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    public boolean hayEntrada() {
        try {
            return lector.ready();
        } catch (IOException e) {
            return false;
        }
    }

    public String leerLinea() {
        try {
            String linea = lector.readLine();
            if (linea == null) {
                return "";
            }
            return linea;
        } catch (IOException e) {
            return "";
        }
    }

    public void vaciar() {
        while (hayEntrada()) {
            leerLinea();
        }
    }
}