# Bingo de la Sostenibilidad (ODS)

Bingo multijugador por terminal, hecho en Java para ALMINGO S.L. Para cantar una línea hay que contestar bien una pregunta de sostenibilidad.

## Cómo se juega

1. Un equipo elige **1) Crear partida** (anfitrión) y los demás **2) Unirse a una partida**.
2. El anfitrión espera a que se conecten los jugadores y pulsa ENTER para empezar.
3. Salen bolas del 1 al 30, sin repetirse, una cada 2 segundos. ENTER saca la siguiente al momento.
4. Cada jugador (anfitrión incluido) tiene un cartón de 3x3 con 9 números distintos del 1 al 30.
5. Cuando una **fila entera** está marcada, aparece el aviso *"Tienes una LINEA!"*.
6. Escribe `L` + ENTER para cantarla y responde la pregunta (A/B/C). Si fallas, sale otra hasta acertar.
7. Quien valida las **3 líneas** primero gana el **BINGO**.

### Colores del cartón

- **Verde:** número que ya ha salido.
- **Amarillo:** última bola.
- **Sin color:** número que aún no ha salido.

### Final de la partida

- Termina en cuanto alguien gana el bingo.
- Si salen las 30 bolas y nadie ha ganado, hay **60 segundos** para cantar las líneas pendientes. Si nadie gana, la partida acaba sin ganador.
- Al terminar se muestra el ganador y la lista de jugadores. ENTER vuelve al menú.

## Preguntas

Hay 20 preguntas con tres respuestas (las respuestas se mezclan cada vez):

- **10 de sostenibilidad general:** ODS, reciclaje, economía circular, huella de carbono...
- **10 de sostenibilidad informática:** Green IT, residuos electrónicos, centros de datos, código eficiente...

No se repiten hasta que han salido todas.

## Compilar y ejecutar

Desde la carpeta que contiene `bingo/`:

```
javac bingo/*.java
java bingo.Bingo
```

Requiere Java y una consola con soporte de colores ANSI.

## Jugar en red

Los equipos no se conectan entre sí: comparten una **carpeta de red** donde se guarda el estado de la partida.

1. El anfitrión crea una carpeta `bingo` y la comparte con permiso de **lectura y escritura**.
2. Al arrancar, cada participante escribe la ruta de esa carpeta, por ejemplo `\\192.168.1.25\bingo` (`\\IP-DEL-ANFITRION\bingo`).
3. Si pulsas ENTER sin escribir nada se usa `C:/bingo`, útil para probar en un solo equipo.

Todos deben usar la misma carpeta. Si sale *"No se puede acceder a la carpeta"*, revisa la ruta, que estéis en la misma red y los permisos de escritura.

Ficheros que se crean en la carpeta:

| Fichero | Contenido |
|---|---|
| `estado.txt` | Estado de la partida (`ESPERANDO`, `JUGANDO`, `FIN`) |
| `bolas.txt` | Bolas que han salido |
| `jugadores.txt` | Jugadores conectados |
| `premios.txt` | Ganador del bingo |

Cada jugador revisa estos ficheros cada 0,5 s para ver bolas nuevas.

## Controles

| Quién | Tecla | Acción |
|---|---|---|
| Anfitrión | ENTER (sala de espera) | Empieza la partida |
| Anfitrión | ENTER (en juego) | Saca la siguiente bola |
| Todos | `L` + ENTER | Cantar línea |
| Todos | `A` / `B` / `C` + ENTER | Responder la pregunta |
| Todos | ENTER (al final) | Volver al menú |

## Clases

- `Bingo`: menú principal y elección de carpeta.
- `Sala`: lee y escribe los ficheros de la carpeta compartida.
- `Anfitrion`: saca las bolas y juega con su cartón.
- `Jugador`: cartón y cantos del jugador.
- `Carton`: genera el cartón y comprueba las líneas.
- `Pregunta` y `BancoPreguntas`: las 20 preguntas, sin repetir.
- `Teclado` y `Pantalla`: entrada por teclado, colores y pausas.
