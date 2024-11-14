package space_invaders.sprites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpriteTest {

    //Se ignoran las pruebas de los getters y setters ya que son generados automaticamente

    @Test
    void testDie() {
        Sprite sprite = new Sprite();
        sprite.die();
        assertFalse(sprite.isVisible());
    }

    //Se prueban isVisible y isDying ya que como no pone get se considera que se han realizado a mano

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