package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoomTest {
    @Test
    void arrayConstructorSetsLayoutFromTemplate(){
        Room r = new Room(Room.generateRoomWithWalls());
        assertArrayEquals(Room.generateRoomWithWalls(),r.getLayout());
    }

    @ParameterizedTest
    @CsvSource({"8, 9", "9, 8", "10, 9", "9, 10"})
    void arrayConstructorThrowsIAE(int x, int y){
        RoomTile[][] roomTiles = new RoomTile[x][y];
        assertThrows(IllegalArgumentException.class, () -> {
            new Room(roomTiles);
        });
    }

    @Test
    void enumConstructorSetsLayout(){
        Room r = new Room(RoomType.DEFAULT_ROOM);
        assertArrayEquals(Room.generateRoomWithWalls(), r.getLayout());
    }

    @Test
    void enumConstructorThrowsIAE(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Room(RoomType.NON_DEFINED);
        });
    }

    @Test
    void replaceTile(){
        Room r = new Room(RoomType.DEFAULT_ROOM);

        RoomTile tile = new RoomTile('T', false);
        r.replaceTile(0, 4, tile);

        RoomTile actual = r.getLayout()[0][4];

        assertEquals(tile, actual);
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

    @Test
    void toStringTest(){
        String defaultRoomString =
                "# # # # # # # # # \n" +
                "#               # \n" +
                "#               # \n" +
                "#               # \n" +
                "#               # \n" +
                "#               # \n" +
                "#               # \n" +
                "#               # \n" +
                "# # # # # # # # # \n";
        Room r = new Room(RoomType.DEFAULT_ROOM);
        assertEquals(defaultRoomString, r.toString());
    }

}