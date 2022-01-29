package gamesMenu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;


/**
 * Piano that allows user to make a song and record their notes in a text file.
 */
public class Piano extends JFrame implements ActionListener{
	
	// notesSection that displays the notes played by the user in the piano.
	protected JTextArea notesSection = new JTextArea();

	// String variable. Each time a piano key is played, the note of the key is appended to this variable.
	public String notes = "";

	/**
	 * backToHome method used for exiting current JFrame and navigating user to home menu.
	 */
	public void backToHome() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		setVisible(false);
		dispose();

	}

	/**
	 * Constructor for Piano class.
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @author Sannjay Karthikeyan
	 */
	public Piano() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
	
		notesSection.setBackground(new Color(209, 255, 255));
		notesSection.setBounds(10, 189, 1223, 22);
		getContentPane().add(notesSection);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);

		// File containing the C key pressed on a piano.
		File file = new File("Piano_Extras/C.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip c = AudioSystem.getClip();
		c.open(audioStream);

		// File containing the C Sharp key pressed on a piano.
		File file1 = new File("Piano_Extras/C#.wav");
		AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
		Clip csharp = AudioSystem.getClip();
		csharp.open(audioStream1);

		// File containing the D key pressed on a piano.
		File file2 = new File("Piano_Extras/D.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip d = AudioSystem.getClip();
		d.open(audioStream2);

		// File containing the D key pressed on a piano.
		File file3 = new File("Piano_Extras/D#.wav");
		AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
		Clip dsharp = AudioSystem.getClip();
		dsharp.open(audioStream3);

		// File containing the E key pressed on a piano.
		File file4 = new File("Piano_Extras/E.wav");
		AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
		Clip e = AudioSystem.getClip();
		e.open(audioStream4);

		// File containing the F key pressed on a piano.
		File file5 = new File("Piano_Extras/F.wav");
		AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(file5);
		Clip f = AudioSystem.getClip();
		f.open(audioStream5);

		// File containing the F# key pressed on a piano.
		File file6 = new File("Piano_Extras/F#.wav");
		AudioInputStream audioStream6 = AudioSystem.getAudioInputStream(file6);
		Clip fsharp = AudioSystem.getClip();
		fsharp.open(audioStream6);

		// File containing the G key pressed on a piano.
		File file7 = new File("Piano_Extras/G.wav");
		AudioInputStream audioStream7 = AudioSystem.getAudioInputStream(file7);
		Clip g = AudioSystem.getClip();
		g.open(audioStream7);

		// File containing the G# key pressed on a piano.
		File file8 = new File("Piano_Extras/G#.wav");
		AudioInputStream audioStream8 = AudioSystem.getAudioInputStream(file8);
		Clip gsharp = AudioSystem.getClip();
		gsharp.open(audioStream8);

		// File containing the a key pressed on a piano.
		File file9 = new File("Piano_Extras/A.wav");
		AudioInputStream audioStream9 = AudioSystem.getAudioInputStream(file9);
		Clip a = AudioSystem.getClip();
		a.open(audioStream9);

		// File containing the A# key pressed on a piano.
		File file10 = new File("Piano_Extras/A#.wav");
		AudioInputStream audioStream10 = AudioSystem.getAudioInputStream(file10);
		Clip asharp = AudioSystem.getClip();
		asharp.open(audioStream10);

		// File containing the B key pressed on a piano.
		File file11 = new File("Piano_Extras/B.wav");
		AudioInputStream audioStream11 = AudioSystem.getAudioInputStream(file11);
		Clip b = AudioSystem.getClip();
		b.open(audioStream11);

		// File containing the C key pressed on a piano.
		File file12 = new File("Piano_Extras/CHigh.wav");
		AudioInputStream audioStream12 = AudioSystem.getAudioInputStream(file12);
		Clip CHigh = AudioSystem.getClip();
		CHigh.open(audioStream12);

		// File containing the C sharp key pressed on a piano.
		File file13 = new File("Piano_Extras/C#High.wav");
		AudioInputStream audioStream13 = AudioSystem.getAudioInputStream(file13);
		Clip CSharpHigh = AudioSystem.getClip();
		CSharpHigh.open(audioStream13);

		// File containing the D key pressed on a piano.
		File file14 = new File("Piano_Extras/DHigh.wav");
		AudioInputStream audioStream14 = AudioSystem.getAudioInputStream(file14);
		Clip DHigh = AudioSystem.getClip();
		DHigh.open(audioStream14);

		// File containing the D Sharp key pressed on a piano.
		File file15 = new File("Piano_Extras/D#High.wav");
		AudioInputStream audioStream15 = AudioSystem.getAudioInputStream(file15);
		Clip DSharpHigh = AudioSystem.getClip();
		DSharpHigh.open(audioStream15);

		// File containing the E Sharp key pressed on a piano.
		File file16 = new File("Piano_Extras/EHigh.wav");
		AudioInputStream audioStream16 = AudioSystem.getAudioInputStream(file16);
		Clip EHigh = AudioSystem.getClip();
		EHigh.open(audioStream16);

		/*
		 * ActionListener for D Sharp key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DLowSharp = new JButton("D#");
		DLowSharp.setForeground(Color.WHITE);
		DLowSharp.setBackground(Color.BLACK);
		DLowSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dsharp.start();
				dsharp.setMicrosecondPosition(0);
				notes += "D# ";
				notesSection.setText(notes);


			}
		});
		DLowSharp.setBounds(228, 222, 55, 167);
		getContentPane().add(DLowSharp);

		/*
		 * ActionListener for F Sharp key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton FLowSharp = new JButton("F#");
		FLowSharp.setForeground(Color.WHITE);
		FLowSharp.setBackground(Color.BLACK);
		FLowSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fsharp.start();
				notes += "F# ";
				notesSection.setText(notes);
				fsharp.setMicrosecondPosition(0);

			}
		});
		FLowSharp.setBounds(457, 222, 55, 167);
		getContentPane().add(FLowSharp);

		/*
		 * ActionListener for G Sharp key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton GHighSharp = new JButton("G#");
		GHighSharp.setForeground(Color.WHITE);
		GHighSharp.setBackground(Color.BLACK);
		GHighSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gsharp.start();
				notes += "G# ";
				notesSection.setText(notes);
				gsharp.setMicrosecondPosition(0);

			}
		});
		GHighSharp.setBounds(597, 222, 55, 167);
		getContentPane().add(GHighSharp);

		/*
		 * ActionListener for A Sharp key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton AHighSharp = new JButton("A#");
		AHighSharp.setForeground(Color.WHITE);
		AHighSharp.setBackground(Color.BLACK);
		AHighSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				asharp.start();
				asharp.setMicrosecondPosition(0);
				notes += "A# ";
				notesSection.setText(notes);

			}
		});
		AHighSharp.setBounds(739, 222, 55, 167);
		getContentPane().add(AHighSharp);

		/*
		 * ActionListener for D Sharp key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DHighSharp = new JButton("D#");
		DHighSharp.setForeground(Color.WHITE);
		DHighSharp.setBackground(Color.BLACK);
		DHighSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DSharpHigh.start();
				DSharpHigh.setMicrosecondPosition(0);
				notes += "D# ";
				notesSection.setText(notes);

			}
		});
		DHighSharp.setBounds(1109, 222, 55, 167);
		getContentPane().add(DHighSharp);




		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CLowMain = new JButton("C");
		CLowMain.setBackground(Color.WHITE);
		CLowMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				c.start();
				notes += "C ";
				notesSection.setText(notes);
				c.setMicrosecondPosition(0);

			}
		});
		CLowMain.setBounds(0, 222, 89, 259);
		getContentPane().add(CLowMain);

		/*
		 * ActionListener for D key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DLowMain = new JButton("D");
		DLowMain.setBackground(Color.WHITE);
		DLowMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				d.start();
				d.setMicrosecondPosition(0);

				notes += "D ";
				notesSection.setText(notes);


			}
		});
		DLowMain.setBounds(143, 222, 89, 259);
		getContentPane().add(DLowMain);

		/*
		 * ActionListener for E key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton ELowMain = new JButton("E");
		ELowMain.setBackground(Color.WHITE);
		ELowMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				e.start();
				notes += "E ";
				notesSection.setText(notes);
				e.setMicrosecondPosition(0);

			}
		});
		ELowMain.setBounds(280, 222, 89, 259);
		getContentPane().add(ELowMain);

		/*
		 * ActionListener for F key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton FLowMain = new JButton("F");
		FLowMain.setBackground(Color.WHITE);
		FLowMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.start();
				notes += "F ";
				notesSection.setText(notes);
				f.setMicrosecondPosition(0);


			}
		});
		FLowMain.setBounds(369, 222, 89, 259);
		getContentPane().add(FLowMain);

		/*
		 * ActionListener for G key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton GHighMain = new JButton("G");
		GHighMain.setBackground(Color.WHITE);
		GHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				g.start();
				notes += "G ";
				notesSection.setText(notes);
				g.setMicrosecondPosition(0);

			}
		});
		GHighMain.setBounds(510, 222, 89, 259);
		getContentPane().add(GHighMain);

		/*
		 * ActionListener for B key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton BHighMain = new JButton("B");
		BHighMain.setBackground(Color.WHITE);
		BHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				b.start();
				b.setMicrosecondPosition(0);
				notes += "B ";
				notesSection.setText(notes);

			}
		});
		BHighMain.setBounds(792, 222, 89, 259);
		getContentPane().add(BHighMain);

		// JLabel that confirms that the user's song has been created and that the song notes have been appended to the text file.
		JLabel songCreated = new JLabel("Your song has been created! Check \"Songs.txt\" to     view it.");
		songCreated.setForeground(Color.WHITE);
		songCreated.setBackground(Color.WHITE);
		songCreated.setFont(new Font("Monospaced", Font.BOLD, 15));
		songCreated.setBounds(148, 156, 864, 22);
		songCreated.setVisible(false);
		getContentPane().add(songCreated);
		
		/*
		 * ActionListener for A key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton AHighMain = new JButton("A");
		AHighMain.setBackground(Color.WHITE);
		AHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				a.start();
				notes += "A ";
				notesSection.setText(notes);
				a.setMicrosecondPosition(0);

			}
		});
		AHighMain.setBounds(652, 222, 89, 259);
		getContentPane().add(AHighMain);

		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CHighMain = new JButton("C");
		CHighMain.setBackground(Color.WHITE);
		CHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CHigh.start();
				CHigh.setMicrosecondPosition(0);
				notes += "C ";
				notesSection.setText(notes);

			}
		});
		CHighMain.setBounds(879, 222, 89, 259);
		getContentPane().add(CHighMain);

		/*
		 * ActionListener for D key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DHighMain = new JButton("D");
		DHighMain.setBackground(Color.WHITE);
		DHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DHigh.start();
				DHigh.setMicrosecondPosition(0);
				notes += "D ";
				notesSection.setText(notes);

			}
		});
		DHighMain.setBounds(1022, 222, 89, 259);
		getContentPane().add(DHighMain);

		/*
		 * ActionListener for E key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton EHighMain = new JButton("E");
		EHighMain.setBackground(Color.WHITE);
		EHighMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EHigh.start();
				EHigh.setMicrosecondPosition(0);
				notes += "E ";
				notesSection.setText(notes);

			}
		});
		EHighMain.setBounds(1161, 222, 89, 259);
		getContentPane().add(EHighMain);

		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CHighSharp = new JButton("C#");
		CHighSharp.setForeground(Color.WHITE);
		CHighSharp.setBackground(Color.BLACK);
		CHighSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CSharpHigh.start();
				CSharpHigh.setMicrosecondPosition(0);
				notes += "C# ";
				notesSection.setText(notes);

			}
		});
		CHighSharp.setBounds(968, 222, 55, 167);
		getContentPane().add(CHighSharp);

		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CLowSharp = new JButton("C#");
		CLowSharp.setForeground(Color.WHITE);
		CLowSharp.setBackground(Color.BLACK);
		CLowSharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				csharp.start();

				notes += "C# ";
				notesSection.setText(notes);
				csharp.setMicrosecondPosition(0);

			}
		});
		
		
		CLowSharp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CLowSharp.setBounds(89, 224, 55, 165);
		getContentPane().add(CLowSharp);

		// ActionListener that invokes the HowToPlay class, displaying a JFrame with a set of instructions
		// to familiarize the user with the JoeFriend piano.
		JButton btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new HowToPlay().setVisible(true);
				
			}
		});
		btnHowToPlay.setBounds(10, 121, 154, 23);
		btnHowToPlay.setBackground(Canvas.buttonColor);
		btnHowToPlay.setFont(new Font("Monospaced", Font.BOLD, 14));
		getContentPane().add(btnHowToPlay);
		

		// Button that allows user to record the notes played and create a song with them.
		JButton btnCreateYourOwn = new JButton("Make a song");
		btnCreateYourOwn.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnCreateYourOwn.setBackground(Canvas.buttonColor);
		
		/*
		 * ActionListener that allows the user to create their own song.
		 * Writes the current date and time, alongside the notes played by the user to a text file.
		 * Displays a confirmation for the user that their song has been created.
		 */
		btnCreateYourOwn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter("Songs.txt", true));
					bw.append("\n" + notes + "\nCreated on " + java.time.LocalDate.now() + "\n--------------------\n");
					bw.close();
					
				} catch (IOException e1) {
		
					e1.printStackTrace();
				}
								
				songCreated.setVisible(true);

			}

		});
		btnCreateYourOwn.setBounds(10, 155, 154, 23);
		getContentPane().add(btnCreateYourOwn);

		
		/*
		 * ActionListener for D key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DHighSub = new JButton("");
		DHighSub.setBackground(Color.WHITE);
		DHighSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DHigh.start();
				DHigh.setMicrosecondPosition(0);
				notes += "D ";
				notesSection.setText(notes);

			}
		});
		DHighSub.setBounds(1109, 389, 55, 92);
		getContentPane().add(DHighSub);

		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CHighSub = new JButton("");
		CHighSub.setBackground(Color.WHITE);
		CHighSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CHigh.start();
				CHigh.setMicrosecondPosition(0);
				notes += "C ";
				notesSection.setText(notes);

			}
		});
		CHighSub.setBounds(968, 389, 55, 92);
		getContentPane().add(CHighSub);

		/*
		 * ActionListener for C key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton CLowSub = new JButton("");
		CLowSub.setBackground(Color.WHITE);
		CLowSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				notes += "C ";
				notesSection.setText(notes);

				c.start();
				c.setMicrosecondPosition(0);

			}
		});
		CLowSub.setBounds(89, 389, 55, 92);
		getContentPane().add(CLowSub);

		/*
		 * ActionListener for F key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton FLowSub = new JButton("");
		FLowSub.setBackground(Color.WHITE);
		FLowSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f.start();
				notes += "F ";
				notesSection.setText(notes);
				f.setMicrosecondPosition(0);

			}
		});
		FLowSub.setBounds(457, 389, 55, 92);
		getContentPane().add(FLowSub);

		/*
		 * ActionListener for G key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton GHighSub = new JButton("");
		GHighSub.setBackground(Color.WHITE);
		GHighSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				g.start();
				notes += "G ";
				notesSection.setText(notes);
				g.setMicrosecondPosition(0);

			}
		});
		GHighSub.setBounds(597, 389, 55, 92);
		getContentPane().add(GHighSub);

		/*
		 * ActionListener for A key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton AHighSub = new JButton("");
		AHighSub.setBackground(Color.WHITE);
		AHighSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				a.start();
				a.setMicrosecondPosition(0);
				notes += "A ";
				notesSection.setText(notes);

			}
		});
		AHighSub.setBounds(739, 389, 55, 92);
		getContentPane().add(AHighSub);

		/*
		 * ActionListener for D key that plays the respective audio file for this key. 
		 * Resets the audio file so it can be played again.
		 * Appends this key to the text variable containing all the keys played.
		 * Updates the JTextArea containing the keys played with this current key.
		 */
		JButton DLowSub = new JButton("");
		DLowSub.setBackground(Color.WHITE);
		DLowSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				d.start();
				notes += "D ";
				notesSection.setText(notes);

				d.setMicrosecondPosition(0);

			}
		});
		DLowSub.setBounds(228, 389, 55, 92);
		getContentPane().add(DLowSub);
		
		// Title for the current JFrame.
		JLabel pianoTitle = new JLabel("Piano");
		pianoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pianoTitle.setFont(new Font("Monospaced", Font.BOLD, 65));
		pianoTitle.setForeground(Color.CYAN);
		pianoTitle.setBounds(425, 37, 391, 92);
		getContentPane().add(pianoTitle);
		
		// JButton that navigates the user back to the home menu.
		JButton backHome = new JButton("Back To Home");
		backHome.setBounds(10, 87, 154, 23);
		getContentPane().add(backHome);
		backHome.setBackground(Canvas.buttonColor);
		backHome.setFont(new Font("Monospaced", Font.BOLD, 15));
		
		AHighSub.setBounds(739, 389, 55, 92);
		getContentPane().add(AHighSub);

		/*
		 * ActionListener that navigates the user to the home menu.
		 * Invokes the backToHome() method to perform this action.
		 */
		backHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					backToHome();
					
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		// Background of current frame.
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1259, 481);
		getContentPane().add(background);
		background.setIcon(new ImageIcon("Piano_Extras/bkg.png"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}