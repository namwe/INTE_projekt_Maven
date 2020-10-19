package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoomTest {
    @Test
    void constructorSetsLayoutFromTemplate(){
        Room r = new Room(Room.generateRoomWithWalls());
        assertArrayEquals(Room.generateRoomWithWalls(),r.getLayout());
    }

    @Test
    void generateRoomWithWalls(){
        RoomTile[][] roomWithWalls = Room.generateRoomWithWalls();

        RoomTile[] wallRow = new RoomTile[9];
        for (int i = 0; i < wallRow.length; i++) {
            wallRow[i] = Wall.getInstance();
        }

        assertArrayEquals(wallRow, roomWithWalls[0]);
        assertArrayEquals(wallRow, roomWithWalls[8]);

        RoomTile[] airRow = wallRow.clone();
        for (int i = 1; i < airRow.length-1; i++) {
            airRow[i] = Air.getInstance();
        }

        for (int i = 1; i < roomWithWalls.length-1; i++) {
            assertArrayEquals(airRow, roomWithWalls[i]);
        }
    }
}