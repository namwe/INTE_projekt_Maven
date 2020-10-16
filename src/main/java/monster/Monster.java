package monster;

public abstract class Monster {
	
	
	protected int strength; 
	private int speed; 
	private int aggressiveness; 
	
	
    
    public Monster(int strength, int speed, int aggressiveness) {
    this.strength = strength;
    this.speed = speed;
    this.aggressiveness = aggressiveness;
   
    }
    
    public int getStrength() {
    	return strength; 
    }
    
    protected void setStrength(int strength) { //för test - inte ok förmodligen
    	this.strength = strength;
      }
    
    public int getSpeed() {
    	return speed;
    }
    
    public int getAggressiveness() {
    	return aggressiveness;    	
    }
       
    
    public String toString() {
    	return strength + " " + speed +  " " + aggressiveness;
    }
    
}
