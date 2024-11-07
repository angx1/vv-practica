package space_invaders.sprites;

import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import space_invaders.sprites.Shot;

import static java.lang.Long.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    private Shot shot;

    @BeforeEach
    public void setUp() {
        // Inicializa el disparo en una posición inicial
        shot = new Shot(0, 0); // Puedes cambiar las coordenadas según sea necesario
    }

    @Test
    public void testShotInitialization() {
        assertNotNull(shot);
        assertTrue(shot.isVisible(), "El disparo debe ser visible al inicializarse.");
        assertEquals(6, shot.getX(), "La coordenada X debe ser 6 ya que suma 6 en X.");
        assertEquals(-1, shot.getY(), "La coordenada Y debe ser -1 ya que Y resta  1.");
    }

/*    @Test
    public void testShotPositioning() {
        shot.setX(100);
        shot.setY(200);
        assertEquals(100, shot.getX(), "La coordenada X debe ser 100.");
        assertEquals(200, shot.getY(), "La coordenada Y debe ser 200.");
         @Test
    public void testShotVisibility() {
        shot.setVisible(false);
        assertFalse(shot.isVisible(), "El disparo debe ser invisible.");
        shot.setVisible(true);
        assertTrue(shot.isVisible(), "El disparo debe ser visible.");
    }


    @Test
    public void testShotMovement() {
        shot.setX(150);
        shot.setY(150);
        shot.setY(shot.getY() - 10); // Simular disparo hacia arriba
        assertEquals(140, shot.getY(), "La coordenada Y debe ser 140 tras disparar.");
    }
    }*/



/*    @Test
    public void testShotOutOfBounds() {
        // Intentamos colocar el disparo más allá del límite superior
        shot.setY(Commons.BOARD_HEIGHT + 10);  // Esto lo coloca fuera de los límites hacia arriba
        // Verificamos que el disparo esté efectivamente en una posición más allá del límite inferior
        assertEquals(Commons.BOARD_HEIGHT + 10, shot.getY(), "El disparo debe poder superar el límite inferior.");
    }*/

    // VALORES LIMITES
    @Test
    public void testShotInitializationWithNegativeXAndValidY() {
        Shot shot = new Shot(-1, 175);
        assertEquals(5, shot.getX(), "(C1) La coordenada X debería ser 5.");
        assertEquals(174, shot.getY(), "(C1) La coordenada Y debería ser 174.");
    }

    @Test
    public void testShotInitializationWithZeroXAndValidY() {
        Shot shot = new Shot(0, 175);
        assertEquals(6, shot.getX(), "(C2) La coordenada X debería ser 6.");
        assertEquals(174, shot.getY(), "(C2) La coordenada Y debería ser 174.");
    }

    @Test
    public void testShotInitializationWithValidXAndY() {
        Shot shot = new Shot(1, 175);
        assertEquals(7, shot.getX(), "(C3) La coordenada X debería ser 7.");
        assertEquals(174, shot.getY(), "(C3) La coordenada Y debería ser 174.");
    }

    @Test
    public void testShotInitializationWithValidXAndInvalidY() {
        Shot shot = new Shot(179, 175);
        assertEquals(185, shot.getX(), "(C4) La coordenada X debería ser 185.");
        assertEquals(174, shot.getY(), "(C4) La coordenada Y debería ser 174.");
    }

    @Test
    public void testShotInitializationWithZeroXAndY() {
        Shot shot = new Shot(Commons.BOARD_WIDTH - 1, 175);
        assertEquals(363, shot.getX(), "(C5) La coordenada X debería ser 363.");
        assertEquals(174, shot.getY(), "(C5) La coordenada Y debería ser 174.");
    }


    @Test
    public void testShotInitializationWithZeroXAndYAboveMin() {
        Shot shot = new Shot(Commons.BOARD_WIDTH, 175);
        assertEquals(Commons.BOARD_WIDTH + 6 , shot.getX(), "(C6) La coordenada X debería ser 364.");
        assertEquals(174, shot.getY(), "(C6) La coordenada Y debería ser 174.");
    }

    @Test
    public void testShotInitializationWithXAboveMinAndInvalidY() {
        Shot shot = new Shot(Commons.BOARD_WIDTH + 1, 175);
        assertEquals(365, shot.getX(), "(C7) La coordenada X debería ser 365.");
        assertEquals(174, shot.getY(), "(C7) La coordenada Y debería ser 174.");
    }


    @Test
    public void testShotInitializationWithXAboveMinAndZeroY() {
        Shot shot = new Shot(175, -1);
        assertEquals(181, shot.getX(), "(C8) La coordenada X debería ser 175.");
        assertEquals(-2, shot.getY(), "(C8) La coordenada Y debería ser -2.");
    }


    @Test
    public void testShotInitializationWithMaxXAndMaxY() {
        Shot shot = new Shot(175, 0);
        assertEquals(181, shot.getX(), "(C9) La coordenada X debería ser 181.");
        assertEquals(-1, shot.getY(), "(C9) La coordenada Y debería ser -1.");
    }


    @Test
    public void testShotInitializationWithXAboveMaxAndYAboveMax() {
        Shot shot = new Shot(175, 1);
        assertEquals(181, shot.getX(), "(C10) La coordenada X debería ser el valor 181.");
        assertEquals(0, shot.getY(), "(C10) La coordenada Y debería ser el valor 0.");
    }

    @Test
    public void testShotInitializationWithXAboveMaxAndMaxY() {
        Shot shot = new Shot(175, Commons.BOARD_HEIGHT -1);
        assertEquals(181, shot.getX(), "(C11) La coordenada X debería ser el valor 181.");
        assertEquals(348 , shot.getY(), "(C11) La coordenada Y debería ser 348.");
    }

    @Test
    public void testShotInitializationWithMaxXAndYAboveMax() {
        Shot shot = new Shot(175, Commons.BOARD_HEIGHT);
        assertEquals(181, shot.getX(), "(C12) La coordenada X debería ser 181.");
        assertEquals(349, shot.getY(), "(C12)La coordenada Y debería ser el valor 349.");
    }


    @Test
    public void testShotInitializationWithMaxXAndY() {
        Shot shot = new Shot(175, Commons.BOARD_HEIGHT + 1);
        assertEquals(181, shot.getX(), "(C13) La coordenada X debería ser 181.");
        assertEquals(350, shot.getY(), "(C13) La coordenada Y debería ser el valor max 350.");
    }

}

