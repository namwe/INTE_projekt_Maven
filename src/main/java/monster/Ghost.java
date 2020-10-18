package monster;


public class Ghost extends Monster {
	//ok att sätta boolean till protected 
	//för få åtkomst för att kunna sätta 
	//båda state (true/false) test?
	protected boolean invisible; 
	private int age;
	private final static int MAXAGE = 10000; 
	private final static int MAXSTRENGTH = 70; 
	
	public Ghost(int age) {	
		super((age >= 5000) ? MAXSTRENGTH : 50, 60, 20);
		this.age = age;
		if (this.age < 0 || this.age > MAXAGE) 
			throw new IllegalArgumentException("Age " + this.age + " not allowed "); 
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
				this.strength = 20;
				//System.out.println("Spöken kan inte dö, styrkan minskar bara till 20");
			}
			
		
	}
	
	
	public boolean isInvisible(){
	return invisible;	
	}
	
	
	public void toggleVisibility(){  
		invisible = !invisible;
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
