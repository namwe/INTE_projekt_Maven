package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MapTest {
    @Test
    void constructorSetsRooms(){
        Room[][] rooms = defaultRoomsMapOracle();
        Map m = new Map(rooms);
        assertArrayEquals(rooms, m.getRooms());
    }

    @ParameterizedTest
    @CsvSource({"2, 3", "1, 2"})
    void constructorThrowsIAE(int x, int y){
        Room[][] rooms = new Room[x][y];
        assertThrows(IllegalArgumentException.class, () -> new Map(rooms));
    }

    @Test
    void placeDoorsTest(){
        Room[][] rooms = defaultRoomsMapOracle();
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

    @Test
    void getTile() {
        Map m = new Map(defaultRoomsMapOracle());
        Position p = new Position(0, 0, 0, 0);
        assertEquals(Wall.getInstance(), m.getTile(p));
    }

    @Test
    void replaceTile() {
        Map m = new Map(defaultRoomsMapOracle());
        Position p = new Position(0, 0, 0, 0);
        m.replaceTile(p, Air.getInstance());
        assertEquals(Air.getInstance(), m.getTile(p));
    }

    private Room[][] defaultRoomsMapOracle(){
        Room[][] rooms = new Room[Map.HEIGHT][Map.WIDTH];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                rooms[i][j] = new Room(RoomType.DEFAULT_ROOM);
            }
        }
        return rooms;
    }
}