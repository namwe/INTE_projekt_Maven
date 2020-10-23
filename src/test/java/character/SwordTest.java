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

    @Test
    public void Sword_Is_Equipped() {
        Equipment equipment = new Sword(new StatEquipment(2,5));
        equipment.setEquipped(true);
        assertTrue(equipment.isEquipped());
    }


}