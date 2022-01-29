package main;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * The guide page class
 * @author Brooke Xin Lai
 *
 */
public class Guide extends Client {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor method that creates new guide page
	 */
	public Guide() {
		guide.setSize(970, 560);
		guide.setLocationRelativeTo(null);
		guide.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		guide.setVisible(true);
		guide.setResizable(false);
		
		JLabel background = new JLabel("Setting");
		background.setBounds(0, 0, 960, 540);
		background.setIcon(new ImageIcon("images/guide.png"));
		guide.add(background);
	}
}