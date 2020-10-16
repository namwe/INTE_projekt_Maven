package monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class FrankensteinTest {

		
	@Test
	void FrankensteinGetInstanceSetsCorrectValuesTest() {
		Frankenstein f = Frankenstein.getInstance(); 

		assertEquals(60, f.getStrength());
		assertEquals(20, f.getSpeed());	
		assertEquals(30, f.getAggressiveness());	
	}
	
	/* 
	 @AfterEach
	 void tearDown() throws Exception {
		 
	 }
   

	@Test  
	void FrankensteinGetInstanceReturnsSameInstanceTest() {
		//assertSame?
		//testa att endast en instans kan skapas, jämför objekten - hur gör man det att det är samma objekt?		
	}
	
	*/
	
	
	@Test
	void hurtFrankensteinDecreasesStrengthBy10Percent(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.hurtFrankenstein();
		assertEquals(54, f.getStrength());
		
	}
	
	@Test
	void hurtFrankensteinSetsStrengthToZeroIfStrengthLessThan2Test(){
		Frankenstein f = Frankenstein.getInstance(); 
		f.setStrength(1);  //detta bör lösas på annat vis - ska inte finnas setStrength-metod. 
		f.hurtFrankenstein();
		assertEquals(0, f.getStrength());	
	}
	
	@Test
	void reviveFrankensteinTest() {
		Frankenstein f = Frankenstein.getInstance(); 
		f.setStrength(0); 
		f.revive();
		assertEquals(60, f.getStrength());	
	}
	
}
