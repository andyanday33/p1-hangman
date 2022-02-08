package p1.hangman;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This is the class where the main method is located. main method calls the gameSequence() method to run the game,
 * every sequence/round in the game is handled inside gameSequence() until the game ends.
 */
public class App {

	/**
	 * The game is being run inside this method, every sequence/round/guess is being handled inside this.
	 * @param sc Scanner to take user input from the console.
	 * @param opts Contains metadata about the game, how many guesses each player is going to have,
	 *                source of words, etc.
	 */
	static void gameSequence(Scanner sc, CommandOpts opts) {

		GameState game;
		String correctness;

		if (opts.getWordsource().equals("")) {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");
			System.out.println("  4. States");

			System.out.print("Pick a category:");

			game = new GameState(Words.randomWord(sc.nextInt()), opts);
		} else {
			game = new GameState(Words.randomWord(opts.getWordsource()), opts);
		}

		while (!game.won() && !game.lost()) {
			game.showWord(game.getWord());

			System.out.println("Guesses remaining: " + game.getRemainingGuesses());

			System.out.print("Guess a letter or word (? for a hint): ");

			correctness = game.guessLetterOrWord();

			switch (correctness) {

				case "CORRECT":
					System.out.println("Good guess!");
					break;
				case "WRONG":
					System.out.println("Wrong guess!");
					break;
				case "CANNOT TAKE HINT":
					System.out.println("No more hints are allowed");
					break;
				case "HINT":
					System.out.println("Took a hint");
					System.out.println("Remaining hints: " + game.getNoOfHints());
					break;
				case "SAME GUESS TWICE":
					System.out.println("You have already guessed this letter");
					break;
				default:
					System.out.println("Invalid input");
					break;
			}

			System.out.println();
		}

		if (game.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + game.getGuessesMade() + " guesses");
		}
		else
			System.out.println("You lost!");
			System.out.println("The word was " + game.getWord());
	}

	/**
	 * Main method, creates a Scanner, CommandOpts object and gameSequence object.
	 * @param args console arguments.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
		CommandOpts opts;

		opts = new CommandOpts(args);

		gameSequence(sc, opts);

	}
}
