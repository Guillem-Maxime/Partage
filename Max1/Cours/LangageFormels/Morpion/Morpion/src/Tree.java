import java.util.ArrayList;


public class Tree {
	//ATTRIBUTES
	private ArrayList<ArrayList<Morpion>> tree;
	
	//METHODS
	public Tree(){
		this.tree = new ArrayList<ArrayList<Morpion>>();
	}
	
	public ArrayList<ArrayList<Morpion>> getTree(){
		return this.tree;
	}
	
	public int stepSize(int stepIndex){
		return this.tree.get(stepIndex).size();
	}
	
	public void setRoot(){
		ArrayList<Morpion> lRoot = new ArrayList<Morpion>();
		Morpion mRoot = new Morpion();
		lRoot.set(0, mRoot);
		this.tree.set(0, lRoot);
	}
	
	public void makeTree(){
		
		this.setRoot();
		int value = 1;
		for(int i = 1; i < 9; i++){
			for(int k = 0; k < this.stepSize(i); k ++){
			
				
				this.tree.set(i+1, nextBranch(this.tree.get(i).get(k), value));
				if(value == 1){
					value = -1;
				}else{
					value = 1;
				}
			
			
			}
		}
		
	}
	
	public static ArrayList<Morpion> nextBranch(Morpion root, int value){
		ArrayList<Morpion> resultList = new ArrayList<Morpion>();
		int indList = 0;
		
		for(int i = 0; i < 9; i ++){
			if(root.getElem(i) == 0){
				Morpion tmpTab = root;
				tmpTab.setElem(value, i);
				resultList.set(indList, tmpTab); 
			}
		}
		
		return resultList;
	}
	
	public int getMValue(int generation, int morp){
		return this.tree.get(generation).get(morp).getValue();
	}
	
	public void setMValue(int generation, int morp, int value){
		this.tree.get(generation).get(morp).setValue(value);
	}
	
	public void setValues(int player, boolean isFirstPlayer){
		
		//On commence par la fin
		for(int i = 0; i < this.stepSize(9); i++){
			if(this.tree.get(9).get(i).isWinning(player)){
				this.setMValue(9, i, 1);
			}else{
				this.setMValue(9, i, 0);
			}
		}
		
		//Ensuite on remonte
		for(int j = 8; j > 0; j--){
			for(int k = 0; k < this.stepSize(j); k++){
				this.setMValue(j, k, max());
				if((isFirstPlayer && (j % 2 == 1)) || (!isFirstPlayer && (j % 2 == 0))){
				}else if((isFirstPlayer && (j % 2 == 0)) || (!isFirstPlayer && (j % 2 == 1))){
					this.setMValue(j, k, min())
				}
				
				
			}
		}
		
	}
	
	
	public int min(ArrayList<Morpion> generation){
		
		for(int i = 0; i < this.stepSize(g))
		
	}
	
	public static int max(int a, int b){
		if(a > b){
			return a;
		}else {
			return b;
		}
	}
}
