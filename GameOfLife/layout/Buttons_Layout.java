package layout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import universe.Board;

public class Buttons_Layout extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522653000315918611L;

	private static JTextField infoRows;
	private static JTextField infoCols;
	public static JButton buttonUpdateCR;
	
	public static JButton buttonNew;
	public static JButton buttonStop;
	
	public static JLabel txtGeneration;
	
	public Buttons_Layout(){
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setBackground(Color.GRAY);
		
		
		dimensionButtons();
		basicButtons();

		
	}
	
	private void basicButtons(){
		
		
		buttonNew = new JButton("New");
		add(buttonNew);
		
		
		buttonStop = new JButton("Stop");
		add(buttonStop);
	}
	
	
	private void dimensionButtons(){
		
		txtGeneration = new JLabel("Generation:  "+Univers_Layout.getBoard().getGeneration()+" "); 
		
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
