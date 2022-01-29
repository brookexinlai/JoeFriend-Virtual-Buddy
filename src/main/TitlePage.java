package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * The title page class
 * @author Brooke Xin Lai
 *
 */
public class TitlePage extends Client {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor method for creating title page
	 */
	public TitlePage() {
		
		//set frame settings
		titlepage.setSize(1000, 700);
		titlepage.setLocationRelativeTo(null);
		titlepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		titlepage.setResizable(false);
		titlepage.setVisible(true);
		
		//add background image
		JLabel titleimage = new JLabel();
		titleimage.setBounds(0, 0, 1125, 700);
		titlepage.add(titleimage);
		titleimage.setIcon(new ImageIcon("images/titleimage.jpg"));
		
		//add title image
		JLabel title = new JLabel();
		title.setBounds(325, 50, 600, 200);
		titleimage.add(title);
		title.setIcon(new ImageIcon("images/title.png"));
		
		//create start button
		JButton start = new JButton("Start");
		
		//add action listener
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent toMain) {
				if (toMain.getSource() == start) {
					//create new home object
					Home home = new Home();
					
					//remove title page
					titlepage.setVisible(false);
				}
			}
		});
		
		//set button settings
		start.setBackground(buttonColor);
		start.setBounds(410, 250, 150, 75);
		start.setFont(mainFont);
		
		//add button to background
		titleimage.add(start);
		
		//create guide button
		JButton guide = new JButton ("Guide");
		
		//add action listener
		guide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == guide) {
					
					//create new guide page
					Guide guide = new Guide();
				}
			}
		});
		
		//set button settings
		guide.setBackground(buttonColor);
		guide.setBounds(410, 350, 150, 75);
		guide.setFont(mainFont);
		
		//add button to background
		titleimage.add(guide);
		
		//create achievements button
		JButton achievements = new JButton("Achievements");
		
		//add action listener
		achievements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == achievements) {
					
					//create new achievements page
					Achievements ach = new Achievements();
				}
			}
		});
		
		//set button settings
		achievements.setBackground(buttonColor);
		achievements.setBounds(360, 450, 250, 75);
		achievements.setFont(mainFont);
		
		//add button to background
		titleimage.add(achievements);
		
		//
		JButton leave = new JButton("Leave");
		leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == leave) {
					System.exit(0);
				}
			}
		});
		
		//set button settings
		leave.setBackground(buttonColor);
		leave.setBounds(410, 550, 150, 75);
		leave.setFont(mainFont);
		titleimage.add(leave);
		
		//add credits label
		JLabel credits = new JLabel("<html>By: Saanjay & Brooke<br>Course: ICS-3U7-01<br>Teacher: Ms. Xie</html>");
		credits.setBounds(20, 20, 600, 50);
		titleimage.add(credits);
		
	}
}
