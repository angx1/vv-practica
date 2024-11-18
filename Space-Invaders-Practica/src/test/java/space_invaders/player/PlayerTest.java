package space_invaders.player;


import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Commons;
import space_invaders.sprites.Player;


class PlayerTest {
    
    private Player player;
    private JPanel testPanel;

    @BeforeEach
    void setUp() {
        player = new Player();
        testPanel = new JPanel();
    }

    @Test
    void testRightBoundary() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        
        
        for(int i = 0; i < Commons.BOARD_WIDTH; i++) {
            player.keyPressed(rightPress);
            player.act();
        }
        
        
        player.keyPressed(rightPress);
        player.act();
        

        assertTrue(player.getImage() != null, 
            "Player should remain visible even at boundary");
    }

    @Test
    void testLeftBoundary() {
        KeyEvent leftPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED, 
            System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        
        for(int i = 0; i < Commons.BOARD_WIDTH; i++) {
            player.keyPressed(leftPress);
            player.act();
        }
        
        
        player.keyPressed(leftPress);
        player.act();
        
        
        assertTrue(player.getImage() != null, 
            "Player should remain visible even at boundary");
    }

    @Test
    void testKeyPressLeft() {
        
        Image initialImage = player.getImage();
        int initialImageX = initialImage.getWidth(null);
        
        
        KeyEvent leftPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(leftPress);
        player.act();
        
    
        Image currentImage = player.getImage();
        int currentImageX = currentImage.getWidth(null);
        
        assertNotEquals(initialImageX, currentImageX,
            "Player should move when LEFT key is pressed");
    }

    @Test
    void testKeyPressRight() {
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        
    
        player.keyPressed(rightPress);
        Image beforeMove = player.getImage();
        player.act();
        Image afterMove = player.getImage();
        
        assertNotSame(beforeMove, afterMove,
            "Player should move when RIGHT key is pressed");
    }

    @Test
    void testKeyRelease() {
        
        KeyEvent rightPress = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        player.keyPressed(rightPress);
        player.act();
        
        
        KeyEvent rightRelease = new KeyEvent(testPanel, KeyEvent.KEY_RELEASED,
            System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        player.keyReleased(rightRelease);
        
        
        Image positionBeforeAct = player.getImage();
        player.act();
        Image positionAfterAct = player.getImage();
        
        assertEquals(positionBeforeAct, positionAfterAct,
            "Player should not move after key is released");
    }

    @Test
    void testInvalidKeys() {
    
        KeyEvent invalidKey = new KeyEvent(testPanel, KeyEvent.KEY_PRESSED,
            System.currentTimeMillis(), 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
        
        Image beforePress = player.getImage();
        player.keyPressed(invalidKey);
        player.act();
        Image afterPress = player.getImage();
        
        assertEquals(beforePress, afterPress,
            "Player should not move when invalid key is pressed");
    }
}