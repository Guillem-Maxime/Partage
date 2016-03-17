
public class Couple {
	//ATTRIBUTES
	private Travel parent1;
	private Travel parent2;
	
	//METHODS
	public Couple(Travel t1, Travel t2){
		this.parent1 = t1;
		this.parent2 = t2;
	}
	
	public Travel getParent1(){
		return(this.parent1);
	}
	
	public Travel getParent2(){
		return(this.parent2);
	}
	
}
