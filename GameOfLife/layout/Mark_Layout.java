package layout;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Mark_Layout extends JFrame{
	
	private String version = "v.0.1";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2347357195798973449L;

	public Mark_Layout(){
		
		setTitle("Game of Life "+version+" | http://github.com/DidWeb | Eduardo Pinuaga");
		
		setBounds(1200,1000,1200,1000);
		
		Panel_Layout sheet = new Panel_Layout();
		
		
		sheet.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(sheet);
		
	}

}
