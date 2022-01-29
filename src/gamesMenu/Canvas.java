package gamesMenu;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gamesMenu.ScreenShotConfirmed;

/**
 * A canvas for the user to draw on and take screenshots of their drawings.
 */
public class Canvas extends JFrame implements MouseMotionListener, ActionListener

{

	// Public Fonts and colors used to decorate text and buttons in every game class.
	public static Font mainFont = new Font("Monospaced", Font.BOLD, 15);
	public static Color buttonColor = new Color (209, 225, 255);

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
	 * Constructor for Canvas Class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @throws IOException
	 * @throws AWTException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * @author Sannjay Karthikeyan
	 */
	Canvas() throws IOException, AWTException, UnsupportedAudioFileException, LineUnavailableException {
		
		// Audio file for background music.
		File file = new File ("Canvas_Extras/bkgMusic.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
		// Loops clip continuously until JFrame is exited.
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
		
		// Interface for receiving mouse motions and movements.
		addMouseMotionListener(this);
		
		// JLabel for user instructions.
		JLabel instructions = new JLabel("Draw anywhere! Click the SCREENSHOT button below to take a screenshot. Click the \"Reset Canvas\" button to erase your drawings.");
		this.add(instructions);

		// JButton for user to take a screenshot of their screen.
		JButton SCREENSHOT = new JButton("Screenshot");
		this.add(SCREENSHOT);
		
		// Jbutton to reset the canvas (erases the current drawing on the canvas).
		JButton RESET = new JButton("Reset Canvas");
		this.add(RESET);
		RESET.setBackground(buttonColor);
		RESET.setFont(mainFont);
		
		// Sets the font for the instructions JLabel to Monospaced, Bold, 15pt
		instructions.setFont(new Font("Monospaced", Font.BOLD, 15));
	
		// Sets the background of the SCREENSHOT button to a preferred color used in every JFrame
		SCREENSHOT.setBackground(buttonColor);
		SCREENSHOT.setFont(mainFont);
		
		// JButton to navigate the user back to the home menu.
		JButton BACKTOHOME = new JButton("Back To Home");
		this.add(BACKTOHOME);
		BACKTOHOME.setBackground(buttonColor);
		BACKTOHOME.setFont(mainFont);
		
		// ActionListener that uses the backToHome() method to navigate the user back to the home when button clicked.
		BACKTOHOME.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				
				backToHome(clip);
			
			}

		});
		
		// ActionListener that resets the canvas (erases all drawings).
		RESET.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				getContentPane().invalidate();
				getContentPane().validate();
				getContentPane().repaint();
			
			}

		});
		
		// ActionListener that takes a screenshot of the user's drawing.
		SCREENSHOT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Java robot class used to take a screenshot of the user's display.
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e2) {
					System.out.println("ERROR");
				}

				Rectangle rect = new Rectangle (Toolkit.getDefaultToolkit().getScreenSize());

				// Captures a screenshot of the user's display.
				BufferedImage screenShot = robot.createScreenCapture(rect);


				// ImageIO class used to create a JPG file called "screenshot", that contains a screenshot of the user's drawing.
				try {
					ImageIO.write(screenShot, "JPG", new File ("screenshot.jpg"));
				} catch (IOException e1) {
					System.out.println("ERROR LOADING BACKGROUND.");
				}

				// Opens a confirmation window notifying the user that a screenshot has been successfully taken.
				new ScreenShotConfirmed().setVisible(true);
				new ScreenShotConfirmed().pack();

			}

		});

	}

	/**
	 * mouseDragged method that uses the player's cursor to draw on the canvas.
	 */
	public void mouseDragged(MouseEvent e) {

		Graphics g = getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval(e.getX(), e.getY(), 10, 10);

	}

	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}