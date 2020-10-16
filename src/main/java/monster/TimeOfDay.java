package monster;

public class TimeOfDay {
	
	private static TimeOfDay INSTANCE = null;
	
	final static int ONE_MINUTE = 1000*10;	
	private boolean night = true;
	
	public static TimeOfDay getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new TimeOfDay();
		}
		return INSTANCE;
	}
		
	public boolean isNight() {
			return night;
	}
	
	
	public void scheduleTime() {
		int i = 0;
		while(i < 10) {
		try {
			Thread.sleep(ONE_MINUTE);
			i++;
			setNight();
		} catch (InterruptedException e) {
			e.printStackTrace();
			}	
		}	
	}
	
	
	private void setNight(){
		if(!night)
			night = true;
		else {
			night = false;
		}
	}
    
	
	
}
