import java.util.Random;


public class Main {
	public static void main(String[] args){
		
		//INITIALIZATION 
			//number of towns in our country
		int numberTowns = 10;
			//the value of the mutation rate
		double mutValue = 0.7;
			//The population of travels we will take
		int pop = 25;
			//the lengths between the roads in our country
		int[][] country = new int[numberTowns][numberTowns];
			//we fill our country with random values
		fillRoads(country, numberTowns);
			
		
			//we create a map that we fill with our country
		Map map = new Map(numberTowns);
		map.fillRoads(country);
		
		//Brute Force Method
		BruteFor bruteFor = new BruteFor(map, numberTowns);
		System.out.println("Methode de la Brute Force.");
		long bfResult = bruteFor.bruteForce();
		
		
		
		//Genetic algorithmic method.
		GeneAlg geneAlg = new GeneAlg(map, numberTowns, mutValue, pop);
		
		//debug
		System.out.println("Algorithme génétique pour 100 étapes.");
		geneAlg.geneticAlgorithm(100, 1);
		/*
		System.out.println("Algorithme génétique pour 10000 étapes.");
		geneAlg.geneticAlgorithm(10000, 1);
		System.out.println("Algorithme génétique pour 25000 étapes.");
		geneAlg.geneticAlgorithm(25000, 1);
		System.out.println("Algorithme génétique pour 50000 étapes.");
		geneAlg.geneticAlgorithm(50000, 1);
		System.out.println("Algorithme génétique pour 100000 étapes.");
		geneAlg.geneticAlgorithm(100000, 1);
		*/
		/*
		System.out.println("Algorithme génétique pour atteindre 4 fois la valeur trouvée par Brute Force.");
		geneAlg.geneticAlgorithm(bfResult * 4, 2);
		System.out.println("Algorithme génétique pour atteindre 3 fois la valeur trouvée par Brute Force.");
		geneAlg.geneticAlgorithm(bfResult * 3, 2);
		System.out.println("Algorithme génétique pour atteindre 2 fois la valeur trouvée par Brute Force.");
		geneAlg.geneticAlgorithm(bfResult * 2, 2);
		System.out.println("Algorithme génétique pour atteindre la valeur trouvée par Brute Force.");
		geneAlg.geneticAlgorithm(bfResult, 2);
		*/
		
	}
	
	/**
	 * Function that fill a tab with random values
	 * @param tab the tab to fill
	 * @param n the size of the tab (tab is a square matrix)
	 */
	public static void fillRoads(int[][] tab, int n){
		
		Random rand = new Random();
		int a;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i != j){
					a = rand.nextInt(10) + 1;
					tab[i][j] = a; 
				}else{
					tab[i][j] = Integer.MAX_VALUE;
				}
				
				//debug 
				//System.out.println("roads[" + i + "][" + j +"] = " + tab[i][j]);
			}
		}
	}

}
