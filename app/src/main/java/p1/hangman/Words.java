package p1.hangman;

import java.io.*;
import java.util.ArrayList;

/**
 * This class contains words for each category. Also is responsible for choosing a random word.
 */
public class Words {

	static String[] counties = { "Argyll and Bute", "Caithness",  "Kingdom of Fife",
			            "East Lothian", "Highland", "Dumfries and Galloway",
			            "Renfrewshire", "Scottish Borders", "Perth and Kinross" };
	static String[] countries = { "Scotland", "England", "Wales", "Northern Ireland", "Ireland",
			            "France", "Germany", "Netherlands", "Spain", "Portugal",
			            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece" };
	static String[] cities = { "St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
			            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk" };
	
	static String[] states = { "Alabama", "Ohio", "Texas", "California", "Washington", "North Carolina",
						"Florida", "Hawaii", "New Jersey", "Colorado", "Arizona", "Georgia", "Kentucky",
						"Illinois", "Minnesota", "Utah", "Wisconsin", "Indiana", "Arkansas"};
	static ArrayList<String> customwords;

	/**
	 * This method returns a random word for given category selected from a list of predefined words inside the program.
	 * @param category Category id (Countries, States, etc.).
	 * @return A randomly selected string or "INCORRECT CATEGORY" as an error.
	 */
	public static String randomWord(int category) {
		if (category == 1)
			return counties[(int)(Math.random() * (counties.length - 1))];
		if (category == 2)
			return countries[(int)(Math.random() * (countries.length - 1))];
		if (category == 3)
			return cities[(int)(Math.random()* (cities.length - 1))];
		if (category == 4)
			return states[(int)(Math.random() * (states.length - 1))];
		return "INCORRECT CATEGORY";
	}

	/**
	 * This method returns a random word for given category from a list of predefined words outside the program.
	 * @param wordsource Path of the file that the words are located.
	 * @return A randomly selected word or an error message.
	 */
	public static String randomWord(String wordsource) {
		String line;
		customwords = new ArrayList<>();
		
		try {
			FileReader file = new FileReader(wordsource);
			BufferedReader reader = new BufferedReader(file);
			while((line = reader.readLine()) != null) {
                customwords.add(line);
            }
			return customwords.get((int)(Math.random()*customwords.size()));
		} catch(FileNotFoundException e) {
			System.out.println("File error");
			return "FILE ERROR";
		} catch(IOException e) {
		System.out.println("IO error");
		return "IO ERROR";
	}
	}
}
