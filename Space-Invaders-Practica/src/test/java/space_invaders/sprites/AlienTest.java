package space_invaders.sprites;

import main.Commons;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test
    void initAlien_shouldBeValueXLowerCorrectInitialization() {
        Alien alien = new Alien(-20, 10);
        assertTrue(alien.getX() >= 0);
    }

    @Test
    void initAlien_shouldBeValueXHighCorrectInitialization() {
        Alien alien = new Alien(400, 100);
        assertEquals(alien.getX(), Commons.BOARD_WIDTH);
    }

    @Test
    void initAlien_shouldBeValueYLowerCorrectInitialization() {
        Alien alien = new Alien(10, -20);
        assertTrue(alien.getY() >= 0);
    }

    @Test
    void initAlien_shouldBeValueYHighCorrectInitialization() {
        Alien alien = new Alien(100, 400);
        assertEquals(alien.getY(), Commons.BOARD_HEIGHT);
    }
}