package monster;

import character.Equipment;
import character.Sword;

public class Frankenstein extends Monster {

	private static Frankenstein INSTANCE = null;
	private static final int DEFAULTSTRENGTH = 80;
	private final static int DEFAULTSPEED = 20;
	private final static int DEFAULTAGRESSIVENESS = 30;
	private long lastAttackTimeStamp;

	private Frankenstein() {
		super(DEFAULTSTRENGTH, DEFAULTSPEED, DEFAULTAGRESSIVENESS, TypeOfMonster.FRANKENSTEIN);
	}

	public static Frankenstein getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Frankenstein();
		}
		return INSTANCE;
	}

	public void reviveFromDead() {
		if (strength == 0)
			revive();
	}

	private void revive() {
		strength = DEFAULTSTRENGTH;
		speed = DEFAULTSPEED;
		aggressiveness = DEFAULTAGRESSIVENESS;
	}

	@Override
	public void hurtMonster(Equipment equ) {
		if (equ instanceof Sword) {
			if (strength > 5) {
				strength = strength - 5;
				aggressiveness = aggressiveness + 5;
			} else {
				killFrankenstein();
			}
			long attackTimeStamp = System.currentTimeMillis();
			recover(attackTimeStamp);
		}
		else
			throw new IllegalEquipmentException(equ, this);
	}

	private void recover(long attackTimeStamp) {
		long timeSinceAttack;
		if (lastAttackTimeStamp == 0) {
			timeSinceAttack = 1000;
		} else {
			timeSinceAttack = attackTimeStamp - lastAttackTimeStamp;
		}
		if (timeSinceAttack > (1000 * 10) && timeSinceAttack < (1000 * 20)) {
			strength = strength + 5;
			if (aggressiveness > 5)
				aggressiveness = aggressiveness - 5;
		}
		if (timeSinceAttack >= (1000 * 20)) {
			this.revive();
		}
		lastAttackTimeStamp = attackTimeStamp;
	}

	private void killFrankenstein() {
		strength = 0;
		aggressiveness = 0;
		speed = 0;
	}

}
