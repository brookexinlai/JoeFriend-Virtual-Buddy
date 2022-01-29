package main;

import java.io.*;
import java.lang.Math;
import java.util.List;

/**
 * The line class for jokes, pick-up lines, and insults
 * @author Brooke Xin Lai
 *
 */
public class Line extends Home {

	private static final long serialVersionUID = 1L;
	
	public String line;
	
	/**
	 * Constructor for lines
	 * @param readFile: text file with lines
	 * @param numLines: number of lines
	 */
	public Line(String readFile, int numLines) {
		String lines = null;
		String result = "";
		int random;
		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(readFile));	//create new file reader
			
			//generate line number
			random = (int) (Math.random()*numLines);
			
			//for loop to search text file
			for (int i = 0; i <= random; i++) {
				lines = reader.readLine();
				
				//if the line number is the randomized integer, assign result as line
				if (i == random) {
					result = lines;
				}
			}
			
			//close reader
			reader.close();
			
			//assign result to variable line
			line = result;
		}
		catch (IOException iox) {		//handle exception
			System.out.println("Error");
		}
	}
	
	/**
	 * Getter method for getting line
	 * @return line: this line
	 */
	public String getLine() {
		return line;
	}
	
	/**
	 * Outputs line to home page
	 */
	public void outputLine() {
		
		//clear text box
		clearText();
		
		//add bottom menu
		options();
		
		//add top menu
		addMenu();
		
		//set text to line
		output.setText(line);
	}
	
	/**
	 * Checks if list length is equal to num
	 * @param list: this list
	 * @param num: this num
	 * @return true if list size equals num
	 */
	public boolean outputtedAll(List<String> list, int num) {
		if (list.size() == num) {
			return true;
		}
		return false;
	}
}