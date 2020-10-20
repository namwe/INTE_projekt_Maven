package character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StatEquipmentTest {
    @Test
    public void Throw_IAE_When_Stats_Are_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            StatEquipment statEquipment = new StatEquipment(-1,10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            StatEquipment statEquipment1 = new StatEquipment(5,-5);
        });
    }

    @Test
    public void Throw_IAE_When_Stats_Are_Higher_Than_Ten() {
        assertThrows(IllegalArgumentException.class, () -> {
            StatEquipment statEquipment = new StatEquipment(4,11);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            StatEquipment statEquipment1 = new StatEquipment(15,-2);
        });
    }

    @Test
    public void getCondition_Returns_Five_When_Constructor_Is_Set_To_Five() {
        StatEquipment statEquipment = new StatEquipment(5,10);
        assertEquals(statEquipment.getCondition(), 5);
    }

    @Test
    public void getMana_Returns_Three_When_Constructor_Is_Set_To_Three() {
        StatEquipment statEquipment = new StatEquipment(2,3);
        assertEquals(statEquipment.getMana(), 3);
    }

    @Test
    public void toStringTest() {
        StatEquipment statEquipment = new StatEquipment(4,7);
        String expected = "condition = " + 4 + " mana = " + 7;
        assertEquals(expected, statEquipment.toString());
    }

}