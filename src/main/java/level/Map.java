package level;


public class Map {
    public static final int WIDTH = 2, HEIGHT = 2;
    private Room[][] rooms;

    public Map(Room[][] rooms) {
        this.rooms = rooms;
    }

    public Room[][] getRooms() {
        return rooms;
    }
}
