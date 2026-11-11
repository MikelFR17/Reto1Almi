# Reto1Almi · Sección Web (Almingo)

Página web corporativa de **Almingo**, una empresa ficticia de desarrollo web y aplicaciones para empresas y particulares. Está creada íntegramente con **HTML5 y CSS3**, sin JavaScript, y forma parte del **Reto 1 de Almi**.

Todo el código de esta sección está en la rama `web`, dentro de la carpeta `retoAlmingo/`.

## 📄 Páginas

| Página | Archivo | Descripción |
|--------|---------|-------------|
| **Home** | `index.html` | Portada con carrusel de marcas, proyectos destacados, testimonios y preguntas frecuentes (FAQ). |
| **Services** | `servicios.html` | Galería de las webs que hemos entregado a clientes (Coca-Cola, Sephora, Dior, Google, Kiko Milano, Victoria's Secret, Amazon, Primor y Messi). |
| **Projects** | `Proyectos.html` | Proyecto en curso (*EcoBingo*) y proyectos realizados (*FitLife*, *EduSmart*, *GreenHome*, *TravelGo*, *PetCare*). |
| **Registration** | `registro.html` | Formulario de registro con nombre, apellidos, email, contraseña y fecha de nacimiento. |

## ✨ Características

- **Carrusel infinito de logos** con animación CSS que se pausa al pasar el ratón.
- **Animaciones de aparición al hacer scroll** (`animation-timeline: view()`).
- **Testimonios rotativos** de clientes, animados solo con CSS.
- **FAQ desplegable** con las etiquetas nativas `<details>` y `<summary>`.
- **Efectos hover** en menús, tarjetas de proyectos y botones.
- **Menú de navegación y footer** compartidos en todas las páginas.
- **Formulario de registro** con validación básica del navegador (email y contraseña de mínimo 8 caracteres).

## 🚀 Tecnologías utilizadas

- HTML5
- CSS3 (Flexbox, animaciones, `mask-image`, gradientes)

## 📁 Estructura del proyecto

```
Reto1Almi/
├── retoAlmingo/
│   ├── index.html        # Página principal
│   ├── servicios.html    # Servicios entregados
│   ├── Proyectos.html    # Proyectos de la empresa
│   ├── registro.html     # Formulario de registro
│   ├── style.css         # Estilos comunes (menú y footer)
│   ├── inicio.css        # Estilos de la página principal
│   ├── servicio.css      # Estilos de servicios
│   ├── proyectos.css     # Estilos de proyectos
│   ├── registro.css      # Estilos del formulario
│   └── images/           # Logos, capturas e imágenes
└── README.md
```

## 🖥️ Cómo ejecutarlo en local

1. Clona el repositorio y cambia a la rama `web`:
   ```bash
   git clone https://github.com/MikelFR17/Reto1Almi.git
   cd Reto1Almi
   git checkout web
   ```
2. Entra en la carpeta del proyecto:
   ```bash
   cd retoAlmingo
   ```
3. Abre `index.html` en tu navegador o usa la extensión **Live Server** de VS Code.

> 💡 Se recomienda usar un navegador basado en Chromium (Chrome, Edge) para ver correctamente las animaciones de aparición al hacer scroll.

## 🌿 Ramas

| Rama   | Contenido                                |
|--------|------------------------------------------|
| `main` | Versión base del repositorio             |
| `web`  | Desarrollo de la página web (esta rama)  |

## 🔮 Posibles mejoras

- Hacer el diseño totalmente responsive (actualmente usa anchos fijos de 1280 px).
- Conectar el formulario de registro con un backend.
- Añadir una página de contacto.

## 👤 Autor

**MikelFR17** · [github.com/MikelFR17](https://github.com/MikelFR17)

## 📄 Licencia

Proyecto de uso académico/educativo.
