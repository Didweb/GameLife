package layout;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import universe.Board;
import universe.Cell;

public class Buttons_Layout extends JPanel {


	private static final long serialVersionUID = 7522653000315918611L;

	private static JTextField infoRows;
	private static JTextField infoCols;
	public static JButton buttonUpdateCR;
	
	
	private static JTextField maxLive;
	private static JTextField minLive;
	private static JTextField born;
	
	public static JButton buttonNew;
	public static JButton buttonStop;
	
	public static JLabel txtGeneration;
	
	
	
	public Buttons_Layout(){
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setBackground(Color.GRAY);
		
		
		dimensionButtons();
		parametresGeneral();
		basicButtons();

		
	}
	
	private void basicButtons(){
		
		
		buttonNew = new JButton("New");
		add(buttonNew);
		
		
		buttonStop = new JButton("Stop");
		add(buttonStop);
	}
	
	private void parametresGeneral(){
		
		JLabel txtmaxLi = new JLabel("MaxLive:  ");
		Board.getCells();
		maxLive = new JTextField(""+Cell.getMaxLive(), 10);
		
		JLabel txtminLi = new JLabel("MinLive:  ");
		Board.getCells();
		minLive = new JTextField(""+Cell.getMinLive(), 10);
		
		
		JLabel txtNborn = new JLabel("Born:  ");
		Board.getCells();
		born = new JTextField(""+Cell.getnBorn(), 10);
		
		add(txtmaxLi);
		add(maxLive);
		
		add(txtminLi);
		add(minLive);
		
		add(txtNborn);
		add(born);
		
		
	}
	
	
	private void dimensionButtons(){
		
		Univers_Layout.getBoard();
		txtGeneration = new JLabel("Generation:  "+Board.getGeneration()+" "); 
		
		JLabel txtRows = new JLabel("Rows:  ");
		infoRows = new JTextField(""+Board.getRows(), 10);
		
		JLabel txtCols = new JLabel("Cols:  ");
		infoCols = new JTextField(""+Board.getCols(), 10);
		
		add(txtGeneration);
		
		add(txtRows);
		add(infoRows);
		
		add(txtCols);
		add(infoCols);
		
		buttonUpdateCR = new JButton("Update dimensions");
		
		add(buttonUpdateCR);
		
		
		
	}

	public static JTextField getInfoRows() {
		return infoRows;
	}

	public static JTextField getInfoCols() {
		return infoCols;
	}




	
	

	
		
	
	
}
