package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MapTest {
    @Test
    void constructorSetsRooms(){
        Room[][] rooms = defaultRoomsOracle();
        Map m = new Map(rooms);
        assertEquals(rooms, m.getRooms());
    }

    private Room[][] defaultRoomsOracle(){
        Room[][] rooms = new Room[3][3];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                rooms[i][j] = new Room(RoomType.DEFAULT_ROOM);
            }
        }
        return rooms;
    }
}