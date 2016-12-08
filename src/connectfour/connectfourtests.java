package connectfour;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */
public class connectfourtests {
	
	/**
	 * 
	 */
	private final int five = 5;
	/**
	 * 
	 */
	private final int one = 1;
	/**
	 * 
	 */
	private final int three = 3;
	/**
	 * 
	 */
	private final int four = 4;
	/**
	 * 
	 */
	private final int two = 2;
	/**
	 * 
	 */
	private final int zero = 0;
	/**
	 * 
	 */
	private Game game = new Game();
	/**
	 * 
	 */
	private Cell[][] b;

	/**
	 * 
	 */
	@Test
	public final void playerTurnTest() {
		assertTrue(game.getPlayerTurn() == one);
	}
	
	/**
	 * 
	 */
	@Test
	public final void changeturnonetest() {
		int turn = zero;
		game.changeTurn();
		turn = game.getPlayerTurn();
		assertTrue(turn == two);
	}
	
	/**
	 * 
	 */
	@Test
	public final void changeturntwotest() {
		int turn = zero;
		game.changeTurn();
		game.changeTurn();
		turn = game.getPlayerTurn();
		assertTrue(turn == one);
	}
	
	/**
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public final void changeturnthreetest() {
		game = new Game();
		game.setPlayerTurn(three);
		game.changeTurn();
	}
	
	/**
	 * 
	 */
	@Test
	public final void setpiecetest() {
		game.setPiece(five, five);
		b = game.getBoard();
		assertTrue(b[five][five].isRed());
	}
	
	/**
	 * 
	 */
	@Test
	public final void setpiecetwotest() {
		game.changeTurn();
		game.setPiece(five, five);
		b = game.getBoard();
		assertTrue(b[five][five].isBlack());
	}
	
	/**
	 * 
	 */
	@Test
	public final void redvertiwintest() {
		game = new Game();
		game.setPiece(one, five);
		game.setPiece(one, two);
		game.setPiece(one, five);
		game.setPiece(two, two);
		game.setPiece(one, five);
		game.setPiece(three, two);
		game.setPiece(one, five);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void isRed() {
		game = new Game();
		game.setPiece(one, five);
		b = game.getBoard();
		assertTrue(b[five][five].isRed());
	}
	
	/**
	 * 
	 */
	@Test
	public final void isBlack() {
		game = new Game();
		game.setPiece(one, five);
		game.setPiece(one, four);
		b = game.getBoard();
		assertTrue(b[five][four].isBlack());
	}
	
	/**
	 * 
	 */
	@Test
	public final void setRed() {
		game = new Game();
		b = game.getBoard();
		b[five][five].setRed(true);
		assertTrue(b[five][five].isRed());
	}
	
	/**
	 * 
	 */
	@Test
	public final void redhorizwintest() {
		game = new Game();
		game.setPiece(one, five);
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, two);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void blackhorizwintest() {
		game = new Game();
		game.setPiece(one, one);
		game.setPiece(one, five);
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, two);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 2);
	}
	
	/**
	 * 
	 */
	@Test
	public final void blackwintest1() {
		game = new Game();
		game.setPiece(one, one);
		game.setPiece(one, five);
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, two);
		b = game.getBoard();
		game.gameStatus();
		assertTrue(game.getBlackWin() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void redwintest() {
		game = new Game();
		game.setPiece(one, five);
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, two);
		b = game.getBoard();
		game.gameStatus();
		assertTrue(game.getRedWin() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void blackvertiwintest() {
		game = new Game();
		game.setPiece(one, one);
		game.setPiece(one, five);
		game.setPiece(one, two);
		game.setPiece(one, five);
		game.setPiece(two, two);
		game.setPiece(one, five);
		game.setPiece(three, two);
		game.setPiece(one, five);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 2);
	}
	
	/**
	 * 
	 */
	@Test
	public final void reddiagwintest() {
		game = new Game();
		game.setPiece(one, one);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, five);
		game.setPiece(one, three);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, four);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void reddiagtwowintest() {
		game = new Game();
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, five);
		game.setPiece(one, three);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, two);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void blackdiagwintest() {
		game = new Game();
		game.setPiece(one, zero);
		game.setPiece(one, one);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, five);
		game.setPiece(one, three);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, four);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 2);
	}
	
	/**
	 * 
	 */
	@Test
	public final void blackdiagtwowintest() {
		game = new Game();
		game.setPiece(one, zero);
		game.setPiece(one, five);
		game.setPiece(one, four);
		game.setPiece(one, four);
		game.setPiece(one, three);
		game.setPiece(one, three);
		game.setPiece(one, five);
		game.setPiece(one, three);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, two);
		game.setPiece(one, two);
		b = game.getBoard();
		assertTrue(game.gameStatus() == 2);
	}
	
	/**
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public final void setPieceFail() {
		game = new Game();
		game.type = GameType.TwoPlayer;
		b = game.getBoard();
		game.setPiece(one, zero);
		game.setPiece(one, zero);
		game.setPiece(one, zero);
		game.setPiece(one, zero);
		game.setPiece(one, zero);
		game.setPiece(one, zero);

	}
	
	/**
	 * 
	 */
	@Test
	public final void setPieceBlack() {
		game = new Game();
		game.setPiece(two, five);
		game.setPiece(zero, 1);
		b = game.getBoard();
		assertTrue(b[five][one].isBlack());
	}
	
	/**
	 * 
	 */
	@Test
	public final void setRedWin() {
		game = new Game();
		game.setRedWin(1);
		int i = game.getRedWin();
		assertTrue(i == 1);
		
	}
	
	/**
	 * 
	 */
	@Test
	public final void setRedLose() {
		game = new Game();
		game.setRedWin(2);
		assertTrue(game.getRedWin() != 1);
	}
	
	/**
	 * 
	 */
	@Test
	public final void setBlackWin() {
		game = new Game();
		game.setBlackWin(three);
		assertTrue(game.getBlackWin() == three);
	}

	/**
	 * 
	 */
	@Test
	public final void setBoard() {
		game = new Game();
		game.setPiece(five, five);
		b = game.getBoard();
		game.setBoard(b);
		assertTrue(b[five][five].isRed());
	}
	
	/**
	 * 
	 */
	@Test
	public final void gameWinFalse() {
		game = new Game();
		game.setPiece(five, five);
		game.getBoard();
		assert(game.gameStatus() == 0);
	}
	@Test 
	public final void testValidMove() {
		game = new Game();
		assertTrue(game.isValidMove() >= 0);
	}
	@Test
	public final void testgetHorizontalConnects() {
		game = new Game();
		assertTrue(game.getHorizontalConnects() >= 0);
	}
	@Test
	public final void testgetVerticalConnects() {
		game = new Game();
		assertTrue(game.getVerticalConnects() >= 0);
	}
	@Test
	public final void testIsred() {
		game = new Game();
		game.setRed(false);
		assertTrue(game.isRed() == false);
	}
	@Test
	public final void testIsblack() {
		game = new Game();
		game.setblack(false);
		assertTrue(game.isBlack() == false);
	}


}
