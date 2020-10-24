package character;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    public void Armor_Is_Equipped() {
        Equipment equipment = new Armor(new StatEquipment(3,8));
        equipment.setEquipped(true);
        assertTrue(equipment.isEquipped());
    }

    @Test
    public void Armor_With_Same_Stats_And_Not_Equipped_Are_Not_Same_Object() {
        Equipment equipment = new Armor(new StatEquipment(3,7));
        Equipment equipment2 = new Armor(new StatEquipment(3,7));
        equipment.setEquipped(true);
        assertEquals(1, equipment.compareTo(equipment2));
    }

}