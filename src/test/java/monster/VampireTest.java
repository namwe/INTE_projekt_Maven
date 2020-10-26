package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Equipment;
import character.Scroll;
import character.StatEquipment;
import character.Sword;

class VampireTest {

	private final static int MAXSTRENGTH = 90;
	private final static int MINSTRENGTH = 5;
	private static final int NIGHTSPEED = 80;
	private static final int DAYSPEED = 5;
	private static final int NIGHTAGRESSIVENESS = 50;
	private static final int DAYAGRESSIVENESS = 5;

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
		assertEquals(DAYSPEED, v.getSpeed());
		assertEquals(DAYAGRESSIVENESS, v.getAggressiveness());
	}

	@Test
	void hurtMonsterWithScrollMana0IncreasesAggrressivenessBy5Test() {
		Vampire v = new Vampire(new NowMockNightTrue());
		StatEquipment statEqu = new StatEquipment(0, 0);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		assertEquals(NIGHTAGRESSIVENESS + 5, v.getAggressiveness());
	}

	@Test
	void hurtMonsterMana5StrengthMoreThan0IncreAggrreBy5AndDecereasesStrengthBy1Test() {
		Vampire v = new Vampire(new NowMockNightTrue());
		StatEquipment statEqu = new StatEquipment(0, 5);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		assertEquals(NIGHTAGRESSIVENESS + 5, v.getAggressiveness());
		assertEquals(MAXSTRENGTH - 1, v.getStrength());
	}

	@Test
	void hurtMonsterWithScrollMana5Strength0IncreAggrreBy5ANoChangeToStrengthTest() {
		Vampire v = new Vampire(new NowMockNightTrue());
		v.strength = 0;
		StatEquipment statEqu = new StatEquipment(0, 5);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		assertEquals(0, v.getStrength());
		assertEquals(NIGHTAGRESSIVENESS + 5, v.getAggressiveness());
	}

	@Test
	void hurtMonsterMana10IncreAggrreBy5AndDecerStrengthBy5DecrSpeedBy2Test() {
		Vampire v = new Vampire(new NowMockNightTrue());
		StatEquipment statEqu = new StatEquipment(0, 10);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		assertEquals(MAXSTRENGTH - 5, v.getStrength());
		assertEquals(NIGHTAGRESSIVENESS + 5, v.getAggressiveness());
		assertEquals(NIGHTSPEED - 2, v.getSpeed());
	}

	@Test
	void hurtMonsterMana10Strength4SetStrengthTo0Test() {
		Vampire v = new Vampire(new NowMockNightTrue());
		v.strength = 4;
		StatEquipment statEqu = new StatEquipment(0, 10);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		assertEquals(0, v.getStrength());
		assertEquals(NIGHTAGRESSIVENESS, v.getAggressiveness());
		assertEquals(NIGHTSPEED, v.getSpeed());
	}

	@Test
	void hurtMonsterMana10Speed1IncreAggrreBy5AndDecerStrengthBy5NoDecrInSpeedTest() {
		Vampire v = new Vampire(new NowMockNightTrue());
		v.speed = 1;
		StatEquipment statEqu = new StatEquipment(0, 10);
		Equipment scroll = new Scroll(statEqu);
		v.hurtMonster(scroll);
		System.out.println(v);
		assertEquals(MAXSTRENGTH - 5, v.getStrength());
		assertEquals(NIGHTAGRESSIVENESS + 5, v.getAggressiveness());
		assertEquals(1, v.getSpeed());
	}
	
	@Test
	void hurtMonsterEquimpmentNotInstanceOfScrollThrowsExceptionTest() {
		Monster v = new Vampire(new NowMockNightTrue());
		StatEquipment statEqu = new StatEquipment(0, 10);		
		assertThrows(IllegalEquipmentException.class, () -> {
			Equipment sword = new Sword(statEqu);	
			v.hurtMonster(sword);
			});
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
