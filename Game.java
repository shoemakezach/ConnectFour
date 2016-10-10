package ConnectFour;

/**
 * 
 * @author Zach Shoemake, Zach Hopman, Chris Gonzales 
 *
 */
public class Game {

	/**
	 * 
	 */
	Cell board[][];
	/**
	 * 
	 */
	int PlayerTurn = 1;
	/**
	 * 
	 */
	int row = 6;
	/**
	 * 
	 */
	int col = 7;
	/**
	 * 
	 */
	Boolean GameOver = false;
	/**
	 * 
	 */
	Boolean validMove = true;
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
	public final int GetPlayerTurn(){
		return PlayerTurn;
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
		}

		else if (PlayerTurn == 1) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setRed(true);	
					ChangeTurn();
					GameStatus();
					return;
				}
			}
		}
		else if (PlayerTurn == 2) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setBlack(true);
					ChangeTurn();
					GameStatus();
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
	public final void ChangeTurn() {
		if (PlayerTurn == 1) {
			PlayerTurn = 2;
		}
		else if (PlayerTurn == 2) {
			PlayerTurn = 1;
		}
		else {
			System.out.println("PlayerTurn is out of bounds");
		}
	}

	/**
	 * 
	 * Keeps track of the status of the game. 
	 * 
	 * @return returns the status of the game.
	 */
	public final boolean GameStatus() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				//Red Wins Vertical	
				if (r + THREE < SIX) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c].isRed()) {
							if (board[r + 2][c].isRed()) {
								if (board[r + THREE][c].isRed()) {



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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



									System.out.println(PlayerTurn + " Won!");

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
	 * 
	 * @return
	 */
	public boolean isRed() {
		return isRed;
	}
	/**
	 * 
	 * @param isRed
	 */
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isBlack() {
		return isBlack;
	}
	/**
	 * 
	 * @param isBlack
	 */
	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}


}



//package ConnectFour;
//
//import java.util.Scanner;
//
///**
// * 
// * @author Zach Shoemake, Zach Hopman, Chris Gonzales
// *
// * @version 1
// */
//public class Game {
//
//	/**
//	 * 
//	 */
//	int row = 7;
//	/**
//	 * 
//	 */
//	int col = 6;
//	/**
//	 * 
//	 */
//	private int[][] board = new int[row][col];
//	/**
//	 * 
//	 */
//	int PlayerTurn = 1;
//
//	/**
//	 * 
//	 */
//	Boolean GameOver = false;
//	/**
//	 * 
//	 */
//	Boolean validMove = true;
//	
//	/**
//	 * 
//	 */
//	public static final int THREE = 3;
//	/**
//	 * 
//	 */
//	public static final int FOUR = 4;
//
//	/**
//	 * 
//	 * Constructor to create the game board.
//	 *  
//	 */
//	public Game() {
//
//		newGame();
//
//		while (!GameOver) {
//			System.out.println("It's Player " + PlayerTurn + "'s turn");
//			PrintArray(board);
//
//			do {
//				//temp way to get input for turn method
//				System.out.println("What column do you want to go in? "
//						+ "enter 0-5"); 
//				Scanner reader = new Scanner(System.in);
//				int input = reader.nextInt();
//
//				Turn(PlayerTurn, input);
//
//			} while(!validMove);
//
//			GameOver = GameStatus(PlayerTurn);
//			PrintArray(board);
//			ChangeTurn();
//
//		}
//
//	}
//
//	/**
//	 * 
//	 */
//	public final void newGame() {
//		for (int rows = 0; rows < row; rows++) {
//			for (int cols = 0; cols < col; cols++) {
//				board[rows][cols] = 0;
//			}
//		}
//		System.out.println("New Game Started\n");
//	}
//
//	/**
//	 * 
//	 * @param player
//	 * @param input
//	 */
//	public final void Turn(int player, int input) {
//
//		if ((input > col - 1) || (input < 0)) {
//			System.out.println("Not a Valid Move");
//			validMove = false;
//			return;
//		}
//		// checks if column is open
//		for (int rows = row - 1; rows >= 0; rows--) {
//			if (board[rows][input] == 0) {
//				if ((rows == 0) || (board[rows - 1][input] != 0)) {
//					board[rows][input] = player;
//					System.out.println("Your Turn is over");
//					validMove = true;
//					return;
//				}
//			}
//
//		}
//
//	}
//
//	/**
//	 * 
//	 * @param array
//	 */
//	public final void PrintArray(int[][] array) {
//		for (int rows = row - 1; rows >= 0; rows--) {
//			for (int cols = 0; cols < col; cols++) {
//				System.out.print(array[rows][cols] + "  ");
//			}
//			System.out.print("\n");
//		}
//	}
//
//	/**
//	 * Method completes each players turn. 
//	 */
//	public final void ChangeTurn() {
//		if (PlayerTurn == 1) {
//			PlayerTurn = 2;
//		} else if (PlayerTurn == 2) {
//			PlayerTurn = 1;
//		} else {
//			System.out.println("PlayerTurn is out of bounds");
//		}
//	}
//
//	/**
//	 * 
//	 * @param player
//	 * @return boolean
//	 */
//	public final boolean GameStatus(int player) {
//		for (int r = 0; r < row; r++) {
//			for (int c = 0; c < col; c++) {
//
//				// up/down
//				if ((r >= 3) && board[r][c] == PlayerTurn 
//						&& board[r - 1][c] ==  PlayerTurn 
//						&& board[r - 2][c] == PlayerTurn 
//						&& board[r - THREE][c] == PlayerTurn) {
//
//					System.out.println(PlayerTurn + " Won!");
//
//					return true;
//
//					// left/right
//				} else if ((c <= col - FOUR) && board[r][c] == PlayerTurn 
//						&& board[r][c + 1] == PlayerTurn 
//						&& board[r][c + 2] == PlayerTurn
//						&& board[r][c + THREE] == PlayerTurn) {
//
//					System.out.println(PlayerTurn + " Won!");
//
//					return true;
//
//					// up right/down left
//				} else if ((r <= row - FOUR) && (c <= col - FOUR) 
//						&& board[r][c] == PlayerTurn 
//						&& board[r + 1][c + 1] == PlayerTurn
//						&& board[r + 2][c + 2] == PlayerTurn 
//						&& board[r + THREE][c + THREE] == PlayerTurn) {
//					System.out.println(PlayerTurn + " Won!");
//
//					return true;
//
//					// up left/ down right MAGIC NUMBERS??
//				} else if ((c <= col - FOUR) && (r >= THREE) 
//						&& board[r][c] == PlayerTurn 
//						&& board[r - 1][c + 1] == PlayerTurn
//						&& board[r - 2][c + 2] == PlayerTurn 
//						&& board[r - THREE][c + THREE] == PlayerTurn) {
//
//					System.out.println(PlayerTurn + " Won!");
//					return true;
//
//				}
//
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * A getter for the get board method. 
//	 * @return integer for where we are on the board.
//	 */
//	public final int[][] getBoard() {
//		return board;
//	}
//
//	/**
//	 * A getter for the player turn method. 
//	 * @return returns an integer for which player turn it is. 
//	 */
//	public final int getPlayerTurn() {
//		return PlayerTurn;
//	}
//
//	/**
//	 * A getter for the number of rows. 
//	 * @return returns an integer for row. 
//	 */
//	public final int getRow() {
//		return row;
//	}
//
//	/**
//	 * A getter for the number columns in a method. 
//	 * @return returns an integer for column. 
//	 */
//	public final int getCol() {
//		return col;
//	}
//
//	/**
//	 * a boolean for if the game is over or not. 
//	 * @return true or false.
//	 */
//	public final Boolean getGameOver() {
//		return GameOver;
//	}
//
//
//}