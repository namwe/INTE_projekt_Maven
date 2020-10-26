package monster;

import java.util.Calendar;

public class Now {
	private boolean night; // privat?
	private boolean midnight = false; // privat?
	private static Now INSTANCE = null;

	public static Now getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Now();
		}
		return INSTANCE;
	}

	//annan konstruktor?? 
	
	protected Now() { // ok med protected för att kunna skapa upp mock-instanser i subklasserna?
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		if (hour < 5 || hour > 21) // "natt" mellan 5 på morgonen och 22 på kvällen
			this.night = true;
		if (hour == 24) {
			midnight = true;
		}
	}

	
	public boolean isNight() {
		return night;
	}

	public boolean isMidnight() {
		return midnight;

	}

}
