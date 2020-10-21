package monster;
//spöke synligt om midnatt, annars osynligt
//Om 5000 eller mer starkare
public class Ghost extends Monster {
	
	private boolean invisible = true; 
	private int age;
	private final static int MAXAGE = 10000; 
	private final static int THRESHOLDAGE = 5000;
	private final static int MAXSTRENGTH = 70; 
	private final static int MINSTRENGTH = 50; 
	private final static int DEFAULTSPEED = 60; 
	private final static int DEFAULTAGRESSIVENESS = 20;
	
	public Ghost(int age, Now n) {	
		super((age >= THRESHOLDAGE) ? MAXSTRENGTH : MINSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS);
		this.age = age;
		if (n.isMidnight())
			this.invisible = false;
		if (this.age < 0 || this.age > MAXAGE) 
			throw new IllegalArgumentException("Age " + this.age + " not allowed "); 
	}
		
	
	public boolean isInvisible(Now n){
		 if (!n.isMidnight()) {
			 invisible = true;
			 }
		 else { invisible = false;
				 }
		return invisible;
	}
		
	
	
	public int getAge() {
    	return age;
    }
	
	
	@Override
	public void hurtMonster() {
		if (this.getStrength() > 25) {
			int currentStrength = this.getStrength();
			int newStrength = (int) (currentStrength * 0.8);
			    this.strength = newStrength;
			}
			else {
				if (this.strength <= 25);
				this.strength = 25;
				//System.out.println("Spöken kan inte dö, styrkan minskar bara till 20");
			}		
	}
	
	
	public String invisibleToString() {
		if(invisible)
			return "invisible";
			else {
				return "visible";
			}
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + " " + age + " " +invisibleToString(); 	
	}
	

}
