package gamesMenu;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Confirms that the user has taken a screenshot of their drawing in the canvas.
 */



public class ScreenShotConfirmed extends JFrame {

	
	public String confirmed = "Screenshot taken. Please check the project folder.     ";
	
	/**
	 * Constructor for ScreenShotConfirmed Class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * @author Sannjay Karthikeyan
	 */
	ScreenShotConfirmed() {

		
		getContentPane().setLayout( new GridBagLayout());

		// Custom dimensions for the JFrame. Ensures that the window will not be shrinked to an 
		// unusable size when invoked in the Piano class.
		Dimension dimens = new Dimension(250, 100);
		this.setPreferredSize(new Dimension(400, 100));

		// JLabel that tells the user that the screenshot has been taken.
		JLabel confirmation = new JLabel(confirmed);
		confirmation.setFont(new Font("Calibri", Font.BOLD, 14));
		getContentPane().add(confirmation, new GridBagConstraints());

		// JButton that confirms the user has viewed this notification.
		JButton ok = new JButton("OK");
		getContentPane().add(ok);
		ok.setBackground(new Color(209, 255, 255));	
		ok.setFont(new Font("Monospaced", Font.BOLD, 11));

		// ActionListener that disposes the current frame when the OK button is clicked.
		ok.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				dispose();
		
			}
		});

		this.pack();

	}
	
}