package p1.hangman;

import java.util.ArrayList;
import java.util.Scanner;

// The game state

/**
 * This class contains methods to handle the game logic such as guessing a word, winning and losing.
 */
public class GameState {
	private String word; // letters

	private int guessesMade;
	private int remainingGuesses;
	private int noOfHints;
	
	ArrayList<Integer> guessedLetters;
	ArrayList<Integer> remainingLetters = new ArrayList<>();
	
	public Scanner sc = new Scanner(System.in).useDelimiter("\n");

	/**
	 * Constructor for GameState class.
	 * @param targetWord target word that is going to be guessed.
	 * @param maxGuesses maximum number of guesses for the game.
	 * @param maxHints maximum number of hints for the game.
	 */
	public GameState(String targetWord, int maxGuesses, int maxHints) {
		this.word = targetWord;

		   guessedLetters = new ArrayList<>();
		
		for(int i = 0; i < targetWord.length(); ++i) {
			remainingLetters.add(i);
		}
		//System.out.println(missing);
		
		this.guessesMade = 0; // guesses made, 0 by default
		remainingGuesses = maxGuesses; // guesses remaining, max number of guesses by default
		this.noOfHints = maxHints;
	}

	/**
	 * The method to print out current state of guessed word. If a character x is guessed correctly, prints out
	 * every x in the word in their indexes, if not, prints out symbol "-" in their indexes.
	 * @param word the target word that is being guessed.
	 */
	void showWord(String word) {
		for (int i = 0; i < word.length(); ++i) {
			if (guessedLetters.contains(i)) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
		// System.out.println(missing);
	}

	/**
	 * The method that is handling guessing a letter/word logic. Categorizes the input as word-letter-hint and treats
	 * differently in every situation.
	 * @return For word; true if the guessed word correct, for letter; true
	 * if the target word contains the guessed letter, false in every other situation.
	 */
	boolean guessLetter() {

		char letter;
		
		System.out.print("Guess a letter or word (? for a hint): ");
		
		String str = sc.next();
		
		if (str.length() > 1) {
			if (str.equals(word)) {
				remainingLetters.clear();
				return true;
			} else return false;
		}
		
		letter = str.charAt(0);
		
		if (letter == '?') {
			hint();
			return false;
		}
		
		for(int i = 0; i < remainingLetters.size(); ++i) { // Loop over the not got
			if (Character.toLowerCase(word.charAt(remainingLetters.get(i))) == letter) {
				guessedLetters.add(remainingLetters.remove(i));
				guessesMade++;
				return true;
			}
		}

		guessesMade++; // One more guess
		remainingGuesses--;
		return false;
	}

	/**
	 * Checks if the game is won or not.
	 * @return true if the number of unguessed letters is 0.
	 */
	boolean won() {
		return remainingLetters.size() == 0;
	}

	/**
	 * Checks if the game is lost or not.
	 * @return true if the number of unguessed letters is more than 0 and there are no guesses remaining.
	 */
	boolean lost() {
		return remainingLetters.size() > 0 && remainingGuesses == 0;
	}

	/**
	 * Prints out a hint if the number of hints is not 0.
	 */
	void hint() {
		if (noOfHints == 0) {
			System.out.println("No more hints allowed");
		}
		
		System.out.print("Try: ");
		System.out.println(word.charAt((int)(Math.random()*word.length())));
	}

	//Getters and setters -automatically generated-

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getGuessesMade() {
		return guessesMade;
	}

	public void setGuessesMade(int guessesMade) {
		this.guessesMade = guessesMade;
	}

	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	public void setRemainingGuesses(int remainingGuesses) {
		this.remainingGuesses = remainingGuesses;
	}

	public int getNoOfHints() {
		return noOfHints;
	}

	public void setNoOfHints(int noOfHints) {
		this.noOfHints = noOfHints;
	}
}
