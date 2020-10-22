package level;


public class Map {
    public static final int WIDTH = 2, HEIGHT = 2;
    private Room[][] rooms;

    public Map(Room[][] rooms) {
        if (!dimensionsAreOk(rooms)) {
            throw new IllegalArgumentException();
        }
        this.rooms = rooms;
    }

    private boolean dimensionsAreOk(Room[][] rooms) {
        if (rooms.length != HEIGHT) {
            return false;
        }

        for (Room[] row : rooms) {
            if (row.length != WIDTH) {
                return false;
            }
        }
        return true;
    }

    public RoomTile getTile(Position position) {
        return rooms[position.getRoomRow()][position.getRoomColumn()].getLayout()[position.getTileRow()][position.getTileColumn()];
    }

    public RoomTile replaceTile(Position position, RoomTile tile) {
        RoomTile originalTile = getTile(position);
        rooms[position.getRoomRow()][position.getRoomColumn()].replaceTile(position.getTileRow(), position.getTileColumn(), tile);
        return originalTile;
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void placeDoors() {
        int centerRow = Room.HEIGHT / 2;
        int centerColumn = Room.WIDTH / 2;
        int lastRow = Room.HEIGHT - 1;
        int lastColumn = Room.WIDTH - 1;

        for (int i = 0; i < Map.HEIGHT; i++) {
            for (int j = 0; j < Map.WIDTH; j++) {
                //West
                if (j < Map.HEIGHT - 1) {
                    this.getRooms()[i][j].replaceTile(centerRow, lastColumn, Door.getInstance());
                }
                //South
                if (i < Map.WIDTH - 1) {
                    this.getRooms()[i][j].replaceTile(lastRow, centerColumn, Door.getInstance());
                }
                //East
                if (j > 0) {
                    this.getRooms()[i][j].replaceTile(centerRow, 0, Door.getInstance());
                }
                //North
                if (i > 0) {
                    this.getRooms()[i][j].replaceTile(0, centerColumn, Door.getInstance());
                }
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Room.HEIGHT; i++) {
            sb.append(rooms[0][0].rowToString(i));
            sb.append(rooms[0][1].rowToString(i));
            sb.append("\n");
        }
        for (int i = 0; i < Room.HEIGHT; i++) {
            sb.append(rooms[1][0].rowToString(i));
            sb.append(rooms[1][1].rowToString(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
