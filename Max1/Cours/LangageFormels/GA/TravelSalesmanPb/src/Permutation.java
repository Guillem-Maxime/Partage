import java.util.ArrayList;


public class Permutation {
	//ATTRIBUTES
	int[] initial;
	ArrayList<int[]> permutList;
	
	//METHODS
	public Permutation(int[] tab){
		this.initial = tab;
		this.permutList = permutations(tab); 
	}
	
	public int[] getInitial(){
		return(this.initial);
	}
	
	public ArrayList<int[]> getPermutList(){
		return(this.permutList);
	}
	
	
	public static ArrayList<int[]> permutations(int[] tab){
		
		ArrayList<int[]> resultList = new ArrayList<int[]>();
		
		subPermutations(tab, 0, resultList);
		
		return resultList;
	}

	
	public static void subPermutations(int[] tab, int pos, ArrayList<int[]> list){
		
		if(tab.length - pos == 1){
			list.add(tab.clone());
		}else{
			for(int i = pos; i < tab.length; i ++){
				swap(tab, pos, i);
				subPermutations(tab, pos + 1, list);
				swap(tab, pos, i);
			}
		}
	}
	
	
	public static void swap(int[] tab, int pos1, int pos2){
		int tmp = tab[pos1];
		tab[pos1] = tab[pos2];
		tab[pos2] = tmp;
	}
	
	public ArrayList<Travel> setTravels(){
		ArrayList<Travel> result = new ArrayList<Travel>();
		
		for(int i = 0; i < this.permutList.size(); i ++){
			Travel t = new Travel(this.initial.length, this.permutList.get(i));
			result.add(i, t);
		}
		
		return result;
	}
}
