package space_invaders.sprites;
import main.Commons;

import java.awt.RenderingHints;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;


/*


 * 1. initPlayer():

Particiones de Equivalencia: Esta función no recibe parámetros, por lo que no hay particiones de entrada. Se centra en la inicialización del jugador. Las pruebas deben verificar:

La imagen del jugador se carga correctamente.

La posición inicial del jugador es la correcta (START_X y START_Y).

El ancho del jugador (width) se calcula correctamente a partir de la imagen.

Valores Límite: No aplica directamente, ya que no hay rangos numéricos de entrada.

Valores Especiales: No aplica directamente. 
 

 * 2. act():

Particiones de Equivalencia:

x dentro de los límites de la pantalla.

x en el límite izquierdo de la pantalla (x = 2).

x en el límite derecho de la pantalla (x = Commons.BOARD_WIDTH - 2 * width).

Valores Límite: Concentrarse en los valores límite de x:

x = 2

x = 3 (justo dentro del límite izquierdo)

x = Commons.BOARD_WIDTH - 2 * width

x = Commons.BOARD_WIDTH - 2 * width - 1 (justo dentro del límite derecho)

Si hay un valor mínimo posible para width, pruébalo también. 
Valores extremos de dx (aunque el juego solo use 2 y 0, prueba valores mayores y 
negativos para ver el comportamiento, especialmente para robustez).

Valores Especiales: Podrías considerar valores de dx que sean muy grandes 
(positivos o negativos) para ver cómo se comporta la función (aunque no sean 
valores esperados en el juego normal). Esto ayuda a probar la robustez.


 * 3. keyPressed(KeyEvent e) y keyReleased(KeyEvent e):

Particiones de Equivalencia:

Tecla izquierda presionada (KeyEvent.VK_LEFT).

Tecla derecha presionada (KeyEvent.VK_RIGHT).

Otras teclas presionadas (cualquier otra tecla).

Valores Límite: No aplica directamente, ya que se trabaja con códigos de tecla específicos.

Valores Especiales:

Combinaciones de teclas (por ejemplo, izquierda y derecha presionadas simultáneamente).

Teclas que no son de movimiento. Considerar que el código no reacciona a VK_RIGHT, hay un error.
*/



class PlayerTest {

    @Test
    void initPlayer() {
        Player player = new Player();
        int playerX=  player.getX();
        int playerY=  player.getY();
        assertEquals(playerX, Commons.BOARD_WIDTH/2);
        assertEquals(playerY, Commons.BOARD_HEIGHT/2);
    
    }

    @Test
    void act() {
        Player player = new Player();
        int playerX =  player.getX();
        int playerY =  player.getY();
        player.act();
        assertEquals(playerX, player.getX());
        assertEquals(playerY, player.getY());
    }







    

        

}

