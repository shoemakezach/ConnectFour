import java.util.Arrays;
import java.util.Scanner;

public class Game {

	int board[][] = new int[7][6];
	int PlayerTurn = 1;
	int row = 7;
	int col = 6;
	Boolean GameOver = false;

	public Game() {

		newGame();

		while (!GameOver) {
			System.out.println("It's Player " + PlayerTurn + "'s turn");
			PrintArray(board);
			
			System.out.println("What column do you want to go in? enter 0-5");  //temp way to get input for turn method
			Scanner reader = new Scanner(System.in);
			int input = reader.nextInt();
			
			Turn(PlayerTurn,input);
			GameOver = GameStatus(PlayerTurn);
			PrintArray(board);
			ChangeTurn();

		}

	}

	public void newGame() {
		for (int rows = 0; rows < row; rows++) {
			for (int cols = 0; cols < col; cols++) {
				board[rows][cols] = 0;
			}
		}
		System.out.println("New Game Started\n");
	}

	public void Turn(int player, int input) {


		for (int rows = row -1; rows >= 0; rows--)// checks if column is open
		{
			if (board[rows][input] == 0) {
				if ((rows == 0) || (board[rows - 1][input] != 0)) {
					board[rows][input] = player;
					System.out.println("Your Turn is over");
					return;
				}
			}

		}
		System.out.println("column not open");

	}

	public void PrintArray(int[][] array) {
		for (int rows = row - 1; rows >= 0; rows--) {
			for (int cols = 0; cols < col; cols++) {
				System.out.print(array[rows][cols] + "  ");
			}
			System.out.print("\n");
		}
	}

	public void ChangeTurn() {
		if (PlayerTurn == 1)
			PlayerTurn = 2;
		else if (PlayerTurn == 2)
			PlayerTurn = 1;
		else
			System.out.println("PlayerTurn is out of bounds");
	}

	public boolean GameStatus(int player) {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				if (board[r][c] == 0)
					break;


				// right
				else if ((c <= col-4) && board[r][c] == PlayerTurn && board[r + 1][c] == PlayerTurn && board[r + 2][c] == PlayerTurn
						&& board[r + 3][c] == PlayerTurn) {
					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// left
				else if ((c >= 3) && board[r][c] == PlayerTurn && board[r - 1][c] == PlayerTurn && board[r - 2][c] == PlayerTurn
						&& board[r - 3][c] == PlayerTurn) {

					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// up
				else if ((r <= row-4) && board[r][c] == PlayerTurn && board[r][c + 1] == PlayerTurn && board[r][c + 2] == PlayerTurn
						&& board[r][c + 3] == PlayerTurn) {

					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// down
				else if ((r >= 3) && (c <= col-4) && board[r][c] == PlayerTurn && board[r][c - 1] == PlayerTurn && board[r][c - 2] == PlayerTurn
						&& board[r][c - 3] == PlayerTurn) {

					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// up right
				else if ((r <= row-4) && board[r][c] == PlayerTurn && board[r + 1][c + 1] == PlayerTurn
						&& board[r + 2][c + 2] == PlayerTurn && board[r + 3][c + 3] == PlayerTurn) {
					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// up left
				else if ((r <= row-4) && (c >= 3) && board[r][c] == PlayerTurn && board[r - 1][c + 1] == PlayerTurn
						&& board[r - 2][c + 2] == PlayerTurn && board[r - 3][c + 3] == PlayerTurn) {

					System.out.println(PlayerTurn + " Won!");
					return true;

				}
				// down right
				else if ((r >= 3) && (c <= col-4) && board[r][c] == PlayerTurn && board[r + 1][c - 1] == PlayerTurn
						&& board[r + 2][c - 2] == PlayerTurn && board[r + 3][c - 3] == PlayerTurn) {
					System.out.println(PlayerTurn + " Won!");

					return true;

				}
				// down left
				else if ((r >= 3) && (c >= 3) && board[r][c] == PlayerTurn && board[r - 1][c - 1] == PlayerTurn
						&& board[r - 2][c - 2] == PlayerTurn && board[r - 3][c - 3] == PlayerTurn) {
					System.out.println(PlayerTurn + " Won!");

					return true;
				}

			}
		}
		return false;
	}
}
