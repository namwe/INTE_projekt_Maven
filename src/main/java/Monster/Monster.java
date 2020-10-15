package Monster;

import java.util.ArrayList;
import java.util.Arrays;

public class Monster {
	
	//Den här klassen ska vara abstract
	
	private int strength; 
	private int speed; 
	private int aggressiveness; 
	private Habitat[] habitats; 
	
	
    public Monster(int strength, int speed, int aggressiveness, Habitat ...habitats) {
    this.strength = strength;
    this.speed = speed;
    this.aggressiveness = aggressiveness;
    this.habitats = habitats;   
    }
    
    public int getStrength() {
    	return strength; 
    }
    
    public int getSpeed() {
    	return speed;
    }
    
    public int getAggressiveness() {
    	return aggressiveness;
    }
    /*
    public Habitat[] getHabitats() {
    	 return habitats;
    }
    */
    
    public String toString() {
    	return strength + " " + speed +  " " + aggressiveness +	" " +  Arrays.toString(habitats) ;
    }
    
}
