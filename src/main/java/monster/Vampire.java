package monster;

public class Vampire extends Monster {
	
	private final static int MAXSTRENGTH = 90; 
	private final static int MINSTRENGTH = 5; 
	private final static int DEFAULTSPEED = 80; 
	private final static int DEFAULTAGRESSIVENESS = 50;
	
		
	public Vampire(Now n) {	//dependency injection
		super((n.isNight())? MAXSTRENGTH : MINSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS);  
	}
	

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
		//"Här borde endast särskild typ av attack typ silversvärd döda Vampyren"); 	
	}
	
	
	
	

}
