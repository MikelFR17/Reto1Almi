package bingo;
import java.util.Random;

public class BancoPreguntas {
    private Pregunta[] todas = new Pregunta[20];
    private boolean[] usada = new boolean[20];
    private int sinUsar = 20;
    private Random azar = new Random();

    public BancoPreguntas() {
        // ---------- SOSTENIBILIDAD NORMAL (10) ----------
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
        todas[6] = new Pregunta("Que son las 3R?",
                "Reducir, reutilizar y reciclar", "Romper, reparar y repetir", "Rapido, real y rentable");
        todas[7] = new Pregunta("Que es la huella de carbono?",
                "Los gases que producimos con lo que hacemos", "La marca de un zapato", "El peso de un camion");
        todas[8] = new Pregunta("Que es la economia circular?",
                "Usar los recursos muchas veces", "Usar y tirar", "Comprar cosas nuevas cada mes");
        todas[9] = new Pregunta("De que trata el ODS 13?",
                "Accion por el clima", "Hambre cero", "Educacion de calidad");

        // ---------- SOSTENIBILIDAD INFORMATICA (10) ----------
        todas[10] = new Pregunta("Como es un software sostenible?",
                "Gasta poca energia", "Usa muchos servidores sin necesidad", "Se queda abierto todo el dia");
        todas[11] = new Pregunta("Que es el Green IT?",
                "Usar la tecnologia gastando menos recursos y energia", "Un programa para dibujar plantas", "Un antivirus ecologico");
        todas[12] = new Pregunta("Que hacemos con un ordenador viejo que ya no usamos?",
                "Llevarlo a un punto de reciclaje de residuos electronicos", "Tirarlo al contenedor amarillo", "Dejarlo en la calle");
        todas[13] = new Pregunta("Que ahorra energia cuando dejas el ordenador un rato?",
                "Suspenderlo o apagarlo", "Dejarlo con el brillo al maximo", "Poner un salvapantallas animado");
        todas[14] = new Pregunta("Que es un centro de datos?",
                "Un edificio con muchos servidores que gasta mucha energia", "Una tienda de ordenadores", "Un programa para guardar fotos");
        todas[15] = new Pregunta("Como alargamos la vida de un movil o portatil?",
                "Reparandolo o ampliandolo en vez de cambiarlo", "Cambiandolo cada ano", "Tirandolo cuando se raya");
        todas[16] = new Pregunta("Que es la basura electronica?",
                "Aparatos electronicos que ya no se usan", "Los correos spam", "Los archivos duplicados");
        todas[17] = new Pregunta("Por que conviene borrar archivos y correos que no usamos?",
                "Porque guardarlos en servidores gasta energia", "Porque el ordenador queda mas bonito", "No sirve de nada");
        todas[18] = new Pregunta("Que codigo es mas sostenible?",
                "El que hace el mismo trabajo con menos calculos", "El que repite tareas sin necesidad", "El que tarda mas en ejecutarse");
        todas[19] = new Pregunta("Que energia es mejor para alimentar los servidores?",
                "La renovable, como la solar o la eolica", "Solo el carbon", "Generadores de gasoil");
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
