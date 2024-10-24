package space_invaders.sprites;

import main.Commons;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BombTest {

    @Test
    void initBomb_shouldValueXBombEqualsToALienCorrectInitialization() {
        Alien alien = new Alien(10, 10);
        assertEquals(alien.getX(), alien.getBomb().getX());
    }

    @Test
    void initBomb_shouldValueYBombEqualsToALienCorrectInitialization() {
        Alien alien = new Alien(10, 10);
        assertEquals(alien.getY(), alien.getBomb().getY());
    }

    @Test
    void initBomb_shouldBoundsValueXBombEqualsToALienCorrectInitialization() {
        Alien alien = new Alien(400, 10);
        assertEquals(Commons.BOARD_WIDTH, alien.getBomb().getX());
    }

    @Test
    void initBomb_shouldBoundsValueYBombEqualsToALienCorrectInitialization() {
        Alien alien = new Alien(10, 400);
        assertEquals(Commons.BOARD_HEIGHT, alien.getBomb().getY());
    }
}