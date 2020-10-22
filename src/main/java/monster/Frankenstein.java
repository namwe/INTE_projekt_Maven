package monster;

public class Frankenstein extends Monster {

	private static final int MAXSTRENGTH = 80;
	private static Frankenstein INSTANCE = null;
	private final static int DEFAULTSPEED = 20; 
	private final static int DEFAULTAGRESSIVENESS = 30;
	private long attackTimeStamp ;
	private long lastAttackTimeStamp; 
		
	private Frankenstein() {
		super(MAXSTRENGTH,DEFAULTSPEED,DEFAULTAGRESSIVENESS);
	}
	
	public static Frankenstein getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Frankenstein();
		}
		return INSTANCE;
	}
	
	
	 public void reviveFromDead(){    
		 if (this.strength == 0)
			 this.revive();	
	    }
	 
	 
	 private void revive(){ 
		this.strength = MAXSTRENGTH;
		this.speed = DEFAULTSPEED;
		this.aggressiveness = DEFAULTAGRESSIVENESS;
	 }
	 
	
	@Override
	public void hurtMonster() { 
		if (this.strength > 5) {
			this.strength = strength-5;
			this.aggressiveness = this.aggressiveness+5;
		}		
		else {
			this.killFrankenstein(); 		
		}
		attackTimeStamp = System.currentTimeMillis();
		this.recover(attackTimeStamp);
	}
	
	
	

	private void recover(long attackTimeStamp) {
		long timeSinceAttack;
		if (lastAttackTimeStamp == 0 ) {
			timeSinceAttack = 1000;
		}
			else {
				timeSinceAttack = attackTimeStamp - lastAttackTimeStamp;
			}	
		if (timeSinceAttack > (1000*10) && timeSinceAttack < (1000*20)) {
			this.strength = strength+5;
			if (this.aggressiveness > 5) 
			this.aggressiveness = aggressiveness-5;
		}		
		if (timeSinceAttack >= (1000*20)) {
			this.revive();
			}
		lastAttackTimeStamp = attackTimeStamp;
	}
		
	
		
	 private void killFrankenstein() {
		 	this.strength = 0;
			this.aggressiveness = 0; 
			this.speed = 0;
	 }
		 
	
}
