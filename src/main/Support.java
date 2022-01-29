package main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;

import javax.swing.*;

/**
 * The support function
 * @author Brooke Xin Lai
 *
 */
public class Support extends Home {
	
	private static final long serialVersionUID = 1L;
	private final int maxChars = 2820;
	private JFrame input;
	private JButton newEntry;
	private JButton deleteAll;
	public String userEntry;
	public String dateOfEntry;
	private static String writeFile = "entries.txt";
	public static String supported;
	
	/**
	 * Constructor for running support
	 */
	public Support() {

	}
	
	/**
	 * constructor for storing entry
	 */
	public Support(String dateOfEntry, String userEntry) {
		this.dateOfEntry = dateOfEntry;
		this.userEntry = userEntry;
	}
	
	/**
	 * runs main support menu
	 */
	public void runSupport() {
		
		//reset text box
		clearText();
		
		//reset text
		output.setText("Hey, is there something bothering you? We can talk...if you want.");
		
		//add button for new entry
		newEntry = new JButton("New entry");
		
		//add action listener
		newEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == newEntry) {
					//open input window
					input();
				}
			}
		});
		
		//set button settings
		newEntry.setBackground(buttonColor);
		newEntry.setBounds(240, 140, 120, 50);
		newEntry.setFont(optionFont);
		
		//add button to text box
		text.add(newEntry);
		
		//add button for deleting entries
		deleteAll = new JButton("Delete all entries");
		
		//add action listener
		deleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == deleteAll) {
					
					//remove buttons
					newEntry.setVisible(false);
					deleteAll.setVisible(false);
					
					//run removal confirmation
					removeAll();
				}
			}
		});
		
		//set button settings
		deleteAll.setBackground(buttonColor);
		deleteAll.setBounds(400, 140, 220, 50);
		deleteAll.setFont(optionFont);
		
		//add button to text box
		text.add(deleteAll);
	}
	
	/**
	 * Getter method for entry
	 * @return userEntry
	 */
	public String getEntry() {
		return userEntry;
	}
	
	/**
	 * Getter method for date
	 * @return dateOfEntry
	 */
	public String getDate() {
		return dateOfEntry;
	}
	
	/**
	 * Checks entry for achievement
	 * @throws IOException
	 */
	public void checkEntry() throws IOException {
		
		//set list as memory
				BufferedReader reader = new BufferedReader(new FileReader("supported.txt"));
				supported = reader.readLine();
						
				//if the song hasn't been played yet, store in memory
				BufferedWriter writer = new BufferedWriter(new FileWriter("supported.txt"));
				if (supported == null || supported == "") {
					//add to text file if song has been played once
					writer.write("supported");
					notify("What Friends Are For", "Rant to Joe.");
					storeAchievement("Support");
				}
				//close writer and reader
				writer.close();
				reader.close();
	}
	
	/**
	 * Stores entry in text file memory
	 */
	private void storeEntry() {
		try {
			
			//create new writer
			FileWriter writer = new FileWriter(writeFile, true);
			
			//write entry and date
			writer.write(dateOfEntry + "\n");
			writer.write(userEntry + "\n");
			writer.write("---\n");
			
			//close writer
			writer.close();
		}
		
		catch (IOException iox) {	//handle exception
			System.out.println("Error");
		}
	}
	
	/**
	 * Displays kind message after entry storage
	 */
	private void kindMessage() {
		
		//create new JDialog
		JDialog kind = new JDialog(home, "Thank you!");
		kind.setSize(500, 329);
		kind.setLocationRelativeTo(null);
		kind.setVisible(true);
		kind.setLayout(null);
		kind.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//create new JLabel for background image
		JLabel supported = new JLabel();
		supported.setBounds(0, 0, 500, 329);
		supported.setIcon(new ImageIcon("images/supported.png"));
		
		//add image to JDialog
		kind.add(supported);
		
		//create new JLabel for message output
		JLabel mssg = new JLabel("<html>Your entry has been saved<br/><br/>Do you feel better now? I hope so.<br/><br/>If not, I wouldn't mind if you stayed a little longer...<br/><br/>Kids Help Phone: 1-800-668-6868 OR<br/>Text CONNECT to 686868</html>");
		mssg.setBounds(250, 75, 200, 200);
		
		//add label to JDialog
		supported.add(mssg);
		
		//set JDialog visible
		kind.setVisible(true);
	}
	
	/**
	 * Confirmation for deleting entries
	 */
	public void removeAll() {
		
		//reset text
		output.setText("Hey, wait! Are you sure you want to delete all your entries?");
		
		//create button
		JButton yes = new JButton("Yes");
		
		yes.setBackground(buttonColor);
		yes.setBounds(250, 140, 150, 50);
		yes.setFont(optionFont);
		text.add(yes);
		
		JButton no = new JButton("No");
		no.setBackground(buttonColor);
		no.setBounds(80, 140, 125, 50);
		no.setFont(optionFont);
		text.add(no);
		
		//add action listener for confirmed button
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//clear text file
					PrintWriter pw = new PrintWriter("entries.txt");
					pw.close();
				} 
				catch (FileNotFoundException e1) {		//handle exception
					output.setText("Sorry, I couldn't delete them for some reason.");
					yes.setVisible(false);
					no.setVisible(false);
				}
				
				//reset text box text
				output.setText("Okay, I'll forget you ever told me anything.");
				
				//remove buttons from home
				yes.setVisible(false);
				no.setVisible(false);
				
				//add bottom menu
				options();
				
				//add top menu
				addMenu();
						
			}
		});
			
		//add action listener for refusal button
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == no) {
					
					//reset text
					output.setText("<html><br/>Yeah...I don't think you should delete them either.<br/>Not that I'd care if you did, or anything. Your choice :100:</html>");
					
					//remove buttons
					yes.setVisible(false);
					no.setVisible(false);
					
					//add bottom menu
					options();
					
					//add top menu
					addMenu();
				}
			}
		});
	}
	
	/**
	 * Checks if length of string is over the limit
	 * @param limit: entry word limit
	 * @param str: entry
	 * @return overLimit: if length of str is over limit
	 */
	public boolean overLimit(int limit, String str) {
		if (str.length() > limit) {
			return true;
		}
		return false;
	}
	/**
	 * Runs frame for user input
	 */
	public void input() {
		
		//create new frame
		input = new JFrame("Venting: Write anything you need to");
		input.setSize(600, 700);
		input.setLocationRelativeTo(null);
		input.setVisible(true);
		input.setLayout(null);
		
		//add new JLabel to output a message when entry is over limit
		JLabel invalid = new JLabel();
		invalid.setBounds(400, 10, 125, 25);
		invalid.setForeground(Color.red);
		input.add(invalid);
		
		//add jlabel to display current date
		JLabel enter = new JLabel(LocalDate.now().toString());
		enter.setBounds(10, 10, 2000, 25);
		input.add(enter);
		
		//add text area for input
		JTextArea userInput = new JTextArea();
		userInput.setBounds(0, 50, 590, 550);
		userInput.setLineWrap(true);
		userInput.setWrapStyleWord(true);
		input.add(userInput);
		
		//create save button
		JButton save = new JButton("Save Entry");
		
		//add action listener
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save) {
					
					//store date and entry in variables
					userEntry = userInput.getText();
					dateOfEntry = LocalDate.now().toString();
					
					if (overLimit(maxChars, userEntry) == false) {		//perform if entry is under limit
						//create new object
						Support support = new Support(dateOfEntry, userEntry);
						
						try {
							//check entry for achievement
							support.checkEntry();
						} catch (IOException e1) {		//handle exception
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//store entry
						support.storeEntry();
						
						//remove current home page and input page
						home.dispose();
						input.dispose();
						
						//output kind message
						kindMessage();
					}
					
					//if entry is over limit, display message
					else {
						input.setVisible(true);
						invalid.setText("*" + (userEntry.length() - maxChars) + " chars over limit!");	
					}
				}
			}
		});
		
		//set button settings
		save.setBackground(buttonColor);
		save.setBounds(50, 615, 125, 30);
		save.setFont(optionFont);
		
		//add button to frame
		input.add(save);
		
		//create discard button
		JButton discard = new JButton("Discard Entry");
		
		//add action listener
		discard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == discard) {
					
					//remove buttons
					newEntry.setVisible(false);
					deleteAll.setVisible(false);
					
					//reset text
					output.setText("Hm. Maybe next time then.");
					
					//add bottom menu
					options();
					
					//add top menu
					addMenu();
					
					//dispose input frame
					input.dispose();
				}				
			}			
		});
		
		//set button settings
		discard.setBackground(buttonColor);
		discard.setBounds(400, 615, 140, 30);
		discard.setFont(optionFont);
		
		//add button to frame
		input.add(discard);
		
	}
}