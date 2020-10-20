package monster;

import java.util.Calendar;

public class uiMonster {
	
	public static void main (String[] args) {
		

		Now n = Now.getInstance();
		n.midnight = true;
		Ghost g = new Ghost(1000, n); 
		System.out.println(g);
		
		Now n1 = Now.getInstance();
		Ghost g1 = new Ghost(1000, n); 
		System.out.println(g);
		
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		
	//	Now n = Now.getInstance();
		//n.night = false;
		//System.out.println("***"+n.isNight());
		//Vampire v1 = new Vampire(n);
		//System.out.println(v1);
		
		//n.night = true;
		//System.out.println(n.isNight());
		//v1.getStrength(n);
		//System.out.println(v1);
		
		
		
	
	
	
		
		
	}
}	
		
		
	
