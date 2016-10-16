package connectfour;

/**
 * 
 * @author Zach Shoemake, Zach Hopman, Chris Gonzales 
 *
 */
public class Game {

	/**
	 * a certain cell on the board.
	 */
	private Cell[][] board;

	/**
	 * states who's turn it is. 
	 */
	private int playerTurn = 1;
	/**
	 * 
	 */
	private int row = SIX;
	/**
	 * 
	 */
	private int col = SEVEN;
	/**
	 * 
	 */
	//private Boolean gameOver = false;
	/**
	 * 
	 */
	//private Boolean validMove = true;
	/**
	 * 
	 */
	private boolean isRed;
	/**
	 * 
	 */
	private boolean isBlack;

	/**
	 * 
	 */
	public static final int THREE = 3;
	/**
	 * 
	 */
	public static final int FOUR = 4;

	/**
	 * 
	 */
	public static final int FIVE = 5; 
	/**
	 * 
	 */
	public static final int SIX = 6; 
	/**
	 * 
	 */
	public static final int SEVEN = 7; 



	/**
	 * 
	 * Constructor to create the game board. 
	 * 
	 */
	public Game() {

		board = new Cell[row][col];
		newGame();

	}

	/**
	 * 
	 * starts a new game, resets board.
	 * 
	 */
	public final void newGame() {
		for (int rows = 0; rows < row; rows++) {
			for (int cols = 0; cols < col; cols++) {
				board[rows][cols] = new Cell(false, false);
			}
		}
		System.out.println("New Game Started\n");
	}

	/**
	 * 
	 * This method returns the which player's turn it is. 
	 * 
	 * @return returns which players turn it is. 
	 */
	public final int getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * 
	 * sets the piece on the board that the player uses. 
	 * 
	 * @param r uses the row for parameter. 
	 * @param c uses the column for parameter. 
	 */
	public final void setPiece(final int r, final int c) {

		if (board[r][c].isBlack() || board[r][c].isRed()) { //throw error here
			System.out.println("Error: Stack Full");
			return; 
		} else if (playerTurn == 1) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setRed(true);	
					changeTurn();
					gameStatus();
					return;
				}
			}
		} else if (playerTurn == 2) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setBlack(true);
					changeTurn();
					gameStatus();
					return;
				}
			}
		}
	}

	/**
	 * 
	 * changes the turn to alternate players.
	 * 
	 */
	public final void changeTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else if (playerTurn == 2) {
			playerTurn = 1;
		} else {
			System.out.println("PlayerTurn is out of bounds");
		}
	}

	/**
	 * 
	 * Keeps track of the status of the game. 
	 * 
	 * @return returns the status of the game.
	 */
	public final boolean gameStatus() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				//Red Wins Vertical	
				if (r + THREE < SIX) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c].isRed()) {
							if (board[r + 2][c].isRed()) {
								if (board[r + THREE][c].isRed()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}
				//Red Wins Horizontal
				if (c + THREE < SEVEN) {
					if (board[r][c].isRed()) {
						if (board[r][c + 1].isRed()) {
							if (board[r][c + 2].isRed()) {
								if (board[r][c + THREE].isRed()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}

				//Diagonal Right
				if (r + THREE < SIX && c - THREE >= 0) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c - 1].isRed()) {
							if (board[r + 2][c - 2].isRed()) {
								if (board[r + THREE][c - THREE].isRed()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}

				//Diagonal Left
				if (r + THREE < SIX && c + THREE < SEVEN) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c + 1].isRed()) {
							if (board[r + 2][c + 2].isRed()) {
								if (board[r + THREE][c + THREE].isRed()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}
				// Black Wins Vertical
				if (r + THREE < SIX) {
					if (board[r][c].isBlack()) {
						if (board[r + 1][c].isBlack()) {
							if (board[r + 2][c].isBlack()) {
								if (board[r + THREE][c].isBlack()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}
				//Black Wins Horizontal
				if (c + THREE < SEVEN) {
					if (board[r][c].isBlack()) {
						if (board[r][c + 1].isBlack()) {
							if (board[r][c + 2].isBlack()) {
								if (board[r][c + THREE].isBlack()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}

				//Black Diagonal Right
				if (r + THREE < SIX && c - THREE >= 0) {
					if (board[r][c].isBlack()) {
						if (board[r + 1][c - 1].isBlack()) {
							if (board[r + 2][c - 2].isBlack()) {
								if (board[r + THREE][c - THREE].isBlack()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}

				//Black Diagonal Left
				if (r + THREE < SIX && c + THREE < SEVEN) {
					if (board[r][c].isBlack()) {
						if (board[r + 1][c + 1].isBlack()) {
							if (board[r + 2][c + 2].isBlack()) {
								if (board[r + THREE][c + THREE].isBlack()) {



									System.out.println(playerTurn + " Won!");

									return true;
								}
							}
						}
					}
				}

			}
		}
		return false;
	}

	/**
	 * a boolean for whether tile is red or not. 
	 * 
	 * @return returns a true or false for red. 
	 */
	public final boolean isRed() {
		return isRed;
	}
	/**
	 * method for setting a tile to red. 
	 * 
	 * @param isred true or false parameter for red or not. 
	 */
	public final void setRed(final boolean isred) {
		this.isRed = isred;
	}
	/**
	 * a boolean for whether tile is black or not. 
	 * 
	 * @return returns a true or false for black.
	 */
	public final boolean isBlack() {
		return isBlack;
	}
	/**
	 * method for setting a tile to black. 
	 * 
	 * @param isblack true or false parameter for black or not. 
	 */
	public final void setblack(final boolean isblack) {
		this.isBlack = isblack;
	}
	/**
	 * 
	 * @return returns the board position. 
	 */
	public final Cell[][] getBoard() {
		return board;
	}
	/**
	 * 
	 * @param b sets the particular cell on the board. 
	 */
	public final void setBoard(final Cell[][] b) {
		this.board = b;
	}


}