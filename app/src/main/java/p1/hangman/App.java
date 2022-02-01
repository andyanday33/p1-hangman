package p1.hangman;

import java.util.Scanner;

public class App {

	static void doStuff(Scanner sc, CommandOpts opts, GameState g) {

		boolean correct;

		if (opts.wordsource == "") {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");
			System.out.println("  4. States");

			System.out.print("Pick a category:");

			g = new GameState(Words.randomWord(sc.nextInt()), opts.maxguesses, opts.maxhints);
		} else {
			g = new GameState(Words.randomWord(opts.wordsource), opts.maxguesses, opts.maxhints);
		}

		while (!g.won() && !g.lost()) {
			g.showWord(g.word);

			System.out.println("Guesses remaining: " + g.wrong);

			correct = g.guessLetter();

			if (correct) System.out.println("Good guess!");
			if (!correct) System.out.println("Wrong guess!");
		}

		if (g.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + g.g + " guesses");
		}
		else
			System.out.println("You lost!");
			System.out.println("The word was " + g.word);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameState g = null;
		CommandOpts opts;

		opts = new CommandOpts(args);

		doStuff(sc, opts, g);

	}
}
