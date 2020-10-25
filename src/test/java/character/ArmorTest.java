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

}