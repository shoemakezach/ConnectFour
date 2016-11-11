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
	private int blackWin = 0;
	/**
	 * 
	 */
	private int redWin = 0;

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

	private static final int CONNECT_FOUR_ROWS = 6; 
	
	public GameType type;
	public LevelDifficulty level;
	

	/**
	 * 
	 * Constructor to create the game board. 
	 * 
	 */
	public Game() {
		type = GameType.OnePlayer;
		level = LevelDifficulty.Easy;
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
		playerTurn = 1;
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

		if(type == GameType.TwoPlayer){
		if (board[r][c].isBlack() || board[r][c].isRed()) { //throw error here
			throw new IndexOutOfBoundsException();
		} else if (playerTurn == 1) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setRed(true);	
					changeTurn();
					return;
				}
			}
		} else if (playerTurn == 2) {
			for (int i = r; i < SIX; i++) {
				if (i == FIVE || board[i + 1][c].isRed() 
						|| board[i + 1][c].isBlack()) {
					board[i][c].setBlack(true);
					changeTurn();
					return;
				}
			}
		}
		}
		if(type == GameType.OnePlayer){
			if( level == LevelDifficulty.Easy){
				if (playerTurn == 1) {
					if (board[r][c].isBlack() || board[r][c].isRed()) { //throw error here
						throw new IndexOutOfBoundsException();
					} 
					for (int i = r; i < SIX; i++) {
						if (i == FIVE || board[i + 1][c].isRed() 
							|| board[i + 1][c].isBlack()) {
							board[i][c].setRed(true);	
							changeTurn();
							return;
						}
					}
				} else if (playerTurn == 2) {
					// Change to Recall get random, also make get random here
					if (board[r][c].isBlack() || board[r][c].isRed()) { //throw error here
						throw new IndexOutOfBoundsException();
					} 
					for (int i = r; i < SIX; i++) {
						if (i == FIVE || board[i + 1][c].isRed() 
							|| board[i + 1][c].isBlack()) {
							board[i][c].setBlack(true);
							changeTurn();
							return;
						}
					}
				}
			}
			if(level == LevelDifficulty.Medium){
				if (board[r][c].isBlack() || board[r][c].isRed()) { //throw error here
					throw new NullPointerException();
				} else if (playerTurn == 1) {
					for (int i = r; i < SIX; i++) {
						if (i == FIVE || board[i + 1][c].isRed() 
							|| board[i + 1][c].isBlack()) {
							board[i][c].setRed(true);	
							changeTurn();
							return;
						}
					}
				} else if (playerTurn == 2) {
					for (int i = r; i < SIX; i++) {
						if (i == FIVE || board[i + 1][c].isRed() 
							|| board[i + 1][c].isBlack()) {
							board[i][c].setBlack(true);
							// add is valid move here
							changeTurn();
							return;
						}
					}				
			}
			}
			if(level == LevelDifficulty.Hard){
				
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
			throw new NullPointerException();
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
									redWin = redWin + 1;
									return true;
								}
							}
						}
					}
				}
				//Red Wins Horizontal
				if (c + THREE < SEVEN) {
					if (board[r][c].isRed()) {
						if (board[r][c + 1 ].isRed()) {
							if (board[r][c + 2].isRed()) {
								if (board[r][c + THREE].isRed()) {



									System.out.println(playerTurn + " Won!");
									redWin = redWin + 1;
									return true;
								}
							}
						}
					}
				}

				//Red Diagonal Right
				if (r + THREE < SIX && c - THREE >= 0) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c - 1].isRed()) {
							if (board[r + 2][c - 2].isRed()) {
								if (board[r + THREE][c - THREE].isRed()) {



									System.out.println(playerTurn + " Won!");
									redWin = redWin + 1;
									return true;
								}
							}
						}
					}
				}

				//Red Diagonal Left
				if (r + THREE < SIX && c + THREE < SEVEN) {
					if (board[r][c].isRed()) {
						if (board[r + 1][c + 1].isRed()) {
							if (board[r + 2][c + 2].isRed()) {
								if (board[r + THREE][c + THREE].isRed()) {



									System.out.println(playerTurn + " Won!");
									redWin = redWin + 1;
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
									blackWin = blackWin + 1;
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
									blackWin = blackWin + 1;
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
									blackWin = blackWin + 1;
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
									blackWin = blackWin + 1;
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
     * Get length of connect in a specific column
     * @param column
     * @param player
     * @param gameBoard
     * @return
     */
   
	//Morph into get valid move method
	public static int getVerticalConnects(int column, int player, int[][] gameBoard) {
        int colStart = 0;
        int connectLength = 0;
        // if column is empty
        if(gameBoard[CONNECT_FOUR_ROWS - 1][column] == 0)
            return 0;
        // get first piece
        while(gameBoard[colStart][column] == 0 && colStart < CONNECT_FOUR_ROWS - 1)
            colStart++;
        // if first piece is opponent
        if(gameBoard[colStart][column] != player) {
            return 1;
        }
        // count connected pieces
        for(int i = colStart + 1;
            i < CONNECT_FOUR_ROWS &&
                gameBoard[i][column] == player;
            i++) {
            connectLength++;
        }
        if(colStart + connectLength <=2) {
            return 0;
        }
       return 0;

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

	/**
	 * Getter for black winning or not. 
	 * @return returns if black win or not. 
	 */
	public final int getBlackWin() {
		return blackWin;
	}

	/**
	 * setter for if black win or not. 
	 * @param bWin sets winner to black. 
	 */
	public final void setBlackWin(final int bWin) {
		this.blackWin = bWin;
	}

	/**
	 * getter for if red win or not. 
	 * @return returns if red win or not. 
	 */
	public final int getRedWin() {
		return redWin;
	}
	
	/**
	 * setter for the win of red player. 
	 * @param rWin sets winner to red. 
	 */
	public final void setRedWin(final int rWin) {
		this.redWin = rWin;
	}

	/**
	 * setter for the player turn. 
	 * @param pTurn sets players turn. 
	 */
	public final void setPlayerTurn(final int pTurn) {
		this.playerTurn = pTurn;
	}
	
	

}