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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomTile roomTile = (RoomTile) o;
        return charRepresentation == roomTile.charRepresentation &&
                solid == roomTile.solid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(charRepresentation, solid);
    }
}
