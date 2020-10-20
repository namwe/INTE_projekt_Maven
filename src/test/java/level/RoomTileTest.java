package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoomTileTest {
    @ParameterizedTest
    @CsvSource({"T, false","C, true"})
    void constructorSetsValues(char c, boolean s){
        RoomTile rt = new RoomTile(c, s);
        assertEquals(c,rt.getCharRepresentation());
        assertEquals(s, rt.isSolid());
    }

    @Test
    void toStringTest(){
        RoomTile rt = new RoomTile('T', true);
        assertEquals("T", rt.toString());
    }
}
