package level;

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

    public static RoomTile[][] generateRoomWithWalls() {
        RoomTile[][] newLayout = new RoomTile[HEIGHT][WIDTH];

        for (int i = 0; i < WIDTH; i++) {
            newLayout[0][i] = new Wall();
        }
        for (int i = 1; i < HEIGHT - 1; i++) {
            newLayout[i][0] = new Wall();
            for (int j = 1; j < WIDTH - 1; j++) {
                newLayout[i][j] = new Air();
            }
            newLayout[i][WIDTH - 1] = new Wall();
        }
        for (int i = 0; i < WIDTH; i++) {
            newLayout[HEIGHT - 1][i] = new Wall();
        }

        return newLayout;
    }

    public RoomTile[][] getLayout() {
        return layout;
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
