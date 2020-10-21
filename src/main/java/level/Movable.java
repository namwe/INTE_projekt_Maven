package level;

public abstract class Movable extends RoomTile{
    private Position position;
    private Map map;

    public Movable(char charRepresentation, boolean solid, Position position, Map map) {
        super(charRepresentation, solid);
        this.position = position;
        this.map = map;
    }

    public Position getPosition() {
        return position;
    }
}
