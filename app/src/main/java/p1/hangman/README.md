This game is an implementation of the classic hangman game, if you don't know the rules
you can find it here: https://en.wikipedia.org/wiki/Hangman_(game)

To run the game with predefined categories and words just launch it with gradle [run] command.

To run the game with a custom wordsource, launch it with gradle [run --args"--source ABSOLUTE_SOURCE_TO_TEXTFILE""] command,
where ABSOLUTE_SOURCE_TO_TEXTFILE stands for a absolute directory of a .txt file which has words that are separated
by new lines in it.

To change number of hints and number of guesses in a launch, add --guesses = NO_OF_GUESSES and --hints = NO_OF_HINTS
arguments to the gradle run command inside --args. (F.e. run --args"--guesses 4")

To run the tests, use gradle [check] command.