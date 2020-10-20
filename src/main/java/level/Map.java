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
}
