package ConnectFour;

import javax.swing.JFrame;

/**
 * 
 * @author Zach Shoemake, Chris Gonzales, Zach Hopman
 *
 * @version 10/9/16
 */
public class conn4GUI {

	/**
	 * A maximum size for board.
	 */
	public static final int MAXSIZE = 900;

	/**
	 * 
	 * @param args 
	 */
	public static void main(final String[] args) {
		
		JFrame frame = new JFrame("Connect Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conn4Panel panel = new conn4Panel();
        frame.getContentPane().add(panel);
        frame.setSize(MAXSIZE, MAXSIZE);
		frame.setVisible(true);
		
	}
}