package level;

public class Door extends RoomTile {

    public static final char CHAR_REPRESENTATION = '@';
    private static Door instance = new Door();

    private Door() {
        super(CHAR_REPRESENTATION, false);
    }

    public static Door getInstance() {
        return instance;
    }
}
