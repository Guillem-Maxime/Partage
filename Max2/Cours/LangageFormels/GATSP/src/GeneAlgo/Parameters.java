package GeneAlgo;
import java.util.Random;


public class Parameters {
	//ATTRIBUTES
	private static int individualsNb;
	private static int generationsMaxNb;
	private static int initialGeneNb;
	private static int minFitness;
	
	private static double mutationRate;
	private static double mutationAddRate;
	private static double mutationDeleteRate;
	private static double crossoverRate;
	
	private static Random rand = new Random();
	
	//METHODS
	public static int getIndividualsNb(){
		return individualsNb;
	}
	
	public static int getGenerationMaxNb(){
		return generationsMaxNb;
	}
	
	public static int getInitialGeneNb(){
		return initialGeneNb;
	}
	
	public static int getMinFitness(){
		return minFitness;
	}
	
	public static double getMutationRate(){
		return mutationRate;
	}

	public static double getMutationAddRate(){
		return mutationAddRate;
	}
	
	public static double getMutationDeleteRate(){
		return mutationDeleteRate;
	}
	
	public static double getCrossoverRate(){
		return crossoverRate;
	}
	
	public static Random getRand(){
		return rand;
	}
	
}
