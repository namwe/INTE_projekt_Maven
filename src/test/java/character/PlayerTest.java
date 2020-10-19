package character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void Player_Has_Default_Values_On_Sword_When_Spawned() {
        Player p1 = new Player("Gladiator");
        Equipment defComp = new Sword(new StatEquipment(10, 0));
        assertEquals(p1.getSpecificEquipment(defComp).getStats().getCondition(), defComp.getStats().getCondition());
        assertEquals(p1.getSpecificEquipment(defComp).getStats().getMana(), defComp.getStats().getMana());
    }

    @Test
    public void Player_Can_Never_Spawn_Without_An_Equipment() {
        Player p1 = new Player("Gladiator");
        assertNotEquals(0, p1.getSizeOfEquipments());
    }


    @Test
    public void Player_Puts_On_Equipment_With_No_Equipment_Of_Same_Type_Already_Equipped() {
        Player player = new Player("Gladiator");
        Equipment eq = new Armor(new StatEquipment(3,10));
        player.addToInventory(eq);
        player.putOn(eq);
        assertEquals(true, player.getSpecificEquipment(eq).isEquipped());
    }

    @Test
    public void Player_tries_to_put_on_equipment_that_has_not_been_added_to_inventory() {
        Player player = new Player("Gladiator");
        Equipment equipment = new Sword(new StatEquipment(10,5));
        assertThrows(IllegalArgumentException.class, () -> {
           player.putOn(equipment);
        });
    }




}