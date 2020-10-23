package monster;

import character.Scroll;
import character.Equipment;

public class Vampire extends Monster {

	private static final int MAXSTRENGTH = 90;
	private static final int MINSTRENGTH = 5;
	private static final int DEFAULTSPEED = 80;
	private static final int DEFAULTAGRESSIVENESS = 50;
	
	
	

	public Vampire(Now n) { // dependency injection
		super((n.isNight()) ? MAXSTRENGTH : MINSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS, TypeOfMonster.VAMPIRE);
	}

	public int getStrength(Now n) {
		if (!n.isNight()) {
			strength = MINSTRENGTH;
		} else {
			strength = MAXSTRENGTH;
		}
		return strength;
	}

	public void hurtMonster(Equipment equ) {
		// "Endast trolleri skadar Vampyren, scroll med hög mana skadar mer");
		if (equ instanceof Scroll) {
			if (equ.getStats().getMana()> 3) {
				System.out.println(equ.getStats());
				System.out.println(equ); 
				if (strength > 1)
					strength = strength - 2;
				else {strength = strength - 1;}
			}
		}
	}

	
	
}
