package GeneAlgo;
import java.util.ArrayList;


public abstract class Individual implements Comparable<Individual>{
	//ATTRIBUTES
	protected int fitness;
	protected ArrayList<IGene> genome;
	
	//METHODS
	public int getFitness(){
		return this.fitness;
	}
	
	public ArrayList<IGene> getGenome(){
		return this.genome;
	}
	
	public abstract void Mutate();
	public abstract int Evaluate();
	
	public int compareTo(Individual b){
		if(this.fitness > b.fitness){ return 1; }
		else{ return 0; }
	}
	
	public String toString(){
		String str = this.fitness  + " : " + genome;
		return str;
	}
	
	
}
