package space_invaders.sprites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpriteTest {

    @Test
    void isVisible_shouldBeTrueAfterInitialization() {
        Sprite sprite = new Sprite();
        assertTrue(sprite.isVisible());
    }

    @Test
    void die_shouldMakeSpriteInvisible() {
        Sprite sprite = new Sprite();
        sprite.die();
        assertFalse(sprite.isVisible());
    }

}