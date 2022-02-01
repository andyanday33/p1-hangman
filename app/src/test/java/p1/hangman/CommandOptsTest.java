package p1.hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptsTest {

	@Test
	public void optionsTest() {
		String[] args = { "--guesses", "2", "--hints", "4", "words.txt" };
		CommandOpts opts = new CommandOpts(args);
		assertEquals(opts.maxguesses, 2);
		assertEquals(opts.maxhints, 4);
		assertEquals(opts.wordsource, "words.txt");
	}

}
