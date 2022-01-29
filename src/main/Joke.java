package main;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.io.*;

/**
 * The joke class
 * @author Brooke Xin Lai
 *
 */
public class Joke extends Line {

	private static final long serialVersionUID = 1L;
	private static final int NUM_JOKES = 15;
	private static List<String> outputtedJokes;
	
	/**
	 * Constructor for jokes
	 */
	public Joke() {
		super ("jokes.txt", NUM_JOKES);
	}
	
	/**
	 * Checks joke for achievement
	 * @throws IOException
	 */
	public void checkJoke() throws IOException {
		
		//set list to memory
		outputtedJokes = Files.readAllLines(new File("jokesOut.txt").toPath(), Charset.defaultCharset() );
				
		//if the current joke hasn't been displayed yet, add it to the list
		BufferedWriter writer = new BufferedWriter(new FileWriter("jokesOut.txt", true));
		if (outputtedJokes.contains(line) == false) {
			outputtedJokes.add(line);
			//store element in memory
			writer.write(line);
			writer.newLine();
			//if all available jokes have been displayed, add an achievement
			if (outputtedAll(outputtedJokes, NUM_JOKES) == true) {
				notify("Ha! That's funny!", "Hear all of Joe's Jokes.");
				storeAchievement("Jokes");
			}
		}
		
		//close writer
		writer.close();
	}
}