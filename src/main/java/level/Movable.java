package level;

public abstract class Movable extends RoomTile{
    private RoomTile originalTile;
    private int[][] roomPosition;

    public Movable(char charRepresentation) {
        super(charRepresentation, true);
    }
}
