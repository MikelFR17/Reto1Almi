# ALMINGO S.L. · Proyecto de modernización

ALMINGO S.L. es una empresa de desarrollo de software y apps para empresas y particulares. Con la llegada de una nueva gerencia, la empresa renueva sus equipos y sus bases de datos internas, se abre al mercado internacional con una web en inglés y adopta control de versiones para coordinar a todo el equipo de desarrollo.

Este repositorio reúne **todo el trabajo del proyecto**, organizado en tres ramas independientes.

## Estructura del repositorio

| Rama | Contenido | Descripción |
|---|---|---|
| `main` | Este README | Visión general del proyecto Almingo |
| `bingo` | [Código Java del juego] | Bingo de la Sostenibilidad, juego multijugador por terminal |
| `web` | [Archivos de la web] | Página web de la empresa en inglés |
| `base-de-datos` | `README.md` + SQL exportado | Base de datos del proyecto |

Cada rama es independiente y tiene su propio README con los detalles. Para ver una parte, cambia de rama:

```
git checkout bingo
git checkout web
git checkout base-de-datos
```

## Las tres partes del proyecto

### Bingo de la Sostenibilidad
Primer encargo de la nueva etapa: **gamificar el aprendizaje y la concienciación sobre sostenibilidad** con un bingo colectivo que se juega en una sala.
- Varios jugadores, en equipos distintos y a la vez.
- Para cantar una línea o el bingo hay que acertar preguntas de sostenibilidad.
- 20 preguntas: 10 de sostenibilidad general y 10 de sostenibilidad informática.

### Página web
Nueva web de la empresa **en inglés**, pensada para entrar en el mercado internacional.

### Base de datos
Diseño de la base de datos con su modelo entidad-relación, asegurando la **integridad de los datos**, con datos de ejemplo y consultas tipo. Se entrega como SQL exportado.

## Infraestructura y trabajo en equipo

- **Máquina virtual:** instalada y configurada para alojar la base de datos y los servicios del proyecto.
- **Control de versiones (Git):** todo el equipo trabaja sobre el mismo repositorio, con ramas separadas por parte y copias de seguridad del trabajo.

## Cómo está organizado el trabajo

```
              main (visión general)
                      |
      +---------------+---------------+
      |               |               |
    bingo            web        base-de-datos
```

## Equipo

| Integrante | Participación |
|---|---|
| **Josu** | Desarrollo del Bingo de la Sostenibilidad (rama `bingo`) |
| **Evelyn** | Página web y base de datos (rama `web` y `base-de-datos`) |
| **Mikel** | Página web y base de datos (rama `web` y `base-de-datos`) |
