package monster;

import java.util.Calendar;

public class Now {
	private boolean night; 
	private boolean midnight = false; 
	private static Now INSTANCE = null;
	
	public static Now getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Now();
		}
		return INSTANCE;
	}

	
	protected Now() { 
		Calendar c = Calendar.getInstance();
		setNight(c);
		setMidnight(c);
	}
	
	protected Now(int hour) { 
		
	}
	
	
	private void setNight(Calendar c){
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (hour < 5 || hour > 21) // "natt" mellan 5 på morgonen och 22 på kvällen
			this.night = true;	
	}

	private void setMidnight(Calendar c){
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (hour == 24)
			midnight = true;			
	}
	
	
	public boolean isNight() {
		return night;
	}

	public boolean isMidnight() {
		return midnight;

	}

}
