package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import character.Equipment;
import character.Scroll;
import character.StatEquipment;

class GhostTest {

	StatEquipment statEqu = new StatEquipment(5, 5);
	Equipment equ = new Scroll(statEqu);

	@Test
	void GhostConstructorSetsValuesCorrectAgeLessThan5000MidnightTrueTest() {
		Ghost g = new Ghost(4999, new NowMockMidnightTrue());
		assertEquals(50, g.getStrength());
		assertEquals(60, g.getSpeed());
		assertEquals(20, g.getAggressiveness());
		assertEquals(4999, g.getAge());
		assertFalse(g.isInvisible(new NowMockMidnightTrue()));
	}

	@Test
	void GhostConstructorSetsValuesCorrectAgeMoreThan5000MidnightFalseTest() {
		Ghost g = new Ghost(5000, new NowMockMidnightFalse());
		assertEquals(70, g.getStrength());
		assertEquals(5000, g.getAge());
		assertTrue(g.isInvisible(new NowMockMidnightFalse()));
	}

	@Test
	void constructorArgumentTooSmallThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(-1, Now.getInstance());
		});
	}

	@Test
	void constructorArgumentTooBigThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(10001, Now.getInstance());
		});
	}

	@Test
	void hurtMonsterDecreasesStrengthBy20PercentTest() {
		Ghost g = new Ghost(4999, Now.getInstance());
		g.hurtMonster(equ);
		assertEquals(40, g.getStrength());
	}

	@Test
	void hurtMonsterNoDecreaseOfStrengthIfStrengtLessThan26Test() {
		Ghost g = new Ghost(4999, Now.getInstance());
		g.strength = 25;
		g.hurtMonster(equ);
		assertEquals(25, g.getStrength());
	}

	@Test
	void toStringReturnsAgeAndVisibleWhenMidnight() {
		Ghost g = new Ghost(4999, new NowMockMidnightFalse());
		assertEquals(g.toString(), "50 60 20 4999 invisible");
	}

	@Test
	void toStringReturnsAgeAndInvisibleTestWhenNotMidnight() {
		Ghost g = new Ghost(4999, new NowMockMidnightTrue());
		assertEquals(g.toString(), "50 60 20 4999 visible");
	}

	private class NowMockMidnightTrue extends Now {
		private NowMockMidnightTrue() {
		}

		@Override
		public boolean isMidnight() {
			return true;
		}

	}

	private class NowMockMidnightFalse extends Now {
		private NowMockMidnightFalse() {
		}

		@Override
		public boolean isMidnight() {
			return false;
		}
	}

}
