package gamesMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;

/**
 * A Cookie Clicker game where the user makes cookies by clicking a button. The more they click, the faster they can make cookies.
 * Multipliers are unlocked at certain intervals, allowing the user to make more cookies in a single click.
 * 
 */
public class CookieClicker extends JFrame implements ActionListener {

	/**
	 * backToHome method used for exiting current JFrame and navigating user to home menu.
	 * @param e
	 */
	public void backToHome() {


		setVisible(false);
		dispose();

	}

	/**
	 * getLastLine method that returns the last line in a text file. 
	 * @param reader
	 * @return
	 * @throws IOException
	 * @author Sannjay Karthikeyan
	 */
	private static String getLastLine(BufferedReader reader) throws IOException {
		String line = null;
		String nextLine;
		while ((nextLine = reader.readLine()) != null) {
			line = nextLine;
		}
		return line;
	}

	// BufferedReader to read data from a text document containing the user's progress in this game.
	public BufferedReader br = new BufferedReader(new FileReader(new File("cookieclickersavedata.txt")));
	
	// BufferedWriter to write data to a text file.
	public BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cookieclickersavedata.txt"), true));

	// Integer variable that contains the number of cookies clicked.
	public int saveData = Integer.parseInt(getLastLine(br));

	public JLabel clicks = new JLabel("Number of Cookies Made");
	
