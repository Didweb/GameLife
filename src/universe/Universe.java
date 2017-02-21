package universe;



import java.awt.Color;
import javax.swing.JFrame;

import universe.Board;

import cell.Cell;

public class Universe  extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String version = "0.1";
	
	public static Board board;
	public static Cell cells;
	
	private static Thread thread;
	
	
	
	public Universe(){
		board = new Board();
		cells = new Cell();
	
	}
	
	private   void game() {
		
		
		 
		 
		setSize(1200,1024);
	    setTitle("Game of Life v."+version+" | http://github.com/DidWeb");
	   
	    setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		
		add(board);
		setVisible(true);
		

	}
	private static void updateGeneration(){
		
		Board.updateGeneration();
		
	}
	
	private synchronized void sohwGeneration(){
		
		repaint();
		
	}
	

	public static void main(String[] args)  {
		
		
		Universe univers = new Universe();
		univers.iniciar();

	}

	
	private synchronized void iniciar(){
			
			
		game();
			thread = new Thread(this, "Graficos");
			thread.start();
		}
		
	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime(); 
		
		double  timepoTranscurrido;
		double delta = 0;
		
		
		
		while(Board.active){
			final long inicioBucle = System.nanoTime();
			
			timepoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion =  inicioBucle;
			
			delta += timepoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				updateGeneration();
				delta--;
				
			}
			sohwGeneration();
			
			if (System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){
				
				//aps = 0;
				//fps = 0;
				referenciaContador = System.nanoTime();
			}
			
			
		}
		
	}


}



