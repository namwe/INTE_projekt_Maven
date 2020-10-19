package level;


import java.util.HashMap;
import java.util.Map;

public class Room {

    public static final int WIDTH = 9, HEIGHT = 9;
    private RoomTile[][] layout;


    public Room(RoomTile[][] layout) {
        if (!dimentionsAreOk(layout)) {
            throw new IllegalArgumentException();
        }
        this.layout = layout;
    }



    private boolean dimentionsAreOk(RoomTile[][] layout) {
        if (layout.length != HEIGHT) {
            return false;
        }

        for (RoomTile[] row : layout) {
            if (row.length != WIDTH) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RoomTile[] row : layout) {
            for (RoomTile tile : row) {
                sb.append(tile);
                sb.append(' ');
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
