package connectfour;

/**
 * 
 * @author Zach Shoemake, Chris Gonzales, Zach Hopman
 * 
 * 
 * @version 12/07/16
 */
public class Cell {

	/** Returns a true or false value. */
	private boolean isRed;
	
	/** Returns a true or false value. */
	private boolean isBlack;
	
	/**
	 * 
	 * @param red the cell is red or not.
	 * @param black the cell is black or not. 
	 */
	Cell(final boolean red, final boolean black) { //CANNOT BE FINAL 
		setRed(red);
		setBlack(black);
	}

	/**
	 * 
	 * the boolean for a red player's piece. 
	 * 
	 * @return returns true or false for red or not. 
	 */
	public final boolean isRed() {
		return isRed;
	}
	
	/**
	 * 
	 * sets a a piece to red. 
	 * 
	 * @param isred returns true or false for red or not.
	 */
	public final void setRed(final boolean isred) {
		this.isRed = isred;
	}

	/**
	 * 
	 * @return returns a true or false for black or not.
	 */
	public final boolean isBlack() {
		return isBlack;
	}

	/**
	 * 
	 * @param isblack returns true or false for is black or not.
	 */
	public final void setBlack(final boolean isblack) {
		this.isBlack = isblack;
	}
	
	 
}