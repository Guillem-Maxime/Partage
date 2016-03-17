import java.util.Random;


public class Population {
	//ATTRIBUTES
	private int people;
	private Travel[] population;
	
	//METHODS
	public Population(int p, Travel[] pop){
		this.people = p;
		this.population = pop;
	}
	
	public int getPeople(){
		return(this.people);
	}
	
	public Travel[] getPopulation(){
		return(this.population);
	}
	
	
	/**
	 * Function that returns the Travel at a random index
	 * @return a randomly chosen Travel
	 */
	public Travel randTr(){
		Random rand = new Random();
		int index = rand.nextInt(this.people);
		return(this.population[index]);
	}
	
	
	/**
	 * Function that gets a Travel at the chosen index
	 * @param index the chosen index
	 * @return the corresponding Travel
	 */
	public Travel getTravel(int index){
		return(this.population[index]);
	}
	
	
	/**
	 * Function that returns the index of the longest Travel given a map
	 * @param map the given map
	 * @return the index of the longest Travel
	 */
	public int longestRoute(Map map){
		
		long length = 0;
		int index = 0;
		
		for(int i = 0; i < this.people; i++){
			if(length < this.population[i].calculLength(map)){
				length = this.population[i].calculLength(map);
				index = i;
			}
		}
		
		return index;
	}
	
	
	/**
	 * Function that returns the index of the shortest Travel given a map
	 * @param map the given map
	 * @return the index of the shortest Travel
	 */
	public int shortestRoute(Map map){
		
		long length = 0;
		int index = 0;
		
		for(int i = 0; i < this.people; i++){
			if(length > this.population[i].calculLength(map)){
				length = this.population[i].calculLength(map);
				index = i;
			}
		}
		
		return index;
	}
	
	
	/**
	 * Function that replace a Travel by another in the population
	 * @param source the Travel to be replaced
	 * @param dest the Travel replaced with
	 */
	public void replace(Travel source, Travel dest){
		
		for(int i = 0; i < this.people; i++){
			if(this.getTravel(i) == source){
				this.population[i] = dest;
			}
		}
	}
	
	
	/**
	 * Function that gets the length of the longest Travel given a map
	 * @param map the given map
	 * @return the length of the longest Travel
	 */
	public long lengthLongest(Map map){
		long result = 0;
		
		for(int i = 0; i < this.people; i++){
			if(result < this.population[i].calculLength(map)){
				result = this.population[i].calculLength(map);
			}
		}
		
		return result;
	}
	
	/**
	 * Function that gets the length of the shortest Travel given a map
	 * @param map the given map
	 * @return the length of the shortest travel
	 */
	public long lengthShortest(Map map){
		long result = Long.MAX_VALUE;
	
		for(int i = 0; i < this.people; i++){
			if(result > this.population[i].calculLength(map)){
				result = this.population[i].calculLength(map);
			}
		}
		
		return result;
	}
}
