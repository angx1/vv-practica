package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testGameInit() {
        Board board = new Board();
        board.initBoard();
        assertEquals(Commons.NUMBER_OF_ALIENS_TO_DESTROY, board.getAliens().size());
        int n = 0;
        for (Alien alien : board.getAliens()) {
            int x = Commons.INITIAL_X + 18 * n;
            int y = Commons.INITIAL_Y + 18 * n;
            assertEquals(x, alien.getX());
            assertEquals(y, alien.getY());
            n++,
        }
        assertNotNull(board.getPlayer());
        assertNotNull(board.getShot());
    }

    @Test
    void testUpdate(){
        if ( deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY){
            assertFalse(inGame);
        }
    }


    @Test testUpdate_Aliens(){
        Board board = new Board();
        board.initBoard();
        board.updateAliens();
        for (Alien alien : board.getAliens()) {
            int x = alien.getX();
            int y = alien.getY();
            if (x == Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && alien.getDirection() == 1) {
                assertEquals(Commons.GO_DOWN, alien.getDirection());
            }
            if (x == Commons.BORDER_LEFT && alien.getDirection() == -1) {
                assertEquals(Commons.GO_DOWN, alien.getDirection());
            }
            if (y == Commons.BOARD_HEIGHT - Commons.GROUND - Commons.ALIEN_HEIGHT) {
                assertFalse(board.getInGame());
            }
        }
    }

}