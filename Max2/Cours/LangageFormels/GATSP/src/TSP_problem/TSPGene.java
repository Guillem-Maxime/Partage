package TSP_problem;

import GeneAlgo.IGene;

public class TSPGene implements IGene{
	//ATTRIBUTES
	private City city;
	
	//METHODS
	/**
	 * General Constructor
	 * @param c City
	 */
	public TSPGene(City c){
		this.city = c;
	}
	
	/**
	 * Constructor from another gene
	 * @param g the TSPGene used
	 */
	public TSPGene(TSPGene g){
		this.city = g.city;
	}
	
	/**
	 * get Method
	 * @return Attribute City
	 */
	public City getCity(){
		return this.city;
	}
	
	/**
	 * Method that get the distance between the City in this gene and the city in another gene
	 * @param g anoter gene containing a City
	 * @return the distance between those two cities
	 */
	public int getDistance(TSPGene g){
		return GATSP.getDistance(this.city, g.city);
	}
	
	public void Mutate(){ }
	
	public String toString(){
		return this.city.toString();
	}
}
