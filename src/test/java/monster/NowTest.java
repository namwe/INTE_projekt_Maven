package monster;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class NowTest {

		
	@Test
	void NownGetInstanceReturnsSameSingeltonInstanceTest() {
		Now n1 = Now.getInstance();
		Now n2 = Now.getInstance();
		assertSame(n1, n2);
	}
	
	
	@Test
	void setNightReturnsTrueIfNight() {
		Now n1 = Now.getInstance();
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (hour < 5 || hour > 21) // "natt" mellan 5 på morgonen och 22 på kvällen
		assertTrue(n1.night); 
		else {
			assertFalse(n1.night);
		}
	}
	
	
	@Test
	void setMidNightReturnsTrueIfNight() {
		Now n1 = Now.getInstance();
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (hour == 24) // "natt" mellan 5 på morgonen och 22 på kvällen
		assertTrue(n1.midnight); 
		else {
			assertFalse(n1.midnight);
		}
	}
	
	
}