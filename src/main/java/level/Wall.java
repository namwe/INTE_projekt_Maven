package level;

public class Wall extends RoomTile {

    public static final char CHAR_REPRESENTATION = '#';
    private static Wall instance = new Wall();

    private Wall() {
        super(CHAR_REPRESENTATION, true);
    }

    public static Wall getInstance() {
        return instance;
    }
}
