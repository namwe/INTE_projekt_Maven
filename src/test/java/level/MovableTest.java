package level;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MovableTest {
    private class ConcreteMovable extends Movable{
        public ConcreteMovable(char charRepresentation, Position position, Map map) {
            super(charRepresentation, position, map);
        }
    }

    private Position position = new Position(0,0, 1,1);
    private Map map = new Map(defaultRoomsMapOracle());
    private Movable movable = new ConcreteMovable('T', position, map);

    @Test
    void constructorSetsValues(){
        assertEquals('T', movable.getMap().getTile(position).getCharRepresentation());
        assertEquals(position, movable.getPosition());
        assertEquals(map, movable.getMap());
    }

    @ParameterizedTest
    @CsvSource({"NORTH, T","EAST, ' '", "SOUTH, ' '", "WEST, T"})
    void moveResetsOldTileIfAllowed(Direction direction, char expected){
        movable.move(direction);
        assertEquals(expected, movable.getMap().getTile(position).getCharRepresentation());
    }

    @ParameterizedTest
    @CsvSource({"NORTH, #","EAST, T", "SOUTH, T", "WEST, #"})
    void moveReplacesNewTileIfAllowed(Direction direction, char expected){
        movable.move(direction);
        assertEquals(expected, movable.getMap().getTile(position.getAdjacentPosition(direction)).getCharRepresentation());
    }

    @ParameterizedTest
    @CsvSource({"NORTH", "EAST"})
    void moveCanNotGoOutOfBounds(Direction direction){
        Position p = new Position(0,0,0,0);
        Movable m = new ConcreteMovable('T', p, map);
        m.move(direction);
        assertEquals('T', m.getMap().getTile(p).getCharRepresentation());
    }

    @Test
    void moveThroughEasternDoor(){
        map.placeDoors();
        Position p = new Position(0,0,4,7);
        Movable m = new ConcreteMovable('T', p, map);
        m.move(Direction.EAST);
        assertEquals('T', map.getTile(new Position(0, 1, 4, 1)).getCharRepresentation());
    }

    @Test
    void moveThroughSouthernDoor(){
        map.placeDoors();
        Position p = new Position(0,0,7,4);
        Movable m = new ConcreteMovable('T', p, map);
        m.move(Direction.SOUTH);
        assertEquals('T', map.getTile(new Position(1, 0, 1, 4)).getCharRepresentation());
    }

    @Test
    void moveThroughNorthernDoor(){
        map.placeDoors();
        Position p = new Position(1,0,1,4);
        Movable m = new ConcreteMovable('T', p, map);
        m.move(Direction.NORTH);
        assertEquals('T', map.getTile(new Position(0, 0, 7, 4)).getCharRepresentation());
    }

    @Test
    void moveThroughWesternDoor(){
        map.placeDoors();
        Position p = new Position(0, 1, 4, 1);
        Movable m = new ConcreteMovable('T', p, map);
        m.move(Direction.WEST);
        assertEquals('T', map.getTile(new Position(0,0,4,7)).getCharRepresentation());
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
