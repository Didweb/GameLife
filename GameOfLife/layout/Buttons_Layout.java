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

public class Buttons_Layout extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522653000315918611L;

	private JTextField infoRows;
	private JTextField infoCols;
	private JButton buttonUpdateCR;
	
	public Buttons_Layout(){
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.GRAY);
		
		
		textUnivers();
		
		add(new JButton("New"));
		
		add(new JButton("Stop"));
		
	}
	
	private void textUnivers(){
		
		
		JLabel txtRows = new JLabel("Rows:  ");
		infoRows = new JTextField(""+Board.getRows(), 10);
		
		JLabel txtCols = new JLabel("Cols:  ");
		infoCols = new JTextField(""+Board.getCols(), 10);
		
		add(txtRows);
		add(infoRows);
		
		add(txtCols);
		add(infoCols);
		
		buttonUpdateCR = new JButton("Update dimensions");
		
		add(buttonUpdateCR);
		
		
	}
	
	

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
				System.out.println("Rows: ");
			
			
		}
		
	
	
}