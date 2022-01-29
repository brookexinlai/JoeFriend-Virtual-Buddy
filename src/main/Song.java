package main;

import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The song class: extracts from wav file
 * @author Brooke Xin Lai
 *
 */
public class Song extends Client{
	
	private static final long serialVersionUID = 1L;
	private String file;
	private String played;
	
	/**
	 * Constructor method for creating song
	 * @param file: wav file
	 */
	public Song(String file) {
		this.file = file;
	}
	
	/**
	 * Plays contents of song object
	 */
	public void playSong() {
	    try {
	    	//create new audio input stream
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
	        
	        //assign clip
	        Clip clip = AudioSystem.getClip();
	        
	        //play song
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {		//handle exception
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * Check song for achievements
	 * @throws IOException
	 */
	public void checkSong() throws IOException {

		//set list as memory
		BufferedReader reader = new BufferedReader(new FileReader("songsOut.txt"));
		played = reader.readLine();
				
		//if the song hasn't been played yet, store in memory
		BufferedWriter writer = new BufferedWriter(new FileWriter("songsOut.txt"));
		if (played==null || played =="") {
			//add to text file if song has been played once
			writer.write("played");
			notify("Happy Birthday!", "Hear Joe's birthday song.");
			storeAchievement("Song");
		}
		//close writer and reader
		writer.close();
		reader.close();
	}
}