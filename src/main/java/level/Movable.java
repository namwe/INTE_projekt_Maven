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
        if (map.getTile(nextPosition) == Door.getInstance()) {
            nextPosition = nextRoomPosition(direction);
        }

        map.replaceTile(position, originalTile);
        position = nextPosition;
        originalTile = map.replaceTile(nextPosition, this);
    }

    private Position nextRoomPosition(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(position.getRoomRow() - 1, position.getRoomColumn(), Room.HEIGHT - 2, position.getTileColumn());
            case EAST:
                return new Position(position.getRoomRow(), position.getRoomColumn() + 1, position.getTileRow(), 1);
            case SOUTH:
                return new Position(position.getRoomRow() + 1, position.getRoomColumn(), 1, position.getTileColumn());
            case WEST:
                return new Position(position.getRoomRow(), position.getRoomColumn() - 1, position.getTileRow(), Room.WIDTH - 2);
        }
        //Can't happen
        return null;
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
