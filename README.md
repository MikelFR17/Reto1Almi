# Bingo de la Sostenibilidad

Bingo multijugador por terminal en Java para ALMINGO S.L. Los cantos se validan con preguntas de sostenibilidad.


## Cómo se juega

1. Un equipo elige **1) Crear partida** (anfitrión) y los demás **2) Unirse a una partida**.
2. El anfitrión pulsa ENTER para empezar. Salen bolas del 1 al 30 cada 2 segundos (ENTER saca la siguiente al momento).
3. Cada jugador tiene un cartón 3x3. Cuando completas una fila, el juego te avisa.
4. Escribe `L` + ENTER para cantar la línea y responde la pregunta. Si fallas, sale otra.
5. Al validar las 3 líneas ganas el bingo.

## Compilar y ejecutar

```
javac *.java
java Bingo
```

Los equipos se comunican por la carpeta compartida (por defecto `C:/bingo`). En los demás equipos se escribe la ruta de red, por ejemplo `\\SERVIDOR\bingo`.

## Clases

- `Bingo`: menú principal.
- `Sala`: lee y escribe los ficheros de la carpeta compartida.
- `Anfitrion`: saca las bolas y juega con su cartón.
- `Jugador`: cartón y cantos del jugador.
- `Carton`: genera el cartón y comprueba las líneas.
- `Pregunta` y `BancoPreguntas`: preguntas de sostenibilidad sin repetir.
- `Teclado` y `Pantalla`: entrada por teclado, colores y pausas.
