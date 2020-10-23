package monster;

import character.Equipment;
import level.Map;
import level.Movable;
import level.Position;
import level.Room;


public abstract class Monster extends Movable  {

	protected int strength;
	protected int speed;
	protected int aggressiveness;
	protected TypeOfMonster monsterType;
	
	public Monster(int strength, int speed, int aggressiveness, TypeOfMonster monster ) {
		super('T', new Position(0,0, 1,1), new Map()); 
		this.strength = strength;
		this.speed = speed;
		this.aggressiveness = aggressiveness;
		this.monsterType = monster; 

	}

	abstract public void hurtMonster(Equipment equ);

	public int getStrength() {
		return strength;
	}

	public int getSpeed() {
		return speed;
	}

	public int getAggressiveness() {
		return aggressiveness;
	}

	public TypeOfMonster getMonsterType() {
		return monsterType; 
	}
	
	
	public String toString() {
		TypeOfMonster m = this.getMonsterType();
		String s; 
	/*	switch (m){
		   case VAMPIRE:
			   s = "Vampire";
		      break;
		   
		   case 2:
		      // Operation / Flera operationer ... 
		      break;
		   case 3:
		      // Operation / Flera operationer ... 
			   break; 
		   default:
		      // Operation / Flera operationer ... 
		      break;
		}
	*/
		return this.getMonsterType() + " " + strength + " " + speed + " " + aggressiveness;
	}

}
