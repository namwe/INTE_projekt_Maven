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
		assertEquals(60, f.getStrength());
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
	void setStrengthSetsCorrectValuesTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		assertEquals(60, f.getStrength());	
	}
		
	
	@Test
	void hurtFrankensteinDecreasesStrengthBy10Percent(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.hurtFrankenstein();
		assertEquals(54, f.getStrength());
		
	}
	
	@Test
	void hurtFrankensteinSetsStrengthToZeroIfStrengthLessThan2Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 0;
		f.hurtFrankenstein();
		assertEquals(0, f.getStrength());	
	}
	
	
	
	@Test
	void reviveDeadFrankensteinTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 0;
		f.revive();
		assertEquals(60, f.getStrength());	
	}
	@Test
	void reviveLivingFrankensteinTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 1;
		f.revive();
		assertEquals(1, f.getStrength());	
	}
	
	
	@AfterEach
    public void setStrengtToInitialStrength(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.strength = 60;
    }
	
}
