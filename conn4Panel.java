package conn4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class conn4Panel extends JPanel {
	/** the cells on the board. */
	private JButton[][] board;

	/** Button to reset mines. */
	//private JButton butReset;

	Image black;
	Image blank;
	Image red;
	Image BLACK;
	Image BLANK;
	Image RED;
	
	public int tempR;
	public int tempC;
	private boolean isClicked;
	
	public conn4Panel() {

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		isClicked = false;
		
		// create the board
		center.setLayout(new GridLayout(6, 7));
		board = new JButton[6][7];
		//butReset = new JButton();


		for (int row = 0; row < 6; row++)
			for (int col = 0; col < 7; col++) {
				board[row][col] = new JButton("");
				center.add(board[row][col]);
			}

		

		bottom.setLayout(new GridLayout(3, 2));
	
		// add all to contentPane
//		add(new JLabel("Connect Four"), 
//				BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		try{ //find image files
			File input1 = new File("/Users/cgonz/Documents/Blank.png");
			blank = ImageIO.read(input1);
			File input2 = new File
					("/Users/cgonz/Documents/Black.png");
			black = ImageIO.read(input2);
			File input3 = new File
					("/Users/cgonz/Documents/Red.png");
			red = ImageIO.read(input3);
		}
		catch(IOException e)
		{
			System.out.println("ERROR");
		}

		BLANK = blank.getScaledInstance
				(100, 100, Image.SCALE_DEFAULT); 
		BLACK = black.getScaledInstance
				(100, 100, Image.SCALE_DEFAULT);
		RED = red.getScaledInstance
				(100, 100, Image.SCALE_DEFAULT);
		
		displayBoard();


//		add(butReset, BorderLayout.CENTER);
	}

	
	private void displayBoard() {
		Image BLANK = blank.getScaledInstance
				(100, 100, Image.SCALE_DEFAULT); 
		for (int r = 0; r < 6 ; r++){
			for (int c = 0; c < 7; c++) {
				board[r][c].setText("");
				board[r][c].setPreferredSize(new Dimension
						(100,100));
				board[r][c].setIcon(new ImageIcon(BLANK));
		
				if(isClicked = true){
					board[tempR][tempC].setIcon(new ImageIcon(BLACK));
				
			}
		}
	}
	

	class ButtonListener implements ActionListener, 
	MouseListener {
		public void actionPerformed(ActionEvent E) {
			for (int r = 0; r < 6; r++)
				for (int c = 0; c < 7; c++)
					if (board[r][c] == E.getSource()){
						isClicked = true;
						tempR = r;
						tempC = c;
					}
			
			displayBoard();	

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//TODO Auto-generated method stub
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
}

