package monster;

import character.Equipment;
import character.Scroll;

public class Ghost extends Monster {

	private boolean invisible = true;
	private int age;
	private final static int MAXAGE = 10000;
	private final static int THRESHOLDAGE = 5000;
	private final static int MAXSTRENGTH = 70;
	private final static int MINSTRENGTH = 50;
	private final static int DEFAULTSPEED = 60;
	private final static int DEFAULTAGRESSIVENESS = 20;

	public Ghost(int age, Now n) {
		super((age >= THRESHOLDAGE) ? MAXSTRENGTH : MINSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS,
				TypeOfMonster.GHOST);
		this.age = age;
		if (n.isMidnight())
			this.invisible = false;
		if (this.age < 0 || this.age > MAXAGE)
			throw new IllegalArgumentException("Age " + age + " not allowed ");
	}

	public boolean isInvisible(Now n) {
		if (!n.isMidnight())
			return invisible = true;
		else
			return invisible = false;
	}

	public int getAge() {
		return age;
	}

	@Override
	public void hurtMonster(Equipment equ) {
		if (equ instanceof Scroll) {
			if (equ.getStats().getMana() > 0) {
				if (this.getStrength() > 25) {
					if (equ.getStats().getMana() > 1 && equ.getStats().getMana() <= 5) // mana är 1-5
						strength = (int) (strength * 0.9);
					else if (equ.getStats().getMana() > 5 && equ.getStats().getMana() < 11) // mana är 5-10
						strength = (int) (strength * 0.8);
				} else {
					this.strength = 25;
					// System.out.println("Spöken kan inte dö, styrkan minskar bara till 25");
				}
			}
				else { //Mana 0;
					aggressiveness++; }
		}
			
			else {
			throw new IllegalEquipmentException(equ, this);
			}
		}
		
	

	
	public String invisibleToString() {
		if (invisible)
			return "invisible";
		else {
			return "visible";
		}
	}

	
	@Override
	public String toString() {
		return super.toString() + " " + age + " " + invisibleToString();
	}

}
