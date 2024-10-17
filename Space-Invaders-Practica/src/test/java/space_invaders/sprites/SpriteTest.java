package space_invaders.sprites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpriteTest {

    @Test
    void testDie() {
        Sprite sprite = new Sprite();
        sprite.die();
        assertFalse(sprite.isVisible());
    }

    @Test
    void testIsVisible() {
        Sprite sprite = new Sprite();
        assertTrue(sprite.isVisible());
    }

    @Test
    void testIsDying() {
        Sprite sprite = new Sprite();
        assertFalse(sprite.isDying());
    }

}