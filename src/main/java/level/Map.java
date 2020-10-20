package level;


public class Map {
    public static final int WIDTH = 2, HEIGHT = 2;
    private Room[][] rooms;

    public Map(Room[][] rooms) {
        if (!dimensionsAreOk(rooms)){
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

    public Room[][] getRooms() {
        return rooms;
    }

    public void placeDoors() {
        this.getRooms()[0][0].replaceTile(4, 8, Door.getInstance());
        this.getRooms()[0][0].replaceTile(8, 4, Door.getInstance());

        this.getRooms()[0][1].replaceTile(4, 0, Door.getInstance());
        this.getRooms()[0][1].replaceTile(8, 4, Door.getInstance());

        this.getRooms()[1][0].replaceTile(0, 4, Door.getInstance());
        this.getRooms()[1][0].replaceTile(4, 8, Door.getInstance());

        this.getRooms()[1][1].replaceTile(0, 4, Door.getInstance());
        this.getRooms()[1][1].replaceTile(4, 0, Door.getInstance());
    }
}
