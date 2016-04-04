package GeneAlgo;

public class IndividualFactory {
	
	private static IndividualFactory instance;
	
	private IndividualFactory(){ }
	
	public static IndividualFactory getInstance(){
		if(instance == null){
			instance = new IndividualFactory();
		}
		return instance;
	}
	
	
	public void Init(String type){
		//Code à implémenter plus tard
	}
	
	public Individual getIndividual(String type){
		Individual ind = null;
		//code à implémenter par la suite
		return ind;
	}
	
	public Individual getIndividual(String type, Individual mother){
		Individual ind = null;
		//code à implémenter plus tard
		return ind;
	}
	
	public Individual getIndividual(String type, Individual mother, Individual father){
		Individual ind = null;
		//code à implémenter plus tard
		return ind;
	}
}
