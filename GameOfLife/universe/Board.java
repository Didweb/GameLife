package universe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;


import javax.swing.JPanel;

import cell.Cell;


public class Board  extends JPanel {

	private static int[][] univers;
	private static int[][] uni;
	
	private static  int cols = 150;//1024; //512;
	private static  int rows = 150; //1024; //512;
	
	
	private static int sizeCell = 4;

	private Color dead = new Color(0,0,0);
	private Color live = new Color(255,255,255);
	private Color colorLinea = new Color(150,150,150);
	
	private static Cell cells;
	
	public static boolean active = true;
	public static int generation = 0;
	private static int aLive = 0;


	public  Board(){
		

		
		initUnivers();
		randomLive();
		
		cells =  new Cell();
		
	}
	
	public static void initUnivers(){
		
		int nCols = 0;
		int nRows = 0;
		univers = new int[rows][cols];
		
		for(int x=0; x<(cols * rows); x++){
			
			if(nCols==cols){
				nCols=0;
				nRows ++;
			}
			
			univers[nRows][nCols] = 0;
			nCols++;
		}
		
	}
	
	public static void randomLive(){
		
		int ranRows;
		int ranCols;
		int ranTeil = new Random().nextInt(150); 
		
		for(int x=0; x<ranTeil;x++){
			
			ranRows = new Random().nextInt(rows); 
			ranCols = new Random().nextInt(cols); 
			
			univers[ranRows][ranCols] = 1;
		}
		
	}
	
	public void update(Graphics g){
		
		paint(g);   
		
	    
	}

	
	
	public static void updateGeneration(){
		Cell.seeArea(univers, cols, rows);
	}

	public static int[][] getUnivers() {
		return univers;
	}
	
	public void  paint(Graphics g){
		
	
		
		aLive=0;
		
		//univers = cells.getUni();
		
		int rowsF = 0;
		int colsF = 0;
		
		for(int x=0; x<(cols * rows); x++){
			
			
			if(colsF == cols){
				colsF = 0;
				rowsF++;
			}
			
			
			g.setColor( piantDeadLive(univers[rowsF][colsF]) );
			g.fillRect(rowsF*sizeCell,colsF*sizeCell,sizeCell,sizeCell); 
			
			
			colsF++;
		
		}
		if(aLive>0){
			active = true;
		} else {
			active = false;
		}
		
		generation++;
		
	}
	

	
	
	public static int getCols() {
		return cols;
	}

	public static int getRows() {
		return rows;
	}

	public Color piantDeadLive(int value){
		
		Color valueColor = dead;
		
		
		if(value>0){
			valueColor = live;
			
			aLive++;
		}  
		
		return valueColor;
	}

	
	
}
