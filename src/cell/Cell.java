package cell;

public class Cell {

	
	private static int state;
	private static int maxLive = 3;
	private static int minLive = 2;
	private static int nBorn = 3;
	private static int neighbors = 0;
	
	
	public Cell(){
		
		state = 0;
	}
	
	
	public static int getStateCell(){
	
		return state;
	}
	
	
	
	public static void setStateCell(int valueState){
		
		state = valueState;
	}
	
	
	public static void checkLife(int nLiveNeighbors){
		
		if(state == 1){
		if(nLiveNeighbors > maxLive || nLiveNeighbors < minLive){
			
			setStateCell(0);
			}
		} else {
			
			if(nLiveNeighbors == nBorn ){
				setStateCell(1);
			}
		}
		
	}
	

	public static int nNeighbors(int live){
		
		neighbors += live;
		return neighbors;
		
	}
	
	public static void seeArea(int[][] uni, int cols, int rows){
		
		int nCols = 0;
		int nRows = 0;
		int valueNeig;
		
		for (int x=0;x<(cols*rows); x++){
			
			
			
			if(nCols == cols ){
				nCols = 0;
				nRows++;
			}
			setStateCell(uni[nCols][nRows]);
			valueNeig = 0;
			
			// Rows -1
			if(nRows-1>=0){
				
				
				if(nCols-1>=0){
					if(uni[nCols-1][nRows-1] == 1){
						valueNeig++;	
					}
				}
				
				if(uni[nCols][nRows-1] == 1){
					valueNeig++;	
				}
				
				if(nCols+1<=cols){
					if(uni[nCols+1][nRows-1] == 1){
						valueNeig++;	
					}
				}
				
			}
			
			
			// Rows =
			if(nCols-1>=0){
				if(uni[nCols-1][nRows] == 1){
					valueNeig++;	
				}
			}
			
			
			if(nCols+1<=cols){
				if(uni[nCols+1][nRows] == 1){
					valueNeig++;	
				}
			}
			
			
			
			// Rows +1
			if(nRows+1<=rows){
				
				
				if(nCols-1>=0){
					if(uni[nCols-1][nRows+1] == 1){
						valueNeig++;	
					}
				}
				
				if(uni[nCols][nRows+1] == 1){
					valueNeig++;	
				}
				
				if(nCols+1<=cols){
					if(uni[nCols+1][nRows+1] == 1){
						valueNeig++;	
					}
				}
				
			}
			
			
			checkLife(valueNeig);
			uni[nCols][nRows] = getStateCell();
			
			nCols++;
				
		}
		
		
		
	}
	
	
}
