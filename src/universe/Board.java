package universe;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


import cell.Cell;


public class Board  extends JPanel{

	private static int[][] univers;
	
	private  int cols = 1024; //512;
	private  int rows = 1024; //512;
	
	
	private Color dead = new Color(0,0,0);
	private Color live = new Color(255,255,255);
	
	
	
	public void initBoard(){
		
		int nCols = 0;
		int nRows = 0;
		univers = new int[rows][cols];
		
		for(int x=0; x<cols; x++){
			
			if(x==nCols){
				nCols=0;
				nRows ++;
			}
			
			univers[nRows][nCols] = 0;
			nCols++;
		}
		
		int ranRows;
		int ranCols;
		int ranTeil = new Random().nextInt(30); 
		
		for(int x=0; x<ranTeil;x++){
			
			ranRows = new Random().nextInt(rows); 
			ranCols = new Random().nextInt(cols); 
			
			univers[ranRows][ranCols] = 1;
		}
		
		
		
	}
	
	public void update(Graphics g){
		initBoard();
		paint(g);        
	    
	}
	
	public void  paint(Graphics g){
		
		initBoard();
		
		int rowsF = 0;
		int colsF = 0;
		
		for(int x=0; x<(cols*rows); x++){
			
			if(colsF==cols){
				colsF = 0;
				rowsF ++;
			}
			
			g.setColor( piantDeadLive(univers[rowsF][colsF]) );
			g.fillRect(colsF+4,rowsF,4 ,4); 
			colsF ++;
			//System.out.println("COl: "+colsF+" - Fila:"+ rowsF);
		}
		
		
		
	}
	
	
	
	
	public Color piantDeadLive(int value){
		
		Color valueColor = dead;
		
		if(value>0){
			valueColor = live;
		}
		
		return valueColor;
	}
	
}
