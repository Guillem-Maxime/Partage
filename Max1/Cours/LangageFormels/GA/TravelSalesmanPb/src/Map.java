
public class Map {
	//ATTRIBUTES
	private int nbrTowns;
	private int[][] roads;
	
	//METHODS
	public Map(int nT){
		this.nbrTowns = nT;
		this.roads = new int[nT][nT];
	}
	
	public int getNbrTowns(){
		return(this.nbrTowns);
	}
	
	public int[][] getRoads(){
		return(this.roads);
	}
	
	
	/**
	 * Function that fill the map with values.
	 * @param r the values
	 */
	public void fillRoads(int[][] r){
		for(int i = 0; i < this.nbrTowns; i++){
			for(int j = 0; j < this.nbrTowns; j++){
				this.roads[i][j] = r[i][j];
			}
		}
	}
	
	
}
