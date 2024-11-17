package space_invaders.sprites;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test
    void initAlien1() {
        Alien alien = new Alien(179, -1);
        assertEquals(179, alien.getX());
        assertEquals(0, alien.getY());
    }

}