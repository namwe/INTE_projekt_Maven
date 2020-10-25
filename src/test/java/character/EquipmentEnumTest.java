package character;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;;

class EquipmentEnumTest {
    @Test
    public void Enum_Armor_Is_Still_Armor_When_Equipment_Is_An_Armor() {
        Equipment equipment = new Armor(new StatEquipment(3,8));
        assertEquals(EquipmentEnum.ARMOR, EquipmentEnum.ARMOR.getType(equipment));
    }

    @Test
    public void Enum_Sword_Is_Still_Sword_When_Equipment_Is_A_Sword() {
        Equipment sword = new Sword(new StatEquipment(4,9));
        EquipmentEnum equipmentEnum = EquipmentEnum.SWORD;
        assertEquals(EquipmentEnum.SWORD, equipmentEnum.getType(sword));
    }

    @Test
    public void Enum_Scroll_Is_Still_Scroll_When_Equipment_Is_A_Scroll() {
        Equipment scroll = new Scroll(new StatEquipment(4,9));
        EquipmentEnum equipmentEnum = EquipmentEnum.SCROLL;
        assertEquals(EquipmentEnum.SCROLL, equipmentEnum.getType(scroll));
    }

    @Test
    public void Enum_Sword_Changes_To_Scroll_When_Equipment_Is_A_Scroll() {
        Equipment scroll = new Scroll(new StatEquipment(2,9));
        EquipmentEnum enumTest = EquipmentEnum.SWORD;
        assertEquals(EquipmentEnum.SCROLL, enumTest.getType(scroll));
    }

    @Test
    public void Enum_Default_Is_Returned_If_Equipment_InstanceOf_Is_Not_Found() {
        Equipment equipment = new Equipment(new StatEquipment(1,1));
        EquipmentEnum enumTest = EquipmentEnum.ARMOR;
        assertEquals(EquipmentEnum.DEFAULT, enumTest.getType(equipment));
    }
}