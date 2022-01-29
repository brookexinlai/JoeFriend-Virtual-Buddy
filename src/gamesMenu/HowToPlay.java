package gamesMenu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

/**
 * The how to play class, creates tutorial frame
 *
 */
public class HowToPlay extends JFrame implements ActionListener {
	
	// Title for the instructions frame.
	public JLabel title = new JLabel("Instructions");
	
	// First instruction for users to read.
	public JLabel instructionsone = new JLabel("Click the buttons to play a key!");
	

	// Second instruction for users to read.
	public JLabel instructionstwo = new JLabel("Each key you played will be displayed above the piano.");
	
	// Third instruction for users to read.
	public JLabel instructionsthree = new JLabel("Click \"Make a song\" to save the notes you played.");
	
	// Fourth instruction for user to read.
	public JLabel instructionsfour = new JLabel(" They will be stored in \"Songs.txt\".");
	
	/**
	 * Constructor for HowToPlay class.
	 * Contains JFrames, JPanels, JLabels, JButtons and other elements for this game/window.
	 * Provides a set of instructions for the user when they play the piano. 
	 * Can be accessed via the instructions button in the Piano.
	 * @author Sannjay Karthikeyan
	 */
	public HowToPlay() {
		
		// Custom dimensions for the JFrame. Ensures that the window will not be shrinked to an 
		// unusable size when invoked in the Piano class.
		Dimension dimens = new Dimension(450, 300);
		this.setSize(dimens);
		getContentPane().setLayout(null);
		
		
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Monospaced", Font.BOLD, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(146, 11, 142, 39);
		getContentPane().add(title);
		
		
		instructionsone.setFont(new Font("Monospaced", Font.BOLD, 15));
		instructionsone.setForeground(Color.WHITE);
		instructionsone.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsone.setBounds(49, 54, 327, 23);
		getContentPane().add(instructionsone);
		
		instructionstwo.setForeground(Color.WHITE);
		instructionstwo.setFont(new Font("Monospaced", Font.BOLD, 12));
		instructionstwo.setHorizontalAlignment(SwingConstants.CENTER);
		instructionstwo.setBounds(10, 88, 424, 23);
		getContentPane().add(instructionstwo);
		
		
		instructionsthree.setForeground(Color.WHITE);
		instructionsthree.setFont(new Font("Monospaced", Font.BOLD, 12));
		instructionsthree.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsthree.setBounds(22, 127, 389, 14);
		getContentPane().add(instructionsthree);
		
		// JButton that confirms that the user has read the instructions present in this frame.
		JButton ok = new JButton("OK");
		ok.setFont(new Font("Monospaced", Font.BOLD, 11));
		ok.setBackground(new Color(209, 255, 255));
		
		// ActionListener that disposes the instructions frame when clicked.
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				
			}
		});
		
		ok.setBounds(172, 206, 89, 23);
		getContentPane().add(ok);
		
		
		instructionsfour.setForeground(Color.WHITE);
		instructionsfour.setFont(new Font("Monospaced", Font.BOLD, 12));
		instructionsfour.setHorizontalAlignment(SwingConstants.CENTER);
		instructionsfour.setBounds(0, 156, 434, 23);
		getContentPane().add(instructionsfour);
		
		// Fifth instruction for user to read.
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 434, 261);
		getContentPane().add(background);
		background.setIcon(new ImageIcon("Piano_Extras/smallbkg.png"));
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
