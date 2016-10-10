package ConnectFour;

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
public class conn4Panel extends JPanel {
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
	Image black;
	/**
	 * image for a blank tile. 
	 */
	Image blank;
	/**
	 * image for a red tile. 
	 */
	Image red;
	/**
	 * image for a black tile. 
	 */
	Image BLACK;
	/**
	 * image for a blank tile. 
	 */
	Image BLANK;
	/**
	 * image for a red tile. 
	 */
	Image RED;

	/**
	 * a temporary integer. 
	 */
	public int tempR;
	/**
	 * a temporary integer. 
	 */
	public int tempC;
	/**
	 * 
	 */
	private boolean isClicked;
	/**
	 * set a new game for the player. 
	 */
	Game game = new Game();

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
	 * @param board parameter to clear the board. 
	 */
	public final void setBoard(final JButton[][] board) {
		this.board = board;
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
	 * @param black the parameter for a black tile. 
	 */
	public final void setBlack(final Image black) {
		this.black = black;
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
	 * @param blank
	 */
	public final void setBlank(final Image blank) {
		this.blank = blank;
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
	 * @param red the parameter for the red image. 
	 */
	public final void setRed(final Image red) {
		this.red = red;
	}

	/**
	 * the getter for BLACK image. 
	 * 
	 * @return returns the BLACK image. 
	 */
	public final Image getBLACK() {
		return BLACK;
	}

	/**
	 * sets the BLACK image. 
	 * 
	 * @param bLACK parameter for image. 
	 */
	public final void setBLACK(final Image bLACK) {
		BLACK = bLACK;
	}

	/**
	 * Getter for the BLANK image. 
	 * 
	 * @return returns the BLANK image. 
	 */
	public final Image getBLANK() {
		return BLANK;
	}

	/**
	 * Setter for the BLANK image. 
	 * 
	 * @param bLANK image for tile. 
	 */
	public final void setBLANK(final Image bLANK) {
		BLANK = bLANK;
	}

	/**
	 * the getter for the red image. 
	 * 
	 * @return returns the RED image. 
	 */
	public final Image getRED() {
		return RED;
	}

	/**
	 * setter for the red image. 
	 * 
	 * @param rED parameter for the red image time. 
	 */
	public final void setRED(final Image rED) {
		RED = rED;
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
	 * @param tempR parameter for the integer of row tile. 
	 */
	public final void setTempR(final int tempR) {
		this.tempR = tempR;
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
	 * @param tempC parameter for the temporary column. 
	 */
	public final void setTempC(final int tempC) {
		this.tempC = tempC;
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
	 * @param game parameter sets the game. 
	 */
	public final void setGame(final Game game) {
		this.game = game;
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
	public conn4Panel() {

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
			File input1 = new File("/Users/Zach/Documents/pics/Blank.png");
			blank = ImageIO.read(input1);
			File input2 = new File("/Users/Zach/Documents/pics/Black.png");
			black = ImageIO.read(input2);
			File input3 = new File("/Users/Zach/Documents/pics/Red.png");
			red = ImageIO.read(input3);
		}
		catch (IOException e) {
			System.out.println("ERROR");
		}

		BLANK = blank.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT); 
		BLACK = black.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);
		RED = red.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);

		Image BLANK = blank.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT); 
		for (int r = 0; r < SIX; r++) {
			for (int c = 0; c < SEVEN; c++) {
				board[r][c].setText("");
				board[r][c].setPreferredSize(new Dimension(
						MAX_IMAGE_SIZE, MAX_IMAGE_SIZE));
				board[r][c].setIcon(new ImageIcon(BLANK));
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
				if (game.board[r][c].isRed() == true) {
					board[r][c].setIcon(new ImageIcon(RED));
				}
				else if (game.board[r][c].isBlack() == true){
					board[r][c].setIcon(new ImageIcon(BLACK));

					//					game.ChangeTurn();
					//					setClicked(false);
				}
				else {
					board[r][c].setIcon(new ImageIcon(BLANK));
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
		 * the action performed method cathces users actions. 
		 */
		public void actionPerformed(final ActionEvent E) {
			for (int r = 0; r < SIX; r++) {
				for (int c = 0; c < SEVEN; c++) {
					if (board[r][c] == E.getSource()) {
						System.out.println("Clicked");
						setClicked(true);
						//game.Turn(game.GetPlayerTurn(), tempC);
						game.setPiece(0, c);

					}
				}
			}

			displayBoard();
			if (game.GameStatus() == true){
				JOptionPane.showMessageDialog(null, "You Win!"
						+ "\n The game will reset");
				game.newGame();
				displayBoard();
			}


		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Setter for the clicked method. 
	 * 
	 * @param isClicked parameter that sets the clicked action. 
	 */
	public final void setClicked(final boolean isClicked) {
		this.isClicked = isClicked;
	}
}