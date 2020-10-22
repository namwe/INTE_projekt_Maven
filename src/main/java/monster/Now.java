package monster;

import java.util.Calendar;

public class Now {
	
	protected boolean night;  //privat?
	protected boolean midnight = false; //privat?
	private static Now INSTANCE = null;
	
		
	public static Now getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Now();	
		}
		return INSTANCE;
	}
	

		
	protected Now() {  //ok med protected?
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		if (hour < 5 && hour > 21) // "natt" mellan 5 på morgonen och 21 på kvällen
			this.night = true;
		if (hour == 24) {
			this.midnight = true;
		}
	}
		
	public boolean isNight() {
		return night;
	}


	public boolean isMidnight() {
		return midnight;
		
	}
		
	
	
	

}
