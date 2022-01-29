package main;

import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import javax.swing.*;

/**
 * The main class: runs main program and houses methods/variables that are shared across classes
 * @author Brooke Xin Lai
 *
 */
public class Client extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public static final int NUM_ACHIEVEMENTS = 6;
	public static List<String> achieved;
	public static Font optionFont = new Font("Monospaced", Font.BOLD, 12);
	public static Font speechFont = new Font("Monospaced", Font.PLAIN, 18);
	public static Font mainFont = new Font("Monospaced", Font.BOLD, 24);
	public static JFrame achievements = new JFrame("JoeFriend: Achievements");
	public JFrame home = new JFrame("JoeFriend: Virtual Buddy");
	public JFrame titlepage = new JFrame ("JoeFriend: Virtual Buddy - Welcome!");
	public JDialog guide = new JDialog(titlepage, "Game Guide");
	public Color buttonColor = new Color (209, 225, 255);
	
	/**
	 * This method plays the specified audio file
	 * @param file
	 */
	public static void playSound(String file) {
	    try {
	    	//declare new audio input stream to read file
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
	        //declare new clip as reading from file
	        Clip clip = AudioSystem.getClip();
	        //start playing file
	        clip.open(audioInputStream);
	        clip.start();
	        
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * This method opens the specified website URL on the user's desktop
	 * @param url
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public static void browse(String url) throws URISyntaxException, IOException {
		//create new URI
		URI uri = new URI(url);
		//open URI location
		Desktop.getDesktop().browse(uri);
		
	}
	
	/**
	 * Opens a JFrame notifying user of achievement once unlocked
	 * @param name: name of achievement
	 * @param det: achievement details
	 */
	public static void notify(String name, String det) {
		
		//create frame
		JFrame notif = new JFrame("New Achievement!");
		notif.setSize(600, 338);
		notif.setLocationRelativeTo(null);
		notif.setVisible(true);
		notif.setLayout(null);
		
		//add background
		JLabel img = new JLabel();
		img.setBounds(0, 0, 600, 338);
		notif.add(img);
		img.setIcon(new ImageIcon("images/shockedJoe.png"));
		
		//add message
		JLabel mssg = new JLabel("New Achievement Unlocked!");
		mssg.setFont(mainFont);
		mssg.setBounds(220, 5, 400, 50);
		img.add(mssg);
		
		//add achievement name
		JLabel ach = new JLabel(" - " + name + " - ");
		ach.setBounds(300, 80, 400, 50);
		ach.setFont(speechFont);
		img.add(ach);
		
		//add achievement details
		JLabel detail = new JLabel(det);
		detail.setBounds(280, 120, 400, 50);
		detail.setFont(speechFont);
		img.add(detail);
		
		//add instructions
		JLabel desc = new JLabel("Head to the Achievments page to view!");
		desc.setBounds(270, 240, 400, 50);
		desc.setFont(optionFont);
		img.add(desc);
	}
	
	/**
	 * Stores unlocked achievements in memory
	 * @param ach: achievement type
	 * @throws IOException
	 */
	public static void storeAchievement(String ach) throws IOException {
		//declare list as memory in text file
		achieved = Files.readAllLines(new File("achievements.txt").toPath(), Charset.defaultCharset() );
		
		//add achievement to list
		achieved.add(ach);
		
		//write achievement type in file
		FileWriter writer = new FileWriter("achievements.txt", true);
		writer.write(ach + "\n");
		writer.close();
	}
	
	/**
	 * Sets 'achieved' list to memory: used in Achievements class when storeAchievement hasn't been called
	 * @throws IOException
	 */
	public static void setAchieved() throws IOException {
		achieved = Files.readAllLines(new File("achievements.txt").toPath(), Charset.defaultCharset() );
	}
	
	/**
	 * The main method: runs program
	 * @param args
	 */

	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	TitlePage title = new TitlePage();
            	//set list achieved to memory
				try {
					setAchieved();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
    }
}