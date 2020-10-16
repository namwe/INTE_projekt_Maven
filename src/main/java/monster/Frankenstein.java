package monster;

public class Frankenstein extends Monster {

	private static final int MAXSTRENGTH = 60;
	private static Frankenstein INSTANCE = null;

	
	private Frankenstein() {
		super(MAXSTRENGTH,20,30);
	}
	
	public static Frankenstein getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Frankenstein();
		}
		return INSTANCE;
	}
	
	
	public void hurtFrankenstein() { 
		if (this.getStrength() > 1) {
		int currentStrength = this.getStrength();
		int newStrength = (int) (currentStrength * 0.9);
		    this.strength = newStrength;
		}
		else {
			this.strength = 0;
			//System.out.println("Frankenstein är död - ok att återuppliva");
		}
		
	}
	
	 public void revive(){    
		 if (this.strength == 0)
	    		this.strength = MAXSTRENGTH;
	    }
	 
	 
	 
	 
	
}
