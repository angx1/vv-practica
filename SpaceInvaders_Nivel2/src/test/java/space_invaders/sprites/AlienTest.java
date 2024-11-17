package space_invaders.sprites;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @ParameterizedTest
    @CsvSource({
            "179, -1, 179, 0",      //1
            "179, 175, 179, 175",   //2
            "-1, -1, 0, 0",         //4
    })
    void testInitAlien(int inputX, int inputY, int expectedX, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getX());
        assertEquals(expectedY, alien.getY());
    }

    @ParameterizedTest
    @CsvSource({
            "359, 175, 358, 175",   //1
            "179, 351, 179, 350",   //2
            "179, 175, 179, 175",   //4
    })
    void testInitBomb(int inputX, int inputY, int expectedX, int expectedY) {
        Alien alien = new Alien(inputX, inputY);
        assertEquals(expectedX, alien.getBomb().getX());
        assertEquals(expectedY, alien.getBomb().getY());
    }

}