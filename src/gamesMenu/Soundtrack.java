package gamesMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.JTextField;

/**
 * Soundtrack containing background music for all games and game menus in the JoeFriend application.
 * @author Sannjay Karthikeyan
 */
public class Soundtrack extends JFrame implements ActionListener {

	/**
	 * backToHome method used for exiting current JFrame and navigating user to home menu.
	 * @param e
	 */
	public void backToHome(Clip e) {

		e.stop();
		setVisible(false);
		dispose();


	}

	// JLabel that displays the song that is currently playing in th frame. This is chosen by the user.
	public JLabel nowPlaying = new JLabel("Choose a song!");

	// JLabel containing title of frame.
	public JLabel title = new JLabel("Soundtrack");
	
	// JLabel containing the music source used for the Rock Paper Scissors game. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel rockPaperScissorsSource = new JLabel("Source: Super Smash Bros. Brawl - Trophy Gallery (2008)");
		
	// JLabel containing the music source used for the Dice game. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel diceSource = new JLabel("Source: Super Smash Bros. Brawl - Online Waiting Room (2008)");
			
	// JLabel containing the music source used for the Canvas game. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel canvasSource = new JLabel("Source: Persona 5 - Beneath the Mask (Instrumental) (2016)");
		
	// JLabel containing the music source used for the Cookie Clicker game. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel cookieClickerSource = new JLabel("Source: Sonic Mega Collection - History (2002)");
		
	// JLabel containing the music source used for the Soundtrack window. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel soundtrackSource = new JLabel("Source: Pokemon X & Y - Coiffure Clips (2013)");
			