	/**
	 * Constructor for CookieClicker Class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @throws IOException
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws InterruptedException
	 */
	public CookieClicker() throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {

		// Audio file containing background music for the game.
		File file1 = new File("CookieClicker_Extras/bkgMusic.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file1);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		// Audio file containing a sound effect that is played whenever a cookie is clicked.
		File file2 = new File ("CookieClicker_Extras/click.wav");
		AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
		Clip clip2 = AudioSystem.getClip();
		clip2.open(audioStream2);

		// Audio file containing a sound effect that is played whenever the user saves their game.
		File file4 = new File ("CookieClicker_Extras/save.wav");
		AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
		Clip save = AudioSystem.getClip();
		save.open(audioStream4);
		

		// Loops the background music audio file until the program is exited.
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
		

		// JPanel where buttons, JLabels and other items are present.
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 593);
		getContentPane().add(panel);
		getContentPane().setLayout(null);
		panel.setLayout(null);

		// JLabel containing the number of cookies made by the user (number of clicks).
		
		clicks.setForeground(Color.WHITE);
		clicks.setFont(new Font("Monospaced", Font.BOLD, 22));
		clicks.setHorizontalAlignment(SwingConstants.CENTER);
		clicks.setBounds(114, 153, 205, 50);
		panel.add(clicks);

		// Sets text of "clicks" JLabel to the user's progress that was saved in a previous session. If there was no previous 
		//progress made, the number of clicks will be set to 0.
		clicks.setText(String.valueOf(saveData));
		
		// JButton that multiplies the number of cookies made in 1 click by 2x. This button is not visible until the user has reached
		// 50 clicks.
		JButton x2 = new JButton("x2");
		x2.setFont(new Font("Monospaced", Font.BOLD, 15));
		x2.setBounds(56, 513, 89, 23);
		panel.add(x2);
		x2.setVisible(false);

		// JButton that multiplies the number of cookies made in 1 click by 4x. This button is not visible until the user has reached
		// 100 clicks.
		JButton x4 = new JButton("x4");
		x4.setFont(new Font("Monospaced", Font.BOLD, 15));
		x4.setBackground(Canvas.buttonColor);
		x4.setBounds(172, 513, 89, 23);
		panel.add(x4);
		x4.setVisible(false);

		// JButton that multiplies the number of cookies made in 1 click by 6x. This button is not visible until the user has reached
		// 500 clicks.
		JButton x6 = new JButton("x6");
		x6.setFont(new Font("Monospaced", Font.BOLD, 15));
		x6.setBounds(289, 513, 89, 23);
		panel.add(x6);
		x6.setVisible(false);
		
		// JButton that multiplies the number of cookies made in 1 click by 8x. This button is not visible until the user has reached
		// 1000 clicks.
		JButton x8 = new JButton("x8");
		x8.setFont(new Font("Monospaced", Font.BOLD, 15));
		x8.setBounds(115, 547, 89, 23);
		panel.add(x8);
		x8.setVisible(false);

		// JButton that multiplies the number of cookies made in 1 click by 10x. This button is not visible until the user has reached
		// 1500 clicks.
		JButton x10 = new JButton("x10");
		x10.setFont(new Font("Monospaced", Font.BOLD, 15));
		x10.setBounds(234, 547, 89, 23);
		panel.add(x10);
		x10.setVisible(false);

		// JButton that multiplies the number of cookies made in 1 click by 100000x. This button is not visible until the user has reached
		// 5000 clicks.
		JButton x100000 = new JButton("x100000");
		x100000.setFont(new Font("Monospaced", Font.BOLD, 18));
		x100000.setBounds(106, 418, 222, 72);
		x100000.setVisible(false);
		panel.add(x100000);

		// JButton that creates 1 cookie for each click.
		JButton x1 = new JButton("");
		x1.setBackground(Canvas.buttonColor);
		x1.setVerticalAlignment(SwingConstants.BOTTOM);
		x1.setIcon(new ImageIcon("CookieClicker_Extras/cookie.png"));
		x1.setBounds(114, 202, 205, 205);
		panel.add(x1);
		
		// ActionListener to create 1 cookie per click. The default button used in this game.
		x1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				saveData++;
				clicks.setText(String.valueOf(saveData));
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// If the number of cookies made are greater then 50, sets the x2 multiplier to true. The player
				// can now make 2 cookies with 1 click.
				if (saveData >= 50) {


					x2.setVisible(true);

				}

			}
		});

		// JLabel that is the title for this game, "Cookie Clicker".
		JLabel title = new JLabel("Cookie Clicker");
		title.setBackground(Color.CYAN);
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Monospaced", Font.BOLD, 30));
		title.setBounds(70, 104, 293, 50);
		panel.add(title);
		
		// Button used to save progress of current game session.
		JButton saveProgress = new JButton("Save");
		saveProgress.setFont(new Font("Monospaced", Font.BOLD, 15));
		saveProgress.setBounds(129, 56, 190, 34);
		panel.add(saveProgress);

		// Button used to reset progress, making the total number of cookies 0.
		JButton resetProgress = new JButton("Reset Progress");
		resetProgress.setBackground(Canvas.buttonColor);
		resetProgress.setFont(new Font("Monospaced", Font.BOLD, 15));

		// ActionListener to reset game progress. 
		resetProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					// Writes the number "0" to a text file containing the number of cookies clicked.
					bw.write("\n0");
					bw.flush();
				
					// Resets the number of cookies clicked to 0. These changes are reflected in the JLabel containing
					// the number of cookies made.
					saveData = 0;
					clicks.setText(String.valueOf(saveData));
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}

				// If the number of cookies is greater than or equal to 50, make the x2 multiplier visible.
				if (saveData >= 50) {


					x2.setVisible(true);

				// If the above condition is not satisfied, make the x2 mutliplier invisible.
				} else {


					x2.setVisible(false);

				}
				// If the number of cookies is greater than or equal to 100, make the x4 multiplier visible.
				if (saveData >= 100) {


					x4.setVisible(true);


				// If the above condition is not satisfied, make the x4 multiplier invisible.
				} else {


					x4.setVisible(false);
				}

				// If the number of cookies is greater than or equal to 500, make the x6 multiplier visible.
				if (saveData >= 500) {

					x6.setVisible(true);

				// If the above condition is not satified, make the x6 multiplier invisible.
				} else {

					x6.setVisible(false);


				}
				
				// If the number of cookies clicked is greater than or equal to 1000, make the x8 multiplier visible.
				if (saveData >= 1000) {


					x8.setVisible(true);

				// If the above condition is not satisfied, make the x8 multiplier invisible.
				} else {

					x8.setVisible(false);
				}

				// If the number of cookies clicked is greater than or equal to 1500, make the 10x multiplier visible.
				if (saveData >= 1500) {

					x10.setVisible(true);

				// If the above condition is not satisfied, make the x10 multiplier invisible.
				} else {

					x10.setVisible(false);

				}

				// If the number of cookies clicked is greater than or equal to 5000, make the 100000x multiplier visible
				if (saveData >= 5000) {


					x100000.setVisible(true);


				// If the above condition is not satisfied, make the x100000 multiplier invisible.
				} else {

					x100000.setVisible(false);

				}


			}
		});
		
		// Adds the resetProgress button to the JPanel.
		resetProgress.setBounds(234, 11, 190, 34);
		panel.add(resetProgress);

		// Back to Home button that uses the backToHome() method to navigate the user back to the home menu. 
		JButton backHome = new JButton("Back To Home");
		backHome.setBackground(Canvas.buttonColor);
		backHome.setFont(new Font("Monospaced", Font.BOLD, 15));
		backHome.setBounds(10, 11, 194, 34);
		panel.add(backHome);
		
		// ActionListener that invokes the backToHome() method when the backHome button is clicked.
		// Used to navigate the user back to the home menu.
		backHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				backToHome();


			}
		});
	
		// JLabel that is displayed whenever the user saves their progress.
		// This JLabel is invisible by default.
		JLabel confirmation = new JLabel("Progress Saved");
		confirmation.setForeground(Color.WHITE);
		confirmation.setVisible(false);
		confirmation.setBounds(329, 56, 92, 37);
		panel.add(confirmation);

		// JLabel that sets the background of this JFrame.
		JLabel bkg = new JLabel("");
		bkg.setBounds(0, 0, 434, 593);
		panel.add(bkg);
		bkg.setIcon(new ImageIcon("CookieClicker_Extras/bkg.png"));

		
		x2.setBackground(Canvas.buttonColor);
		
		// ActionListener that allows the user to create 2x the cookies in one click.
		x2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// Increases the number of total cookies clicked by 2.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 2;
				clicks.setText(String.valueOf(saveData));


				// If the number of cookies made is greater than or equal to 100, the next multiplier is "unlocked", or
				// made visible for the player to use.
				if (saveData >= 100) {

					x4.setVisible(true);


				}

			}
		});

		// ActionListener that allows the user to create 4x the cookies in one click.
		x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);

				// Increases the number of total cookies clicked by 4.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 4;
				clicks.setText(String.valueOf(saveData));

				// If the number of cookies made is greater than or equal to 500, the next multiplier is "unlocked", or
				// made visible for the player to use.
				if (saveData >= 500) {


					x6.setVisible(true);

				}





			}
		});

		// ActionListener that allows the user to create 4x the cookies in one click.
		x6.setBackground(Canvas.buttonColor);
		x6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// Increases the number of total cookies clicked by 6.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 6;
				clicks.setText(String.valueOf(saveData));

				// If the number of cookies made is greater than or equal to 1000, the next multiplier is "unlocked", or
				// made visible for the player to use.
				if (saveData >= 1000) {


					x8.setVisible(true);

				}
				

			}
		});
		
		// ActionListener that allows the user to create 8x the cookies in one click.
		x8.setBackground(Canvas.buttonColor);
		x8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// Increases the number of total cookies clicked by 8.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 8;
				clicks.setText(String.valueOf(saveData));

				// If the number of cookies made is greater than or equal to 1500, the next multiplier is "unlocked", or
				// made visible for the player to use.
				if (saveData >= 1500) {

					x10.setVisible(true);

				}

			}
		});
		
		// ActionListener that allows the user to create 10x the cookies in one click.
		x10.setBackground(Canvas.buttonColor);
		x10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// Increases the number of total cookies clicked by 10.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 10;
				clicks.setText(String.valueOf(saveData));


				// If the number of cookies made is greater than or equal to 5000, the next multiplier is "unlocked", or
				// made visible for the player to use.
				if (saveData >= 5000) {


					x100000.setVisible(true);

				}

			}
		});
		
		// ActionListener that allows the user to create 100,000x the cookies in one click.
		x100000.setBackground(Canvas.buttonColor);
		x100000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Sound effect that is played whenever a button is clicked.
				clip2.start();
				clip2.setMicrosecondPosition(0);
				
				// Increases the number of total cookies clicked by 10.
				// This change is reflected in the JLabel displaying the number of clicks.
				saveData += 100000;
				clicks.setText(String.valueOf(saveData));




			}
		});
		
		
		saveProgress.setBackground(Canvas.buttonColor);

		// ActionListener that saves the user's progress.
		saveProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				try {
					
					// Writes the current number of cookies made to a text file.
					bw.write("\n" + clicks.getText());
					bw.flush();
					
					// Makes the "Progress saved" confirmation JLabel visible, confirming that the user's progress is saved.
					confirmation.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Sound effect to notify the user that their progress is saved.
				save.start();
				save.setMicrosecondPosition(0);

			}
		});

		// doClick method to automatically click the saveProgress button when the game is launched.
		// This is to ensure that the user's progress is saved. 
		saveProgress.doClick();

		// The following if statements check if certain buttons should be enabled or disabled when the game is launched.
		
		// If the number of cookies is greater than or equal to 50, make the x2 multiplier visible.
		if (saveData >= 50) {


			x2.setVisible(true);


		}

		// If the number of cookies is greater than or equal to 100, make the x4 multiplier visible.
		if (saveData >= 100) {


			x4.setVisible(true);

		// If the number of cookies is greater than or equal to 500, make the x6 multiplier visible.
		} if (saveData >= 500) {


			x6.setVisible(true);

		// If the number of cookies is greater than or equal to 1000, make the x8 multiplier visible.
		} if (saveData >= 1000) {


			x8.setVisible(true);

		// If the number of cookies is greater than or equal to 1500, make the x10 multiplier visible.
		} if (saveData >= 1500) {


			x10.setVisible(true);

		// If the number of cookies is greater than or equal to 5000, make the x100000 multiplier visible.	
		} if (saveData >= 5000) {


			x100000.setVisible(true);

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}