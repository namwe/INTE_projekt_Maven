package monster;

import character.Equipment;

public class IllegalEquipmentException  extends RuntimeException  {

	
	public IllegalEquipmentException(Equipment equ, Monster m) {
			super(String.format("Illegal equipment for type " + m.getMonsterType()));
		}
	
}
