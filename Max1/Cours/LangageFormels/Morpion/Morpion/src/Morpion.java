
public class Morpion {
	//ATTRIBUTES
	private int[] tab;
	private int value;
	
	
	//METHODS
	public Morpion(){
		this.tab = new int[9];
		for(int i = 0; i < 9; i ++){
				tab[i] = 0;
		}
		value = 0;
	}
	
	public Morpion(int[] t){
		this.tab = t;
		this.value = 0;
	}
	
	public Morpion(int[] t, int v){
		this.tab = t;
		this.value = v;
	}
	
	public int[] getTab(){
		return this.tab;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getElem(int index){
		return this.tab[index];
	}
	
	public void setElem(int value, int index){
		this.tab[index] = value;
	}
	
	public void setValue(int v){
		this.value = v;
	}
	
	public boolean isWinning(int value){
		
		if(this.getElem(0) == value && (this.getElem(1) == value && this.getElem(2) == value) || (this.getElem(3) == value && this.getElem(6) ==  value) || (this.getElem(4) == value && this.getElem(8) ==  value)){
			return true;
		}else if(this.getElem(1) == value && this.getElem(4) == value && this.getElem(7) == value){
			return true;
		}else if(this.getElem(2) == value && (this.getElem(5) == value && this.getElem(8) == value) || (this.getElem(4) == value && this.getElem(6) ==  value)){
			return true;
		}else if(this.getElem(3) == value && this.getElem(4) == value && this.getElem(5) == value){
			return true;
		}else if(this.getElem(6) == value && this.getElem(7) == value && this.getElem(8) == value){
			return true;
		}
		
		return false;
	}
	
	
	public String toString(){
		String str = this.tab[0] + "|" + this.tab[1] + "|" + this.tab[2];
		str += "\n";
		str += "-----";
		str += "\n";
		str += this.tab[3] + "|" + this.tab[4] + "|" + this.tab[5];
		str += "\n";
		str += "-----";
		str += "\n";
		str += this.tab[6] + "|" + this.tab[7] + "|" + this.tab[8];
		return str;
	}
	
	
}
