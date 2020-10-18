package monster;



public class uiMonster {
	
	public static void main (String[] args) {
		

		
		Now n = Now.getInstance();
		//n.night = false;
		System.out.println("***"+n.isNight());
		Vampire v1 = new Vampire(n);
		System.out.println(v1);
		
		n.night = true;
		System.out.println(n.isNight());
		v1.getStrength(n);
		System.out.println(v1);
		
		
			
		
	}

}
