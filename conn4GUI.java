package conn4;

import javax.swing.JFrame;


public class conn4GUI {

	public static void main (String[] args){
		
		JFrame frame = new JFrame ("Connect Four");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		conn4Panel panel = new conn4Panel();
        frame.getContentPane().add(panel);
        frame.setSize(900,900);
		frame.setVisible(true);
		
	}
}



