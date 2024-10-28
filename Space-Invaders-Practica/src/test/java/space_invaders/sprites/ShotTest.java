package space_invaders.sprites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Long.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.*;

public class ShotTest {

    @Test
    public void testShotMovesUpward() {
        // Crear un disparo en una posición inicial
        Shot shot = new Shot(100, 200); // Posición inicial del disparo
        shot.setVisible(true); // El disparo es visible

        // Simular el movimiento del disparo hacia arriba
        int originalY = shot.getY();
        shot.setY(originalY - 10); // Mover hacia arriba

        // Comprobar que la posición Y ha cambiado
        assertTrue(shot.getY() < originalY, "El disparo debería moverse hacia arriba.");
    }

    @Test
    public void testShotDoesNotMoveDownward() {
        // Crear un disparo en una posición inicial
        Shot shot = new Shot(100, 200); // Posición inicial del disparo
        shot.setVisible(true); // El disparo es visible

        // Simular un intento de mover el disparo hacia abajo
        int originalY = shot.getY();
        shot.setY(originalY + 10); // Mover hacia abajo (esto no debería ser permitido)

        // Comprobar que la posición Y no ha cambiado
        assertEquals(originalY, shot.getY(), "El disparo no debería moverse hacia abajo.");
    }

    @Test
    public void testOnlyOneShotAtATime() {
        int inputX = 100;
        int inputY = 200;

        // Crear el primer disparo
        Shot firstShot = new Shot(inputX, inputY);
        firstShot.setVisible(true); // Aseguramos que el primer disparo es visible

        // Intentamos crear un segundo disparo antes de que el primero desaparezca
        Shot secondShot = new Shot(inputX, inputY);

        // Verificamos que el primer disparo aún es el único disparo visible
        assertSame(firstShot, secondShot, "Debería ser el mismo disparo, solo uno debe estar activo.");
    }

    @Test
    public void testShotDisappearsAtTop() {
        int inputX = 100;
        int inputY = -10; // Posición para simular que ha salido de la pantalla

        // Crear el disparo
        Shot shot = new Shot(inputX, inputY);
        shot.setVisible(true); // El disparo es visible

        // Simulamos que el disparo ha salido de la pantalla
        shot.setY(inputY);

        // Verificamos que el disparo ya no es visible
        assertFalse(shot.isVisible(), "El disparo debería desaparecer al moverse fuera de los límites superiores.");
    }
    @Test
    public void testShotHitsAlien() {
        int shotX = 100;
        int shotY = 200;

        // Crear el disparo y el alien en la misma posición
        Shot shot = new Shot(shotX, shotY);
        shot.setVisible(true);

        Alien alien = new Alien(shotX, shotY);
        alien.setVisible(true);

        // Simular la colisión
        if (shot.getX() == alien.getX() && shot.getY() == alien.getY()) {
            shot.setVisible(false); // El disparo desaparece
            alien.die(); // El alien se "muere"
        }

        // Verificamos que el disparo ya no es visible y que el alien está "muerto"
        assertFalse(shot.isVisible(), "El disparo debería desaparecer al alcanzar un alien.");
    }
    @Test
    public void testShotHitsBomb() {
        int shotX = 150;
        int shotY = 250;

        // Crear el disparo en la posición deseada
        Shot shot = new Shot(shotX, shotY);
        shot.setVisible(true);

        // Crear un alien en una posición arbitraria
        Alien alien = new Alien(shotX, shotY); // Asumiendo que la posición es válida para el alien
        Alien.Bomb bomb = alien.getBomb(); // Obtenemos la bomba asociada al alien

        // Simular la colisión
        if (shot.getX() == bomb.getX() && shot.getY() == bomb.getY()) {
            bomb.setDestroyed(true); // La bomba se destruye
            shot.setVisible(false); // El disparo desaparece
        }

        // Verificamos que el disparo ya no es visible y que la bomba está destruida
        assertFalse(shot.isVisible(), "El disparo debería desaparecer al alcanzar una bomba.");
        assertTrue(bomb.isDestroyed(), "La bomba debería estar destruida al ser alcanzada por el disparo.");
    }


    //Robust Boundary Value Test

    @Test
    public void testShotInitializationWithInvalidXAndY() {
        Shot shot = new Shot(-1, 175);
        assertEquals(0, shot.getX(), "(C1)La coordenada X debería ser 0 para un valor negativo.");
        assertEquals(175, shot.getY(), "(C1) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithInvalidXAndValidY() {
        Shot shot = new Shot(0, 175);
        assertEquals(0, shot.getX(), "(C2)La coordenada X debería ser 0.");
        assertEquals(175, shot.getY(), "(C2) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithInvalidXAndYAboveMin() {
        Shot shot = new Shot(1, 175);
        assertEquals(1, shot.getX(), "(C3) La coordenada X debería ser 1.");
        assertEquals(175, shot.getY(), "(C3) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithValidXAndInvalidY() {
        Shot shot = new Shot(179, 175);
        assertEquals(179, shot.getX(), "(C4) La coordenada X debería ser 179.");
        assertEquals(175, shot.getY(), "(C4) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithZeroXAndY() {
        Shot shot = new Shot(357, 175);
        assertEquals(357, shot.getX(), "(C5) La coordenada X debería ser 357.");
        assertEquals(175, shot.getY(), "(C5) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithZeroXAndYAboveMin() {
        Shot shot = new Shot(358, 175);
        assertEquals(358, shot.getX(), "(C6) La coordenada X debería ser 358.");
        assertEquals(175, shot.getY(), "(C6) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithXAboveMinAndInvalidY() {
        Shot shot = new Shot(359, 175);
        assertEquals(358, shot.getX(), "(C7) La coordenada X debería ser 358.");
        assertEquals(175, shot.getY(), "(C7) La coordenada Y debería ser 175.");
    }

    @Test
    public void testShotInitializationWithXAboveMinAndZeroY() {
        Shot shot = new Shot(175, -1);
        assertEquals(175, shot.getX(), "(C8) La coordenada X debería ser 175.");
        assertEquals(0, shot.getY(), "(C8) La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithMaxXAndMaxY() {
        Shot shot = new Shot(175, 0);
        assertEquals(175, shot.getX(), "(C9) La coordenada X debería ser 175.");
        assertEquals(0, shot.getY(), "(C9) La coordenada Y debería ser 0.");
    }

    @Test
    public void testShotInitializationWithXAboveMaxAndYAboveMax() {
        Shot shot = new Shot(175, 1);
        assertEquals(175, shot.getX(), "(C10) La coordenada X debería ser el valor 175.");
        assertEquals(1, shot.getY(), "(C10) La coordenada Y debería ser el valor 1.");
    }

    @Test
    public void testShotInitializationWithXAboveMaxAndMaxY() {
        Shot shot = new Shot(175, 349);
        assertEquals(175, shot.getX(), "(C11) La coordenada X debería ser el valor 175.");
        assertEquals(349, shot.getY(), "(C11) La coordenada Y debería ser 349.");
    }

    @Test
    public void testShotInitializationWithMaxXAndYAboveMax() {
        Shot shot = new Shot(175, 350);
        assertEquals(175, shot.getX(), "(C12) La coordenada X debería ser 175.");
        assertEquals(350, shot.getY(), "(C12)La coordenada Y debería ser el valor 350.");
    }

    @Test
    public void testShotInitializationWithMaxXAndY() {
        Shot shot = new Shot(175, 351);
        assertEquals(175, shot.getX(), "(C13) La coordenada X debería ser 175.");
        assertEquals(350, shot.getY(), "(C13) La coordenada Y debería ser el valor max 350.");
    }

}

