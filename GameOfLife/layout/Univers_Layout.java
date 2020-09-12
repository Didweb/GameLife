package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;


import javax.swing.JPanel;

import universe.Board;

public class Univers_Layout extends JPanel {

	

	
	public static Board board;
	
	private static final long serialVersionUID = 3059378213981177726L;

	

	
	
	public static Board getBoard() {
		return board;
	}





	public  Univers_Layout(){
		
		setLayout(new BorderLayout());
		board = new Board();
		
		setBackground(Color.GRAY);
		Board.initUnivers();
		Board.randomLive();
		add(board);
		
		
	}
	
	



	public void setInstanceOfClaseA(ActionListener actionListener) {
		
		Board.setActive(true);
		Board.initUnivers();
		Board.randomLive();
		
		board.reaction();
		
		
	}






	
	
	
	
	
	
	
}
