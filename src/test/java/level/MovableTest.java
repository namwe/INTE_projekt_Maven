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
//    @Test
//    void constructorSetsPosition(){
//        Position p = new Position(0, 1, 7, 8);
//        Movable m = new ConcreteMovable(p);
//        assertEquals(p, m.getPosition());
//    }
}
