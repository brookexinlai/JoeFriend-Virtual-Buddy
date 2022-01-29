package main;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.io.*;

/**
 * The pick-up line class
 * @author Brooke Xin Lai
 *
 */
public class PickUp extends Line {

	private static final long serialVersionUID = 1L;
	private static final int NUM_PICKUPS = 11;
	private static List<String> outputtedPickUps;
	
	/**
	 * Constructor class for pick-up lines
	 */
	public PickUp() {
		super ("lines.txt", NUM_PICKUPS);
	}
	
	/**
	 * Checks pick up line for achievements
	 * @throws IOException
	 */
	public void checkPickUp() throws IOException {
		
		//set list to memory
		outputtedPickUps = Files.readAllLines(new File("linesOut.txt").toPath(), Charset.defaultCharset() );
				
		//if the current line hasn't been displayed yet, add it to the list
		BufferedWriter writer = new BufferedWriter(new FileWriter("linesOut.txt", true));
		if (outputtedPickUps.contains(line) == false) {
			outputtedPickUps.add(line);
			//store element in memory
			writer.write(line);
			writer.newLine();
			//if all available lines have been displayed, add an achievement
			if (outputtedAll(outputtedPickUps, NUM_PICKUPS) == true) {
				notify("Are we flirting???", "Hear all of Joe's pick-ups.");
				storeAchievement("PickUps");
			}
		}
		//close writer
		writer.close();
	}
}