# Documentación de Tests de Caja Negra - Clase Player

## 1. Introducción

Este documento detalla las pruebas de caja negra realizadas para cada método de la clase `Player` del juego Space Invaders. Para cada método se especifican las técnicas utilizadas, los casos de prueba diseñados y su justificación.

## 2. Método `act()`

### 2.1 Descripción
Método que actualiza la posición del jugador basándose en el movimiento actual (dx).

### 2.2 Técnicas Aplicadas

#### Análisis de Valores Límite
- **Valores límite identificados:**
  - Límite izquierdo: x = 2
  - Límite derecho: x = BOARD_WIDTH - 2*width

#### Casos de Prueba
```java
void testLimiteBordeIzquierdo() {
    // Mover al jugador repetidamente hacia la izquierda
    // Verificar que no sobrepasa x = 2
}

void testLimiteBordeDerecho() {
    // Mover al jugador repetidamente hacia la derecha
    // Verificar que no sobrepasa BOARD_WIDTH - 2*width
}
```

## 3. Método `keyPressed(KeyEvent e)`

### 3.1 Descripción
Método que maneja las teclas presionadas y establece la dirección de movimiento.

### 3.2 Técnicas Aplicadas

#### Partición de Equivalencia
- **Clases Válidas:**
  - CV1: Tecla LEFT
  - CV2: Tecla RIGHT
- **Clases No Válidas:**
  - CNV1: Cualquier otra tecla

#### Casos de Prueba
```java
void testTeclaIzquierdaIniciaMovimiento() {
    // ENTRADA: KeyEvent con VK_LEFT
    // RESULTADO ESPERADO: El jugador se mueve a la izquierda
}

void testTeclaDerechaIniciaMovimiento() {
    // ENTRADA: KeyEvent con VK_RIGHT
    // RESULTADO ESPERADO: El jugador se mueve a la derecha
}

void testOtrasTeclasNoAfectan() {
    // ENTRADA: KeyEvent con VK_UP
    // RESULTADO ESPERADO: El jugador no se mueve
}
```

#### Tabla de Decisión
| Condición/Acción | R1 | R2 | R3 |
|------------------|----|----|----| 
| Tecla LEFT      | Sí | No | No |
| Tecla RIGHT     | No | Sí | No |
| Otra tecla      | No | No | Sí |
| dx = 2          | Sí | Sí | No |

## 4. Método `keyReleased(KeyEvent e)`

### 4.1 Descripción
Método que maneja las teclas liberadas y detiene el movimiento.

### 4.2 Técnicas Aplicadas

#### Partición de Equivalencia
- **Clases Válidas:**
  - CV1: Soltar tecla LEFT cuando se movía a la izquierda
  - CV2: Soltar tecla RIGHT cuando se movía a la derecha
- **Clases No Válidas:**
  - CNV1: Soltar otras teclas
  - CNV2: Soltar tecla cuando no hay movimiento

#### Casos de Prueba
```java
void testDetenerMovimientoAlSoltarTeclas() {
    // ENTRADA: Secuencia KeyPress LEFT -> KeyRelease LEFT
    // RESULTADO ESPERADO: El jugador se detiene
    
    // ENTRADA: Secuencia KeyPress RIGHT -> KeyRelease RIGHT
    // RESULTADO ESPERADO: El jugador se detiene
}
```

## 5. Pruebas de Integración de Funciones

### 5.1 Técnica: Valores Especiales

#### Casos de Prueba: Secuencias de Teclas
```java
void testCambiosRapidosDireccion() {
    // ENTRADA: Alternancia rápida entre LEFT y RIGHT
    // RESULTADO ESPERADO: El jugador responde a cada cambio de dirección
}
```

### 5.2 Justificación
Estas pruebas verifican el comportamiento del jugador en situaciones que combinan múltiples entradas de teclado y movimientos.

## 6. Resumen de Cobertura

### Técnicas por Método:
1. `act()`:
   - Análisis de valores límite
   - Valores especiales (movimiento continuo)

2. `keyPressed()`:
   - Partición de equivalencia
   - Tabla de decisión
   - Valores especiales

3. `keyReleased()`:
   - Partición de equivalencia
   - Valores especiales (teclas rápidas)

### Tipos de Casos Probados:
1. Movimiento básico
2. Límites del tablero
3. Respuesta a teclas
4. Detención de movimiento
5. Secuencias de teclas
