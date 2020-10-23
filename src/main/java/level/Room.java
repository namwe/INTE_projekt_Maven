package level;

public class Room {

    public static final int WIDTH = 9, HEIGHT = 9;
    private RoomTile[][] layout;

    public Room(){
        this(RoomType.DEFAULT_ROOM);
    }

    public Room(RoomTile[][] layout) {
        if (!dimensionsAreOk(layout)) {
            throw new IllegalArgumentException();
        }
        this.layout = layout;
    }

    public Room(RoomType type) {
        switch (type) {
            case DEFAULT_ROOM:
                layout = Room.generateRoomWithWalls();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean dimensionsAreOk(RoomTile[][] layout) {
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
            newLayout[0][i] = Wall.getInstance();
        }
        for (int i = 1; i < HEIGHT - 1; i++) {
            newLayout[i][0] = Wall.getInstance();
            for (int j = 1; j < WIDTH - 1; j++) {
                newLayout[i][j] = Air.getInstance();
            }
            newLayout[i][WIDTH - 1] = Wall.getInstance();
        }
        for (int i = 0; i < WIDTH; i++) {
            newLayout[HEIGHT - 1][i] = Wall.getInstance();
        }

        return newLayout;
    }

    public void replaceTile(int row, int column, RoomTile tile) {
        layout[row][column] = tile;
    }

    public RoomTile[][] getLayout() {
        return layout;
    }

    public String rowToString(int index){
        StringBuilder sb = new StringBuilder();
        for (RoomTile tile : layout[index]) {
            sb.append(tile);
            sb.append(' ');
        }
        return sb.toString();
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
