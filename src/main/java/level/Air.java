package level;

public class Air extends RoomTile{
    public static final char CHAR_REPRESENTATION = ' ';
    private static Air instance = new Air();

    private Air() {
        super(CHAR_REPRESENTATION, false);
    }

    public static Air getInstance() {
        return instance;
    }
}
