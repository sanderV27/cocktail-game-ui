package com.ridango.game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {
    private Cocktail currentCocktail;
    private StringBuilder revealedName;
    private int attemptsLeft;
    private int score;
    private Set<Integer> revealedIndexes; // Track which letters have been revealed
    private int hintCounter; // Track the number of hints revealed

    public Game(Cocktail currentCocktail) {
        this.currentCocktail = currentCocktail;
        this.revealedName = new StringBuilder(currentCocktail.getStrDrink().length());

        // Initialize revealedName with underscores and reveal spaces/punctuation
        for (int i = 0; i < currentCocktail.getStrDrink().length(); i++) {
            char c = currentCocktail.getStrDrink().charAt(i);
            if (c == ' ' || c == '\'') {
                revealedName.append(c);  // Directly reveal spaces and punctuation
            } else {
                revealedName.append('_'); // Add underscores for other characters
            }
        }

        this.attemptsLeft = 5; // Set maximum attempts to 5
        this.score = 0;
        this.revealedIndexes = new HashSet<>();
        this.hintCounter = 0; // Initialize hint counter

        // Reveal initial hint(s)
        revealRandomLetters(currentCocktail.getStrDrink().length() > 12 ? 2 : 1);
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public int getScore() {
        return score;
    }

    public String getRevealedName() {
        return revealedName.toString();
    }

    public Cocktail getCurrentCocktail() {
        return currentCocktail;
    }

    public boolean makeGuess(String guess) {
        if (guess.equalsIgnoreCase(currentCocktail.getStrDrink())) {
            score += attemptsLeft; // Add remaining attempts to score on a correct guess
            return true;
        } else {
            attemptsLeft--; // Decrement attempts on an incorrect guess
            revealRandomLetters(); // Reveal letters after a wrong guess
            return false;
        }
    }

    public void revealRandomLetters() {
        // Call with default 1 or 2 letters to reveal based on cocktail length
        revealRandomLetters(currentCocktail.getStrDrink().length() > 12 ? 2 : 1);
    }

    public void revealRandomLetters(int lettersToReveal) {
        String cocktailName = currentCocktail.getStrDrink();
        Random random = new Random();

        int maxReveals = cocktailName.length() - 1; // Calculate the maximum reveals to leave at least one unrevealed letter for short names

        for (int i = 0; i < lettersToReveal; i++) {
            // Prevent revealing all letters if the name is 5 characters or fewer
            if (cocktailName.length() <= 5 && revealedIndexes.size() >= maxReveals) {
                break; // Stop revealing if one letter needs to be left out
            }

            int index;
            do {
                index = random.nextInt(cocktailName.length());
            } while (revealedName.charAt(index) != '_' || revealedIndexes.contains(index));

            // Reveal the letter
            revealedName.setCharAt(index, cocktailName.charAt(index));
            revealedIndexes.add(index); // Track revealed index
        }
    }

    public String getNextHint() {
        // Reduce the number of attempts for using a hint, but ensure it doesn't go negative
        if (attemptsLeft > 0) {
            attemptsLeft--;
        }

        // Get the next hint based on the current hintCounter
        String hint = "";
        switch (hintCounter) {
            case 0:
                hint = "Category: " + (currentCocktail.getStrCategory() != null ? currentCocktail.getStrCategory() : "N/A");
                break;
            case 1:
                hint = "Glass: " + (currentCocktail.getStrGlass() != null ? currentCocktail.getStrGlass() : "N/A");
                break;
            case 2:
                hint = "Ingredients: " + (!currentCocktail.getIngredients().isEmpty()
                        ? String.join(", ", currentCocktail.getIngredients())
                        : "N/A");
                break;
            case 3:
                hint = "Instructions: " + (currentCocktail.getStrInstructions() != null ? currentCocktail.getStrInstructions() : "N/A");
                break;
            case 4:
                hint = "Image: " + (currentCocktail.getStrDrinkThumb() != null ? currentCocktail.getStrDrinkThumb() : "N/A");
                break;
        }

        // Increment the hintCounter for the next hint
        hintCounter++;
        return hint;
    }

    public boolean isGameOver() {
        // The game is over if there are no attempts left
        return attemptsLeft <= 0;
    }
}
