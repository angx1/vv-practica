package space_invaders.player;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Commons;
import space_invaders.sprites.Player;


public class PlayerTest {
    
    private Player player;
    
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void testTeclaIzquierdaIniciaMovimiento() {

        KeyEvent keyEvent = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_LEFT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        int posicionInicial = player.getX();
        player.keyPressed(keyEvent);
        player.act();
        
        assertNotEquals(posicionInicial, player.getX());
    }

    @Test
    void testTeclaDerechaIniciaMovimiento() {
        
        KeyEvent keyEvent = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_RIGHT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        int posicionInicial = player.getX();
        player.keyPressed(keyEvent);
        player.act();
        
        
        assertNotEquals(posicionInicial, player.getX());
    }

    @Test
    void testOtrasTeclasNoAfectan() {

        KeyEvent keyEvent = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_UP, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        int posicionInicial = player.getX();
        player.keyPressed(keyEvent);
        player.act();
        

        assertEquals(posicionInicial, player.getX());
    }


    @Test
    void testDetenerMovimientoAlSoltarTeclas() {

        KeyEvent keyLeftPress = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_LEFT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        KeyEvent keyLeftRelease = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_RELEASED, 
            0, 
            0, 
            KeyEvent.VK_LEFT, 
            KeyEvent.CHAR_UNDEFINED
        );
        

        player.keyPressed(keyLeftPress);
        player.act();
        int posicionTrasMovimiento = player.getX();
        
        player.keyReleased(keyLeftRelease);
        player.act();
        int posicionFinal = player.getX();
        
        assertEquals(posicionTrasMovimiento, posicionFinal);
    }


    @Test
    void testLimiteBordeIzquierdo() {

        KeyEvent keyLeft = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_LEFT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        for(int i = 0; i < 100; i++) {
            player.keyPressed(keyLeft);
            player.act();
        }
        
        assertTrue(player.getX() >= 2);
    }

    @Test
    void testLimiteBordeDerecho() {
        KeyEvent keyRight = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_RIGHT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        for(int i = 0; i < 100; i++) {
            player.keyPressed(keyRight);
            player.act();
        }
        
        assertTrue(player.getX() <= Commons.BOARD_WIDTH);
    }

    @Test
    void testCambiosRapidosDireccion() {
        KeyEvent keyLeft = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_LEFT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        KeyEvent keyRight = new KeyEvent(
            new java.awt.Component(){}, 
            KeyEvent.KEY_PRESSED, 
            0, 
            0, 
            KeyEvent.VK_RIGHT, 
            KeyEvent.CHAR_UNDEFINED
        );
        
        int posicionInicial = player.getX();
        
        for(int i = 0; i < 10; i++) {
            player.keyPressed(keyLeft);
            player.act();
            player.keyPressed(keyRight);
            player.act();
        }
        
        assertNotEquals(posicionInicial, player.getX());
    }
}

