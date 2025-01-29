# SimonDice-Recu - Juego con Arquitectura MVVM

Este proyecto es una implementación del juego "Simón Dice", desarrollado en Kotlin utilizando **Jetpack Compose** para la interfaz de usuario. Sigue el patrón de diseño **MVVM (Model-View-ViewModel)** para garantizar una separación clara de responsabilidades y una arquitectura escalable. Además, hace uso de **corutinas** para manejar operaciones asincrónicas, garantizando una experiencia fluida.

---
## 📌 Características
- **Juego clásico de "Simón Dice"** con una interfaz moderna.
- **Arquitectura MVVM** para separación de responsabilidades.
- **Uso de LiveData** para actualizar la UI de manera reactiva.
- **Corutinas** para manejar animaciones y lógica asincrónica.
- **Sonidos personalizados** al presionar cada botón.

---
## 📂 Estructura del Código

### 📁 Datos (Modelo)
- `Datos` → Contiene las enumeraciones para colores y estados del juego.
- `ColorButton` → Define los colores y sus propiedades visuales.
- `Estados` → Enum con los estados del juego (`INICIO`, `GENERANDO`, `ADIVINANDO`, `PERDIDO`).

### 📁 Vista (UI con Jetpack Compose)
- `IU` → Contiene la interfaz general del juego.
- `BotonInicio` → Botón de inicio y reinicio del juego.
- `Botones` → Genera los botones de colores para el juego.

### 📁 ViewModel
- `ModelView` → Gestiona la lógica del juego y el estado de la UI.
    - `empezarJuego()` → Inicia y reinicia la partida.
    - `mostrarSecuencia()` → Muestra la secuencia de colores con retrasos.
    - `compararColor()` → Verifica la entrada del usuario.
    - `agregarColorASecuencia()` → Agrega nuevos colores a la secuencia.

---
## 🚀 Tecnologías Utilizadas
- **Kotlin** → Lenguaje de programación.
- **Jetpack Compose** → Framework de UI declarativa.
- **LiveData** → Manejo de datos reactivos.
- **Corutinas** → Para operaciones asincrónicas.
- **MediaPlayer** → Para la reproducción de sonidos.

---
## 🎮 Cómo Jugar
1. Pulsa "Iniciar" para comenzar.
2. Observa la secuencia de colores que se ilumina.
3. Repite la secuencia en el mismo orden.
4. Si aciertas, la secuencia se alarga.
5. Si fallas, el juego termina y puedes reiniciar.

---
## 🔜 Próximas Mejoras
- **Implementar niveles de dificultad.**
- **Añadir efectos visuales adicionales.**
- **Guardar la puntuación más alta.**
- **Soporte multijugador en línea.**

