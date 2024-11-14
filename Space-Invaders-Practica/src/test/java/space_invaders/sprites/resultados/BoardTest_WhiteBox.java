package space_invaders.sprites.resultados;

import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.Board;
import space_invaders.sprites.*;

public class BoardTest_WhiteBox {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGameInit_AllIterations() {
        // Este caso cubre el camino completo en el que se generan todos los aliens
        assertEquals(24, board.getAliens().size(), "Debería haber exactamente 24 aliens.");

        // Verificar que cada alien tiene las coordenadas correctas
        int expectedX = Commons.ALIEN_INIT_X;
        int expectedY = Commons.ALIEN_INIT_Y;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                Alien alien = board.getAliens().get(i * 6 + j);
                assertEquals(expectedX + 18 * j, alien.getX(), "Coordenada X incorrecta en alien " + (i * 6 + j));
                assertEquals(expectedY + 18 * i, alien.getY(), "Coordenada Y incorrecta en alien " + (i * 6 + j));
            }
        }

        // Verificar que el jugador y el disparo están inicializados
        assertNotNull(board.getPlayer(), "El jugador debería estar inicializado.");
        assertNotNull(board.getShot(), "El disparo debería estar inicializado.");
    }
}
