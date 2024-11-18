package space_invaders.sprites;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Commons;

class PlayerTest extends Player {
    private Player player;
    private JPanel testPanel;

    @BeforeEach
    void setUp() {
        player = new Player();
        testPanel = new JPanel();
    }

    @ParameterizedTest
    @CsvSource({
            "2",      //1
            "328",   //2
            "0"         //4
    })
    void testAct(int x) {
        player.setX(x);
        player.act();
        if (x >= 2) {
            assertEquals(2, player.getX());
        } else if (x >= Commons.BOARD_WIDTH - 2 * Commons.PLAYER_WIDTH) {
            assertEquals(Commons.BOARD_WIDTH - 2 * Commons.PLAYER_WIDTH, player.getX());
        } else {
            assertEquals(player.getX() + dx, player.getX());
        }
    }
    

    @Test
    void testKeyPressedRight() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        
        assertEquals(2, player.dx);
    }

    @Test
    void testKeyPressedLeft() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        
        assertEquals(2, player.dx);
    }

    @Test
    void testKeyPressedOther() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        player.act();
        
        
        assertEquals(0, player.dx);
    }

    @Test
    void testKeyReleasedRight() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        player.act();
        
        KeyEvent rightRelease = new KeyEvent(testPanel, KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        player.keyReleased(rightRelease);
        
        assertEquals(0, player.dx);
    }

    @Test
    void testKeyReleasedLeft() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        player.act();
        
        KeyEvent rightRelease = new KeyEvent(testPanel, KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        player.keyReleased(rightRelease);
        
        assertEquals(0, player.dx);
    }

    @Test
    void testKeyReleasedOther() {
        int temp = player.dx;
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        player.act();
        player.act();
        
        KeyEvent rightRelease = new KeyEvent(testPanel, KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(), 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
        player.keyReleased(rightRelease);
        
        
        assertEquals(temp, player.dx);
    }
    


}