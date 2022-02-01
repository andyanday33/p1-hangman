package p1.hangman;

import java.io.*;
import java.util.ArrayList;

public class Words {

	static String[] words1 = { "Argyll and Bute", "Caithness",  "Kingdom of Fife",
			            "East Lothian", "Highland", "Dumfries and Galloway",
			            "Renfrewshire", "Scottish Borders", "Perth and Kinross" };
	static String[] words2 = { "Scotland", "England", "Wales", "Northern Ireland", "Ireland", 
			            "France", "Germany", "Netherlands", "Spain", "Portugal",
			            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece" };
	static String[] words3 = { "St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
			            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk" };
	
	static String[] words4 = { "Alabama" };
	static ArrayList<String> customwords;
	
	public static String randomWord(int category) {
		if (category == 1)
			return words1[(int)(Math.random()*9)];
		if (category == 2)
			return words2[(int)(Math.random()*15)];
		if (category == 3)
			return words3[(int)(Math.random()*10)];
		if (category == 4)
			return words4[(int)(Math.random()*1)];
		return "INCORRECT CATEGORY";
	}
	
	public static String randomWord(String wordsource) {
		String line;
		customwords = new ArrayList<String>();
		
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
