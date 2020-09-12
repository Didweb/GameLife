package universe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


import javax.swing.JPanel;

import layout.Mark_Layout;


public class Board  extends JPanel  implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4106099759895444750L;
	private static int[][] univers;
	
	private static  int cols = 1024; //512;
	private static  int rows = 1024; //512;
	
	
	private static int sizeCell = 4;

	private Color dead = new Color(0,0,0);
	private Color live = new Color(255,255,0);
	
	private static Cell cells;
	
	public static boolean active = false;


	public static int generation = 0;
	private static int aLive = 0;

	private  Thread thread;


	
	public static Cell getCells() {
		return cells;
	}

	public static void initUnivers(){
		generation = 0;
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
	
	public void mostrar(){
		
		repaint();
		
		
	}
	
	public  void update(Graphics g){
		
		paint(g);   
		
	    
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean active) {
		Board.active = active;
	}
	
	
	
	public  static void updateGeneration(){
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
	
	public  void reaction(){
	

		thread = new Thread(){
		    public void run(){
		    	int i = 0;
				while(isActive()){
					
					 try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					updateGeneration();
					mostrar();
					Mark_Layout.actuGeneration();
					
					System.out.println("====****========= "+isActive()+" "+(i++));
					
				}
		    }
		  };

		  thread.start(); 
		
	}
	
	

	
	@Override
	public void run() {
	
		int i = 0;
		while(isActive()){
			
		
			updateGeneration();
			
			System.out.println("============= "+Board.isActive()+" "+(i++));
			
		}
		
	}

	
	public static int getCols() {
		return cols;
	}

	public static int getRows() {
		return rows;
	}

	public static void setCols(int cols) {
		Board.cols = cols;
	}

	public static void setRows(int rows) {
		Board.rows = rows;
	}

	
	
	
	
	public static void setGeneration(int generation) {
		Board.generation = generation;
	}

	public static int getGeneration() {
		return generation;
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
