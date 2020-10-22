package monster;

import character.Scroll;
import character.Equipment;

public class Vampire extends Monster {

	private final static int MAXSTRENGTH = 90;
	private final static int MINSTRENGTH = 5;
	private final static int DEFAULTSPEED = 80;
	private final static int DEFAULTAGRESSIVENESS = 50;

	public Vampire(Now n) { // dependency injection
		super((n.isNight()) ? MAXSTRENGTH : MINSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS);
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
		// "Här skadar endast trolleri Vampyren");
		if (equ instanceof Scroll) {
			if (strength > 1)
				strength = strength - 1;
		}
	}

}
