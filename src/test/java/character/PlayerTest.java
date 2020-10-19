package character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {
    //** ISE = IllegalStateException
    //** IAE = IllegalArgumentException

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
        assertNotEquals(0, p1.getSizeOfInventory());
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
    public void Throw_IAE_When_Player_tries_to_put_on_equipment_that_has_not_been_added_to_inventory() {
        Player player = new Player("Gladiator");
        Equipment equipment = new Sword(new StatEquipment(10,5));
        assertThrows(IllegalArgumentException.class, () -> {
           player.putOn(equipment);
        });
    }

    @Test
    public void MaybeThrowAnIAEIfPlayerEquipsEquipmentThatIsAlreadyEquipped() {

    }

    @Test
    void Player_dismantles_equipment() {
        Player p1 = new Player("Gladiator");
        Equipment e1 = new Armor(new StatEquipment(2,2));
        p1.addToInventory(e1);
        p1.putOn(e1);
        p1.dismantle(e1);
        assertEquals(false, p1.getSpecificEquipment(e1).isEquipped());

    }

    @Test
    public void Player_Increases_Speed_From_One_To_Two() {
        Player p1 = new Player("Gladiator");
        p1.increaseSpeed();
        assertEquals(p1.getSpeed(), 2);
    }

    @Test
    void Throw_ISE_When_Speed_Is_Increased_To_Higher_Than_Ten() {
        Player p1 = new Player("Gladiator");
        for (int i = 0; i < 9; i++) {
            p1.increaseSpeed();
        }
        assertThrows(IllegalStateException.class, () -> {
            p1.increaseSpeed();
        });
    }





}