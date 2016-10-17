package connectfour;

import static org.junit.Assert.*;

import org.junit.Test;

public class connectfourtests {

	
	Game game = new Game();
	Cell[][] b;
	
	@Test
	public void PlayerTurnTest() {
		int turn = 0;
		turn = game.getPlayerTurn();
		assertTrue(turn == 1);
	}
	@Test
	public void changeturnonetest() {
		int turn = 0;
		game.changeTurn();
		turn = game.getPlayerTurn();
		assertTrue(turn == 2);
	}
	@Test
	public void changeturntwotest() {
		int turn = 0;
		game.changeTurn();
		game.changeTurn();
		turn = game.getPlayerTurn();
		assertTrue(turn == 1);
	}
	@Test
	public void setpiecetest() {
		game.setPiece(5,5);
		b = game.getBoard();
		assertTrue(b[5][5].isRed());
	}
	@Test
	public void setpiecetwotest() {
		game.changeTurn();
		game.setPiece(5,5);
		b = game.getBoard();
		assertTrue(b[5][5].isBlack());
	}
	@Test
	public void redhorizwintest() {
		game = new Game();
		game.setPiece(1,5);
		game.setPiece(1,2);
		game.setPiece(2,5);
		game.setPiece(2,2);
		game.setPiece(3,5);
		game.setPiece(3,2);
		game.setPiece(4,5);
		b = game.getBoard();
		assertTrue(game.gameStatus());
	}
	

}
