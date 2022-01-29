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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.*;

import javax.swing.*;
import java.nio.charset.Charset;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.io.*;
import java.util.List;
import java.nio.file.Files;
import main.Client;

/**
 * Menu for users to select games to play.
 * Each game is opened in a separate JFrame.
 * @author Sannjay Karthikeyan
 */
public class GamesMenu extends Client implements ActionListener {

	private static final long serialVersionUID = -8593462870219644867L;
	public static List<String> games;
	public static final int NUM_GAMES = 5;

	/**
	 * backToHome method used for exiting current JFrame and navigating user to home menu.
	 * @param e
	 */
	public void backToHome(Clip e) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		e.stop();
		setVisible(false);
		dispose();



	}
	
	/**
	 * Constructor method for creating the games menu
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public GamesMenu() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		getContentPane().setLayout(null);

		// Audio file containing background music for this window.
		File file = new File("GamesMenu_Extras/bkgMusic.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(ABORT);

		// WindowListener method to stop the background music if the window is closed. Prevents the music from being played
		// even after the JFrame is closed.		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				clip.stop();
			}

			public void windowClosing(WindowEvent e) {
				clip.stop();
			}
		});



		// ActionListener for the backToHome button, navigating the user to the home menu.
		// Invokes the backToHome method.
		JButton backHome = new JButton("Back To Home");
		backHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					backToHome(clip);
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
		backHome.setFont(new Font("Monospaced", Font.BOLD, 11));
		backHome.setBackground(Canvas.buttonColor);
		backHome.setBounds(10, 11, 128, 23);
		getContentPane().add(backHome);

		// JLabel containing title for current frame.
		JLabel title = new JLabel("Games");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Magneto", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(135, 37, 164, 82);
		getContentPane().add(title);

		// JLabel containing first set of instructions for the user.
		JLabel instructions1 = new JLabel("Choose a game! Each option will open a new");
		instructions1.setForeground(Color.WHITE);
		instructions1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		instructions1.setHorizontalAlignment(SwingConstants.CENTER);
		instructions1.setBounds(10, 109, 414, 37);
		getContentPane().add(instructions1);

		// JLabel containing second set of instructions for the user.
		JLabel instructions2 = new JLabel(" window to play your chosen game.");
		instructions2.setForeground(Color.WHITE);
		instructions2.setHorizontalAlignment(SwingConstants.CENTER);
		instructions2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		instructions2.setBounds(20, 143, 392, 37);
		getContentPane().add(instructions2);

		// JButton that opens the Canvas game.
		JButton canvas = new JButton("Canvas");
		canvas.setBackground(Canvas.buttonColor);
		canvas.setFont(new Font("Monospaced", Font.BOLD, 25));

		// ActionListener that opens the Canvas frame.
		canvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toCanvas) {

				if (toCanvas.getSource() == canvas) {
					Canvas frame;
					try {
						frame = new Canvas();
						frame.setSize(1260, 600);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						frame.getContentPane().setLayout(new FlowLayout());
						frame.getContentPane().setBackground(Color.WHITE);
						clip.stop();
					} catch (IOException | AWTException
							| UnsupportedAudioFileException
							| LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						checkGames("Canvas");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}



			}
		});
		canvas.setBounds(83, 435, 269, 62);
		getContentPane().add(canvas);

		// JButton that opens the Piano window.
		JButton piano = new JButton("Piano");
		piano.setFont(new Font("Monospaced", Font.BOLD, 25));
		piano.setBackground(Canvas.buttonColor);
		piano.addActionListener(new ActionListener() {

			// ActionListener that opens the Piano frame.
			public void actionPerformed(ActionEvent toPiano) {

				if (toPiano.getSource() == piano) {

					Piano frame;
					try {
						frame = new Piano();
						frame.setSize(1260, 520);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						clip.stop();
					} catch (UnsupportedAudioFileException | IOException
							| LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						checkGames("Piano");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		piano.setBounds(82, 191, 270, 62);
		getContentPane().add(piano);

		// JButton that opens the Rock Paper Scissors game.
		JButton rockpaperscissors = new JButton("Rock Paper Scissors");
		rockpaperscissors.setBackground(Canvas.buttonColor);
		rockpaperscissors.setFont(new Font("Monospaced", Font.BOLD, 20));

		// ActionListener that opens the Rock Paper Scissors frame.
		rockpaperscissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toRPS) {

				if (toRPS.getSource() == rockpaperscissors) {


					RockPaperScissors frame;

					try {
						frame = new RockPaperScissors();
						frame.setSize(550, 780);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						clip.stop();

					} catch (LineUnavailableException
							| UnsupportedAudioFileException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						checkGames("Rock, Paper, Scissors");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}



				}




			}
		});
		rockpaperscissors.setBounds(83, 268, 269, 62);
		getContentPane().add(rockpaperscissors);

		// JButton that opens the Dice game.
		JButton dice = new JButton("Dice (Guess a number)");
		dice.setBackground(Canvas.buttonColor);
		dice.setFont(new Font("Monospaced", Font.BOLD, 18));

		// ActionListener that opens the Dice frame.
		dice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toDice) {


				if (toDice.getSource() == dice) {


					Dice frame;
					try {
						frame = new Dice();
						frame.setSize(450, 405);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						clip.stop();

					} catch (UnsupportedAudioFileException | IOException
							| LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						checkGames("Dice");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}






			}
		});
		dice.setBounds(83, 350, 269, 62);
		getContentPane().add(dice);

		// JButton that opens the Cookie Clicker game.
		JButton cookieclicker = new JButton("Cookie Clicker");
		cookieclicker.setBackground(Canvas.buttonColor);
		cookieclicker.setFont(new Font("Monospaced", Font.BOLD, 20));

		// ActionListener that opens the Cookie Clicker frame.
		cookieclicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * Unlike other ActionListeners present in this class, cookieClicker uses the
				 * EventQueue class to run this game.
				 * This ensures that the Cookie Clicker game will face crashes and bugs rarely,
				 * as running Cookie Clicker without the EventQueue class will cause a significant
				 * amount of errors.
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						CookieClicker frame;
						try {
							frame = new CookieClicker();
							frame.setSize(450, 633);
							frame.setLocationRelativeTo(null);
							frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							frame.setVisible(true);
							frame.getContentPane().setLayout(null);
							clip.stop();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							checkGames("CookieClicker");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});

			}

		});

		cookieclicker.setBounds(83, 518, 269, 62);
		getContentPane().add(cookieclicker);

		// JButton that opens the Soundtrack window.
		JButton soundtrack = new JButton("JoeFriend Soundtrack");

		// ActionListener that opens the Soundtrack window.
		soundtrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toSoundtrack) {

				if (toSoundtrack.getSource() == soundtrack) {

					Soundtrack frame;
					try {
						frame = new Soundtrack();
						frame.setSize(450, 725);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
						clip.stop();
					} catch (UnsupportedAudioFileException | IOException
							| LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}




				}




			}
		});
		soundtrack.setBounds(83, 602, 269, 62);
		soundtrack.setBackground(Canvas.buttonColor);
		soundtrack.setFont(new Font("Monospaced", Font.BOLD, 18));
		getContentPane().add(soundtrack);

		JLabel bkg = new JLabel("");
		bkg.setBounds(0, 0, 435, 763);
		bkg.setIcon(new ImageIcon("GamesMenu_Extras/bkg.png"));
		getContentPane().add(bkg);







	}
	
	/**
	 * Checks for game achievement
	 * @param game
	 * @throws IOException
	 */
	public void checkGames(String game) throws IOException {
		
		//set list as memory
		games = Files.readAllLines(new File("gamesPlayed.txt").toPath(), Charset.defaultCharset() );
				
		//if the current game hasn't been played yet, add it to the list and text file
		FileWriter writer = new FileWriter("gamesPlayed.txt", true);
		if (games.contains(game) == false) {
			games.add(game);
			//store element in memory
			writer.write(game + "\n");
			//if all available games have been played, add an achievement
			if (games.size() == NUM_GAMES+1) {
				notify("Gamers Respawn", "Play all Joe's games.");
				storeAchievement("Games");
			}
		}
		writer.close();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
