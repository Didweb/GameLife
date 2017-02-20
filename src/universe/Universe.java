package universe;






import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import universe.Board;

public class Universe  extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String version = "0.1";
	
	public static Board board;
	
	
	private   void game() {
		
		
		
	    board = new Board();
	    setTitle("Game of Life v."+version+" | http://github.com/DidWeb");
	    setSize(1200,1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		add(board);
		setVisible(true);
		

	}
	
	
	private synchronized void initGame(){
		
		game();
		
	}
	

	public static void main(String[] args)  {
		
		
		Universe univers = new Universe();
		univers.initGame();

	}

		

}



