package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


//100% coverage men måste nog hitta ett sätt att sätta insatnsen till null efter varje test. 
//Nu alternativet att återställa instansvariabeln strength till ursprunget @AfterEach

class FrankensteinTest {

		
	@Test
	void FrankensteinGetInstanceSetsCorrectValuesTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());	
		assertEquals(30, f.getAggressiveness());	
	}
	
	
	@Test  
	void FrankensteinGetInstanceReturnsSameSingeltonInstanceTest() {
		Frankenstein f1 = Frankenstein.getInstance();
		Frankenstein f2 = Frankenstein.getInstance(); 
		assertSame(f1, f2);	
	}
	
	@Test
	void FrankensteinGetInstanceReturnsNotNullInstanceTest() {
		Frankenstein f1 = Frankenstein.getInstance();
		Frankenstein f2 = Frankenstein.getInstance();
		assertNotNull(f2);
	}
		
	
	@Test
	void hurtMonsterDecreasesStrengthBy5IncreasesAggBy5Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.hurtMonster();
		assertEquals(75, f.getStrength());
		assertEquals(35, f.getAggressiveness());	
	}
	
	@Test
	void hurtMonsterKillsIfStrengthLessThan6Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 5;
		f.hurtMonster();
		assertEquals(0, f.getStrength());
		assertEquals(0, f.getSpeed());	
		assertEquals(0, f.getAggressiveness());
	}
	
	//Göra detta med mockobjekt genom privata metoderna?
	
	@Test
	void recoverAfter15SecIncreasesStrengthBy5DecreasesAggBy5Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.hurtMonster();
		f.hurtMonster();
		try {
			Thread.sleep(1000*15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.hurtMonster();
		assertEquals(70, f.getStrength());
		assertEquals(40, f.getAggressiveness());
	}
	
	
	@Test
	void recoverAfter25SecIncreasesStrengthBy5DecreasesAggBy5Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.hurtMonster();
		f.hurtMonster();
		try {
			Thread.sleep(1000*25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.hurtMonster();
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());	
		assertEquals(30, f.getAggressiveness());
	}
	
	
	
	
	
	@Test
	void reviveDeadFrankensteinTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 0;
		f.reviveFromDead();
		assertEquals(80, f.getStrength());
		assertEquals(20, f.getSpeed());	
		assertEquals(30, f.getAggressiveness());	
	}
	@Test
	void reviveLivingFrankensteinTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 25;
		f.reviveFromDead();
		assertEquals(25, f.getStrength());	
	}
	
	
	
	
	@AfterEach
    public void resetValues(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 80;
		f.speed = 20;
		f.aggressiveness = 30;
    }
    
    
	
}
