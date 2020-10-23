package character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ScrollTest {

    @Test
    public void Scroll_With_Same_Condition_But_Different_Mana_Are_Not_Same() {
        Equipment equipment = new Scroll(new StatEquipment(5, 3));
        Equipment equipment2 = new Scroll(new StatEquipment(5, 2));
        assertEquals(1, equipment.compareTo(equipment2));
    }


    @Test
    public void Scroll_With_Same_Stats_And_Equipped_Are_Same_Equipment() {
        Equipment equipment = new Scroll(new StatEquipment(5, 3));
        Equipment equipment2 = new Scroll(new StatEquipment(5, 3));
        equipment.setEquipped(false);
        equipment2.setEquipped(false);
        assertEquals(0, equipment.compareTo(equipment2));
    }

}