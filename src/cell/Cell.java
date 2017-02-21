package cell;

public class Cell {

	
	private static int state;
	private static int maxLive = 3;
	private static int minLive = 1;
	private static int nBorn = 2;
	private static int neighbors = 0;
	
	private static int[][] uniEnd;
	
	public Cell(){
		
		state = 0;
	}
	
	
	public static int getStateCell(){
	
		return state;
	}
	
	
	
	public static void setStateCell(int valueState){
		
		state = valueState;
	}
	
	
	public static int checkLife(int nLiveNeighbors, int valueNow){
		
		int valueLife = 0;
		
		if(valueNow == 1){
		if(nLiveNeighbors > maxLive || nLiveNeighbors < minLive){
			
			valueLife= 0;
			}
		} else {
			valueLife = 1;
		}
		
		if(valueNow == 0){
			
			if(nLiveNeighbors == nBorn ){
				valueLife = 1;
			} else {
				valueLife = 0;
			}
		}
		return valueLife;
	}
	

	public static int nNeighbors(int live){
		
		neighbors += live;
		return neighbors;
		
	}
	
	public  static void  seeArea(int[][] uni, int cols, int rows){
		
		
		
		int nCols = 0;
		int nRows = 0;
		int valueNeig;
		
		for (int x=0;x<=(cols*rows); x++){
			
			
			
			if(nCols == cols ){
				nCols = 0;
				
				if(nRows==rows-1){
					nRows=rows-1;
				} else {
				nRows++;}

			}
			
			
			//setStateCell(uni[nRows][nCols]);
			valueNeig = 0;
			
			// Rows -1
			if(nRows-1>=0){
				
				
				if(nCols-1>=0){
					if(uni[nRows-1][nCols-1] == 1){
						valueNeig++;	
					}
				}
				
				if(uni[nRows-1][nCols] == 1){
					valueNeig++;	
				}
				
				if(nCols+1<=cols-1){
					if(uni[nRows-1][nCols+1] == 1){
						valueNeig++;	
					}
				}
				
			}
			
			
			// Rows =
			if(nCols-1>=0){
				if(uni[nRows][nCols-1] == 1){
					valueNeig++;	
				}
			}
			
			
			if(nCols+1<=cols-1){
				
				if(uni[nRows][nCols+1] == 1){
					valueNeig++;	
				}
			}
			
			
			
			// Rows +1
			if(nRows+1<=rows-1){
				
				
				if(nCols-1>=0){
					if(uni[nRows+1][nCols-1] == 1){
						valueNeig++;	
					}
				}
				
				if(uni[nRows+1][nCols] == 1){
					valueNeig++;	
				}
				
				if(nCols+1<=cols-1){
					if(uni[nRows+1][nCols+1] == 1){
						valueNeig++;	
					}
				}
				
			}
			
		
			
			
			uni[nRows][nCols] = checkLife(valueNeig, uni[nRows][nCols] );
			
			
			nCols++;
				
		}
		
		uniEnd = uni;
		
		
		
	}
	
	
	public int[][] getUni(){
		
		return uniEnd;
	}
	
}
