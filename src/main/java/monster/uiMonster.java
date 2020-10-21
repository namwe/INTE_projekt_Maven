package monster;

import java.util.Calendar;

public class uiMonster {
	
	public static void main (String[] args) {
		

		
		
		
		
		
		
		
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		
	Now n = Now.getInstance();
	Ghost g = new Ghost(4999, n); 
	g.hurtMonster();
	System.out.println(g);
	g.hurtMonster();
	System.out.println(g);
	g.hurtMonster();
	System.out.println(g);
	g.hurtMonster();
	System.out.println(g);
	g.hurtMonster();
	System.out.println(g);
	g.hurtMonster();
	System.out.println(g);
		

		
		
		
	
	
	
		
		
	}
}	
		
		
	
