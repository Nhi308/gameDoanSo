package gamedoanso;


import cybersoft.javabackend.java18.gamedoanso.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameTest {
    private Game game;


    @BeforeAll
    public void setupTest () {
        game = new Game();
    }
    @Test
    public void shouldStartSuccessfully () {
        assertDoesNotThrow( () -> game.start());
    }
}
