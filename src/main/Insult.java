package main;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.io.*;

/**
 * The insults class
 * @author Brooke Xin Lai
 *
 */
public class Insult extends Line {

	private static final long serialVersionUID = 1L;
	private static final int NUM_INSULTS = 10;
	private static List<String> outputtedInsults;
	
	/**
	 * Constructor for insults
	 */
	public Insult() {
		super ("insults.txt", NUM_INSULTS);
	}
	
	/**
	 * Checks insults for achievement
	 * @throws IOException
	 */
	public void checkInsults() throws IOException {
		
		//set list as memory
		outputtedInsults = Files.readAllLines(new File("insultsOut.txt").toPath(), Charset.defaultCharset() );
				
		//if the current insult hasn't been displayed yet, add it to the list
		BufferedWriter writer = new BufferedWriter(new FileWriter("insultsOut.txt", true));
		if (outputtedInsults.contains(line) == false) {
			outputtedInsults.add(line);
			//store element in memory
			writer.write(line);
			writer.newLine();
			//if all available insults have been displayed, add an achievement
			if (outputtedAll(outputtedInsults, NUM_INSULTS) == true) {
				notify("Ouch...", "Hear all of Joe's insults.");
				storeAchievement("Insults");
			}
		}
		
		//close writer
		writer.close();
	}
}