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
	Equipment scroll = new Scroll(statEqu);

	@Test
	void VampireConstructorSetsValuesCorrectWhenNightTest() {
		Vampire v = new Vampire(new NowMockNightTrue());
		assertEquals(MAXSTRENGTH, v.getStrength());
		assertEquals(80, v.getSpeed());
		assertEquals(50, v.getAggressiveness());
		assertEquals(TypeOfMonster.VAMPIRE, v.getMonsterType());
	}

	@Test
	void VampireConstructorSetsCorrectWhenDayTest() {
		Vampire v = new Vampire(new NowMockNightFalse());
		assertEquals(MINSTRENGTH, v.getStrength());
		assertEquals(5, v.getSpeed());
		assertEquals(5, v.getAggressiveness());
	}


	@Test  ///testa alla varianter av denna metod 
	void hurtMonsterWithScrollManaOver3DecreasesStrengthBy2() { /// ÄNDRA OM METODEN IMPLEMENTERAS.
		Vampire v = new Vampire(new NowMockNightTrue());
		v.hurtMonster(scroll);
		System.out.println(v);
		System.out.println(v.getStrength());
		System.out.println(scroll.getStats()); 
		assertEquals(MAXSTRENGTH-2, v.getStrength());

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
