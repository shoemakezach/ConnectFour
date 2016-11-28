package connectfour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Zach Shoemake, Zach Hopman, Chris Gonzales
 *
 */
@SuppressWarnings("serial")
public class conn4Panel extends JPanel {
	/** the cells on the board. */
	private JButton[][] board;

	/** constant for the number three.*/
	public static final int THREE = 3;
	/** constant for the number six.*/
	public static final int SIX = 6;
	/** constant for the number seven.*/
	public static final int SEVEN = 7;
	/** constant for the number eight.*/
	public static final int EIGHT = 8;
	/** constant for the number twenty. */
	public static final int TWENTY = 20;
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
	/**set a new game for the player. */
	private Game game = new Game();
	/** Label for player one. */
	private JLabel player1;
	/** Label for player two. */
	//private JLabel player2;
	/** Label for red wins. */
	private JLabel redWin;
	/** Label for black wins. */
	private JLabel blackWin;
	/** Label for the reset button. */
	private JButton reset;

	/** drop down box for difficulty */
	private final JComboBox<String> difficulty;
	private String[] opt = {"easy", "medium","hard"};
	/** drop down box for game type */
	private final JComboBox<String> oneOrTwo;
	private String[] opt1 = {"one player", "two player"};

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
	 */
	public conn4Panel() {
		setName(JOptionPane.showInputDialog("What is your name?"));

		JPanel center = new JPanel();

		isClicked = false;

		// create the board
		center.setLayout(new GridLayout(EIGHT, SEVEN));
		board = new JButton[SIX][SEVEN];
		reset = new JButton();


		difficulty = new JComboBox<String>(opt);
		oneOrTwo = new JComboBox<String>(opt1);

		for (int row = 0; row < SIX; row++) {
			for (int col = 0; col < SEVEN; col++) {
				board[row][col] = new JButton("");
				center.add(board[row][col]);
				board[row][col].addActionListener(listener);
			}
		}

		reset.addActionListener(listener);

		difficulty.addActionListener(listener);
		oneOrTwo.addActionListener(listener);


		JLabel blk1 = new JLabel("");
		redWin = new JLabel("");
		blackWin = new JLabel("");
		player1 = new JLabel("");
		reset.setText("NEW GAME");
		reset.setBackground(Color.GREEN);
		reset.setPreferredSize(new Dimension(TWENTY, TWENTY));

		center.add(reset);
		center.add(blk1);
		center.add(redWin);
		center.add(player1, BorderLayout.CENTER);	
		center.add(blackWin);

		center.add(difficulty);
		center.add(oneOrTwo);
		
		// add all to contentPane
		add(center);

		try { //find image files
			File input1 = new File("Blank.png");
			blank = ImageIO.read(input1);
			File input2 = new File("Black.png");
			black = ImageIO.read(input2);
			File input3 = new File("Red.png");
			red = ImageIO.read(input3);
		} catch (IOException e) {
			System.out.println("ERROR");
		}

		bLANK = blank.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT); 
		bLACK = black.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);
		rED = red.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);

		for (int r = 0; r < SIX; r++) {
			for (int c = 0; c < SEVEN; c++) {
				board[r][c].setText("");
				board[r][c].setPreferredSize(new Dimension(
						MAX_IMAGE_SIZE, MAX_IMAGE_SIZE));
				board[r][c].setIcon(new ImageIcon(bLANK));
			}
		}
		displayBoard();

	}

	/**
	 * 
	 */
	private void displayBoard() {

		redWin.setText(getName() + " Wins: " + game.getRedWin());
		blackWin.setText(" Player 2 Wins: " + game.getBlackWin());

		for (int r = 0; r < SIX; r++) {
			for (int c = 0; c < SEVEN; c++) {
				if (game.getBoard()[r][c].isRed()) {
					board[r][c].setIcon(new ImageIcon(rED));

				} else if (game.getBoard()[r][c].isBlack()) {
					board[r][c].setIcon(new ImageIcon(bLACK));

				} else {
					board[r][c].setIcon(new ImageIcon(bLANK));
				}
			}
		}

		if (game.getPlayerTurn() == 1) {
			player1.setText("       " + getName() + "'s turn");
		}
		if (game.getPlayerTurn() == 2) {
			player1.setText("       Player 2");
		}


	}

	/**
	 * 
	 * @author Zach
	 *
	 */
	class ButtonListener implements ActionListener, 
	MouseListener {
		/**
		 * 
		 * @param e action event for players action. 
		 */
		public void actionPerformed(final ActionEvent e) {

			if (reset == e.getSource()) {
				game.newGame();
			}
			
			if(oneOrTwo == e.getSource()){
				if("one player" == (String)oneOrTwo.getSelectedItem()){
					game.type = GameType.OnePlayer;
					game.setRedWin(0);
					game.setBlackWin(0);
					game.newGame();
				}
				if("two player" == (String)oneOrTwo.getSelectedItem()){
					game.type = GameType.TwoPlayer;
					game.setRedWin(0);
					game.setBlackWin(0);	
					game.newGame();
				}
			}

			if(difficulty == e.getSource()){
				if("easy" == (String)difficulty.getSelectedItem()){
					game.level = LevelDifficulty.Easy;
					game.newGame();
				}
				if("medium" == (String)difficulty.getSelectedItem()){
					game.level = LevelDifficulty.Medium;
					game.newGame();
				}
				if("hard" == (String)difficulty.getSelectedItem()){
					game.level = LevelDifficulty.Hard;
					game.newGame();
				}
			}

			for (int r = 0; r < SIX; r++) {
				for (int c = 0; c < SEVEN; c++) {
					if (board[r][c] == e.getSource()) {
						System.out.println("Clicked" +r + ""+c);
						setClicked(true);
						animation(game.setPiece(0, c), c);
						//move to Game Class**
						
						if(game.type == GameType.OnePlayer && game.level == LevelDifficulty.Easy){
							int rand = game.getRandom();
							animation(game.setPiece(0, rand), rand);
						}
						if(game.type == GameType.OnePlayer && game.level == LevelDifficulty.Medium){
							
							int valid = game.isValidMove();
							animation(game.setPiece(0, valid), valid);
						}
						
					}
					
				}
			}
			displayBoard();
			
			if (game.gameStatus() == 1) {
					JOptionPane.showMessageDialog(null, getName() + " Wins!"
							+ "\n The game will reset");
					game.newGame();
					displayBoard();
					return;
			}
			if (game.gameStatus() == 2) {
					JOptionPane.showMessageDialog(null, "Player 2 Wins!"
							+ "\n The game will reset");
					game.newGame();
					displayBoard();
					return;
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
	/**
	 * Creates an animation for pieces being dropped in 
	 * 
	 * @param rownum is the row the piece should end up in
	 * @param colnum is the column the piece should go in
	 */
	public void animation(int rownum, int colnum){
		
		rED = red.getScaledInstance(MAX_IMAGE_SIZE, MAX_IMAGE_SIZE, 
				Image.SCALE_DEFAULT);
		if (rownum == -1){
			System.out.println("Not Valid Move");
			return;
		}
		if (game.getPlayerTurn() == 1)
		{
			for (int i = 0; i<=rownum;i++)
			{
				if ( i != 0)
					board[i-1][colnum].setIcon(new ImageIcon(bLANK));
				board[i][colnum].setIcon(new ImageIcon(rED));
				System.out.println("1image set at: "+ i +", "+colnum);
				try {
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if (game.getPlayerTurn() == 2)
		{
			for (int i = 0; i<rownum;i++)
			{
				if ( i != 0){
				//board[i+1][colnum].setIcon(new ImageIcon(bLANK));
				board[i][colnum].setIcon(new ImageIcon(rED));
			
				System.out.println("2image set at: "+ i +", "+colnum);
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
}
