package com.ridango;

import com.ridango.game.Cocktail;
import com.ridango.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Cocktail cocktail;

    @BeforeEach
    void setUp() {
        // Set up a mock cocktail for testing
        cocktail = new Cocktail();
        cocktail.setStrDrink("Mojito");
        cocktail.setStrCategory("Cocktail");
        cocktail.setStrGlass("Highball glass");
        cocktail.setStrInstructions("Mix ingredients.");


        game = new Game(cocktail); // Initialize a new game with this cocktail
    }

    @Test
    void testInitialState() {
        assertEquals("______", game.getRevealedName(), "Initial revealed name should be underscores.");
        assertEquals(5, game.getAttemptsLeft(), "Initial attempts left should be 5.");
    }


    @Test
    void testRevealRandomLetters() {
        game.revealRandomLetters();
        assertNotEquals("______", game.getRevealedName(), "Revealed name should contain some letters.");
    }

    @Test
    void testGetNextHint() {
        String hint = game.getNextHint();
        assertNotNull(hint, "Hint should not be null.");
        assertEquals(4, game.getAttemptsLeft(), "Attempts left should decrease by 1 after revealing a hint.");
    }
}
