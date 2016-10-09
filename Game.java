package conn4;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

	Cell board[][];
	int PlayerTurn = 1;
	int row = 6;
	int col = 7;
	Boolean GameOver = false;
	Boolean validMove = true;
	boolean isRed;
	boolean isBlack;

	public Game() {

		board = new Cell[row][col];
		newGame();
//		while (!GameOver) {
//			System.out.println("It's Player " + PlayerTurn + "'s turn");
//			PrintArray(board);
//			
//			do{
//
//			System.out.println("What column do you want to go in? enter 0-5");  //temp way to get input for turn method
//			Scanner reader = new Scanner(System.in);
//			int input = reader.nextInt();
//			
//			Turn(PlayerTurn,input);
//			
//			}while(!validMove);
//			
//			GameOver = GameStatus(PlayerTurn);
//			PrintArray(board);
//			ChangeTurn();
//
//		}

	}
	

	public void newGame() {
		for (int rows = 0; rows < row; rows++) {
			for (int cols = 0; cols < col; cols++) {
				board[rows][cols] = new Cell(false, false);
			}
		}
		System.out.println("New Game Started\n");
	}
	
	public int GetPlayerTurn(){
		return PlayerTurn;
	}

//	public void Turn(int player, int input) {
//
//		if ((input > col) || (input < 0))
//		{
//			System.out.println("Not a Valid Move");
//			validMove = false;
//			return;
//		}
//
//		while (board[row-1][input].isRed() == false && 
//				board[row-1][input].isBlack() == false && row > 1)// checks if column is open
//		{
//			row--;
//		}
//		 if(PlayerTurn == 1){
//				board[row][input].setRed(true);
//				System.out.println("Your Turn is over");
//				validMove = true;
//				return;
//		}
//		 if(PlayerTurn == 2){
//				board[row][input].setBlack(true);
//				System.out.println("Your Turn is over");
//				validMove = true;
//				return;
//			 
//		 }
//		 
//	}
	
	public void setPiece(int r, int c){
		
		if(board[r][c].isBlack() || board[r][c].isRed()){ //throw error here
			System.out.println("Error: Stack Full");
			return;
		}
		
		else if(PlayerTurn == 1){
			for(int i = r; i < 6; i++){
				if(i==5 || board[i + 1][c].isRed()||
					board[i + 1][c].isBlack()){
					board[i][c].setRed(true);	
					ChangeTurn();
					GameStatus();
					return;
				}
			}
		}
		else if(PlayerTurn == 2){
			for(int i = r; i < 6; i++){
				if(i==5 || board[i + 1][c].isRed()||
					board[i + 1][c].isBlack()){
					board[i][c].setBlack(true);
					ChangeTurn();
					GameStatus();
					return;
				}
			}
		}
		else{}
		
	}

//	public void PrintArray(int[][] array) {
//		for (int rows = row - 1; rows >= 0; rows--) {
//			for (int cols = 0; cols < col; cols++) {
//				System.out.print(array[rows][cols] + "  ");
//			}
//			System.out.print("\n");
//		}
//	}

	public void ChangeTurn() {
		if (PlayerTurn == 1)
			PlayerTurn = 2;
		else if (PlayerTurn == 2)
			PlayerTurn = 1;
		else
			System.out.println("PlayerTurn is out of bounds");
	}

	public boolean GameStatus() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				
			//Red Wins Vertical	
			if(r+3 < 6){
				if (board[r][c].isRed()){
					 if (board[r+1][c].isRed()){
						 if (board[r+2][c].isRed()){
							 if (board[r+3][c].isRed()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}
			//Red Wins Horizontal
			if(c+3 < 7){
				if (board[r][c].isRed()){
					 if (board[r][c+1].isRed()){
						 if (board[r][c+2].isRed()){
							 if (board[r][c+3].isRed()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}

			//Diagonal Right
			if(r+3 < 6 && c - 3>= 0){
				if (board[r][c].isRed()){
					 if (board[r+1][c-1].isRed()){
						 if (board[r+2][c-2].isRed()){
							 if (board[r+3][c-3].isRed()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}
			
			//Diagonal Left
			if(r+3 < 6 && c + 3 < 7){
				if (board[r][c].isRed()){
					 if (board[r+1][c+1].isRed()){
						 if (board[r+2][c+2].isRed()){
							 if (board[r+3][c+3].isRed()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}
			// Black Wins Vertical
			if(r+3 < 6){
				if (board[r][c].isBlack()){
					 if (board[r+1][c].isBlack()){
						 if (board[r+2][c].isBlack()){
							 if (board[r+3][c].isBlack()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}
			//Black Wins Horizontal
			if(c+3 < 7){
				if (board[r][c].isBlack()){
					 if (board[r][c+1].isBlack()){
						 if (board[r][c+2].isBlack()){
							 if (board[r][c+3].isBlack()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}

			//Black Diagonal Right
			if(r+3 < 6 && c - 3>= 0){
				if (board[r][c].isBlack()){
					 if (board[r+1][c-1].isBlack()){
						 if (board[r+2][c-2].isBlack()){
							 if (board[r+3][c-3].isBlack()){
						 
					 

					System.out.println(PlayerTurn + " Won!");

					return true;
							 }
						 }
					 }
				 }
			}
			
			//Black Diagonal Left
			if(r+3 < 6 && c + 3 < 7){
				if (board[r][c].isBlack()){
					 if (board[r+1][c+1].isBlack()){
						 if (board[r+2][c+2].isBlack()){
							 if (board[r+3][c+3].isBlack()){
						 
					 

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
//				// left/right
//				else if ((c <= col-4) && board[r][c] == PlayerTurn && board[r][c + 1] == PlayerTurn && board[r][c + 2] == PlayerTurn
//						&& board[r][c + 3] == PlayerTurn) {
//
//					System.out.println(PlayerTurn + " Won!");
//
//					return true;
//
//				}
//				// up right/down left
//				else if ((r <= row-4) &&(c <= col-4) && board[r][c] == PlayerTurn && board[r + 1][c + 1] == PlayerTurn
//						&& board[r + 2][c + 2] == PlayerTurn && board[r + 3][c + 3] == PlayerTurn) {
//					System.out.println(PlayerTurn + " Won!");
//
//					return true;
//
//				}
//				// up left/ down right
//				else if ((c <= col-4) && (r >= 3) && board[r][c] == PlayerTurn && board[r - 1][c + 1] == PlayerTurn
//						&& board[r - 2][c + 2] == PlayerTurn && board[r - 3][c + 3] == PlayerTurn) {
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

	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	
}