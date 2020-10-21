package character;

import static org.junit.jupiter.api.Assertions.*;

import monster.*;
import org.junit.jupiter.api.Test;

class StatTest {

    @Test
    public void Throw_IAE_When_Hp_Set_To_Negative_Number() {
        assertThrows(IllegalArgumentException.class, () -> {
            Stat stat = new Stat(-1,100);
        });
    }

}