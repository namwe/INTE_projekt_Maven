package character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    @Test
    public void Sword_Is_Equipped() {
        Equipment equipment = new Sword(new StatEquipment(2,5));
        equipment.setEquipped(true);
        assertTrue(equipment.isEquipped());
    }


}