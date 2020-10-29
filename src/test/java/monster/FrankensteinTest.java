package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import character.Equipment;
import character.Scroll;
import character.StatEquipment;
import character.Sword;


 
//Singelton - instansvariabeln strength återställs till ursprunget @AfterEach

class FrankensteinTest {

	StatEquipment statEqu = new StatEquipment(5, 5);
	

	@Test
	void FrankensteinGetInstanceSetsCorrectValuesTest() {
		Frankenstein f = Frankenstein.getInstance();
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());
		assertEquals(30, f.getAggressiveness());
		assertEquals(TypeOfMonster.FRANKENSTEIN, f.getMonsterType());
	}

	@Test
	void FrankensteinGetInstanceReturnsSameSingeltonInstanceTest() {
		Frankenstein f1 = Frankenstein.getInstance();
		Frankenstein f2 = Frankenstein.getInstance();
		assertSame(f1, f2);
	}

	@Test //Överflödigt?
	void FrankensteinGetInstanceReturnsNotNullInstanceTest() {
		Frankenstein f1 = Frankenstein.getInstance();
		assertNotNull(f1);
	}
	
	

	@Test
	void T1Statemachine() {
		Frankenstein f = Frankenstein.getInstance();
		Equipment sword = new Sword(statEqu);
		int i = 0; 
		while (i < 16) {
		f.hurtMonster(sword);
		i++;
		}
		f.reviveFromDead();
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());
		assertEquals(30, f.getAggressiveness());
	}

	@Disabled
	@Test
	void T2Statemachine() { 
		Frankenstein f = Frankenstein.getInstance();
		f.hurtMonster(new Sword(statEqu));
		try {
			Thread.sleep(1000 * 25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());
		assertEquals(30, f.getAggressiveness());
		f.hurtMonster(new Sword(statEqu));
		assertEquals(75, f.getStrength());
		assertEquals(20, f.getSpeed());
		assertEquals(35, f.getAggressiveness());
		try {
			Thread.sleep(1000 * 15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());
		assertEquals(35, f.getAggressiveness());
	}

	@Test
	void hurtMonsterKillsFrankensteinIfStrengthLessThan5Test() {
		Frankenstein f = Frankenstein.getInstance();
		f.strength = 4;
		f.hurtMonster(new Sword(statEqu));
		assertEquals(0, f.getStrength());
		assertEquals(0, f.getSpeed());
		assertEquals(0, f.getAggressiveness());
	}

	
	@Test
	void hurtMonsterEquimpmentNotInstanceOfScrollThrowsExceptionTest() {
		Frankenstein f = Frankenstein.getInstance();
		StatEquipment statEqu = new StatEquipment(0, 10);		
		assertThrows(IllegalEquipmentException.class, () -> {
			Equipment scroll = new Scroll(statEqu);	
			f.hurtMonster(scroll);
			});
	}

	@AfterEach
	public void resetValues() {
		Frankenstein f = Frankenstein.getInstance();
		f.strength = 80;
		f.speed = 20;
		f.aggressiveness = 30;
		f.lastAttackTimeStamp = 0;
	}

}
