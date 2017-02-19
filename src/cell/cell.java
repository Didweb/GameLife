package cell;

public class cell {

	
	private static boolean state;
	private static int maxLive = 3;
	private static int minLive = 2;
	private static int nBorn = 3;
	
	
	public cell(){
		
		state = false;
	}
	
	
	public static boolean getStateCell(){
	
		return state;
	}
	
	
	
	public static void setStateCell(boolean valueState){
		
		state = valueState;
	}
	
	
	public static void checkLife(int nLiveNeighbors){
		
		if(state == true){
		if(nLiveNeighbors > maxLive || nLiveNeighbors < minLive){
			
			setStateCell(false);
			}
		} else {
			if(nLiveNeighbors == nBorn ){
				setStateCell(true);
			}
		}
		
	}
	
}
