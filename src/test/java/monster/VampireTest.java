package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Equipment;
import character.Scroll;
import character.StatEquipment;

class VampireTest {

	private final static int MAXSTRENGTH = 90;
	private final static int MINSTRENGTH = 5;
	StatEquipment statEqu = new StatEquipment(5, 5);
	Equipment equ = new Scroll(statEqu);

	@Test
	void VampireConstructorSetsValuesCorrectWhenNightTest() {
		Vampire v = new Vampire(new NowMockNightTrue());
		assertEquals(MAXSTRENGTH, v.getStrength());
		assertEquals(80, v.getSpeed());
		assertEquals(50, v.getAggressiveness());
	}

	@Test
	void VampireConstructorSetsValuesCorrectWhenDayTest() {
		Vampire v = new Vampire(new NowMockNightFalse());
		assertEquals(MINSTRENGTH, v.getStrength());
		assertEquals(80, v.getSpeed());
		assertEquals(50, v.getAggressiveness());
	}

	@Test
	void getStrengthReturnsMINSTRENGTHWhenDayTest() {
		Vampire v = new Vampire(new NowMockNightFalse());
		v.getStrength(new NowMockNightFalse());
		assertEquals(MINSTRENGTH, v.getStrength());
	}

	@Test
	void getStrengthReturnsMINSTRENGTHWhenNightTest() {
		Vampire v = new Vampire(new NowMockNightTrue());
		v.getStrength(new NowMockNightTrue());
		assertEquals(MAXSTRENGTH, v.getStrength());
	}

	@Test
	void hurtMonsterTestDoesNothing() { /// ÄNDRA OM METODEN IMPLEMENTERAS.
		Vampire v = new Vampire(new NowMockNightTrue());
		v.hurtMonster(equ);
		assertEquals(MAXSTRENGTH - 1, v.getStrength());

	}

	private class NowMockNightFalse extends Now {
		private NowMockNightFalse() {
		}

		@Override
		public boolean isNight() {
			return false;
		}
	}

	private class NowMockNightTrue extends Now {
		private NowMockNightTrue() {
		}

		@Override
		public boolean isNight() {
			return true;
		}
	}

}
