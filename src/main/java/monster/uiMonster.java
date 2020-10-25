package monster;

import character.Equipment;
import character.Scroll;
import character.StatEquipment;
import character.Sword;

public class uiMonster {
	
	public static void main (String[] args) {
		
		//Ghost g = new Ghost(500,Now.getInstance()); 
		
 
		
		 Vampire v = new Vampire(Now.getInstance()); 
		 System.out.println(v); 
		 //StatEquipment statEqu = new StatEquipment(5, 5);
		// Equipment scroll = new Scroll (statEqu);
		
		//StatEquipment statSword = new StatEquipment(5, 5);
		//Equipment sword = new Sword(statEqu);
		 
		StatEquipment statEqu = new StatEquipment(0, 0);
		Equipment scroll = new Scroll(statEqu);
		Equipment sword = new Sword(statEqu);
		Ghost g = new Ghost(4999,Now.getInstance()); 
		System.out.println(g);
		g.hurtMonster(scroll);
		
		Now n = Now.getInstance();
		System.out.println(n.isNight()); 
		//v.hurtMonster(sword);
		v.hurtMonster(scroll);
		System.out.println(v);
		v.hurtMonster(scroll);
		System.out.println(v);
		
		Frankenstein  f = Frankenstein.getInstance(); 
		System.out.println(f);
		/*
		Ghost g = new Ghost(4999,Now.getInstance()); 
		System.out.println(g);
		g.hurtMonster(sword);
		System.out.println(g);
		*/
		/*
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		/*
		System.out.println("sover");
		try {
			Thread.sleep(1000*25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		*/
	/*
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		
		
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		System.out.println("sover");
		try {
			Thread.sleep(1000*15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);
		f.hurtMonster();
		System.out.println(f);

	 */
		

	
	}	
	}

//}
		
		
	
