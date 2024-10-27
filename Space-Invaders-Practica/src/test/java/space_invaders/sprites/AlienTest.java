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
        Alien alien = new Alien(179, -1);
        assertEquals(0, alien.getY());
    }

    @Test
    void initAlien_yMin() {
        Alien alien = new Alien(179, 0);
        assertEquals(0, alien.getY());
    }

    @Test
    void initAlien_yMinPlus() {
        Alien alien = new Alien(179, 1);
        assertEquals(1, alien.getY());
    }

    @Test
    void initAlien_yMaxMinus() {
        Alien alien = new Alien(179, 349);
        assertEquals(349, alien.getY());
    }

    @Test
    void initAlien_yMax() {
        Alien alien = new Alien(179, 350);
        assertEquals(Commons.BOARD_HEIGHT, alien.getY());
    }

    @Test
    void initAlien_yMaxPlus() {
        Alien alien = new Alien(179, 351);
        assertEquals(Commons.BOARD_HEIGHT, alien.getY());
    }

    @Test
    void initAlien_nominal() {
        Alien alien = new Alien(179, 175);
        assertEquals(179, alien.getX());
        assertEquals(175, alien.getY());
    }

    //TODO Método initBomb
    @Test
    void initBomb_xMinMinus() {
        Alien alien = new Alien(-1, 175);
        assertEquals(0, alien.getBomb().getX());
    }

    @Test
    void initBomb_xMin() {
        Alien alien = new Alien(0, 175);
        assertEquals(0, alien.getBomb().getX());
    }

    @Test
    void initBomb_xMinPlus() {
        Alien alien = new Alien(1, 175);
        assertEquals(1, alien.getBomb().getX());
    }

    @Test
    void initBomb_xMaxMinus() {
        Alien alien = new Alien(357, 175);
        assertEquals(357, alien.getBomb().getX());
    }

    @Test
    void initBomb_xMax() {
        Alien alien = new Alien(358, 175);
        assertEquals(Commons.BOARD_WIDTH, alien.getBomb().getX());
    }

    @Test
    void initBomb_xMaxPlus() {
        Alien alien = new Alien(359, 175);
        assertEquals(Commons.BOARD_WIDTH, alien.getBomb().getX());
        assertEquals(Commons.BOARD_HEIGHT, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMinMinus() {
        Alien alien = new Alien(179, -1);
        assertEquals(0, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMin() {
        Alien alien = new Alien(179, 0);
        assertEquals(0, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMinPlus() {
        Alien alien = new Alien(179, 1);
        assertEquals(1, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMaxMinus() {
        Alien alien = new Alien(179, 349);
        assertEquals(349, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMax() {
        Alien alien = new Alien(179, 350);
        assertEquals(Commons.BOARD_HEIGHT, alien.getBomb().getY());
    }

    @Test
    void initBomb_yMaxPlus() {
        Alien alien = new Alien(179, 351);
        assertEquals(Commons.BOARD_HEIGHT, alien.getBomb().getY());
        assertEquals(Commons.BOARD_WIDTH, alien.getBomb().getX());
    }

    @Test
    void initBomb_nominal() {
        Alien alien = new Alien(179, 175);
        assertEquals(179, alien.getBomb().getX());
        assertEquals(175, alien.getBomb().getY());
    }

    @Test
    void testIsBombDestroyed() {
        Alien alien = new Alien(179, 175);
        assertTrue(alien.getBomb().isDestroyed());
    }
}