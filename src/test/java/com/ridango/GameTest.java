package com.ridango;

import com.ridango.game.Cocktail;
import com.ridango.game.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testMaxIncorrectGuesses() {
        Cocktail cocktail = new Cocktail();
        cocktail.setStrDrink("Mojito");
        Game game = new Game(cocktail);

        // Make 5 incorrect guesses
        for (int i = 0; i < 5; i++) {
            game.makeGuess("WrongGuess");
        }

        // Check that the game is over after 5 incorrect guesses
        assertTrue(game.isGameOver(), "The game should be over after 5 incorrect guesses.");
    }

    @Test
    void testMaxSkips() {
        Cocktail cocktail = new Cocktail();
        cocktail.setStrDrink("Mojito");
        Game game = new Game(cocktail);

        // Skip 5 times
        for (int i = 0; i < 5; i++) {
            game.getNextHint();
        }

        // Check that the game is over after 5 skips
        assertTrue(game.isGameOver(), "The game should be over after 5 skips.");
    }

    @Test
    void testCorrectGuessScoring() {
        Cocktail cocktail = new Cocktail();
        cocktail.setStrDrink("Mojito");
        Game game = new Game(cocktail);

        // Correct guess
        boolean result = game.makeGuess("Mojito");

        // Check the score is equal to the number of attempts left
        assertTrue(result, "The guess should be correct.");
        assertEquals(5, game.getScore(), "The score should be equal to the number of attempts left (5).");
    }
}
