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
		super((n.isNight()) ? MAXSTRENGTH : MINSTRENGTH, (n.isNight()) ? NIGHTSPEED : DAYSPEED,
				(n.isNight()) ? NIGHTAGRESSIVENESS : DAYAGRESSIVENESS, TypeOfMonster.VAMPIRE);
	}

	public int getStrength() {
		return strength;
	}

	public void hurtMonster(Equipment equ) {
		// "Endast trolleri skadar Vampyren, scroll med hög mana skadar mer");
		// Om styrka skulle bli 0 sätt allt till 0 (kill monster)
		if (equ instanceof Scroll) {
			int mana = equ.getStats().getMana();
			switch (mana) {
			case 0:
				aggressiveness = aggressiveness + 5;
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				if (strength > 1) {
					strength = strength - 1;
					aggressiveness = aggressiveness + 5;
				} else {
					aggressiveness = aggressiveness + 5;
				}
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				if (strength >= 5) {
					strength = strength - 5;
					aggressiveness = aggressiveness + 5;
					if (speed > 2)
						speed = speed - 2;
				} else
					strength = 0;
				break;

			default: // Hur testa denna? Mocka ett (illegal) objekt med mana 11 tex eller överflödigt?
				throw new IllegalArgumentException();
			}
		}

	}

}
