package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VampireTest {
	
		
	private final static int MAXSTRENGTH = 90; 
	private final static int MINSTRENGTH = 5; 
	
		
	@Test
	void VampireConstructorSetsValuesCorrectWhenNightTest() {
		Now n = Now.getInstance();
		n.night = true;
		Vampire v = new Vampire(n); 	
		assertEquals(MAXSTRENGTH, v.getStrength());
		assertEquals(80, v.getSpeed());	
		assertEquals(50, v.getAggressiveness());
	}
	
	
	@Test
	void VampireConstructorSetsValuesCorrectWhenDayTest() {
		Now n = Now.getInstance();
		n.night = false;
		Vampire v = new Vampire(n); 	
		assertEquals(MINSTRENGTH, v.getStrength());
		assertEquals(80, v.getSpeed());	
		assertEquals(50, v.getAggressiveness());
	}
	
	
	
	@Test  
	void getStrengthReturnsMINSTRENGTHWhenDayTest() {
		Now n = Now.getInstance();
		n.night = false;
		Vampire v = new Vampire(n); 
		v.getStrength(n);
		assertEquals(MINSTRENGTH, v.getStrength());	
	}
	
	@Test  
	void getStrengthReturnsMINSTRENGTHWhenNightTest() {
		Now n = Now.getInstance();
		n.night = true;
		Vampire v = new Vampire(n); 
		v.getStrength(n);
		assertEquals(MAXSTRENGTH, v.getStrength());	
	}
	
	@Test  
	void hurtMonsterTestDoesNothing() {  ///ÄNDRA OM METODEN IMPLEMENTERAS. 
		Now n = Now.getInstance();
		n.night = true;
		Vampire v = new Vampire(n); 
		v.hurtMonster();
		assertEquals(MAXSTRENGTH, v.getStrength());
	}
	
}
