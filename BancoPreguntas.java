import java.util.Random;

public class BancoPreguntas {
    private Pregunta[] todas = new Pregunta[18];
    private boolean[] usada = new boolean[18];
    private int sinUsar = 18;
    private Random azar = new Random();

    public BancoPreguntas() {
        todas[0] = new Pregunta("Que significa ODS?",
                "Objetivos de Desarrollo Sostenible", "Oficina de Datos Seguros", "Ofertas de Descuento Semanal");
        todas[1] = new Pregunta("Cuantos ODS hay en la Agenda 2030?",
                "17", "7", "30");
        todas[2] = new Pregunta("Que significa ASG en sostenibilidad?",
                "Ambiental, Social y Gobernanza", "Agua, Sol y Gas", "Ahorro, Salud y Gasto");
        todas[3] = new Pregunta("Que gas calienta mas el planeta?",
                "El CO2", "El oxigeno", "El helio");
        todas[4] = new Pregunta("Que tiramos en el contenedor azul?",
                "Papel y carton", "Vidrio", "Restos de comida");
        todas[5] = new Pregunta("Que tiramos en el contenedor amarillo?",
                "Envases de plastico y latas", "Vidrio", "Pilas");
        todas[6] = new Pregunta("Que tiramos en el contenedor verde?",
                "Botellas y botes de vidrio", "Papel", "Ropa");
        todas[7] = new Pregunta("Cual de estas es una energia renovable?",
                "La del viento", "El petroleo", "El carbon");
        todas[8] = new Pregunta("Que son las 3R?",
                "Reducir, reutilizar y reciclar", "Romper, reparar y repetir", "Rapido, real y rentable");
        todas[9] = new Pregunta("Que es la huella de carbono?",
                "Los gases que producimos con lo que hacemos", "La marca de un zapato", "El peso de un camion");
        todas[10] = new Pregunta("Que es la economia circular?",
                "Usar los recursos muchas veces", "Usar y tirar", "Comprar cosas nuevas cada mes");
        todas[11] = new Pregunta("De que trata el ODS 13?",
                "Accion por el clima", "Hambre cero", "Educacion de calidad");
        todas[12] = new Pregunta("De que trata el ODS 7?",
                "Energia limpia y barata", "Vida submarina", "Paz y justicia");
        todas[13] = new Pregunta("Que haces para ahorrar energia en la oficina?",
                "Apagar los equipos al terminar", "Dejar todo encendido", "Poner el aire al maximo");
        todas[14] = new Pregunta("Como ahorras agua al lavarte los dientes?",
                "Cerrando el grifo", "Dejando el grifo abierto", "Usando mas agua");
        todas[15] = new Pregunta("Donde tiramos las pilas usadas?",
                "En un punto limpio o contenedor de pilas", "En el contenedor amarillo", "En la calle");
        todas[16] = new Pregunta("Que es el desarrollo sostenible?",
                "Cubrir lo que necesitamos hoy sin danar el futuro", "Ganar dinero lo mas rapido posible", "Consumir todo lo que se pueda");
        todas[17] = new Pregunta("Como es un software sostenible?",
                "Gasta poca energia", "Usa muchos servidores sin necesidad", "Se queda abierto todo el dia");
    }

    public Pregunta elegirUna() {
        // Si ya se han usado todas, volvemos a empezar
        if (sinUsar == 0) {
            for (int i = 0; i < usada.length; i++) {
                usada[i] = false;
            }
            sinUsar = todas.length;
        }
        int posicion = azar.nextInt(todas.length);
        while (usada[posicion]) {
            posicion = azar.nextInt(todas.length);
        }
        usada[posicion] = true;
        sinUsar--;
        return todas[posicion];
    }
}