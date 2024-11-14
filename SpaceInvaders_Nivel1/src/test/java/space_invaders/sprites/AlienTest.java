package space_invaders.sprites;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @ParameterizedTest
    @CsvSource({
        "-1, 175, 0",    // xMinMinus
        "0, 175, 0",     // xMin
        "1, 175, 1",     // xMinPlus
        "357, 175, 357", // xMaxMinus
        "358, 175, 358", // xMax
        "359, 175, 358"  // xMaxPlus
    })
    void testInitAlienX(int inputX, int inputY, int expectedX) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getX());
    }

    @ParameterizedTest
    @CsvSource({
        "179, -1, 0",    // yMinMinus
        "179, 0, 0",     // yMin
        "179, 1, 1",     // yMinPlus
        "179, 349, 349", // yMaxMinus
        "179, 350, 350", // yMax
        "179, 351, 350"  // yMaxPlus
    })
    void testInitAlienY(int inputX, int inputY, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedY, alien.getY());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 175, 0",    // xMinMinus
        "0, 175, 0",     // xMin
        "1, 175, 1",     // xMinPlus
        "357, 175, 357", // xMaxMinus
        "358, 175, 358", // xMax
        "359, 175, 358"  // xMaxPlus
    })
    void testInitBombX(int inputX, int inputY, int expectedX) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getBomb().getX());
    }

    @ParameterizedTest
    @CsvSource({
        "179, -1, 0",    // yMinMinus
        "179, 0, 0",     // yMin
        "179, 1, 1",     // yMinPlus
        "179, 349, 349", // yMaxMinus
        "179, 350, 350", // yMax
        "179, 351, 350"  // yMaxPlus
    })
    void testInitBombY(int inputX, int inputY, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedY, alien.getBomb().getY());
    }

    @ParameterizedTest
    @CsvSource({
        "179, 175, 179, 175"  // nominal case
    })
    void testInitAlienNominal(int inputX, int inputY, int expectedX, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getX());
        assertEquals(expectedY, alien.getY());
        assertEquals(expectedX, alien.getBomb().getX());
        assertEquals(expectedY, alien.getBomb().getY());
        assertTrue(alien.getBomb().isDestroyed());
    }
}