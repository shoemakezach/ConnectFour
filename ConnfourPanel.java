package connectfour;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Zach Shoemake, Zach Hopman, Chris Gonzales 
 *
 */
@SuppressWarnings("serial")
public class ConnfourPanel extends JPanel {
	/** the cells on the board. */
	private JButton[][] board;

	/** constant for the number three.*/
	public static final int THREE = 3;
	/** constant for the number six.*/
	public static final int SIX = 6;
	/** constant for the number seven.*/
	public static final int SEVEN = 7;
	/** constant for the number of the image size.*/
	public static final int MAX_IMAGE_SIZE = 100;


	/**
	 * image for the black tile.
	 */
	private Image black;
	/**
	 * image for a blank tile. 
	 */
	private Image blank;
	/**
	 * image for a red tile. 
	 */
	private Image red;
	/**
	 * image for a black tile. 
	 */
	private Image bLACK;
	/**
	 * image for a blank tile. 
	 */
	private Image bLANK;
	/**
	 * image for a red tile. 
	 */
	private Image rED;

	/**
	 * a temporary integer for row. 
	 */
	private int tempR;
	/**
	 * a temporary integer for column. 
	 */
	private int tempC;
	/**
	 * 
	 */
	private boolean isClicked;
	/**
	 * set a new game for the player. 
	 */
	private Game game = new Game();

	//GETTER AND SETTERS FOR THE ABOVE VARIABLES. 

	/**
	 * 
	 * @return returns a place on the board. 
	 */
	public final JButton[][] getBoard() {
		return board;
	}
	/**
	 * Clears the board for a new game. 
	 * 
	 * @param b parameter to clear the board. 
	 */
	public final void setBoard(final JButton[][] b) {
		this.board = b;
	}
	/**
	 * getter for the black tile image. 
	 * 
	 * @return returns the black image for the tile. 
	 */
	public final Image getBlack() {
		return black;
	}

	/**
	 * sets the image tile to black. 
	 * 
	 * @param b the parameter for a black tile. 
	 */
	public final void setBlack(final Image b) {
		this.black = b;
	}

	/**
	 * gets the blank image for the tile. 
	 * 
	 * @return returns the blank image for tile. 
	 */
	public final Image getBlank() {
		return blank;
	}

	/**
	 * sets the tile to blank. 
	 * 
	 * @param bla parameter for the blank tile. 
	 */
	public final void setBlank(final Image bla) {
		this.blank = bla;
	}

	/**
	 * Getter for the red image tile. 
	 * 
	 * @return returns the red image. 
	 */
	public final Image getRed() {
		return red;
	}

	/**
	 * the setter for the red image. 
	 * 
	 * @param r the parameter for the red image. 
	 */
	public final void setRed(final Image r) {
		this.red = r;
	}

	/**
	 * the getter for BLACK image. 
	 * 
	 * @return returns the BLACK image. 
	 */
	public final Image getBLACK() {
		return bLACK;
	}

	/**
	 * sets the BLACK image. 
	 * 
	 * @param b parameter for image. 
	 */
	public final void setBLACK(final Image b) {
		bLACK = b;
	}

	/**
	 * Getter for the BLANK image. 
	 * 
	 * @return returns the BLANK image. 
	 */
	public final Image getBLANK() {
		return bLANK;
	}

	/**
	 * Setter for the BLANK image. 
	 * 
	 * @param b image for tile. 
	 */
	public final void setBLANK(final Image b) {
		bLANK = b;
	}

	/**
	 * the getter for the red image. 
	 * 
	 * @return returns the RED image. 
	 */
	public final Image getRED() {
		return rED;
	}

	/**
	 * setter for the red image. 
	 * 
	 * @param r parameter for the red image time. 
	 */
	public final void setRED(final Image r) {
		rED = r;
	}

	/**
	 * the getter for the temporary row.
	 * 
	 * @return returns the temporary integer. 
	 */
	public final int getTempR() {
		return tempR;
	}

	/**
	 * Setter for the temporary row. 
	 * 
	 * @param temp parameter for the integer of row tile. 
	 */
	public final void setTempR(final int temp) {
		this.tempR = temp;
	}

	/**
	 * the getter for the temporary column. 
	 * 
	 * @return returns where the column is. 
	 */
	public final int getTempC() {
		return tempC;
	}

