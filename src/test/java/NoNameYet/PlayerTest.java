package NoNameYet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void Player_has_default_values_on_sword_when_spawned() {
        Player p1 = new Player("Gladiator");
        Equipment defComp = new Sword(new StatEquipment(10, 0));
        assertEquals(p1.getSpecificEquipment(defComp).getStats().getCondition(), defComp.getStats().getCondition());
        assertEquals(p1.getSpecificEquipment(defComp).getStats().getMana(), defComp.getStats().getMana());
    }

    /*@Test
    public void Player_can_never_spawn_without_default_values_on_sword() {
        Player p1 = new Player("Gladiator");
        Equipment eq1 = new Sword(new StatEquipment(3,5));
        assertNotEquals(p1.getEquipment().getStats().getCondition(), eq1.getStats().getCondition());
    }

     */

    @Test
    public void Player_puts_on_equipment_with_no_equipment_of_same_type_already_equipped() {
        Player player = new Player("Gladiator");
        Equipment eq = new Armor(new StatEquipment(3,10));
        player.addToInventory(eq);
        player.putOn(eq);
        assertEquals(true, player.getSpecificEquipment(eq).isEquipped());
    }

    @Test
    public void Player_tries_to_equip_equipment_that_has_not_been_added_to_inventory() {
        Player player = new Player("Gladiator");
        Equipment equipment = new Scroll(new StatEquipment())
    }



}