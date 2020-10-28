package monster;

import character.Equipment;

public class IllegalEquipmentException  extends RuntimeException  {

	
	public IllegalEquipmentException(Equipment equ, Monster m) {
			super(("Illegal equipment for type " + m.getMonsterType()));
		}
	
}
