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
        assertEquals(roomColumn, p.getRoomColumn());
        assertEquals(tileRow, p.getTileRow());
        assertEquals(tileColumn, p.getTileColumn());
    }

    @ParameterizedTest
    @CsvSource({"NORTH, -1, 0", "EAST, 0, 1", "SOUTH, 1, 0", "WEST, 0, -1"})
    void getAdjacentPosition(Direction direction, int row, int column) {
        Position position = new Position(0, 0, 0, 0);
        Position newPosition = position.getAdjacentPosition(direction);
        assertEquals(row, newPosition.getTileRow());
        assertEquals(column, newPosition.getTileColumn());
    }

    @Test
    void testEquals() {
        Position p1 = new Position(0, 1, 2, 3);
        Position p2 = new Position(0, 1, 2, 3);
        assertTrue(p1.equals(p2));
    }
}
