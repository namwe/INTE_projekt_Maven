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

    @Test
    void constructorThrowsIAE(){
        Room[][] rooms = new Room[2][3];
        assertThrows(IllegalArgumentException.class, () -> new Map(rooms));
    }

    @Test
    void placeDoorsTest(){
        Room[][] rooms = defaultRoomsOracle();
        Map m = new Map(rooms);
        m.placeDoors();

        //Multiple asserts is bad practice, but I'm not sure how to do it in another way.
        assertEquals(Door.getInstance(), m.getRooms()[0][0].getLayout()[4][8]);
        assertEquals(Door.getInstance(), m.getRooms()[0][0].getLayout()[8][4]);

        assertEquals(Door.getInstance(), m.getRooms()[0][1].getLayout()[4][0]);
        assertEquals(Door.getInstance(), m.getRooms()[0][1].getLayout()[8][4]);

        assertEquals(Door.getInstance(), m.getRooms()[1][0].getLayout()[0][4]);
        assertEquals(Door.getInstance(), m.getRooms()[1][0].getLayout()[4][8]);

        assertEquals(Door.getInstance(), m.getRooms()[1][1].getLayout()[0][4]);
        assertEquals(Door.getInstance(), m.getRooms()[1][1].getLayout()[4][0]);
    }

    private Room[][] defaultRoomsOracle(){
        Room[][] rooms = new Room[Map.HEIGHT][Map.WIDTH];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                rooms[i][j] = new Room(RoomType.DEFAULT_ROOM);
            }
        }
        return rooms;
    }


}