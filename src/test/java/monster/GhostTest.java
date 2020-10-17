package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//Kolla coverage -  borde vara full coverage men blir några klagomål.


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
	void GhostToggleVisibilityReturnsCorrectValueTest() {
		Ghost g = new Ghost(5000); 
		if(g.isInvisible()) {
			g.toggleVisibility();
			assertFalse(g.isInvisible());
		}
		if (!g.isInvisible()) {
		g.toggleVisibility();
		assertTrue(g.isInvisible());
		}
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
	void toStringReturnsAgeAndVisibilityTest() {
		Ghost g = new Ghost(4999);
		if(g.isInvisible()) {
			assertEquals(g.toString(),"50 60 20 4999 invisible");	
		}
		else {
		assertEquals(g.toString(),"50 60 20 4999 visible");	
		
		}
		
	}
	
	
	

	
	
}
