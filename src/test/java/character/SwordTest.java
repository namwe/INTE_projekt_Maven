package character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    @Test
    public void Sword_With_Same_Stats_And_Not_Equipped_Are_Same_Object() {
        Equipment equipment = new Sword(new StatEquipment(3,7));
        Equipment equipment2 = new Sword(new StatEquipment(3,7));
        assertEquals(0, equipment.compareTo(equipment2));
    }

}