package character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ScrollTest {

    private final int NOT_EQUAL_POS = 1;
    private final int NOT_EQUAL_NEG = -1;
    private final int EQUAL = 0;

    @Test
    public void Scroll_With_Same_Condition_But_Different_Mana_Are_Not_Same() {
        Equipment equipment = new Scroll(new StatEquipment(5, 3));
        Equipment equipment2 = new Scroll(new StatEquipment(5, 2));
        assertEquals(NOT_EQUAL_POS, equipment.compareTo(equipment2));
    }

    @Test
    public void Scroll_With_Same_Mana_But_Different_Condition_Are_Not_Same() {
        Equipment equipment = new Scroll(new StatEquipment(1, 1));
        Equipment equipment2 = new Scroll(new StatEquipment(3, 1));
        assertEquals(NOT_EQUAL_NEG, equipment.compareTo(equipment2));
    }


    @Test
    public void Scroll_With_Same_Stats_And_Equipped_Are_Same_Equipment() {
        Equipment equipment = new Scroll(new StatEquipment(5, 3));
        Equipment equipment2 = new Scroll(new StatEquipment(5, 3));
        equipment.setEquipped(false);
        equipment2.setEquipped(false);
        assertEquals(EQUAL, equipment.compareTo(equipment2));
    }

}