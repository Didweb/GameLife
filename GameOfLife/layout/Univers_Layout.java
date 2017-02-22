package layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import cell.Cell;
import universe.Board;

public class Univers_Layout extends JPanel {

	
	/**
	 * 
	 */
	
	public static Board board;
	
	private static final long serialVersionUID = 3059378213981177726L;

	public  Univers_Layout(){
		
		setLayout(new BorderLayout());
		board = new Board();
		Cell cells = new Cell();
		
		setBackground(Color.GRAY);
		
		add(board);
		
		
		
		
	}
	
}
