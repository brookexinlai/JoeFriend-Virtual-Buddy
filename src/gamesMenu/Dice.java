package gamesMenu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

/**
 * A dice game where the users guess a number between 1-6.
 * If the number they chose is the same number chosen by the computer, they win.
 * Otherwise, they lose.
 */
public class Dice extends JFrame implements ActionListener {
	public int cpuMove = 1 + (int)(Math.random() * ((6 - 1) + 1));	
	public int streaksNum, gamesWonNum;

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
	 * Constructor for Dice class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @author Sannjay Karthikeyan
	 */
	public Dice() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		// Audio file containing background music for the game.
		File file = new File("Dice_Extras/bkgMusic.wav");
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

		// Audio file containing a sound effect that is played whenever the user has lost a game.
		File file2 = new File("Dice_Extras/youLose.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip youLose = AudioSystem.getClip();
		youLose.open(audioStream2);

		// Audio file containing a sound effect that is played whenever the user has won a game.
		File file3 = new File("Dice_Extras/youWin.wav");
		AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
		Clip youWin = AudioSystem.getClip();
		youWin.open(audioStream3);
		getContentPane().setLayout(null);

		// JPanel that displays the result of a game between a computer and the player.
		JPanel result = new JPanel();
		result.setBounds(0, 0, 434, 369);
		result.setVisible(false);

		// JPanel that displays the START button at the beginning of the game.
		JPanel start = new JPanel();
		start.setBounds(0, 0, 434, 369);
		getContentPane().add(start);
		start.setLayout(null);

		// JButton used to start the game.
		JButton startBtn = new JButton("START");
		startBtn.setFont(new Font("Monospaced", Font.BOLD, 15));
		startBtn.setBackground(new Color(209, 255, 255));
		startBtn.setBounds(174, 168, 86, 32);
		start.add(startBtn);

		// JButton present in the start panel. Navigates the user back to the home menu.
		JButton start_BackToHomeBtn = new JButton("Back To Home");
		start_BackToHomeBtn.setBounds(10, 11, 159, 32);
		start_BackToHomeBtn.setBackground(new Color(209, 255, 255));
		start_BackToHomeBtn.setFont(new Font("Monospaced", Font.BOLD, 15));
		start.add(start_BackToHomeBtn);

		// Background used in the start JPanel.
		JLabel startBkg = new JLabel("");
		startBkg.setBounds(0, 0, 434, 369);
		start.add(startBkg);
		startBkg.setIcon(new ImageIcon("Dice_Extras/bkg.png"));

		// JPanel that allows the user to choose a number between 1 and 6.
		JPanel guess = new JPanel();
		guess.setBounds(0, 0, 434, 369);
		guess.setLayout(null);
		
		// JLabel containing instructions for the guess panel.
		JLabel guessNum = new JLabel("Guess a number.");
		guessNum.setForeground(Color.CYAN);
		guessNum.setBackground(Color.CYAN);
		guessNum.setFont(new Font("Monospaced", Font.BOLD, 30));
		guessNum.setHorizontalAlignment(SwingConstants.CENTER);
		guessNum.setBounds(28, 69, 377, 60);
		guess.add(guessNum);

		// JButton present in the guess panel. Navigates the user back to the home menu.
		JButton guess_BackToHomeBtn = new JButton("Back To Home");
		guess_BackToHomeBtn.setBounds(10, 11, 159, 32);
		guess.add(guess_BackToHomeBtn);
		guess_BackToHomeBtn.setBackground(new Color(209, 255, 255));
		guess_BackToHomeBtn.setFont(new Font("Monospaced", Font.BOLD, 15));

		// JButton that allows the user to choose 1 as their number of choice.
		JButton one = new JButton("1");
		one.setFont(new Font("Monospaced", Font.BOLD, 13));
		one.setBounds(25, 172, 45, 25);
		one.setBackground(new Color(209, 255, 255));
		guess.add(one);

		// JButton that allows the user to choose 2 as their number of choice.
		JButton two = new JButton("2");
		two.setFont(new Font("Monospaced", Font.BOLD, 13));
		two.setBounds(94, 172, 45, 25);
		two.setBackground(new Color(209, 255, 255));
		guess.add(two);

		// JButton that allows the user to choose 3 as their number of choice.
		JButton three = new JButton("3");
		three.setFont(new Font("Monospaced", Font.BOLD, 13));
		three.setBounds(161, 172, 45, 25);
		three.setBackground(new Color(209, 255, 255));
		guess.add(three);

		// JButton that allows the user to choose 4 as their number of choice.
		JButton four = new JButton("4");
		four.setFont(new Font("Monospaced", Font.BOLD, 13));
		four.setBounds(232, 172, 45, 25);
		four.setBackground(new Color(209, 255, 255));
		guess.add(four);

		// JButton that allows the user to choose 5 as their number of choice.
		JButton five = new JButton("5");
		five.setFont(new Font("Monospaced", Font.BOLD, 13));
		five.setBounds(297, 172, 45, 25);
		five.setBackground(new Color(209, 255, 255));
		guess.add(five);

		// JButton that allows the user to choose 6 as their number of choice.
		JButton six = new JButton("6");
		six.setFont(new Font("Monospaced", Font.BOLD, 13));
		six.setBounds(363, 172, 45, 25);
		six.setBackground(new Color(209, 255, 255));
		guess.add(six);

		// Background used in the guess JPanel.
		JLabel guessBkg = new JLabel("");
		guessBkg.setBounds(0, 0, 434, 369);
		guess.add(guessBkg);
		guessBkg.setIcon(new ImageIcon("Dice_Extras/bkg.png"));

		// JLabel containing the results of the game, which is either "You Won!" or "You Lost".
		JLabel theResult = new JLabel("result");
		theResult.setForeground(Color.CYAN);
		theResult.setFont(new Font("Monospaced", Font.BOLD, 30));
		theResult.setBounds(126, 40, 181, 40);
		theResult.setHorizontalAlignment(SwingConstants.CENTER);
		result.add(theResult);

		// JLabel as an image showing the user's number of choice as a dice.
		JLabel plrChoiceImg = new JLabel("");
		plrChoiceImg.setBounds(58, 126, 100, 100);
		result.add(plrChoiceImg);

		// JLabel as an image showing the computer's number of choice as a dice.
		JLabel cpuChoiceImg = new JLabel("");
		cpuChoiceImg.setBounds(274, 126, 100, 100);
		result.add(cpuChoiceImg);

		// JLabel showing the user's number of choice as a message.
		JLabel plrChoiceNum = new JLabel("plrChoiceNum");
		plrChoiceNum.setForeground(Color.WHITE);
		plrChoiceNum.setFont(new Font("Monospaced", Font.BOLD, 14));
		plrChoiceNum.setHorizontalAlignment(SwingConstants.CENTER);
		plrChoiceNum.setBounds(20, 100, 143, 15);
		result.add(plrChoiceNum);

		// JLabel showing the computer's number of choice as a mesage.
		JLabel cpuChoiceNum = new JLabel("cpuChoiceNum");
		cpuChoiceNum.setForeground(Color.WHITE);
		cpuChoiceNum.setFont(new Font("Monospaced", Font.BOLD, 14));
		cpuChoiceNum.setHorizontalAlignment(SwingConstants.CENTER);
		cpuChoiceNum.setBounds(243, 100, 163, 15);
		result.add(cpuChoiceNum);

		// JLabel prompting the user if they would like to play again.
		JLabel playAgain = new JLabel("Would you like to play again?");
		playAgain.setFont(new Font("Monospaced", Font.BOLD, 16));
		playAgain.setForeground(Color.WHITE);
		playAgain.setHorizontalAlignment(SwingConstants.CENTER);
		playAgain.setBounds(54, 263, 325, 40);
		result.add(playAgain);

		// JLabel that displays the word "VS" in the middle of the guess panel.
		JLabel versus = new JLabel("VS");
		versus.setFont(new Font("Monospaced", Font.BOLD, 30));
		versus.setHorizontalAlignment(SwingConstants.CENTER);
		versus.setForeground(new Color(255, 255, 255));
		versus.setBounds(167, 134, 100, 100);
		result.add(versus);

		// JLabel displaying the amount of games won by the user in the current session (while this JFrame 
		// was open).
		JLabel gamesWon = new JLabel("Games Won: ");
		gamesWon.setForeground(Color.WHITE);
		gamesWon.setFont(new Font("Monospaced", Font.BOLD, 12));
		gamesWon.setHorizontalAlignment(SwingConstants.CENTER);
		gamesWon.setBounds(0, 0, 163, 35);
		result.add(gamesWon);

		// JLabel displaying the current game wining streak in the current session (while this JFrame was open).
		JLabel streak = new JLabel("Streak: ");
		streak.setForeground(Color.WHITE);
		streak.setFont(new Font("Monospaced", Font.BOLD, 12));
		streak.setHorizontalAlignment(SwingConstants.CENTER);
		streak.setBounds(271, 0, 163, 35);
		result.add(streak);

		// JButton that allows the user to play the game again.
		JButton yes = new JButton("Yes");
		yes.setFont(new Font("Monospaced", Font.BOLD, 12));
		yes.setBounds(210, 314, 84, 25);
		result.add(yes);

		// JButton that allows the user to exit the game if they wish to.
		JButton no = new JButton("No");
		no.setFont(new Font("Monospaced", Font.BOLD, 12));
		no.setBounds(110, 314, 84, 25);
		result.add(no);

		// ActionListener for the start button, that removes the start panel and add the guess panel, allowing
		// the user to choose a number.
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				start.setVisible(false);

				getContentPane().remove(start);
				getContentPane().add(guess);

			}
		});
		
		// ActionListener for the backToHome button in the start panel, navigating the user to the home menu.
		// Invokes the backToHome method.
		start_BackToHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// "clip" is used as a parameter to stop the current background music.
				backToHome(clip);

			}
		});
		
		// ActionListener for the backToHome button in the guess panel, navigating the user to the home menu.
		// Invokes the backToHome method.
		guess_BackToHomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				backToHome(clip);

			}
		});

		// ActionListener for the one button. The commands in actionPerformed() below are invoked
		// if the user has chosen 1 as their number of choice.
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// If-else-if statement to display the user's result, based on the number they chose.
				if (cpuMove == 1) {

					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Won!");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					
					// Sound effect to tell the user that they won/lost.
					youWin.start();


				} else if (cpuMove == 2) {

					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Lost");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));

					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
				
					// Sound effect to tell the user that they won/lost.
					youLose.start();


				} else if (cpuMove == 3) {

					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Lost");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					
					// Sound effect to tell the user that they won/lost.
					youLose.start();

				} else if (cpuMove == 4) {

					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Lost");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					
					// Sound effect to tell the user that they won/lost.
					youLose.start();

				} else if (cpuMove == 5) {

					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Lost");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					
					// Sound effect to tell the user that they won/lost.
					youLose.start();


				} else if (cpuMove == 6) {


					// Removes the guess panel and adds the result panel for the user to view their result.
					remove(guess);
					getContentPane().add(result);
					
					// Displays the result of the game.
					result.setVisible(true);
					theResult.setText("You Lost");
					
					// Displays the choices made by the user and the computer.
					plrChoiceNum.setText("Your Choice: 1");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					
					// If the user won a game, the streak count and number of games won increases.
					// Otherwise, the amount of games won stays the same. This change is reflected
					// in the results panel.
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					
					// Sound effect to tell the user that they won/lost.
					youLose.start();


				}

			}
		});
		getContentPane().add(result);
		result.setLayout(null);

		// Background image used in the results panel.
		JLabel resultBkg = new JLabel("");
		resultBkg.setBounds(0, 0, 434, 369);
		result.add(resultBkg);
		resultBkg.setIcon(new ImageIcon("Dice_Extras/bkg.png"));

		// ACTIONLISTENERS FOR BUTTONS NUMBERED 2 TO 6 PERFORM THE SAME FUCNTION AS BUTTON NUMBER 1
		
		// ActionListener for the two button. The commands in actionPerformed() below are invoked
		// if the user has chosen 2 as their number of choice.
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (cpuMove == 1) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					youLose.start();


				} else if (cpuMove == 2) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Won!");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					youWin.start();



				} else if (cpuMove == 3) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					youLose.start();

				} else if (cpuMove == 4) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					youLose.start();

				} else if (cpuMove == 5) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					youLose.start();

				} else if (cpuMove == 6) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 2");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					youLose.start();

				}



			}
		});

		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (cpuMove == 1) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					youLose.start();


				} else if (cpuMove == 2) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					youLose.start();

				} else if (cpuMove == 3) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Won!");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					youWin.start();

				} else if (cpuMove == 4) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					youLose.start();

				} else if (cpuMove == 5) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					youLose.start();


				} else if (cpuMove == 6) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 3");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					youLose.start();

				}


			}
		});

		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				if (cpuMove == 1) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					youLose.start();

				} else if (cpuMove == 2) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					youLose.start();

				} else if (cpuMove == 3) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					youLose.start();

				} else if (cpuMove == 4) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Won!");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					youWin.start();

				} else if (cpuMove == 5) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					youLose.start();

				} else if (cpuMove == 6) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 4");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					youLose.start();

				}

			}
		});

		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				if (cpuMove == 1) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					youLose.start();

				} else if (cpuMove == 2) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					youLose.start();

				} else if (cpuMove == 3) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					youLose.start();


				} else if (cpuMove == 4) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					youLose.start();

				} else if (cpuMove == 5) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Won!");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					youWin.start();

				} else if (cpuMove == 6) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 5");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					youLose.start();

				}




			}
		});


		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (cpuMove == 1) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/1.png"));
					youLose.start();

				} else if (cpuMove == 2) {


					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/2.png"));
					youLose.start();

				} else if (cpuMove == 3) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/3.png"));
					youLose.start();

				} else if (cpuMove == 4) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/4.png"));
					youLose.start();

				} else if (cpuMove == 5) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Lost");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum = 0;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/5.png"));
					youLose.start();


				} else if (cpuMove == 6) {

					remove(guess);
					getContentPane().add(result);
					result.setVisible(true);
					theResult.setText("You Won!");
					plrChoiceNum.setText("Your Choice: 6");
					cpuChoiceNum.setText("Computer's Choice: " + cpuMove);
					streaksNum++;
					gamesWonNum++;
					streak.setText("Streak: " + streaksNum);
					gamesWon.setText("Games Won: " + gamesWonNum);
					plrChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					cpuChoiceImg.setIcon(new ImageIcon("Dice_Extras/6.png"));
					youWin.start();

				}

			}
		});

		// ActionListener that sets all game properties (scores, computer/player moves, etc) to their defaults
		// if the user wants to play the game again.
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// removes the result panel and adds the guess panel.
				result.setVisible(false);
				getContentPane().remove(result);
				getContentPane().add(guess);
				
				
				// Integer variable cpuMove is the computer's number of choice.
				cpuMove = 1 + (int)(Math.random() * ((6 - 1) + 1));
				
				// Sound effects are reset so that they can be played more than once.
				youWin.stop();
				youWin.setMicrosecondPosition(0);

				youLose.stop();
				youLose.setMicrosecondPosition(0);

			}
		});

		// ActionListener that disposes the current frame if the user does not want to play again.
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}