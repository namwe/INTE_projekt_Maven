package monster;

public class Vampire extends Monster {
	
	private final static int MAXSTRENGTH = 90; 
	private final static int MINSTRENGTH = 5; 
	
		
	public Vampire(Now n) {	//dependency injection
		super((n.isNight())? MAXSTRENGTH : MINSTRENGTH, 80, 50);  
	}
	
     //Överlagrad metod - Varför kan jag inte skriva @Override?
	 public int getStrength(Now n) {
		 if (!n.isNight()) {
			 this.strength = MINSTRENGTH; 
		 }
		  
		 else {
			 this.strength = MAXSTRENGTH;	 
		 }
	    	return strength; 
	    }
	

	@Override
	public void hurtMonster() {	
		//"Här borde endast särskild typ av attack döda Vampyren"); 	
	}
	
	
	
	

}
