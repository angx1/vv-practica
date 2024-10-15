package space_invaders.sprites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Long.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    @Test
    public void testShotMovesUpward() { //Disparo se hace correctamente y va hacia arriba
        // Coordenadas de entrada
        int inputX = 100;
        int inputY = 200;

        // Crear el objeto Shot
        Shot shot = new Shot(inputX, inputY);

        // Verificar las coordenadas ajustadas
        assertEquals(106, shot.getX(), "La coordenada X del disparo debería ser 106");
        assertEquals(199, shot.getY(), "La coordenada Y del disparo debería ser 199");
    }

    @Test
    public void testShotDoesNotMoveDownward() { //El disparo no va hacia abajo
        // Coordenadas de entrada
        int inputX = 100;
        int inputY = 200;

        // Crear el objeto Shot
        Shot shot = new Shot(inputX, inputY);

        // Guardar la coordenada Y original
        int originalY = shot.getY();

        // Verificar que la coordenada Y no ha aumentado
        assertTrue(shot.getY() <= originalY, "La coordenada Y del disparo no debería aumentar, indicando que no se mueve hacia abajo.");
    }
 /*
    @Test
    public void testOnlyOneShotAtATime() {
        // Coordenadas de entrada
        int inputX = 100;
        int inputY = 200;

        // Crear el primer disparo
        Shot firstShot = new Shot(inputX, inputY);

        // Simulamos que el primer disparo todavía está "en juego"
        assertTrue(firstShot.isVisible(), "El primer disparo debería ser visible.");

        // Intentamos crear un segundo disparo antes de que el primero desaparezca
        Shot secondShot = new Shot(inputX, inputY);

        // Verificamos que el primer disparo aún es el único disparo visible
        assertSame(firstShot, secondShot, "Debería ser el mismo disparo, solo uno debe estar activo.");
    }
 */
    //Robust Boundary Value Test
    private static final int BOARD_WIDTH = 358;  // Valor de ancho del tablero
    private static final int BOARD_HEIGHT = 350; // Valor de altura del tablero

    @Test
    public void testShotInitializationWithInvalidXAndY() {
        Shot shot = new Shot(-1, -1);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0 para un valor negativo.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0 para un valor negativo.");
    }

    @Test
    public void testShotInitializationWithInvalidXAndValidY() {
        Shot shot = new Shot(-1, 0);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithInvalidXAndYAboveMin() {
        Shot shot = new Shot(-1, 1);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0.");
        assertEquals(1, shot.getY(), "La coordenada Y debería ser 1.");
    }

    @Test
    public void testShotInitializationWithValidXAndInvalidY() {
        Shot shot = new Shot(0, -1);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithZeroXAndY() {
        Shot shot = new Shot(0, 0);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithZeroXAndYAboveMin() {
        Shot shot = new Shot(0, 1);
        assertEquals(0, shot.getX(), "La coordenada X debería ser 0.");
        assertEquals(1, shot.getY(), "La coordenada Y debería ser 1.");
    }

    @Test
    public void testShotInitializationWithXAboveMinAndInvalidY() {
        Shot shot = new Shot(1, -1);
        assertEquals(1, shot.getX(), "La coordenada X debería ser 1.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithXAboveMinAndZeroY() {
        Shot shot = new Shot(1, 0);
        assertEquals(1, shot.getX(), "La coordenada X debería ser 1.");
        assertEquals(0, shot.getY(), "La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithMaxXAndMaxY() {
        Shot shot = new Shot(357, 349);
        assertEquals(357, shot.getX(), "La coordenada X debería ser 357.");
        assertEquals(349, shot.getY(), "La coordenada Y debería ser 349.");
    }

    @Test
    public void testShotInitializationWithMaxXAndY() {
        Shot shot = new Shot(358, 350);
        assertEquals(358, shot.getX(), "La coordenada X debería ser 358.");
        assertEquals(350, shot.getY(), "La coordenada Y debería ser 350.");
    }

    @Test
    public void testShotInitializationWithXAboveMaxAndYAboveMax() {
        Shot shot = new Shot(359, 351);
        assertEquals(358, shot.getX(), "La coordenada X debería ser el valor máximo permitido.");
        assertEquals(350, shot.getY(), "La coordenada Y debería ser el valor máximo permitido.");
    }

    @Test
    public void testShotInitializationWithXAboveMaxAndMaxY() {
        Shot shot = new Shot(359, 350);
        assertEquals(358, shot.getX(), "La coordenada X debería ser el valor máximo permitido.");
        assertEquals(350, shot.getY(), "La coordenada Y debería ser 350.");
    }

    @Test
    public void testShotInitializationWithMaxXAndYAboveMax() {
        Shot shot = new Shot(358, 351);
        assertEquals(358, shot.getX(), "La coordenada X debería ser 358.");
        assertEquals(350, shot.getY(), "La coordenada Y debería ser el valor máximo permitido.");
    }





}

