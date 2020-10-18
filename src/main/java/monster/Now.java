package monster;

import java.util.Calendar;

public class Now {
	
	protected boolean night;
	private static Now INSTANCE = null;
	
		
	public static Now getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Now();	
		}
		return INSTANCE;
	}
	
		
	private Now() {
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		if (hour % 2 != 0) {
		this.night = true;
		}
	}
		
	public boolean isNight() {
		return night;
	}
		
	

}
