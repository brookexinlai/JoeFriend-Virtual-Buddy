package main;

import javax.swing.*;
/**
 * Class for the achievements page
 * @author Brooke Xin Lai
 *
 */
public class Achievements extends Client {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for creating the achievements page
	 */
	public Achievements() {
		
		//set jframe settings
		achievements.setSize(1000, 850);
		achievements.setLocationRelativeTo(null);
		achievements.setResizable(false);
		achievements.setVisible(true);
		
		//add background image
		JLabel bck = new JLabel();
		bck.setBounds(0, 0, 1000, 850);
		achievements.add(bck);
		bck.setIcon(new ImageIcon("images/bck.png"));
		
		//add joke achievement
		JLabel allJokes = new JLabel("Ha! That's funny!");
		allJokes.setFont(mainFont);
		allJokes.setBounds(80, 10, 250, 100);
		bck.add(allJokes);
		
		//add joke achievement description
		JLabel jokesDesc = new JLabel("Hear all of Joe's jokes.");
		jokesDesc.setFont(speechFont);
		jokesDesc.setBounds(80, 50, 300, 100);
		bck.add(jokesDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("Jokes")) {
			JLabel star1 = new JLabel();
			star1.setBounds(280, 100, 100, 108);
			bck.add(star1);
			star1.setIcon(new ImageIcon("images/star.png"));
		}
		
		//add insult achievement
		JLabel allInsults = new JLabel("Ouch...");
		allInsults.setFont(mainFont);
		allInsults.setBounds(80, 280, 300, 100);
		bck.add(allInsults);
		
		//add insult achievement description
		JLabel insultsDesc = new JLabel("Hear all of Joe's insults.");
		insultsDesc.setFont(speechFont);
		insultsDesc.setBounds(80, 320, 300, 100);
		bck.add(insultsDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("Insults")) {
			JLabel star2 = new JLabel();
			star2.setBounds(280, 370, 100, 108);
			bck.add(star2);
			star2.setIcon(new ImageIcon("images/star.png"));
		}
		
		//add pick up line achievement
		JLabel allLines = new JLabel("<html>Are you flirting<br/>with me???</html>");
		allLines.setFont(mainFont);
		allLines.setBounds(80, 560, 300, 90);
		bck.add(allLines);
		
		//add pick up line achievement description
		JLabel linesDesc = new JLabel("<html>Hear all of Joe's<br/>pick-up lines.</html>");
		linesDesc.setFont(speechFont);
		linesDesc.setBounds(80, 630, 300, 100);
		bck.add(linesDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("PickUps")) {
			JLabel star3 = new JLabel();
			star3.setBounds(280, 650, 100, 108);
			bck.add(star3);
			star3.setIcon(new ImageIcon("images/star.png"));
		}
		
		//add game achievement
		JLabel allGames = new JLabel("<html>Gamers Don't Die,<br/>They Respwan</html>");
		allGames.setFont(mainFont);
		allGames.setBounds(490, 20, 300, 100);
		bck.add(allGames);
		
		//add game achievement description
		JLabel gamesDesc = new JLabel("Play all of Joe's games.");
		gamesDesc.setFont(speechFont);
		gamesDesc.setBounds(490, 80, 300, 100);
		bck.add(gamesDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("Games")) {
			JLabel star4 = new JLabel();
			star4.setBounds(700, 100, 100, 108);
			bck.add(star4);
			star4.setIcon(new ImageIcon("images/star.png"));
		}
		
		//add song achievement
		JLabel song = new JLabel("Happy Birthday!");
		song.setFont(mainFont);
		song.setBounds(490, 280, 300, 100);
		bck.add(song);
		
		//add song achievement description
		JLabel songDesc = new JLabel("Hear Joe's birthday song.");
		songDesc.setFont(speechFont);
		songDesc.setBounds(490, 320, 300, 100);
		bck.add(songDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("Song")) {
			JLabel star5 = new JLabel();
			star5.setBounds(700, 370, 100, 108);
			bck.add(star5);
			star5.setIcon(new ImageIcon("images/star.png"));
		}
		
		//add support achievement
		JLabel vent = new JLabel("What Friends are For.");
		vent.setFont(mainFont);
		vent.setBounds(490, 550, 300, 100);
		bck.add(vent);
		
		//add support achievement description
		JLabel ventDesc = new JLabel("<html>Have Joe listen to you<br/>rant.</html>");
		ventDesc.setFont(speechFont);
		ventDesc.setBounds(490, 630, 300, 100);
		bck.add(ventDesc);
		
		//if the list includes the current achievement type, add a star image
		if (achieved.contains("Support")) {
			JLabel star6 = new JLabel();
			star6.setBounds(700, 650, 100, 108);
			bck.add(star6);
			star6.setIcon(new ImageIcon("images/star.png"));
		}
	}
}