	/**
	 * setter for the temporary column. 
	 * 
	 * @param temp parameter for the temporary column. 
	 */
	public final void setTempC(final int temp) {
		this.tempC = temp;
	}
	/**
	 * Getter for the game. 
	 * 
	 * @return returns the current game. 
	 */
	public final Game getGame() {
		return game;
	}
	/**
	 * Setter for the game. 
	 * 
	 * @param g parameter sets the game. 
	 */
	public final void setGame(final Game g) {
		this.game = g;
	}


	/**
	 * Button Listener for the connect four game. 
	 * 
	 */
	private ButtonListener listener = new ButtonListener();

	/**
	 * 
	 * Method creates the board and sets buttons up. 
	 * 
	 */
	public ConnfourPanel() {
		
		game = new Game();

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		isClicked = false;
		
		// create the board
		center.setLayout(new GridLayout(SIX, SEVEN));
		board = new JButton[SIX][SEVEN];
		//butReset = new JButton();


		for (int row = 0; row < SIX; row++) {
			for (int col = 0; col < SEVEN; col++) {
				board[row][col] = new JButton("");
				center.add(board[row][col]);
				board[row][col].addActionListener(listener);
			}
		}



		bottom.setLayout(new GridLayout(THREE, 2));

		// add all to contentPane
		//		add(new JLabel("Connect Four"), 
		//				BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		//MY FILES FOR THE PICTURES
		try { //find image files
			File input1 = new File("Blank.png");
			blank = ImageIO.read(input1);
			File input2 = new File("Black.png");
			black = ImageIO.read(input2);
			File input3 = new File("Red.png");
			red = ImageIO.read(input3);
			//extra colors
//			File input4 = new File("/Users/Zach/Documents/pics/pink.png");
//			pink = ImageIO.read(input3);
//			File input5 = new File("/Users/Zach/Documents/pics/blue.png");
//			blue = ImageIO.read(input3);
//			File input6 = new File("/Users/Zach/Documents/pics/green.png");
//			green = ImageIO.read(input3);
		} catch (IOException e) {
			System.out.println("ERROR");
		}

		bLANK = blank.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT); 
		bLACK = black.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);
		rED = red.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);

		//Image bLANK = blank.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
		//		Image.SCALE_DEFAULT); 
		for (int r = 0; r < SIX; r++) {
			for (int c = 0; c < SEVEN; c++) {
				board[r][c].setText("");
				board[r][c].setPreferredSize(new Dimension(
						MAX_IMAGE_SIZE, MAX_IMAGE_SIZE));
				board[r][c].setIcon(new ImageIcon(bLANK));
			}
		}
		displayBoard();


		//		add(butReset, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private void displayBoard() {
		for (int r = 0; r < SIX; r++) {
			for (int c = 0; c < SEVEN; c++) {
				if (game.getBoard()[r][c].isRed()) {
					board[r][c].setIcon(new ImageIcon(rED));
				} else if (game.getBoard()[r][c].isBlack()) {
					board[r][c].setIcon(new ImageIcon(bLACK));

					//					game.ChangeTurn();
					//					setClicked(false);
				} else {
					board[r][c].setIcon(new ImageIcon(bLANK));
				}
			}
		}

	}

	/**
	 * 
	 * @author Zach Shoemake, Zach Hopman, Chris Gonzales. 
	 *
	 */
	class ButtonListener implements ActionListener, 
	MouseListener {
		/**
		 * the action performed method catches users actions. 
		 * 
		 * @param e used for which action event the player uses. 
		 */
		public void actionPerformed(final ActionEvent e) {
			for (int r = 0; r < SIX; r++) {
				for (int c = 0; c < SEVEN; c++) {
					if (board[r][c] == e.getSource()) {
						System.out.println("Clicked");
						setClicked(true);
						//game.Turn(game.GetPlayerTurn(), tempC);
						game.setPiece(0, c);

					}
				}
			}

			displayBoard();
			if (game.gameStatus()) {
				JOptionPane.showMessageDialog(null, "You Win!"
						+ "\n The game will reset");
				game.newGame();
				displayBoard();
			}


		}

		@Override
		public void mouseClicked(final MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(final MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(final MouseEvent e) {
			//TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(final MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(final MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Setter for the clicked method. 
	 * 
	 * @param clicked parameter that sets the clicked action. 
	 */
	public final void setClicked(final boolean clicked) {
		this.isClicked = clicked;
	}
}