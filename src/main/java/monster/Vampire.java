package monster;

import character.Scroll;
import character.Equipment;

public class Vampire extends Monster {

	private static final int MAXSTRENGTH = 90;
	private static final int MINSTRENGTH = 5;
	private static final int NIGHTSPEED = 80;
	private static final int DAYSPEED = 5;
	private static final int NIGHTAGRESSIVENESS = 50;
	private static final int DAYAGRESSIVENESS = 5;

	public Vampire(Now n) { // dependency injection
		super((n.isNight()) ? MAXSTRENGTH : MINSTRENGTH,(n.isNight()) ? NIGHTSPEED : DAYSPEED, (n.isNight()) ? NIGHTAGRESSIVENESS : DAYAGRESSIVENESS, TypeOfMonster.VAMPIRE);
	}

	public int getStrength() {
		return strength;
	}
	
	
	public void sendToCoffin(Now n) { ///obs testa 
		if (!n.isNight());
		aggressiveness = DAYAGRESSIVENESS; 
		speed = DAYSPEED; 
		strength = MINSTRENGTH;	
	}
	
	public void bringOutOfCoffin(Now n) { ///obs testa 
		if (n.isNight());
		aggressiveness = NIGHTAGRESSIVENESS; 
		speed = NIGHTSPEED; 
		strength = MAXSTRENGTH;	
	}
	
	
	public void hurtMonster(Equipment equ) {
		// "Endast trolleri skadar Vampyren, scroll med hög mana skadar mer");
		if (equ instanceof Scroll) {
			if (equ.getStats().getMana()> 3) {
				if (strength > 2)
					strength = strength - 2;
				else {strength = strength - 1;}
			}
		}
	}

	
	
}
