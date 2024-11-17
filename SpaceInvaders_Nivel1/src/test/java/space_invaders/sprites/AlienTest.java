package space_invaders.sprites;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    //initAlien
    @ParameterizedTest
    @CsvSource({
        "-1, 175, 0, 175",      //1
        "0, 175, 0, 175",       //2
        "1, 175, 1, 175",       //3
        "357, 175, 357, 175",   //4
        "358, 175, 358, 175",   //5
        "359, 175, 358, 175",   //6

        "179, -1, 179, 0",      //7
        "179, 0, 179, 0",       //8
        "179, 1, 179, 1",       //9
        "179, 349, 179, 349",   //10
        "179, 350, 179, 350",   //11
        "179, 351, 179, 350"    //12
    })
    void testInitAlien(int inputX, int inputY, int expectedX, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getX());
        assertEquals(expectedY, alien.getY());
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 175, 0, 175",      //1
        "0, 175, 0, 175",       //2
        "1, 175, 1, 175",       //3
        "357, 175, 357, 175",   //4
        "358, 175, 358, 175",   //5
        "359, 175, 358, 175",   //6

        "179, -1, 179, 0",      //7
        "179, 0, 179, 0",       //8
        "179, 1, 179, 1",       //9
        "179, 349, 179, 349",   //10
        "179, 350, 179, 350",   //11
        "179, 351, 179, 350"    //12
    })
    void testInitBomb(int inputX, int inputY, int expectedX, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getBomb().getX());
        assertEquals(expectedY, alien.getBomb().getY());
    }

    @ParameterizedTest
    @CsvSource({
        "179, 175, 179, 175"  // nominal case (initAlien y initBomb CP 13)
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