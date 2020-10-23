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
	
	public Monster(int strength, int speed, int aggressiveness) {
		//super('T', new Position(0,0, 1,1), new Map(new Room[2][2])); 
		super('T', new Position(0,0, 1,1), new Map()); 
		this.strength = strength;
		this.speed = speed;
		this.aggressiveness = aggressiveness;

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

	public String toString() {
		return strength + " " + speed + " " + aggressiveness;
	}

}
