package universe;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import universe.Board;

import cell.Cell;

public class Universe  {

	

	private static String version = "0.1";
	
	public static Board board;
	public static Cell cells;
	
	
	

	
	public Universe(){
		board = new Board();
		cells = new Cell();
	
	}
	

	
	

	
	
	private static void updateGeneration(){
		
		Board.updateGeneration();
		
	}
	

	


	public static void mainXXXX(String[] args)  {
		
		
		Universe univers = new Universe();
		univers.iniciar();

	}

	
	private  void iniciar(){
			
			while(Board.active){
				
				
				
				updateGeneration();
		
			
			}
			
			
			
		}
		


	



}



