package p1.hangman;

import java.util.ArrayList;
import java.util.Scanner;

// The game state
public class GameState {
	public String word; // letters
	public int g;
	public int wrong;
	public int h;
	
	ArrayList<Integer> got;
	ArrayList<Integer> not = new ArrayList<Integer>();
	
	public Scanner sc = new Scanner(System.in).useDelimiter("\n");
	
	public GameState(String target, int g, int h) {
		this.word = target;

		   got = new ArrayList<Integer>();
		
		for(int i = 0; i < target.length(); ++i) {
			not.add(i);
		}
		//System.out.println(missing);
		
		this.g = 0; // guesses made
		wrong = g; // guesses remaining
		this.h = h;
	}
	
	void showWord(String word) {
		for (int i = 0; i < word.length(); ++i) {
			if (got.contains(i)) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println("");
		// System.out.println(missing);
	}
	
	boolean guessLetter() {
		int i;
		char letter;
		
		System.out.print("Guess a letter or word (? for a hint): ");
		
		String str = sc.next();
		
		if (str.length() > 1) {
			if (str==word) {
				not.clear();
				return true;
			} else return false;
		}
		
		letter = str.charAt(0);
		
		if (letter == '?') {
			hint();
			return false;
		}
		
		for(i = 0; i < not.size(); ++i) { // Loop over the not got
			if (Character.toLowerCase(word.charAt(not.get(i))) == letter) {
				got.add(not.remove(i));
				g++;
				return true;
			}
		}

		g++; // One more guess
		wrong--;
		return false;
	}
	
	boolean won() {
		if (not.size() == 0) return true; else return false;
	}

	boolean lost() {
		if (not.size() > 0 && wrong == 0) return true; else return false;
	}

	void hint() {
		if (h == 0) {
			System.out.println("No more hints allowed");
		}
		
		System.out.print("Try: ");
		System.out.println(word.charAt((int)(Math.random()*word.length())));
	}
}
