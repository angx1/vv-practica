package space_invaders.sprites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShotTest_WhiteBox {

    private Shot shot;

    @BeforeEach
    public void setUp() {
        shot = new Shot(100, 50);
    }

    @Test
    public void testInitShot() {
        // Verifica que la imagen se haya cargado correctamente
        assertNotNull(shot.getImage(), "La imagen del disparo debe estar inicializada.");

        // Verifica la coordenada X ajustada con H_SPACE
        assertEquals(106, shot.getX(), "La coordenada X debería ser 106 (100 + 6).");

        // Verifica la coordenada Y ajustada con V_SPACE
        assertEquals(49, shot.getY(), "La coordenada Y debería ser 49 (50 - 1).");
    }
}
