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
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

/**
 * Rock Paper Scissors game.
 * Users can view their number of games won, as well as their winning streak.
 */
public class RockPaperScissors extends JFrame implements ActionListener{

	// String variable containing the results of rock paper scissors match between the computer and the user.
	public String finalResults = "";

	// Integer variable containing the number of games won by the user.
	public int numGamesWon = 0;

	// Integer variable containing the current streak of the user.
	public int streakCount = 0;

	// Integer variable that is a random number bewteen 0 and 2.
	// 0 -> Computer chose rock
	// 1 -> Computer chose paper
	// 2 -> Computer chose scissors
	public int cpuMove = (int)(Math.random() * 3 + 0);
	
	// JLabel containing results of match if the user chose rock as their move.
	private JLabel results_rockPanel;
	private JLabel results_paperPanel;
	private JLabel results_scissorsPanel;
	
	/**
	 * backToHome method used for exiting current JFrame and navigating user to home menu.
	 * @param e
	 */
	public void backToHome(Clip e) {

		e.stop();
		setVisible(false);
		dispose();

	}

	/**
	 * Constructor for RockPaperScissors class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @author Sannjay Karthikeyan
	 */
	public RockPaperScissors() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

		// Audio file containing background music.
		File file = new File("rockPaperScissors_Extras/bkgMusic.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		// Audio file containing sound effect for a game loss.
		File file2 = new File("rockPaperScissors_Extras/youLose.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip youLose = AudioSystem.getClip();
		youLose.open(audioStream2);
		
		// Audio file containing sound effect for a game win.
		File file3 = new File("rockPaperScissors_Extras/youWin.wav");
		AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
		Clip youWin = AudioSystem.getClip();
		youWin.open(audioStream3);

		// Loops background music continuously until JFrame is closed.
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

		// Default fonts and colors used in the current frame.
		Font mainFont = new Font("Monospaced", Font.BOLD, 24);
		Color buttonColor = new Color (209, 225, 255);
		
		// Panel to start the current game.
		JPanel startGame = new JPanel();
		startGame.setBounds(0, 0, 534, 741);
		getContentPane().add(startGame);
		startGame.setLayout(null);

		// JLabel containing title of game.
		JLabel RockPaperScissors = new JLabel("Rock Paper Scissors");
		RockPaperScissors.setFont(new Font("Monospaced", Font.BOLD, 40));
		RockPaperScissors.setForeground(Color.WHITE);
		RockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		RockPaperScissors.setBounds(0, 52, 534, 123);
		startGame.add(RockPaperScissors);

		// Start button used to start game.
		JButton startBtn = new JButton("START");
		startBtn.setBounds(161, 328, 208, 85);
		startGame.add(startBtn);
		startBtn.setBackground(buttonColor);
		startBtn.setFont(mainFont);

		// BackToHome button in the start panel. Navigates user back to Home Menu.
		JButton start_backHome = new JButton("Back To Home");
		start_backHome.setFont(new Font("Monospaced", Font.BOLD, 15));
		start_backHome.setBackground(buttonColor);
		// ActionListener for the backToHome button in the start panel, navigating the user to the home menu.
		// Invokes the backToHome method.
		start_backHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				backToHome(clip);
				
			}
		});
		start_backHome.setBounds(10, 11, 181, 23);
		startGame.add(start_backHome);

		// JLabel containing image of a rock used for decorative purposes and to display user results (only used in the results panel).
		JLabel rockImg = new JLabel(" ");
		rockImg.setHorizontalAlignment(SwingConstants.CENTER);
		rockImg.setBounds(111, 202, 80, 83);
		startGame.add(rockImg);
		rockImg.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));

		// JLabel containing image of a paper used for decorative purposes and to display user results (only used in the results panel).
		JLabel paperImg = new JLabel("paperImg");
		paperImg.setHorizontalAlignment(SwingConstants.CENTER);
		paperImg.setBounds(226, 202, 80, 83);
		startGame.add(paperImg);
		paperImg.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));

		// JLabel containing image of scissors used for decorative purposes and to display user results (only used in the results panel).
		JLabel scissorsImg = new JLabel("scissorsImg");
		scissorsImg.setHorizontalAlignment(SwingConstants.CENTER);
		scissorsImg.setBounds(335, 202, 80, 83);
		startGame.add(scissorsImg);
		scissorsImg.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
		JLabel Background = new JLabel("Background");
		Background.setBounds(0, 0, 534, 741);
		startGame.add(Background);
		Background.setIcon(new ImageIcon("rockPaperScissors_Extras/background.png"));
		
		// Panel that allows user to choose between rock, paper, and scissors.
		JPanel chooseMove = new JPanel();
		getContentPane().add(chooseMove);
		chooseMove.setVisible(false);
		chooseMove.setLayout(null);

		// JLabel containing instructions for user. Present in the chooseMove panel.
		JLabel instructions = new JLabel("Choose your move!");
		instructions.setBounds(0, 89, 534, 83);
		chooseMove.add(instructions);
		instructions.setForeground(Color.WHITE);
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setFont(new Font("Monospaced", Font.BOLD, 45));

		// BackToHome button in the chooseMove panel. Navigates user back to Home Menu.
		JButton btnBackToHome = new JButton("Back To Home");
		btnBackToHome.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnBackToHome.setBackground(buttonColor);
		
		// ActionListener for the backToHome button in the start panel, navigating the user to the home menu.
		// Invokes the backToHome method.
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				backToHome(clip);
				
			}
		});
		btnBackToHome.setBounds(10, 11, 181, 23);
		chooseMove.add(btnBackToHome);

		// JButton for user to choose "Scissors" as their option in the rock paper scissors game.
		JButton scissors = new JButton("Scissors");
		scissors.setBounds(100, 470, 208, 83);
		chooseMove.add(scissors);
		scissors.setHorizontalAlignment(SwingConstants.CENTER);
		scissors.setBackground(buttonColor);
		scissors.setFont(mainFont);

		// JButton for user to choose "Paper" as their option in the rock paper scissors game.
		JButton paper = new JButton("Paper");
		paper.setBounds(100, 349, 207, 83);
		chooseMove.add(paper);
		paper.setHorizontalAlignment(SwingConstants.CENTER);
		paper.setBackground(buttonColor);
		paper.setFont(mainFont);

		// JButton for user to choose "Rock" as their option in the rock paper scissors game.
		JButton rock = new JButton("Rock");
		rock.setHorizontalAlignment(SwingConstants.CENTER);
		rock.setBounds(100, 224, 206, 83);
		chooseMove.add(rock);
		rock.setBackground(buttonColor);
		rock.setFont(mainFont);

		// JLabel containing image of a rock used for decorative purposes and to display user results (only used in the chooseMove and start panel).
		JLabel Rockimg = new JLabel("rockImg");
		Rockimg.setHorizontalAlignment(SwingConstants.CENTER);
		Rockimg.setBounds(330, 244, 80, 83);
		chooseMove.add(Rockimg);
		Rockimg.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));

		// JLabel containing image of a paper used for decorative purposes and to display user results (only used in the chooseMove and start panel).
		JLabel Paperimg = new JLabel("paperImg");
		Paperimg.setBounds(330, 349, 80, 83);
		chooseMove.add(Paperimg);
		Paperimg.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));

		// JLabel containing image of scissors used for decorative purposes and to display user results (only used in the chooseMove and start panel).
		JLabel Scissorsimg = new JLabel("scissorsImg");
		Scissorsimg.setBounds(330, 450, 80, 83);
		chooseMove.add(Scissorsimg);
		Scissorsimg.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));

		// JLabel containing image which is the background of chooseMove panel.
		JLabel bkg = new JLabel("Background");
		bkg.setBounds(0, 0, 534, 741);
		chooseMove.add(bkg);
		bkg.setIcon(new ImageIcon("rockPaperScissors_Extras/background.png"));

		// JPanel that displays game results. Only visible if the user chose rock as their move.
		JPanel rockPanel = new JPanel();
		getContentPane().add(rockPanel);
		rockPanel.setVisible(false);
		rockPanel.setLayout(null);

		// JLabel that shows game resuls in the rock panel.
		results_rockPanel = new JLabel("results");
		results_rockPanel.setForeground(Color.WHITE);
		results_rockPanel.setBounds(0, 80, 534, 99);
		rockPanel.add(results_rockPanel);
		results_rockPanel.setFont(new Font("Monospaced", Font.BOLD, 65));
		results_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JLabel that displays player's move in rockPanel.
		JLabel plrChoice_rockPanel = new JLabel("Your Choice");
		plrChoice_rockPanel.setForeground(Color.WHITE);
		plrChoice_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);
		plrChoice_rockPanel.setBounds(0, 250, 533, 45);
		rockPanel.add(plrChoice_rockPanel);

		// JLabel containing an image that displays player's move in rockPanel.
		JLabel plrChoiceImg_rockPanel = new JLabel("plrChoiceImg");
		plrChoiceImg_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);
		plrChoiceImg_rockPanel.setBounds(70, 310, 80, 83);
		rockPanel.add(plrChoiceImg_rockPanel);
		
		// JLabel present in the middle of results panel. Used for displaying results.
		JLabel versus_rockPanel = new JLabel("VERSUS");
		versus_rockPanel.setForeground(Color.MAGENTA);
		versus_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);
		versus_rockPanel.setBounds(165, 320, 201, 78);
		rockPanel.add(versus_rockPanel);

		// JLabel containing an image that displays computer's move in rockPanel.
		JLabel cpuChoiceImg_rockPanel = new JLabel("cpuChoiceImg");
		cpuChoiceImg_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuChoiceImg_rockPanel.setBounds(380, 310, 80, 83);
		rockPanel.add(cpuChoiceImg_rockPanel);

		// JLabel that displays computer's move in rockPanel.
		JLabel cpuChoice_rockPanel = new JLabel("Computer's Choice");
		cpuChoice_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuChoice_rockPanel.setBounds(0, 430, 533, 45);
		rockPanel.add(cpuChoice_rockPanel);

		// JLabel that displays the number of games won in rockPanel.
		JLabel gamesWon_rockPanel = new JLabel("Games Won: 0");
		gamesWon_rockPanel.setForeground(Color.WHITE);
		gamesWon_rockPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		gamesWon_rockPanel.setBounds(99, 500, 160, 60);
		rockPanel.add(gamesWon_rockPanel);
		gamesWon_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JLabel that displays the current streak of the user.
		JLabel numStreaks_rockPanel = new JLabel("Streaks:");
		numStreaks_rockPanel.setForeground(Color.WHITE);
		numStreaks_rockPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		numStreaks_rockPanel.setBounds(261, 500, 237, 60);
		rockPanel.add(numStreaks_rockPanel);
		numStreaks_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JButton that allows the user to play again.
		JButton btnYes_rockPanel = new JButton("Yes");
		btnYes_rockPanel.setBounds(207, 621, 120, 40);
		rockPanel.add(btnYes_rockPanel);
		btnYes_rockPanel.setBackground(buttonColor);
		btnYes_rockPanel.setFont(mainFont);

		// JButton that exits the game if the user does not want to play.
		JButton btnNo_rockPanel = new JButton("No");
		
		// ActionListener that disposes the current frame if the "No" button is clicked.
		btnNo_rockPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnNo_rockPanel.setBounds(207, 681, 120, 40);
		rockPanel.add(btnNo_rockPanel);
		btnNo_rockPanel.setBackground(buttonColor);
		btnNo_rockPanel.setFont(mainFont);

		// JLabel prompting the user if they want to play again.
		JLabel playAgain_rockPanel = new JLabel("Would you like to play again?");
		playAgain_rockPanel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		playAgain_rockPanel.setForeground(Color.WHITE);
		playAgain_rockPanel.setBounds(99, 560, 341, 60);
		rockPanel.add(playAgain_rockPanel);
		playAgain_rockPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JLabel containing image that is the background for rockPanel.
		JLabel bkg2 = new JLabel("Background2");
		bkg2.setBounds(0, 0, 534, 740);
		rockPanel.add(bkg2);
		bkg2.setIcon(new ImageIcon("rockPaperScissors_Extras/background.png"));

		// JPanel that displays game results. Only visible if the user chose paper as their move.
		JPanel paperPanel = new JPanel();
		getContentPane().add(paperPanel);
		paperPanel.setVisible(false);
		paperPanel.setLayout(null);

		// JLabel that shows game resuls in paperPanel.
		JLabel results_paperPanel = new JLabel("results");
		results_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		results_paperPanel.setFont(new Font("Monospaced", Font.BOLD, 65));
		results_paperPanel.setForeground(Color.WHITE);
		results_paperPanel.setBounds(0, 80, 534, 99);
		paperPanel.add(results_paperPanel);

		// JLabel that displays player's move in paperPanel.
		JLabel plrChoice_paperPanel = new JLabel("Your Choice");
		plrChoice_paperPanel.setForeground(Color.WHITE);
		plrChoice_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		plrChoice_paperPanel.setBounds(0, 250, 533, 45);
		paperPanel.add(plrChoice_paperPanel);

		// JLabel containing image that displays the player's choice.
		JLabel plrChoiceImg_paperPanel = new JLabel("plrChoiceImg");
		plrChoiceImg_paperPanel.setBounds(70, 310, 80, 83);
		paperPanel.add(plrChoiceImg_paperPanel);

		// JLabel present in the middle of results panel. Used for displaying results.
		JLabel versus_paperPanel = new JLabel("VERSUS");
		versus_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		versus_paperPanel.setForeground(Color.MAGENTA);
		versus_paperPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
		versus_paperPanel.setBounds(165, 320, 201, 78);
		paperPanel.add(versus_paperPanel);

		// JLabel that displays computer's move in paperPanel.
		JLabel cpuChoiceImg_paperPanel = new JLabel("cpuChoiceImg");
		cpuChoiceImg_paperPanel.setBounds(380, 310, 80, 83);
		paperPanel.add(cpuChoiceImg_paperPanel);

		// JLabel that displays computer's move in paperPanel.
		JLabel cpuChoice_paperPanel = new JLabel("cpuChoice");
		cpuChoice_paperPanel.setForeground(Color.WHITE);
		cpuChoice_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuChoice_paperPanel.setBounds(0, 430, 533, 45);
		paperPanel.add(cpuChoice_paperPanel);
		cpuChoice_paperPanel.setFont(mainFont);

		// JLabel that displays the number of games won in paperPanel.
		JLabel gamesWon_paperPanel = new JLabel("Games Won: ");
		gamesWon_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		gamesWon_paperPanel.setForeground(Color.WHITE);
		gamesWon_paperPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		gamesWon_paperPanel.setBounds(99, 500, 160, 60);
		paperPanel.add(gamesWon_paperPanel);

		// JLabel that displays the current streak of the user.
		JLabel numStreaks_paperPanel = new JLabel("Streaks:");
		numStreaks_paperPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		numStreaks_paperPanel.setForeground(Color.WHITE);
		numStreaks_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);
		numStreaks_paperPanel.setBounds(261, 500, 237, 60);
		paperPanel.add(numStreaks_paperPanel);

		// JButton that allows the user to play again.
		JButton btnYes_paperPanel = new JButton("Yes");
		
		// ActionListener that sets all game properties (scores, computer/player moves, etc) to their defaults
		// if the user wants to play the game again.
		btnYes_paperPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Resets the final results of the current game.
				finalResults = "";

				// Removes the current results panel and any other results.
				paperPanel.setVisible(false);
				remove(cpuChoice_paperPanel);
				remove(plrChoice_paperPanel);

				// Integer variable cpuMove is the computer's number of choice.
				cpuMove = (int)(Math.random() * 3 + 0);
				finalResults += cpuMove;
				
				remove(paperPanel);
				getContentPane().add(chooseMove);
				chooseMove.setVisible(true);

				// Sound effects are reset so that they can be played more than once.
				youWin.stop();
				youWin.setMicrosecondPosition(0);

				youLose.stop();
				youLose.setMicrosecondPosition(0);

			}
		});
		
		// JButton that continues the game if the user chooses to.
		btnYes_paperPanel.setBounds(207, 621, 120, 40);
		paperPanel.add(btnYes_paperPanel);
		btnYes_paperPanel.setBackground(buttonColor);
		btnYes_paperPanel.setFont(mainFont);

		// JButton that closes the current frame if the user wishes to exit the game.
		JButton btnNo_paperPanel = new JButton("No");
		
		// ActionListener that disposes the current frame if the "No" button is clicked.
		btnNo_paperPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();


			}
		});
		
		
		btnNo_paperPanel.setBounds(207, 681, 120, 40);
		paperPanel.add(btnNo_paperPanel);
		btnNo_paperPanel.setBackground(buttonColor);
		btnNo_paperPanel.setFont(mainFont);

		// JLabel prompting the user if they want to play again.
		JLabel playAgain_paperPanel = new JLabel("Would you like to play again?");
		playAgain_paperPanel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		playAgain_paperPanel.setForeground(Color.WHITE);
		playAgain_paperPanel.setBounds(99, 560, 341, 60);
		paperPanel.add(playAgain_paperPanel);
		playAgain_paperPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JLabel containing image which is the background for paperPanel.
		JLabel bkg3 = new JLabel("Background3");
		bkg3.setBounds(0, 0, 534, 740);
		paperPanel.add(bkg3);
		bkg3.setIcon(new ImageIcon("rockPaperScissors_Extras/background.png"));

		// JPanel that displays game results. Only visible if the user chose scissors as their move.
		JPanel scissorsPanel = new JPanel();
		getContentPane().add(scissorsPanel);
		scissorsPanel.setVisible(false);
		scissorsPanel.setLayout(null);

		// JLabel that shows game results in scissorsPanel.
		JLabel results_scissorsPanel = new JLabel(" ");
		results_scissorsPanel.setBounds(0, 80, 534, 99);
		scissorsPanel.add(results_scissorsPanel);
		results_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		results_scissorsPanel.setFont(new Font("Monospaced", Font.BOLD, 65));
		results_scissorsPanel.setForeground(Color.WHITE);
		results_scissorsPanel.setBounds(0, 80, 534, 99);

		// JLabel that displays player's move in scissorsPanel.
		JLabel plrChoice_scissorsPanel = new JLabel(" ");
		plrChoice_scissorsPanel.setBounds(0, 250, 533, 45);
		scissorsPanel.add(plrChoice_scissorsPanel);
		plrChoice_scissorsPanel.setForeground(Color.WHITE);
		plrChoice_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		plrChoice_scissorsPanel.setBounds(0, 250, 533, 45);
		plrChoice_scissorsPanel.setFont(mainFont);

		// JLabel containing image that displays the player's choice.
		JLabel plrChoiceImg_scissorsPanel = new JLabel("plrChoiceImg");
		plrChoiceImg_scissorsPanel.setBounds(70, 310, 80, 83);
		scissorsPanel.add(plrChoiceImg_scissorsPanel);

		// JLabel present in the middle of results panel. Used for displaying results.
		JLabel versus_scissorsPanel = new JLabel("VERSUS");
		versus_scissorsPanel.setBounds(165, 320, 201, 78);
		scissorsPanel.add(versus_scissorsPanel);
		versus_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		versus_scissorsPanel.setForeground(Color.MAGENTA);
		versus_scissorsPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
		versus_scissorsPanel.setBounds(165, 320, 201, 78);
		scissorsPanel.add(versus_scissorsPanel);

		// JLabel that displays computer's move in scissorsPanel.
		JLabel cpuChoiceImg_scissorsPanel = new JLabel(" ");
		cpuChoiceImg_scissorsPanel.setBounds(380, 310, 80, 83);
		scissorsPanel.add(cpuChoiceImg_scissorsPanel);

		// JLabel that displays computer's move in scissorsPanel.
		JLabel cpuChoice_scissorsPanel = new JLabel("cpuChoice_scissorsPanel");
		cpuChoice_scissorsPanel.setBounds(0, 430, 533, 45);
		scissorsPanel.add(cpuChoice_scissorsPanel);
		cpuChoice_scissorsPanel.setForeground(Color.WHITE);
		cpuChoice_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		cpuChoice_scissorsPanel.setBounds(0, 430, 533, 45);
		cpuChoice_scissorsPanel.setFont(mainFont);

		// JLabel that displays the number of games won in scissorsPanel.
		JLabel gamesWon_scissorsPanel = new JLabel(" ");
		gamesWon_scissorsPanel.setBounds(84, 500, 160, 60);
		scissorsPanel.add(gamesWon_scissorsPanel);
		gamesWon_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		gamesWon_scissorsPanel.setForeground(Color.WHITE);
		gamesWon_scissorsPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		gamesWon_scissorsPanel.setBounds(113, 500, 140, 60);

		// JLabel that displays the current streak of the user.
		JLabel numStreaks_scissorsPanel = new JLabel(" ");
		numStreaks_scissorsPanel.setBounds(261, 500, 237, 60);
		scissorsPanel.add(numStreaks_scissorsPanel);
		numStreaks_scissorsPanel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		numStreaks_scissorsPanel.setForeground(Color.WHITE);
		numStreaks_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		numStreaks_scissorsPanel.setBounds(261, 500, 237, 60);

		// JButton that allows the user to play again.
		JButton btnYes_scissorsPanel = new JButton("Yes");
		
		// ActionListener that sets all game properties (scores, computer/player moves, etc) to their defaults
		// if the user wants to play the game again.
		btnYes_scissorsPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Resets the final results of the current game.
				finalResults = "";

				// Removes the current results panel and any other results.
				scissorsPanel.setVisible(false);
				remove(cpuChoice_scissorsPanel);
				remove(plrChoice_scissorsPanel);

				// Integer variable cpuMove is the computer's number of choice.
				cpuMove = (int)(Math.random() * 3 + 0);
				finalResults += cpuMove;
				remove(scissorsPanel);
				getContentPane().add(chooseMove);
				chooseMove.setVisible(true);

				// Sound effects are reset so that they can be played more than once.
				youWin.stop();
				youWin.setMicrosecondPosition(0);

				youLose.stop();
				youLose.setMicrosecondPosition(0);
			}
		});
		btnYes_scissorsPanel.setBounds(207, 621, 120, 40);
		scissorsPanel.add(btnYes_scissorsPanel);
		btnYes_scissorsPanel.setBackground(buttonColor);
		btnYes_scissorsPanel.setFont(mainFont);

		// JButton that closes the current frame if the user wishes to exit the game.
		JButton btnNo_scissorsPanel = new JButton("No");
		
		// ActionListener that disposes the current frame if the "No" button is clicked.
		btnNo_scissorsPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnNo_scissorsPanel.setBounds(207, 681, 120, 40);
		scissorsPanel.add(btnNo_scissorsPanel);
		btnNo_scissorsPanel.setBackground(buttonColor);
		btnNo_scissorsPanel.setFont(mainFont);

		// JLabel prompting the user if they want to play again.
		JLabel playAgain_scissorsPanel = new JLabel("Would you like to play again?");
		playAgain_scissorsPanel.setBounds(99, 560, 341, 60);
		scissorsPanel.add(playAgain_scissorsPanel);
		playAgain_scissorsPanel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		playAgain_scissorsPanel.setForeground(Color.WHITE);
		playAgain_scissorsPanel.setBounds(99, 560, 341, 60);
		playAgain_scissorsPanel.setHorizontalAlignment(SwingConstants.CENTER);

		// JLabel containing image which is the background for scissorsPanel.
		JLabel bkg4 = new JLabel("bkg4");
		bkg4.setBounds(0, 0, 534, 741);
		scissorsPanel.add(bkg4);
		bkg4.setIcon(new ImageIcon("rockPaperScissors_Extras/background.png"));
		versus_rockPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
		cpuChoice_rockPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
		
		/*
		 * If-else statement to determine the computer's choice. If the random integer variable cpuMove equals 0, the number 0 is appended to the String variable finalResults.
		 * finalResults stores both the computer and user's choice for each match. The first character in the String variable final results represents the computer's move.
		 * The second character in this variable represents the player's move.
		 * 0 -> Rock
		 * 1 -> Paper
		 * 2 -> Scissors
		 */
		if (cpuMove == 0) {

			finalResults += "0";


		} else if (cpuMove == 1) {


			finalResults += "1";


		} else {


			finalResults += "2";

		}

		// AcitonListener for startBtn that removes the startGame panel and allows the user to choose a move by adding the chooseMove panel.
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toLeave) {
				startGame.setVisible(false);

				remove(startGame);
				getContentPane().add(chooseMove);
				chooseMove.setVisible(true);

			}
		});



		// ActionListener for the rock button. The commands in actionPerformed() below are invoked
		// if the user has chosen rock as their move of choice.
		rock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toLeave) {
				
				// Removes chooseMovePanel, adds rockPanel and other necessary JLabels, JButtons and items.
				chooseMove.setVisible(false);
				getContentPane().remove(chooseMove);
				getContentPane().add(rockPanel);
				rockPanel.setVisible(true);
				plrChoice_rockPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
				int usrChoice = Integer.parseInt(String.valueOf(finalResults.charAt(0)));
				plrChoice_rockPanel.setText("Your Move: Rock");


				// If-else-if-statement to display the user's result, based on the move they chose.
				if (usrChoice == 0) {

					// Displays the result of the game.
					results_rockPanel.setText("Tie!");
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					numGamesWon++;
					gamesWon_rockPanel.setText("Games Won: " + numGamesWon);
					streakCount++;
					numStreaks_rockPanel.setText("Streak: " + streakCount);
					
					// Displays the choices made by the user and the computer.
					cpuChoice_rockPanel.setText("Computer's Move: Rock");
					results_rockPanel.setForeground(Color.GREEN);
					cpuChoice_rockPanel.setForeground(Color.WHITE);
					plrChoice_rockPanel.setForeground(Color.WHITE);
					cpuChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					plrChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					youWin.start();





				} else if (usrChoice == 1) {

					// Displays the result of the game.
					results_rockPanel.setText("You Lost!");
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streakCount = 0;
					
					// Displays the choices made by the user and the computer.
					numStreaks_rockPanel.setText("Streak: " + streakCount);
					cpuChoice_rockPanel.setText("Computer's Move: Paper");
					results_rockPanel.setForeground(Color.CYAN);
					cpuChoice_rockPanel.setForeground(Color.WHITE);
					plrChoice_rockPanel.setForeground(Color.PINK);
					cpuChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					plrChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					youLose.start();



				} else {

					// Displays the result of the game.
					results_rockPanel.setText("You Won!");
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					numGamesWon++;
					gamesWon_rockPanel.setText("Games Won: " + numGamesWon);
					streakCount++;
					numStreaks_rockPanel.setText("Streak: " + streakCount);
					
					// Displays the choices made by the user and the computer.
					cpuChoice_rockPanel.setText("Computer's Move: Scissors");
					results_rockPanel.setForeground(Color.GREEN);
					cpuChoice_rockPanel.setForeground(Color.PINK);
					plrChoice_rockPanel.setForeground(Color.WHITE);
					cpuChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					plrChoiceImg_rockPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					youWin.start();


				}


			}
		});

		// ACTIONLISTENERS FOR "PAPER" and "SCISSORS" BUTTONS PERFORM THE SAME FUCNTION AS BUTTON NUMBER 1
	
		// ActionListener for the paper button. The commands in actionPerformed() below are invoked
		// if the user has chosen paper as their move.
		paper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toLeave) {
				chooseMove.setVisible(false);

				getContentPane().remove(chooseMove);
				getContentPane().add(paperPanel);
				paperPanel.setVisible(true);
				plrChoice_paperPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
				int usrChoice = Integer.parseInt(String.valueOf(finalResults.charAt(0)));
				plrChoice_paperPanel.setText("Your Move: Paper");


				if (usrChoice == 0) {

					results_paperPanel.setText("You Win!");
					numGamesWon++;
					gamesWon_paperPanel.setText("Games Won: " + numGamesWon);
					streakCount++;
					numStreaks_paperPanel.setText("Streak: " + streakCount);
					cpuChoice_paperPanel.setText("Computer's Move: Rock");
					results_paperPanel.setForeground(Color.GREEN);
					cpuChoice_paperPanel.setForeground(Color.PINK);
					plrChoice_paperPanel.setForeground(Color.WHITE);
					cpuChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					plrChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					youWin.start();





				} else if (usrChoice == 1) {

					results_paperPanel.setText("Tie!");
					numGamesWon++;
					streakCount++;
					numStreaks_paperPanel.setText("Streak: " + streakCount);
					cpuChoice_paperPanel.setText("Computer's Move: Paper");
					results_paperPanel.setForeground(Color.GREEN);
					cpuChoice_paperPanel.setForeground(Color.WHITE);
					plrChoice_paperPanel.setForeground(Color.WHITE);
					cpuChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					plrChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					youWin.start();



				} else {

					results_paperPanel.setText("You Lost!");

					gamesWon_paperPanel.setText("Games Won: " + numGamesWon);
					streakCount = 0;
					numStreaks_paperPanel.setText("Streak: " + streakCount);
					cpuChoice_paperPanel.setText("Computer's Move: Scissors");
					results_paperPanel.setForeground(Color.CYAN);
					cpuChoice_paperPanel.setForeground(Color.WHITE);
					plrChoice_paperPanel.setForeground(Color.PINK);
					cpuChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					plrChoiceImg_paperPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					youLose.start();


				}


			}



		});

		// ACTIONLISTENERS FOR "SCISSORS" BUTTONS PERFORM THE SAME FUCNTION AS BUTTON NUMBER 1
		
		// ActionListener for the scissors button. The commands in actionPerformed() below are invoked
		// if the user has chosen scissors as their move.
		scissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toLeave) {
				chooseMove.setVisible(false);

				getContentPane().remove(chooseMove);
				getContentPane().add(scissorsPanel);
				scissorsPanel.setVisible(true);
				plrChoice_scissorsPanel.setFont(new Font("Monospaced", Font.BOLD, 30));
				int usrChoice = Integer.parseInt(String.valueOf(finalResults.charAt(0)));
				plrChoice_scissorsPanel.setText("Your Move: Scissors");


				if (usrChoice == 0) {

					results_scissorsPanel.setText("You Lost!");
					gamesWon_scissorsPanel.setText("Games Won: " + numGamesWon);
					streakCount = 0;
					
					numStreaks_scissorsPanel.setText("Streak: " + streakCount);
					cpuChoice_scissorsPanel.setText("Computer's Move: Rock");
					results_scissorsPanel.setForeground(Color.CYAN);
					cpuChoice_scissorsPanel.setForeground(Color.WHITE);
					plrChoice_scissorsPanel.setForeground(Color.PINK);
					cpuChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					plrChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/rockImg.png"));
					youLose.start();





				} else if (usrChoice == 1) {

					results_scissorsPanel.setText("You Win!");
					streakCount++;
					numGamesWon++;
					gamesWon_scissorsPanel.setText("Games Won: " + numGamesWon);
					
					numStreaks_scissorsPanel.setText("Streak: " + streakCount);
					cpuChoice_scissorsPanel.setText("Computer's Move: Paper");
					results_scissorsPanel.setForeground(Color.GREEN);
					cpuChoice_scissorsPanel.setForeground(Color.PINK);
					plrChoice_scissorsPanel.setForeground(Color.WHITE);
					cpuChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					plrChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/paperImg.png"));
					youWin.start();



				} else {

					results_scissorsPanel.setText("Tie!");
					numGamesWon++;
					gamesWon_scissorsPanel.setText("Games Won: " + numGamesWon);
					streakCount++;
					numStreaks_scissorsPanel.setText("Streak: " + streakCount);
					cpuChoice_scissorsPanel.setText("Computer's Move: Scissors");
					results_scissorsPanel.setForeground(Color.GREEN);
					cpuChoice_scissorsPanel.setForeground(Color.WHITE);
					plrChoice_scissorsPanel.setForeground(Color.WHITE);
					cpuChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					plrChoiceImg_scissorsPanel.setIcon(new ImageIcon("rockPaperScissors_Extras/scissorsImg.png"));
					youWin.start();


				}


			}


		});

		// ActionListener that sets all game properties (scores, computer/player moves, etc) to their defaults
		// if the user wants to play the game again.
				
		btnYes_rockPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toLeave) {

				// resets the finalResutls panel containing the 
				finalResults = "";
				
				
				// removes the result panel and adds the chooseMove panel.
				rockPanel.setVisible(false);
				remove(cpuChoice_rockPanel);
				remove(plrChoice_rockPanel);
				remove(rockPanel);
				getContentPane().add(chooseMove);
				chooseMove.setVisible(true);

				// Integer variable cpuMove is the computer's number of choice. This is reset for future games.
				cpuMove = (int)(Math.random() * 3 + 0);
				finalResults += cpuMove;
				
				// Sound effects are reset so that they can be played more than once.
				youWin.stop();
				youWin.setMicrosecondPosition(0);

				youLose.stop();
				youLose.setMicrosecondPosition(0);

			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
}