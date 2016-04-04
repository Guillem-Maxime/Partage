package TSP_problem;
import java.util.ArrayList;



public class GATSP {
	//ATTRIBUTES
	private static ArrayList<City> cities;
	private static int[][] distances;
	
	//METHODS
	public GATSP(ArrayList<City> c, int[][] d){
		cities = c;
		distances = d;
	}
	
	public static ArrayList<City> getCities(){
		return cities;
	}
	
	public static int[][] getDistances(){
		return distances;
	}
	
	public static int getDistance(City c1, City c2){
		return distances[cities.indexOf(c1)][cities.indexOf(c2)];
	}
}
