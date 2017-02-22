package layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import universe.Board;

public class Mark_Layout extends JFrame{
	
	private String version = "v.0.2";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2347357195798973449L;

	Buttons_Layout sheetButtons;
	Univers_Layout sheetUnivers;
	
	
	public Mark_Layout(){
		
		setTitle("Game of Life "+version+" | http://github.com/DidWeb | Eduardo Pinuaga");
		
		setBounds(1200,1000,1200,1000);
		
		sheetButtons = new Buttons_Layout();
		sheetUnivers = new Univers_Layout();
		
		
		
		add(sheetButtons, BorderLayout.NORTH);
		add(sheetUnivers, BorderLayout.CENTER);
		su();
		
	}
	
	
	
	
	
	
	
	
	
	public void su(){
		
	
	
		Buttons_Layout.buttonUpdateCR.addActionListener(new ActionListener() {

		@Override

		public void actionPerformed(ActionEvent e) {
			
			Board.setCols(Integer.parseInt(Buttons_Layout.getInfoCols().getText().trim()));
			Board.setRows(Integer.parseInt(Buttons_Layout.getInfoRows().getText().trim()));
			
			sheetUnivers.setInstanceOfClaseA(this);
			
			
			
		}

		});

	}
}
