package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class GhostTest {

	@Test
	void GhostConstructorSetsValuesCorrectAgeLessThan5000Test() {
		Ghost g = new Ghost(4999); 
		assertEquals(50, g.getStrength());
		assertEquals(60, g.getSpeed());	
		assertEquals(20, g.getAggressiveness());
		assertEquals(4999, g.getAge());	
	}
	
	
	@Test
	void GhostConstructorSetsStrengthCorrectAgeMoreorEqualTo5000Test() {
		Ghost g = new Ghost(5000); 
		assertEquals(70, g.getStrength());
	}
	


	@Test
	void constructorArgumentTooSmallThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(-1);	
		});
	}
	
	
	@Test
	void GhostToggleVisibilityWhenFirstStateIsTrueReturnsCorrectValueTest() {
		Ghost g = new Ghost(5000); 
		g.invisible = true;
		g.toggleVisibility();
		assertTrue(!g.isInvisible());
	}
	
	@Test
	void GhostToggleVisibilityWhenFirstStateIsFalseReturnsCorrectValueTest() {
		Ghost g = new Ghost(5000); 
		g.invisible = false;
		g.toggleVisibility();
		assertTrue(g.isInvisible());
	}
	


	@Test
	void constructorArgumentTooBigThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(10001);	
		});
	}
	
	
	
	
	@Test
	void hurtMonsterDecreasesStrengthBy20PercentTest() {
		Ghost g = new Ghost(4999); 
		g.hurtMonster();
		assertEquals(40, g.getStrength());	
	}
	
	
	@Test
	void hurtMonsterDoesNotMonsterDecreaseStrengthBy20PercentIfCurrentStrengthIs20Test() {
		Ghost g = new Ghost(4999);
		g.strength = 20;
		g.hurtMonster();
		assertEquals(20, g.getStrength());	
	}
	
	
	@Test
	void toStringReturnsAgeAndVisibilityWhenGhostIsInvisibleTest() {
		Ghost g = new Ghost(4999);
		g.invisible = true;
		assertEquals(g.toString(),"50 60 20 4999 invisible");	
			
	}
	
	@Test
	void toStringReturnsAgeAndVisibilityTestWhenGhostIsVisible() {
		Ghost g = new Ghost(4999);
		g.invisible = false;
			assertEquals(g.toString(),"50 60 20 4999 visible");			
	}
	

	
	
}
