package space_invaders.sprites;

import main.Commons;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    //TODO Método initAlien
    @Test
    void initAlien_xMinMinus() {
        Alien alien = new Alien(-1, 175);
        assertEquals(0, alien.getX());
    }

    @Test
    void initAlien_xMin() {
        Alien alien = new Alien(0, 175);
        assertEquals(0, alien.getX());
    }

    @Test
    void initAlien_xMinPlus() {
        Alien alien = new Alien(1, 175);
        assertEquals(1, alien.getX());
    }

    @Test
    void initAlien_xMaxMinus() {
        Alien alien = new Alien(357, 175);
        assertEquals(357, alien.getX());
    }

    @Test
    void initAlien_xMax() {
        Alien alien = new Alien(358, 175);
        assertEquals(Commons.BOARD_WIDTH, alien.getX());
    }

    @Test
    void initAlien_xMaxPlus() {
        Alien alien = new Alien(359, 175);
        assertEquals(Commons.BOARD_WIDTH, alien.getX());
    }

    @Test
    void initAlien_yMinMinus() {
        Alien alien = new Alien(175, -1);
        assertEquals(0, alien.getY());
    }

    @Test
    void initAlien_yMin() {
        Alien alien = new Alien(175, 0);
        assertEquals(0, alien.getY());
    }

    @Test
    void initAlien_yMinPlus() {
        Alien alien = new Alien(175, 1);
        assertEquals(1, alien.getY());
    }

    @Test
    void initAlien_yMaxMinus() {
        Alien alien = new Alien(175, 357);
        assertEquals(357, alien.getY());
    }

    @Test
    void initAlien_yMax() {
        Alien alien = new Alien(175, 358);
        assertEquals(Commons.BOARD_WIDTH, alien.getY());
    }

    @Test
    void initAlien_yMaxPlus() {
        Alien alien = new Alien(175, 359);
        assertEquals(Commons.BOARD_WIDTH, alien.getY());
    }

    @Test
    void initAlien_nominal() {
        Alien alien = new Alien(175, 175);
        assertEquals(175, alien.getX());
        assertEquals(175, alien.getY());
    }

    //TODO Método initBomb
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