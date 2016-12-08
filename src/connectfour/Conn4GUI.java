package connectfour;
/**
 * 
 * @author Zach Shoemake, Chris Gonzales, Zach Hopman
 * 
 * 
 *@version 12/07/16
 */

import javax.swing.JFrame;

/**
 * 
 * @author Zach Shoemake, Chris Gonzales, Zach Hopman
 *
 * @version 10/9/16
 */
public final class Conn4GUI {
	/**
	 * constructor. 
	 */
	private Conn4GUI() {
		
	}
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
		Conn4Panel panel = new Conn4Panel();
        frame.getContentPane().add(panel);
        frame.setSize(MAXSIZE, MAXSIZE);
		frame.setVisible(true);
		
	}
}