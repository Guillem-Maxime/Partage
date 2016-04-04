package GeneAlgo;
import java.util.ArrayList;


public class EvolutionaryProcess {
	//ATTRIBUTES
	private ArrayList<Individual> population = new ArrayList<Individual>();
	protected int generationNb = 0;
	protected int bestFitness;
	protected String problem;
	
	//METHODS
	public EvolutionaryProcess(String pb){
		this.problem = pb;
		IndividualFactory.getInstance().Init(pb);
		
		for(int i = 0; i < Parameters.getIndividualsNb(); i++){
			this.population.add(IndividualFactory.getInstance().getIndividual(pb));
		}
	}
	
	public ArrayList<Individual> getPopulation(){
		return this.population;
	}
	
	public int getGenerationNb(){
		return this.generationNb;
	}
	
	public double getBestFitness(){
		return this.bestFitness;
	}
	
	public String getProblem(){
		return this.problem;
	}
	
	public void survival(ArrayList<Individual> newGeneration){
		this.population = newGeneration;
	}
	
	public Individual selection(){
		//Roulette biaisée sur le rang
		int totalRanks = ( Parameters.getIndividualsNb() * (Parameters.getIndividualsNb() - 1) ) / 2;
		int rand = Parameters.getRand().nextInt(totalRanks);
		
		int indIndex = 0;
		int nbParts = Parameters.getIndividualsNb();
		int totalParts = 0;
		
		while(totalParts < rand){
			indIndex++;
			totalParts += nbParts;
			nbParts --;
		}
		
		ArrayList<Individual> sortPopulation = sort(population);
		
		Individual ind = sortPopulation.get(indIndex);
		
		return ind;
	}
	
	
	public ArrayList<Individual> sort(ArrayList<Individual> pop){
		ArrayList<Individual> result = pop;
		boolean permut;
		Individual tmp;
		
		do{
			permut = false;
			for(int i = 0; i < result.size() - 1; i++){
				if(result.get(i).compareTo(result.get(i + 1)) == 1){
					tmp = result.get(i);
					result.set(i, result.get(i+1));
					result.set(i+1, tmp);
					permut = true;
				}
			}
		}while(permut);
		
				
		return result;
	}
	
	
	public void run(){
		this.bestFitness = Parameters.getMinFitness() + 1;
		
		while(this.generationNb > Parameters.getGenerationMaxNb() && this.bestFitness > Parameters.getMinFitness()){
			
			//Evaluation
			for(int i = 0; i < this.population.size(); i++){
				this.population.get(i).Evaluate();
			}
			
			//Best Individual
			Individual bestInd = sort(this.population).get(0);
			this.bestFitness = bestInd.getFitness();
		
			//Selection and reproduction
			ArrayList<Individual> newGeneration = new ArrayList<Individual>();
			
			//Elitism
			newGeneration.add(bestInd);
			for(int j = 0; j < Parameters.getIndividualsNb(); j++){
				if(Parameters.getRand().nextDouble() < Parameters.getMutationRate()){
					
					//Choice of parents
					Individual father = this.selection();
					Individual mother = this.selection();
					
					//Reproduction
					newGeneration.add(IndividualFactory.getInstance().getIndividual(problem, mother, father));
				}else{
					
					//Choice of parents
					Individual mother = this.selection();
					
					//Reproduction
					newGeneration.add(IndividualFactory.getInstance().getIndividual(problem, mother));
				}
				
				//Survival
				this.survival(newGeneration);
				
				this.generationNb ++;
			}
			
		}
	}
}
