package main;

import gamesMenu.GamesMenu;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The home page class
 * @author Brooke Xin Lai
 *
 */
public class Home extends Client {
	
	private static final long serialVersionUID = 1L;
	public JLabel background = new JLabel();
	public JLabel text = new JLabel();
	public JLabel output = new JLabel();
	private JButton window = new JButton();
	private JButton perms = new JButton();
	private JButton xd = new JButton();
	
	/**
	 * Constructor method for creating a home screen
	 */
	public Home() {
		
		//create home frame
		home.setSize(1000, 700);
		home.setLocationRelativeTo(null);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setResizable(false);
		home.setLayout(null);
		
		//set background image
		background.setBounds(0, 0, 1125, 700);
		background.setIcon(new ImageIcon("images/background.jpg"));
		home.add(background);
		
		//add text box image
		text.setBounds(50, 415, 900, 239);
		text.setIcon(new ImageIcon("images/textbox.png"));
		background.add(text);
		
		//add joe to frame
		JLabel joe = new JLabel();
		joe.setBounds(285, 100, 400, 533);
		joe.setIcon(new ImageIcon("images/joe.png"));
		background.add(joe);
		
		//add initial GUI to frame
		intro();
	}
	
	/**
	 * Adds GUI components to home page when prompted from title page
	 */
	public void intro() {
		
		//set output text
		output.setText("Huh? You! How did you get in my house?");
		output.setBounds(50, 50, 900, 100);
		output.setFont(speechFont);
		text.add(output);
		
		//declare dialogue button
		window = new JButton("I broke your window");
		
		//add action listener
		window.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == window) {
					
					//change text box text
					output.setText("Nice try. I don't have windows. I thrive in the darkness hsss.");
					
					//clear initial buttons
					clearText();
					
					//add new GUI components
					convo();
				}
			}
		});
		
		//set button settings and add to text box
		window.setBackground(buttonColor);
		window.setBounds(80, 140, 175, 50);
		window.setFont(optionFont);
		text.add(window);
		
		//declare dialogue button
		perms = new JButton("You invited me?");
		
		//add action listener
		perms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == perms) {
					
					//change text box text
					output.setText("Lies. I would never invite you.");
					
					//clear initial buttons
					clearText();
					
					//add new GUI components
					convo();
				}
			}
		});
		
		//set button settings and add to text box
		perms.setBackground(buttonColor);
		perms.setBounds(280, 140, 200, 50);
		perms.setFont(optionFont);
		text.add(perms);
		
		//declare dialogue button
		xd = new JButton("XD");
		
		//add action listener
		xd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == xd) {
					
					//change text box to text
					output.setText("???????");
					
					//clear initial buttons
					clearText();
					
					//add new GUI components
					convo();
				}
			}
		});
		
		//set button settings and add to text box
		xd.setBackground(buttonColor);
		xd.setBounds(520, 140, 100, 50);
		xd.setFont(optionFont);
		text.add(xd);
		
		//set home visible
		home.setVisible(true);
	}
	
	/**
	 * Adds main JButtons to home page
	 */
	public void addMenu() {
		
		//create button to go back to menu
		JButton back = new JButton("Back to Menu");
		back.setFont(mainFont);
		back.setBackground(buttonColor);
		back.setBounds(15, 15, 230, 50);
		
		//add action listener
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == back) {
					
					//create new title page
					TitlePage titlepage = new TitlePage();
					
					//dispose current home page
					home.dispose();
				}
			}
		});
		
		//create button to game menu
		JButton games = new JButton("Games");
		games.setFont(mainFont);
		games.setBackground(buttonColor);
		games.setBounds(250, 15, 120, 50);
		
		//add action listener
		games.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == games) {
					try {
						
						//create new game menu
						GamesMenu games = new GamesMenu();
						games.setSize(450, 714);
						games.setLocationRelativeTo(null);
						games.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						games.setVisible(true);
						games.getContentPane().setLayout(null);
						
					} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {	//handle exception
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//create button to generate joke
		JButton jokes = new JButton("Jokes");
		jokes.setFont(mainFont);
		jokes.setBackground(buttonColor);
		jokes.setBounds(380, 15, 120, 50);
		
		//add action listener
		jokes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toJokes) {
				if (toJokes.getSource() == jokes) {
					
					//create new joke
					Joke joke = new Joke();
					
					//output joke
					joke.outputLine();
					
					//remove current version of home page
					home.setVisible(false);
					
					//check joke for achievement
					try {
						joke.checkJoke();
					} catch (IOException e) {	//handle exception
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		//create button to generate pick up line
		JButton pickup = new JButton("Pick-Ups");
		pickup.setFont(mainFont);
		pickup.setBackground(buttonColor);
		pickup.setBounds(510, 15, 150, 50);
		
		//add action listener
		pickup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toPickUp) {
				if (toPickUp.getSource() == pickup) {
					
					//create new pick up line
					PickUp pickup = new PickUp();
					
					//output pick up line
					pickup.outputLine();
					
					//remove current version of home page
					home.setVisible(false);
					
					//check pick up line for achievement
					try {
						pickup.checkPickUp();
					} catch (IOException e) {	//handle exception
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		//create button to generate insult
		JButton insults = new JButton("Insults");
		insults.setFont(mainFont);
		insults.setBackground(buttonColor);
		insults.setBounds(670, 15, 140, 50);
		
		//add action listener
		insults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toInsults) {
					if (toInsults.getSource() == insults) {
						
						//create new insult
						Insult insult = new Insult();
						
						//output insult
						insult.outputLine();
						
						//remove current version of home page
						home.setVisible(false);
						
						//check insult for achievement
						try {
							insult.checkInsults();
						} catch (IOException e) {	//handle exception
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});
		
		
		//create button to run support function
		JButton support = new JButton("Support");
		support.setFont(mainFont);
		support.setBackground(buttonColor);
		support.setBounds(830, 15, 150, 50);
		
		//add action listener
		support.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == support) {
					
					//create new support object
					Support supp = new Support();
					
					//run support function
					supp.runSupport();
					
					//remove current version of home page
					home.dispose();
				}
			}
		});
		
		//add buttons to background image
		background.add(back);
		background.add(games);
		background.add(jokes);
		background.add(pickup);
		background.add(insults);
		background.add(support);
	}
	
	/**
	 * Sets home page version when prompted
	 */
	public void convo() {
		
		//create arrow button
		JButton next = new JButton("->");
		
		//add action listener
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == next) {
					
					//add bottom menu
					options();
					
					//add top menu
					addMenu();
					
					//reset text box text
					output.setText("Anyways, why are you even here? What do you want from me?");
					
					//remove arrow button
					next.setVisible(false);
				}
			}
		});
		
		//set button settings
		next.setBackground(buttonColor);
		next.setBounds(600, 140, 100, 50);
		next.setFont(optionFont);
		
		//add button to text box
		text.add(next);
	}
	
	/**
	 * Adds JButton options to bottom menu of home page
	 */
	public void options() {
		
		//create option button
		JButton song = new JButton("Sing to me");
		
		//add action listener
		song.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == song) {
					
					//create new song
					Song song = new Song("music/joe's_song.wav");
					
					//change text box text
					output.setText("Sure, my dad sang me this song on voicemail once for my birthday.");
					
					//play song
					song.playSong();
					
					//check song for achievement
					try {
						song.checkSong();
					} catch (IOException e1) {		//handle exception
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//set button settings
		song.setBackground(buttonColor);
		song.setBounds(50, 140, 130, 50);
		song.setFont(optionFont);
		
		//add button to text box
		text.add(song);
		
		//create option button
		JButton math = new JButton("Math Help");
		
		//add action listener
		math.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == math) {
					
					//open websites
					try {
						browse("https://www.desmos.com/scientific");
						browse("https://www.desmos.com/calculator");
						browse("https://www.khanacademy.org/math");
						browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
					} catch (URISyntaxException | IOException e1) {		//handle exceptions
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//set button settings
		math.setBackground(buttonColor);
		math.setBounds(210, 140, 100, 50);
		math.setFont(optionFont);
		
		//add button to text box
		text.add(math);
		
		//create option button
		JButton french = new JButton("French Help");
		
		//add action listener
		french.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == french) {
					
					//open websites
					try {
						browse("https://www.wordreference.com/");
						browse("https://translate.google.ca/");
						browse("https://www.khanacademy.org/math");
						browse("https://conjugator.reverso.net/conjugation-french.html");
						browse("https://bonpatron.com/en/");
						browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
					} catch (URISyntaxException | IOException e1) {		//handle exceptions
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//set button settings
		french.setBackground(buttonColor);
		french.setBounds(330, 140, 120, 50);
		french.setFont(optionFont);
		
		//add buttons to background
		text.add(french);
		
		//create option button
		JButton eng = new JButton("English Help");
		
		//add action listener
		eng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == eng) {
					
					//open websites
					try {
						browse("https://www.thesaurus.com/");
						browse("https://www.citationmachine.net/mla/cite-a-website");
						browse("https://www.reverso.net/spell-checker/english-spelling-grammar/");
						browse("https://www.dictionary.com/");
						browse("https://www.sparknotes.com/");
						browse("https://literarydevices.net/cadence/");
						browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
					} catch (URISyntaxException | IOException e1) {		//handle exceptions
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				}
			}
		});
		
		//set button settings
		eng.setBackground(buttonColor);
		eng.setBounds(470, 140, 130, 50);
		eng.setFont(optionFont);
		
		//add button to text box
		text.add(eng);
		
		//create option button
		JButton sci = new JButton("Science Help");
		
		//add action listener
		sci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == sci) {
					
					//open websites
					try {
						browse("https://sites.google.com/site/schweitzerscience/");
						browse("https://www.khanacademy.org/science");
						browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
					} catch (URISyntaxException | IOException e1) {		//handle exceptions
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//set button settings
		sci.setBackground(buttonColor);
		sci.setBounds(620, 140, 120, 50);
		sci.setFont(optionFont);
		
		//add button to text box
		text.add(sci);
		
		//create option button
		JButton ics = new JButton("ICS Help");
		
		//add action listener
		ics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == ics) {
					
					//open websites
					try {
						browse("https://stackoverflow.com/");
						browse("https://docs.oracle.com/javase/7/docs/api/");
						browse("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
					} catch (URISyntaxException | IOException e1) {		//handle exceptions
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//set button settings
		ics.setBackground(buttonColor);
		ics.setBounds(760, 140, 98, 50);
		ics.setFont(optionFont);
		
		//add button to text box
		text.add(ics);
	}
	
	/**
	 * Clears initial buttons from home page
	 */
	public void clearText() {
		window.setVisible(false);
		perms.setVisible(false);
		xd.setVisible(false);
	}
}

