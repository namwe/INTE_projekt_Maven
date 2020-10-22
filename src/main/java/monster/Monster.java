package monster;

public abstract class Monster {
	
	
	protected int strength; 
	protected int speed; 
	protected int aggressiveness; 
	
	
    
    public Monster(int strength, int speed, int aggressiveness) {
    this.strength = strength;
    this.speed = speed;
    this.aggressiveness = aggressiveness;
   
    }
    
    abstract public void hurtMonster();
    
    public int getStrength() {
    	return strength; 
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
