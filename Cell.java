package conn4;

public class Cell {

	private boolean isRed;
	
	private boolean isBlack;
	
	Cell(boolean red, boolean black){
		red = isRed;
		black = isBlack;
	}

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
