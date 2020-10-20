package monster;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


class GhostTest {  //sätt tillbaka insta
	
	Now n = Now.getInstance();

	@Test
	void GhostConstructorSetsValuesCorrectAgeLessThan5000MidnightFalseTest() {
		Ghost g = new Ghost(4999, n); 
		n.midnight = false; 
		assertEquals(50, g.getStrength());
		assertEquals(60, g.getSpeed());	
		assertEquals(20, g.getAggressiveness());
		assertEquals(4999, g.getAge());	
		assertTrue(g.isInvisible());	
	}
	
	

	@Test
	void GhostConstructorSetsValuesCorrectAgeLessThan5000MidnightTrueTest() {
		n.midnight = true; 
		Ghost g = new Ghost(4999, n); 
		assertEquals(50, g.getStrength());
		assertEquals(60, g.getSpeed());	
		assertEquals(20, g.getAggressiveness());
		assertEquals(4999, g.getAge());	
		assertFalse(g.isInvisible());	
	}
	
	
	@Test
	void GhostConstructorSetsStrengthCorrectAgeMoreorEqualTo5000Test() {
		Ghost g = new Ghost(5000, n); 
		assertEquals(70, g.getStrength());
	}
	


	@Test
	void constructorArgumentTooSmallThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(-1, n);	
		});
	}
	

	@Test
	void constructorArgumentTooBigThrowsIAEATest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Ghost(10001, n);	
		});
	}
	
	
	
	@Test
	void hurtMonsterDecreasesStrengthBy20PercentTest() {
		Ghost g = new Ghost(4999, n); 
		g.hurtMonster();
		assertEquals(40, g.getStrength());	
	}
	
	
	@Test
	void hurtMonsterDoesNotMonsterDecreaseStrengthBy20PercentIfCurrentStrengthIs20Test() {
		Ghost g = new Ghost(4999, n);
		g.strength = 20;
		g.hurtMonster();
		assertEquals(20, g.getStrength());	
	}
	
	
	@Test
	void toStringReturnsAgeAndVisibilityWhenGhostIsInvisibleTest() {
		Ghost g = new Ghost(4999, n);
		g.invisible = true;
		assertEquals(g.toString(),"50 60 20 4999 invisible");	
			
	}
	
	@Test
	void toStringReturnsAgeAndVisibilityTestWhenGhostIsVisible() {
		Ghost g = new Ghost(4999, n);
		g.invisible = false;
			assertEquals(g.toString(),"50 60 20 4999 visible");			
	}
	

	@AfterEach
    public void resetNow (){
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		if (hour % 2 != 0) {
			n.night = true;
		}
		else {
			n.night = false;	
		}
		
		if (hour == 24) {
			n.midnight = true;
			System.out.println(hour + "natt");
		}
		else {
			n.midnight = false;	
		}
    }
	
}
