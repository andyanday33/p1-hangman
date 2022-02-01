package p1.hangman;

public class CommandOpts {

	public int maxguesses;
	public int maxhints;
	
	String wordsource;
	
	CommandOpts(String[] args) {
		maxguesses = 10;
		maxhints = 2;
		
		wordsource = "";
		
		for(int i = 0; i < args.length; ++i) {
			if (args[i].equals("--guesses")) {
				maxguesses = Integer.parseInt(args[i+1]);
				i++;
			}
			else if (args[i].equals("--hints")) {
				maxhints = Integer.parseInt(args[i+1]);
				i++;
			}
			else wordsource = args[i];
		}
	}
}
