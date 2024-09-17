package com.ridango.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class CocktailGameApplication implements CommandLineRunner {

	@Autowired
	private CocktailService cocktailService;

	@Autowired
	private HighScoreRepository highScoreRepository;

	private Set<String> usedCocktails = new HashSet<>(); // Track used cocktail names

	public static void main(String[] args) {
		SpringApplication.run(CocktailGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean playAgain = true;

		while (playAgain) {
			int totalScore = 0; // Total score for the current game session
			boolean newCocktail = true;

			// Fetch and display the current high score
			HighScore topScore = highScoreRepository.findTopByOrderByScoreDesc();
			System.out.println("Current high score: " + (topScore != null ? topScore.getScore() : 0));

			// Start a new game session
			while (newCocktail) {
				Cocktail cocktail;
				do {
					cocktail = cocktailService.getRandomCocktail();
				} while (usedCocktails.contains(cocktail.getStrDrink())); // Ensure no duplicate cocktails

				usedCocktails.add(cocktail.getStrDrink()); // Add to the used set

				Game game = new Game(cocktail); // Create the game with initial hints revealed
				int attemptsLeft = 5; // Control attempts from the main loop
				System.out.println("New game started! Guess the cocktail: " + game.getRevealedName());
				System.out.println("Additional info: " + game.getNextHint());

				while (attemptsLeft > 0) {
					System.out.println("Enter your guess (or type 'skip' to reveal more hints): ");
					String guess = scanner.nextLine();

					if (guess.equalsIgnoreCase("skip")) {
						game.revealRandomLetters(); // Reveal more letters
						System.out.println("Cocktail: " + game.getRevealedName());
						System.out.println("Additional info: " + game.getNextHint()); // Show next hint
						attemptsLeft--; // Decrease attempts when skipping
						System.out.println("Attempts left: " + attemptsLeft);
					} else if (game.makeGuess(guess)) {
						System.out.println("Correct! The cocktail is " + game.getCurrentCocktail().getStrDrink());
						System.out.println("You got " + attemptsLeft+ " points for this round");
						totalScore += attemptsLeft; // Increase score by attempts left
						break; // Exit the loop as the guess is correct
					} else {
						System.out.println("Wrong guess. Try again!");
						attemptsLeft--; // Decrease attempts for incorrect guess
						System.out.println("Attempts left: " + attemptsLeft);
						System.out.println("Cocktail: " + game.getRevealedName());
					}

					// Check if the game should end
					if (attemptsLeft == 0) {
						System.out.println("Game over! The correct answer was: " + game.getCurrentCocktail().getStrDrink());
						newCocktail = false; // End the game session
					}
				}

				// If the player didn't guess correctly, display the score and high score
				if (!newCocktail) {
					System.out.println("Your total score: " + totalScore);
					if (totalScore > (topScore != null ? topScore.getScore() : 0)) {
						HighScore newHighScore = new HighScore();
						newHighScore.setScore(totalScore);
						highScoreRepository.save(newHighScore);
						System.out.println("New high score: " + totalScore + "!");
					} else {
						System.out.println("High score: " + (topScore != null ? topScore.getScore() : 0));
					}
				}
			}

			// Ask if the player wants to start a new game session
			System.out.println("Do you want to start a new game session? (yes/no): ");
			String response = scanner.nextLine();
			playAgain = response.equalsIgnoreCase("yes");

			if (!playAgain) {
				System.out.println("Thanks for playing!");
			} else {
				usedCocktails.clear(); // Clear the used cocktails set for a new game session
			}
		}
	}
}
