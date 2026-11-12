# Base de datos · ALMINGO S.L.

Base de datos para la gestión interna de **ALMINGO S.L.**, diseñada dentro del proyecto de modernización de la empresa. Sustituye a las bases de datos anteriores, que la nueva gerencia quería cambiar.

Esta rama contiene solo el `README.md` y el **SQL exportado** (`[nombre-del-archivo].sql`), con la estructura y los datos.

## Objetivo

- Centralizar la información de la empresa en un único sistema.
- Asegurar la **integridad de los datos**.
- Poder extraer la información con **consultas tipo**.

## Qué contiene el archivo SQL

- Creación de la base de datos `[nombre_bd]`.
- Creación de las tablas, con sus claves primarias y foráneas.
- Inserción de datos de ejemplo.
- [Consultas tipo, si las incluisteis en el archivo].

## Modelo de datos

[Descripción breve del modelo entidad-relación: qué información guarda la empresa y cómo se relaciona.]

| Tabla | Contenido | Relaciones |
|---|---|---|
| `[tabla1]` | [p. ej. empleados] | [p. ej. relacionada con proyectos] |
| `[tabla2]` | [p. ej. clientes] | [...] |
| `[tabla3]` | [p. ej. proyectos] | [...] |

## Integridad de los datos

La base de datos asegura que los datos sean coherentes mediante:
- **Claves primarias:** cada registro es único.
- **Claves foráneas:** no se pueden crear relaciones con registros que no existen.
- [Otras restricciones: NOT NULL, UNIQUE, CHECK...]

## Cómo importarla

1. Instala el gestor de base de datos [MySQL / MariaDB / otro] en tu equipo o en la máquina virtual.
2. Importa el archivo desde la terminal:

```
mysql -u [usuario] -p < [nombre-del-archivo].sql
```

3. Comprueba que se ha creado:

```
SHOW DATABASES;
USE [nombre_bd];
SHOW TABLES;
```

## Consultas tipo

[Una o dos consultas de ejemplo, por ejemplo:]

```sql
-- Ejemplo: listar todos los clientes
SELECT * FROM [tabla_clientes];
```
