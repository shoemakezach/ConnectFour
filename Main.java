package ConnectFour;

public class Main {

	public boolean win(){
		for(int r = 0; r < row; r++){
			for(int c = 0; c < col; c++){
				//board[r][c] is position

				if(board[r][c] == 0)
					break;
				
				//PlayerTurn 

				//right
				else if(board[r][c] == PlayerTurn && board[r+1][c] == PlayerTurn && board[r+2][c] == PlayerTurn && board[r+3][c] == PlayerTurn){
					return true; 

				}
				//left
				else if(board[r][c] == PlayerTurn && board[r-1][c] == PlayerTurn && board[r-2][c] == PlayerTurn && board[r-3][c] == PlayerTurn){
					return true; 

				}
				//up
				else if(board[r][c] == PlayerTurn && board[r][c+1] == PlayerTurn && board[r][c+2] == PlayerTurn && board[r][c+3] == PlayerTurn){
					return true; 

				}
				//down
				else if(board[r][c] == PlayerTurn && board[r][c-1] == PlayerTurn && board[r][c-2] == PlayerTurn && board[r][c-3] == PlayerTurn){
					return true; 

				}
				//up right
				else if(board[r][c] == PlayerTurn && board[r+1][c+1] == PlayerTurn && board[r+2][c+2] == PlayerTurn && board[r+3][c+3] == PlayerTurn){
					return true; 

				}
				//up left
				else if(board[r][c] == PlayerTurn && board[r-1][c+1] == PlayerTurn && board[r-2][c+2] == PlayerTurn  && board[r-3][c+3] == PlayerTurn){
					return true; 

				}
				//down right
				else if(board[r][c] == PlayerTurn && board[r+1][c-1] == PlayerTurn && board[r+2][c-2] == PlayerTurn && board[r+3][c-3] == PlayerTurn){
					return true; 

				}
				//down left
				else if(board[r][c] == PlayerTurn && board[r-1][c-1] == PlayerTurn && board[r-2][c-2] == PlayerTurn && board[r-3][c-3] == PlayerTurn){

					return true; 
				}

			}
		}
	}

}
