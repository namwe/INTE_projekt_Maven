package monster;

import character.Equipment;
import character.Sword;

public class Frankenstein extends Monster {

	private static Frankenstein INSTANCE = null;
	private static final int DEFAULTSTRENGTH = 80;
	private final static int DEFAULTSPEED = 20;
	private final static int DEFAULTAGRESSIVENESS = 30;
	protected long lastAttackTimeStamp;

	private Frankenstein() {
		super(DEFAULTSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS, TypeOfMonster.FRANKENSTEIN);
	}

	public static Frankenstein getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Frankenstein();
		}
		return INSTANCE;
	}

	@Override
	public int getStrength() {
		long timeNow = System.currentTimeMillis();
		if (lastAttackTimeStamp != 0) {
			int time = (int) (timeNow - lastAttackTimeStamp);
			if (time > (1000 * 10) && time < (1000 * 20))
				strength = strength + 5;
			else if (time >= (1000 * 20))
				this.revive();
		}
		return strength;
	}

	public void reviveFromDead() {
		if (this.getStrength() == 0)
			this.revive();
	}

	private void revive() {
		strength = DEFAULTSTRENGTH;
		speed = DEFAULTSPEED;
		aggressiveness = DEFAULTAGRESSIVENESS;
	}

	@Override
	public void hurtMonster(Equipment equ) {
		lastAttackTimeStamp = System.currentTimeMillis();
		if (equ instanceof Sword) {
			if (this.getStrength() >= 5) {
				strength = getStrength() - 5;
				aggressiveness = aggressiveness + 5;
				lastAttackTimeStamp = System.currentTimeMillis();
			} else
				killFrankenstein();
			lastAttackTimeStamp = System.currentTimeMillis();
		} else
			throw new IllegalEquipmentException(equ, this);
	}

	private void killFrankenstein() {
		strength = 0;
		aggressiveness = 0;
		speed = 0;
	}

}
