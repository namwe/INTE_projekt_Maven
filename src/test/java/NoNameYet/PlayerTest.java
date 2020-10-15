package NoNameYet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void Player_has_default_values_on_sword_when_spawned() {
        Player p1 = new Player("Gladiator");
        Equipment defComp = new Sword(new StatEquipment(10, 0));
        assertEquals(p1.getEquipment().getStats().getCondition(), defComp.getStats().getCondition());
        assertEquals(p1.getEquipment().getStats().getMana(), defComp.getStats().getMana());
    }

}