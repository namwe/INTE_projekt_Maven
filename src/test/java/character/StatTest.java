package character;

import static org.junit.jupiter.api.Assertions.*;

import monster.*;
import org.junit.jupiter.api.Test;

class StatTest {

    @Test
    public void Throw_IAE_When_Hp_Set_To_Negative_Number() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Stat(-1,100);
        });
    }

    @Test
    public void Throw_IAE_When_Mana_Set_To_Higher_Than_One_Hundred() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Stat(5,120);
        });
    }

    @Test
    public void getHp_Returns_Five_When_Constructor_Is_Set_To_Five() {
        Stat stat = new Stat(5,20);
        assertEquals(5, stat.getHp());
    }

    @Test
    public void getMana_Returns_Seven_When_Constructor_Is_Set_To_Seven() {
        Stat stat = new Stat(12,7);
        assertEquals(7, stat.getMana());
    }

}