	// JLabel containing the music source used for the Games Menu window. Only visible if the background music for this game or window has been played in THIS frame.
	public JLabel gamesMenuSource = new JLabel("Source: ASTRO's PLAYROOM - Home Menu (2020)");
			
	
	/**
	 * Constructor for Soundtrack class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	Soundtrack() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		// Audio file containing background music for the Soundtrack window.
		File file = new File("Soundtrack_Extras/soundtrack.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip soundtrackmusic = AudioSystem.getClip();
		soundtrackmusic.open(audioStream);
		soundtrackmusic.start();
	
		// Audio file containing background music for the Rock Paper Scissors game.
		File file2 = new File("RockPaperScissors_Extras/bkgMusic.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip rockPaperScissorsmusic = AudioSystem.getClip();
		rockPaperScissorsmusic.open(audioStream2);

		// Audio file containing background music for the dice game.
		File file3 = new File("Dice_Extras/bkgMusic.wav");
		AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
		Clip diceMusic = AudioSystem.getClip();
		diceMusic.open(audioStream3);

		// Audio file containing background music for the canvas game.
		File file4 = new File("Canvas_Extras/bkgMusic.wav");
		AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
		Clip canvasMusic = AudioSystem.getClip();
		canvasMusic.open(audioStream4);

		// Audio file containing background music for the cookie clicker game.
		File file5 = new File("CookieClicker_Extras/bkgMusic.wav");
		AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(file5);
		Clip cookieClickerMusic = AudioSystem.getClip();
		cookieClickerMusic.open(audioStream5);

		// Audio file containing background music for the games menu window.
		File file6 = new File("GamesMenu_Extras/bkgMusic.wav");
		AudioInputStream audioStream6 = AudioSystem.getAudioInputStream(file6);
		Clip gamesMenuMusic = AudioSystem.getClip();
		gamesMenuMusic.open(audioStream6);

		// Loops the background music for the Soundtrack window (this window) until the program is exited.
		soundtrackmusic.loop(ABORT);
		
		// WindowListener method to stop the background music if the window is closed. Prevents the music from being played
		// even after the JFrame is closed.	
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosed(WindowEvent e) {
		    	soundtrackmusic.stop();
		    	rockPaperScissorsmusic.stop();
		    	diceMusic.stop();
		    	canvasMusic.stop();
		    	cookieClickerMusic.stop();
		    	gamesMenuMusic.stop();
		    }

		    public void windowClosing(WindowEvent e) {
		    	soundtrackmusic.stop();
		    	rockPaperScissorsmusic.stop();
		    	diceMusic.stop();
		    	canvasMusic.stop();
		    	cookieClickerMusic.stop();
		    	gamesMenuMusic.stop();
		    }
		});

		// JPanel to display contents of frame.
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Monospaced", Font.BOLD, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(97, 54, 240, 99);
		panel.add(title);
		
		nowPlaying.setForeground(Color.WHITE);
		nowPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		nowPlaying.setFont(new Font("Monospaced", Font.BOLD, 18));
		nowPlaying.setBounds(0, 54, 434, 23);
		panel.add(nowPlaying);

		rockPaperScissorsSource.setForeground(Color.WHITE);
		rockPaperScissorsSource.setHorizontalAlignment(SwingConstants.CENTER);
		rockPaperScissorsSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		rockPaperScissorsSource.setBounds(10, 196, 414, 50);
		panel.add(rockPaperScissorsSource);
		rockPaperScissorsSource.setVisible(false);

		diceSource.setForeground(Color.WHITE);
		diceSource.setHorizontalAlignment(SwingConstants.CENTER);
		diceSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		diceSource.setBounds(10, 290, 414, 44);
		panel.add(diceSource);
		diceSource.setVisible(false);

		canvasSource.setForeground(Color.WHITE);
		canvasSource.setHorizontalAlignment(SwingConstants.CENTER);
		canvasSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		canvasSource.setBounds(10, 378, 414, 38);
		panel.add(canvasSource);
		canvasSource.setVisible(false);

		cookieClickerSource.setForeground(Color.WHITE);
		cookieClickerSource.setHorizontalAlignment(SwingConstants.CENTER);
		cookieClickerSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		cookieClickerSource.setBounds(10, 468, 414, 32);
		panel.add(cookieClickerSource);
		cookieClickerSource.setVisible(false);

		soundtrackSource.setForeground(Color.WHITE);
		soundtrackSource.setHorizontalAlignment(SwingConstants.CENTER);
		soundtrackSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		soundtrackSource.setBounds(10, 549, 414, 40);
		panel.add(soundtrackSource);
		soundtrackSource.setVisible(false);

		gamesMenuSource.setForeground(Color.WHITE);
		gamesMenuSource.setHorizontalAlignment(SwingConstants.CENTER);
		gamesMenuSource.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 13));
		gamesMenuSource.setBounds(10, 635, 414, 40);
		panel.add(gamesMenuSource);
		gamesMenuSource.setVisible(false);

		// JButton that redirects the user back to the home page.
		JButton backHome = new JButton("Back To Home");
		backHome.setBackground(Canvas.buttonColor);
		backHome.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		// ActionListener that invokes the backToHome method to close the current window and 
		// navigate the user to the Home page.
		backHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				backToHome(soundtrackmusic);
			
			}
		});
		backHome.setFont(new Font("Monospaced", Font.BOLD, 15));
		backHome.setBounds(10, 11, 156, 23);
		panel.add(backHome);

		// JButton that plays the music from the Games Menu window.
		JButton gamesMenu = new JButton("Games Menu");
		gamesMenu.setBackground(Canvas.buttonColor);
		gamesMenu.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		// ActionListener that plays music from Games Menu window. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.
		gamesMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rockPaperScissorsmusic.stop();
				diceMusic.stop();
				canvasMusic.stop();
				cookieClickerMusic.stop();
				soundtrackmusic.stop();
				gamesMenuMusic.setMicrosecondPosition(0);
				gamesMenuMusic.start();
				gamesMenuSource.setVisible(true);
				nowPlaying.setText("Now Playing: Games Menu Music");


			}
		});

		// JButton that plays the music from the cookie clicker game.
		JButton cookieClicker = new JButton("Cookie Clicker");
		cookieClicker.setBackground(Canvas.buttonColor);
		cookieClicker.setFont(new Font("Monospaced", Font.BOLD, 25));
		

		// ActionListener that plays music from cookie clicker game. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.
		cookieClicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rockPaperScissorsmusic.stop();
				diceMusic.stop();
				canvasMusic.stop();
				gamesMenuMusic.stop();
				soundtrackmusic.stop();
				cookieClickerMusic.setMicrosecondPosition(0);
				cookieClickerMusic.start();
				cookieClickerSource.setVisible(true);
				nowPlaying.setText("Now Playing: Cookie Clicker Music");

			}
		});

		// JButton that plays the music from the Canvas game.
		JButton canvas = new JButton("Canvas");
		canvas.setBackground(Canvas.buttonColor);
		canvas.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		// ActionListener that plays music from the canvas game. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.		
		canvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rockPaperScissorsmusic.stop();
				diceMusic.stop();
				gamesMenuMusic.stop();
				cookieClickerMusic.stop();
				soundtrackmusic.stop();
				canvasMusic.setMicrosecondPosition(0);
				canvasMusic.start();
				canvasSource.setVisible(true);
				nowPlaying.setText("Now Playing: Canvas Music");

			}
		});

		// JButton that plays the music from the Dice game.
		JButton dice = new JButton("Dice (Guess a number)");
		dice.setBackground(Canvas.buttonColor);
		dice.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		// ActionListener that plays music from the dice game. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.
		dice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				soundtrackmusic.stop();
				canvasMusic.stop();
				gamesMenuMusic.stop();
				cookieClickerMusic.stop();
				rockPaperScissorsmusic.stop();
				diceMusic.setMicrosecondPosition(0);
				diceMusic.start();
				diceSource.setVisible(true);
				nowPlaying.setText("Now Playing: Dice Music");

			}
		});

		// JButton that plays the music from the Rock Paper Scissors game.
		JButton rockpaperscissors = new JButton("Rock Paper Scissors");
		rockpaperscissors.setBackground(Canvas.buttonColor);
		rockpaperscissors.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		// ActionListener that plays music from the Rock Paper Scissors game. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.
		rockpaperscissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				soundtrackmusic.stop();
				diceMusic.stop();
				canvasMusic.stop();
				gamesMenuMusic.stop();
				cookieClickerMusic.stop();
				rockPaperScissorsmusic.setMicrosecondPosition(0);
				rockPaperScissorsmusic.start();
				rockPaperScissorsSource.setVisible(true);
				nowPlaying.setText("Now Playing: Rock Paper Scissors Music");



			}
		});

		// JButton that plays the music from the Soundtrack window.
		JButton soundtrack = new JButton("JoeFriend Soundtrack");
		soundtrack.setBackground(Canvas.buttonColor);
		soundtrack.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		// ActionListener that plays music from the Soundtrack window. If any other music clips are
		// playing, they will be paused. In case that this music clip has been played before,
		// this actionListener resets the clip for it to be played at the beginning.
		soundtrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				rockPaperScissorsmusic.stop();
				diceMusic.stop();
				canvasMusic.stop();
				gamesMenuMusic.stop();
				cookieClickerMusic.stop();
				soundtrackmusic.setMicrosecondPosition(0);
				soundtrackmusic.start();
				soundtrackSource.setVisible(true);
				nowPlaying.setText("Now Playing: Soundtrack Music");

			}
		});
		soundtrack.setBounds(40, 501, 353, 50);
		panel.add(soundtrack);
		rockpaperscissors.setBounds(40, 147, 353, 50);
		panel.add(rockpaperscissors);
		dice.setBounds(40, 242, 353, 50);
		panel.add(dice);
		canvas.setBounds(40, 330, 353, 50);
		panel.add(canvas);
		gamesMenu.setBounds(40, 587, 353, 50);
		panel.add(gamesMenu);
		cookieClicker.setBounds(40, 418, 353, 50);
		panel.add(cookieClicker);

		// JLabel containing image that is the background for this frame.
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Soundtrack_Extras/bkg.png"));
		background.setBounds(0, 0, 434, 701);
		panel.add(background);

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}