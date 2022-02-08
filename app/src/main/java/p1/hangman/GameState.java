package p1.hangman;

import java.util.ArrayList;

// The game state

/**
 * This class contains methods to handle the game logic such as guessing a word, winning and losing.
 */
public class GameState {
    private final String word; // letters

    private int guessesMade;
    private int remainingGuesses;
    private int noOfHints;

    private final ArrayList<Character> guessesSoFar;
    private final ArrayList<Integer> guessedLetters;
    private final ArrayList<Integer> remainingLetters;

    /**
     * Constructor for GameState class.
     *
     * @param targetWord target word that is going to be guessed.
     *
     * @param opts Options object for the game
     *
     */
    public GameState(String targetWord, CommandOpts opts) {
        this.word = targetWord;
        remainingLetters = new ArrayList<>();
        guessedLetters = new ArrayList<>();
        guessesSoFar = new ArrayList<>();

        for (int i = 0; i < targetWord.length(); ++i) {
            remainingLetters.add(i);
        }
        //System.out.println(missing);

        this.guessesMade = 0; // guesses made, 0 by default
        this.remainingGuesses = opts.getMaxguesses();
        this.noOfHints = opts.getMaxhints();
    }

    /**
     * The method to print out current state of guessed word.
     * If a character x is guessed correctly, prints out
     * every x in the word in their indexes, if not, prints out symbol "-" in their indexes.
     *
     * @param word the target word that is being guessed.
     *
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
     * The method that is handling guessing a letter/word logic. Categorizes the
     * input as word-letter-hint and treats differently in every situation.
     *
     * @return String 'CORRECT' if the guess is correct, 'WRONG' if the guess is wrong,
     *     'INVALID INPUT' if the input is non-alphabetic, nor whitespace,
     *     'HINT' if guess is '?' and player can take a hint, 'CANNOT TAKE HINT'
     *     if guess is '?' and player has no hints remaining, and 'SAME GUESS TWICE'
     *     if the player has already guessed the letter he entered.
     */
    String guessLetterOrWord(String letterOrWord) {

        char letter;

        if (letterOrWord.length() == 0) {
            return "INVALID INPUT";
        }

        if (letterOrWord.length() > 1) {
            guessesMade++;
            if (letterOrWord.equalsIgnoreCase(word)) {
                remainingLetters.clear();
                return "CORRECT";
            } else {
                return "WRONG";
            }
        }

        letter = letterOrWord.charAt(0);

        if (letter == '?') {
            if (hint()) {
                return "HINT";
            } else {
                return "CANNOT TAKE HINT";
            }
        }

        if (!isValidInput(letter)) {
            return "INVALID INPUT";
        }

        if (guessesSoFar.contains(letter)) {
            return "SAME GUESS TWICE";
        }

        guessesSoFar.add(letter);
        guessesMade++;

        if (isLetterInWord(letter)) {
            return "CORRECT";
        }

        remainingGuesses--;

        return "WRONG";
    }

    /**
     * Checks if the game is won or not.
     *
     * @return true if the number of non-guessed letters is 0.
     */
    boolean won() {
        return remainingLetters.size() == 0;
    }

    /**
     * Checks if the game is lost or not.
     *
     * @return true if the number of non-guessed letters is more
     *     than 0 and there are no guesses remaining.
     *
     */
    boolean lost() {
        return remainingLetters.size() > 0 && remainingGuesses == 0;
    }

    /**
     * Prints out a hint if the number of hints is not 0.
     */
    boolean hint() {
        if (noOfHints == 0) {
            return false;
        } else {
            noOfHints--;
            System.out.print("Try: ");
            int randomIndex = (int) (Math.random() * (remainingLetters.size() - 1));
            System.out.println(word.charAt(remainingLetters.get(randomIndex)));
            return true;
        }

    }

    //Getters and setters -automatically generated-

    public String getWord() {
        return word;
    }

    public int getGuessesMade() {
        return guessesMade;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public int getNoOfHints() {
        return noOfHints;
    }

    /**
     * This method checks if the given letter appears inside the word at least once.
     * @param letter letter that is going to be checked.
     * @return true if the letter appears inside the word at least once.
     */
    public boolean isLetterInWord(char letter) {

        boolean found = false;

        for (int i = 0; i < remainingLetters.size(); ++i) {

            char charFromWord = word.charAt(remainingLetters.get(i));

            if (Character.toLowerCase(charFromWord)
                    == Character.toLowerCase(letter)) {
                guessedLetters.add(remainingLetters.remove(i));
                found = true; // Since we are not looking for
                //only one letter x but all the letters x that
                //appears inside the word, we cannot return true
                //inside here, we will find and remove every letter x,
                //and then return the value of 'found'.
            }
        }
        return found;
    }

    /**
     * This method checks if the input letter given by the player is valid.
     *
     * @param letter the input letter given by the player.
     *
     * @return true if the letter is alphabetic or a whitespace.
     *
     */
    public boolean isValidInput(char letter) {
        return Character.isAlphabetic(letter) || Character.isWhitespace(letter);
    }

}
