package character;

import static org.junit.jupiter.api.Assertions.*;

import level.*;
import monster.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayerTest {
    //** ISE = IllegalStateException
    //** IAE = IllegalArgumentException

    private Position position = new Position(0,0, 1,1);
    private Map map = new Map();
    private char playerChar = 'P';

    @Test
    public void Player_Has_Default_Values_On_Sword_When_Spawned() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment defComp = new Sword(new StatEquipment(10, 0));

    }

    @Test
    public void Throw_IAE_When_Name_Is_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player( null, playerChar, position, map);
        });
    }

    @Test
    public void Player_Equips_Default_Sword_In_Inventory() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        List<Equipment> equipments = p1.getEquipments();
        p1.putOn(equipments.get(0));
        assertTrue(equipments.get(0).isEquipped());
    }


    @Test
    public void Player_Can_Never_Spawn_Without_An_Equipment() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        assertNotEquals(0, p1.getSizeOfInventory());
    }

    @Test
    public void Throw_ISE_When_Player_Equips_Two_Equipment_Of_Type_Scroll() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment scroll = new Scroll(new StatEquipment(10,3));
        Equipment scroll2 = new Scroll(new StatEquipment(10,6));
        p1.addToInventory(scroll);
        p1.addToInventory(scroll2);
        p1.putOn(scroll);
        assertThrows(IllegalStateException.class, () -> {
            p1.putOn(scroll2);
        });
    }

    @Test
    public void Adding_Two_Equipments_Results_In_Three_In_Total_In_Inventory() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        p1.addToInventory(new Armor(new StatEquipment(4,9)));
        p1.addToInventory(new Scroll(new StatEquipment(10,4)));
        assertEquals(p1.getSizeOfInventory(), 3);
    }


    @Test
    public void Player_Puts_On_Equipment_With_No_Equipment_Of_Same_Type_Already_Equipped() {
        Player player = new Player( "Gladiator", playerChar, position, map);
        Equipment eq = new Armor(new StatEquipment(3,10));
        player.addToInventory(eq);
        player.putOn(eq);
        assertTrue(player.getEquipmentWithSpecificStats(eq).isEquipped());
    }

    @Test
    public void Throw_IAE_When_Player_Tries_To_Put_On_Equipment_That_Has_Not_Been_Added_To_Inventory() {
        Player player = new Player( "Gladiator", playerChar, position, map);
        Equipment equipment = new Sword(new StatEquipment(4,9));
        assertThrows(IllegalArgumentException.class, () -> {
           player.putOn(equipment);
        });
    }

    @Test
    public void Throw_ISE_When_Equipping_Two_Of_Same_Kind_Of_Equipment_That_Is_Not_Type_Sword() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment equipment = new Armor(new StatEquipment(4,7));
        Equipment equipment1 = new Armor(new StatEquipment(1,6));
        p1.addToInventory(equipment);
        p1.addToInventory(equipment1);
        p1.putOn(equipment);
        assertThrows(IllegalStateException.class, () -> {
            p1.putOn(equipment1);

        });
    }

    @Test
    public void Player_Equips_Two_Swords() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(2,5));
        Equipment sword2 = new Sword(new StatEquipment(4,8));
        p1.addToInventory(sword);
        p1.addToInventory(sword2);
        p1.putOn(sword);
        p1.putOn(sword2);
        assertTrue(sword.isEquipped());
        assertTrue(sword2.isEquipped());
    }

    @Test
    public void Player_Equips_Two_Swords_With_Same_Stats() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(5,5));
        Equipment sword2 = new Sword(new StatEquipment(5,5));
        p1.addToInventory(sword);
        p1.addToInventory(sword2);
        p1.putOn(sword);
        p1.putOn(sword2);
        assertTrue(sword.isEquipped());
        assertTrue(sword2.isEquipped());
    }

    @Test
    public void Throw_ISE_When_Equipping_Swords_More_Than_Two() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(2,5));
        Equipment sword2 = new Sword(new StatEquipment(4,8));
        Equipment sword3 = new Sword(new StatEquipment(2,4));
        p1.addToInventory(sword);
        p1.addToInventory(sword2);
        p1.addToInventory(sword3);
        p1.putOn(sword);
        p1.putOn(sword2);
        assertThrows(IllegalStateException.class, () -> {
            p1.putOn(sword3);
        });
    }

    @Test
    public void When_Player_Dismantles_Equipments_They_Are_No_Longer_Equipped() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(2,5));
        Equipment scroll = new Scroll(new StatEquipment(10,8));
        p1.addToInventory(sword);
        p1.addToInventory(scroll);
        p1.putOn(sword);
        p1.putOn(scroll);
        p1.unEquip(sword);
        p1.unEquip(scroll);
        assertFalse(sword.isEquipped());
        assertFalse(scroll.isEquipped());
    }

    @Test
    void Player_Dismantles_Equipment() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment e1 = new Armor(new StatEquipment(2,2));
        p1.addToInventory(e1);
        p1.putOn(e1);
        p1.unEquip(e1);
        assertFalse(p1.getEquipmentWithSpecificStats(e1).isEquipped());

    }

    @Test
    public void Player_Increases_Speed_From_One_To_Two() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        p1.increaseSpeed();
        assertEquals(p1.getSpeed(), 2);
    }

    @Test
    void Throw_ISE_When_Speed_Is_Increased_To_Higher_Than_Ten() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);;
        for (int i = 0; i < 9; i++) {
            p1.increaseSpeed();
        }
        assertThrows(IllegalStateException.class, () -> {
            p1.increaseSpeed();
        });
    }

    @Disabled
    void Player_Attacking_Frankenstein_With_Sword_Results_In_Thirty_Less_Hp() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(5, 8));
        p1.addToInventory(sword);
        p1.putOn(sword);
        p1.damage(Frankenstein.getInstance());
       // assertEquals(70, p1.getPlayerStats().getHp());

    }

    @Test
    void Player_Attacking_Ghost_With_Sword_Decreases_Condition_With_One() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(3, 4));
        p1.addToInventory(sword);
        p1.putOn(sword);
        p1.damage(new Ghost(20, Now.getInstance()));
        assertEquals(2, p1.getEquipmentWithSpecificStats(sword).getStats().getCondition());
    }

    @Test
    void Player_Attacking_Frankenstein_With_Sword_Decreases_Condition_With_Two() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(6, 4));
        p1.addToInventory(sword);
        p1.putOn(sword);
        p1.damage(Frankenstein.getInstance());
        assertEquals(4, p1.getEquipmentWithSpecificStats(sword).getStats().getCondition());
    }

    @Test
    void Player_Attacking_Vampire_With_Sword_Decreases_Condition_With_Three() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(9, 4));
        p1.addToInventory(sword);
        p1.putOn(sword);
        p1.damage(new Vampire(Now.getInstance()));
        assertEquals(6, p1.getEquipmentWithSpecificStats(sword).getStats().getCondition());
    }

    @Test
    void Player_Attacking_Vampire_With_Scroll_Decreases_Mana_With_7() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment scroll = new Scroll(new StatEquipment(10, 10));
        p1.addToInventory(scroll);
        p1.putOn(scroll);
        p1.damage(new Vampire(Now.getInstance()));
        assertEquals(3, p1.getEquipmentWithSpecificStats(scroll).getStats().getMana());
    }

    @Test
    void Player_Attacking_Frankenstein_With_Scroll_Decreases_Mana_With_5() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment scroll = new Scroll(new StatEquipment(10, 7));
        p1.addToInventory(scroll);
        p1.putOn(scroll);
        p1.damage(Frankenstein.getInstance());
        assertEquals(2, p1.getEquipmentWithSpecificStats(scroll).getStats().getMana());
    }

    @Test
    void Player_Attacking_Ghost_With_Scroll_Decreases_Mana_With_3() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment scroll = new Scroll(new StatEquipment(10, 4));
        p1.addToInventory(scroll);
        p1.putOn(scroll);
        p1.damage(new Ghost(10,Now.getInstance()));
        assertEquals(1, p1.getEquipmentWithSpecificStats(scroll).getStats().getMana());
    }

    @Test
    void Player_Attacking_With_No_Sword_Or_Scroll_Equipped_Results_In_ISE() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment sword = new Sword(new StatEquipment(3, 4));
        p1.addToInventory(sword);
        assertThrows(IllegalStateException.class, () -> {
            p1.damage(new Ghost(20, Now.getInstance()));
        });
    }

    @Test
    void Player_Attacking_With_Equipment_Equipped_That_Is_Not_Sword_Or_Scroll_Results_In_ISE() {
        Player p1 = new Player( "Gladiator", playerChar, position, map);
        Equipment armor = new Armor(new StatEquipment(2, 8));
        p1.addToInventory(armor);
        p1.putOn(armor);
        assertThrows(IllegalStateException.class, () -> {
            p1.damage(new Ghost(20, Now.getInstance()));
        });
    }



}