import java.util.ArrayList;


public class BruteFor {
	//ATTRIBUTES
	private Map map;
	private int nbrTowns;
	
	//METHODS
	public BruteFor(Map m, int nT){
		this.map = m;
		this.nbrTowns = nT;
	}
	
	public Map getMap(){
		return(this.map);
	}
	
	public int getNbrTowns(){
		return(this.nbrTowns);
	}
	
	public long bruteForce(){
		
		long result = 0;
		
		int[] tab = new int[this.nbrTowns];
		
		for(int i = 1; i <= this.nbrTowns; i++){
			tab[i - 1] = i;
		}
		
		Permutation perm = new Permutation(tab);
		
		ArrayList<Travel> travelList = perm.setTravels();
		
		result = minLength(travelList);
		
		System.out.println("Le resultat trouvé par BruteForce est : " + result);
		
		return result;
	}
	
	
	public long minLength(ArrayList<Travel> list){
		long result = Long.MAX_VALUE;
		
		for(int i = 0; i < list.size(); i++){
			if(result > list.get(i).calculLength(this.map)){
				result = list.get(i).calculLength(this.map);
			}
		}
		
		return result;
	}
}
