package space_invaders.sprites;

import main.Commons;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {
    

    // Se ignoran los test de getters y setters, porque se generan automaticamente

    //Se prueba el constructor, que contiene initShot, que es el método que se quiere probar
    //TODO Revisar si merece la pena pegar la imagen

    @ParameterizedTest
    @CsvSource({
        "-1, 175, 5, 174",   // Caso límite negativo X
        "0, 175, 6, 174",    // Caso límite cero X
        "1, 175, 7, 174",    // Caso válido X
        "179, 175, 185, 174", // Caso válido X mayor
        "357, 175, 363, 174",  // Caso límite máximo X
        "358, 175, 364, 174",  // Caso sobre límite X
        "359, 175, 365, 174"  // Caso sobre límite X
    })
    void testShotInitializationX(int inputX, int inputY, int expectedX, int expectedY) {
        Shot shot = new Shot(inputX, inputY);
        assertEquals(expectedX, shot.getX(), "La coordenada X debería ser " + expectedX);
        assertEquals(expectedY, shot.getY(), "La coordenada Y debería ser " + expectedY);
    }

    @ParameterizedTest
    @CsvSource({
        "179, -1, 185, -2",  // Caso límite negativo Y
        "179, 0, 185, -1",   // Caso límite cero Y
        "179, 1, 185, 0",    // Caso válido Y
        "179, " + Commons.BOARD_HEIGHT + ", 185, 349",  // Caso límite máximo Y
        "179, " + (Commons.BOARD_HEIGHT - 1) + ", 185, 348",  // Caso sobre límite Y
        "179, " + (Commons.BOARD_HEIGHT + 1) + ", 185, 350"  // Caso sobre límite Y
    })

    void testShotInitializationY(int inputX, int inputY, int expectedX, int expectedY) {
        Shot shot = new Shot(inputX, inputY);
        assertEquals(expectedX, shot.getX(), "La coordenada X debería ser " + expectedX);
        assertEquals(expectedY, shot.getY(), "La coordenada Y debería ser " + expectedY);
    }

    /*@Test
    public void testShotOutOfBounds() {
        shot.setY(Commons.GROUND + 10);
        assertEquals(Commons.GROUND + 10, shot.getY(), "El disparo debe poder superar el límite inferior.");
    }*/
}

