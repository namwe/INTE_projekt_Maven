package level;

public abstract class Movable extends RoomTile {
    private Position position;
    private Map map;
    private RoomTile originalTile;

    public Movable(char charRepresentation, Position position, Map map) {
        super(charRepresentation, true);
        this.position = position;
        this.map = map;
        originalTile = map.replaceTile(position, this);
    }

    public Position getPosition() {
        return position;
    }

    public Map getMap() {
        return map;
    }

    public void move(Direction direction) {
        Position nextPosition = position.getAdjacentPosition(direction);

        if (!allowedMovment(nextPosition)) {
            return;
        }

        map.replaceTile(position, originalTile);
        position = nextPosition;
        originalTile = map.replaceTile(nextPosition, this);
    }

    private boolean allowedMovment(Position nextPosition) {
        RoomTile nextTile;
        try {
            nextTile = map.getTile(nextPosition);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
        return !nextTile.isSolid();
    }
}
