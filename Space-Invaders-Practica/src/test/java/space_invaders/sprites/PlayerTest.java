import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import space_invaders.sprites.Player;
import java.awt.event.KeyEvent;

class PlayerTest {
    
        @Test
        void testAct() {
            Player player = new Player();
            player.act();
            assertEquals(2, player.getX());
        }
    
        @Test
        void testKeyPressed() {
            Player player = new Player();
            player.keyPressed(KeyEvent.VK_LEFT);
            assertEquals(-1, player.getDx());
        }

        @Test
        void testKeyReleased() {
            Player player = new Player();
            player.keyReleased(KeyEvent.VK_LEFT);
            assertEquals(0, player.getDx());
        }

        @Test 
        void testInitPlayer() {
            Player player = new Player();
            assertEquals(270, player.getX());
            assertEquals(280, player.getY());
        }

}

