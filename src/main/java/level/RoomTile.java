package level;

import java.util.Objects;

public class RoomTile {
    private final char charRepresentation;
    private final boolean solid;

    public RoomTile(char charRepresentation, boolean solid) {
        this.charRepresentation = charRepresentation;
        this.solid = solid;
    }

    public char getCharRepresentation() {
        return charRepresentation;
    }

    public boolean isSolid() {
        return solid;
    }

    @Override
    public String toString() {
        return Character.toString(charRepresentation);
    }

}
