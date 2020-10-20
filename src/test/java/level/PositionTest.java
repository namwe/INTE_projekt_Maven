package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {

    @ParameterizedTest
    @CsvSource({"0, 0, 0, 0,", "1, 0, 8, 2"})
    void constructorSetsValues(int roomRow, int roomColumn, int tileRow, int tileColumn){
        Position p = new Position(roomRow, roomColumn, tileRow, tileColumn);

        assertEquals(roomRow, p.getRoomRow());
        assertEquals(roomRow, p.getRoomColumn());
        assertEquals(roomRow, p.getTileRow());
        assertEquals(roomRow, p.getTileColumn());
    }
}
