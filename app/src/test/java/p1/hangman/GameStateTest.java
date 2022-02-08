package p1.hangman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameStateTest {

    GameState game;

    @Before
    public void setup() {
        String[] args = {"--guesses", "9", "--hints", "3"};
        CommandOpts opts = new CommandOpts(args);
        game = new GameState("Alabama", opts);
    }

    @Test
    public void wrongGuessTest() {

        String guess = "c";

        game.guessLetterOrWord(guess);
        assertEquals(8, game.getRemainingGuesses());
    }

    @Test
    public void correctGuessTest() {
        String guess = "a";

        game.guessLetterOrWord(guess);
        assertEquals(9, game.getRemainingGuesses());
    }

    @Test
    public void hintTest() {
        String guess = "?";
        game.guessLetterOrWord(guess);
        assertEquals(2, game.getNoOfHints());
    }

    @Test
    public void invalidInputTest() {
        String guess = "-";
        String gameResponse = game.guessLetterOrWord(guess);
        assertEquals("INVALID INPUT", gameResponse);
    }

    @Test
    public void emptyInputTest() {
        String guess = "";
        String gameResponse = game.guessLetterOrWord(guess);
        assertEquals("INVALID INPUT", gameResponse);
    }

    @Test
    public void fullGameWonTest() {
        assertEquals("CORRECT", game.guessLetterOrWord("l"));
        assertEquals("WRONG", game.guessLetterOrWord("Z"));
        assertEquals("WRONG", game.guessLetterOrWord("C"));
        assertEquals(7, game.getRemainingGuesses());
        game.guessLetterOrWord("?");
        assertEquals("CORRECT", game.guessLetterOrWord("B"));
        assertEquals("CORRECT", game.guessLetterOrWord("ALABAMA"));
        assertTrue(game.won());
        assertEquals(5, game.getGuessesMade());
    }

    @Test
    public void fullGameLostTest() {
        game.guessLetterOrWord("c");
        game.guessLetterOrWord("z");
        game.guessLetterOrWord("t");
        game.guessLetterOrWord("x");
        game.guessLetterOrWord("y");
        game.guessLetterOrWord("k");
        game.guessLetterOrWord("p");
        game.guessLetterOrWord("q");
        game.guessLetterOrWord("w");
        assertTrue(game.lost());
    }

    @Test
    public void outOfHintsTest(){
        game.guessLetterOrWord("?");
        game.guessLetterOrWord("?");
        game.guessLetterOrWord("?");
        assertEquals("CANNOT TAKE HINT", game.guessLetterOrWord("?"));
    }

}
