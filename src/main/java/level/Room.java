package level;


import java.util.HashMap;
import java.util.Map;

public class Room {

    private static final int WIDTH = 9, HEIGHT = 9;
    private char[][] layout;
    private Map<RoomType, char[][]> roomTemplates = new HashMap<>();

    public Room(char[][] layout) {
        if (!dimentionsAreOk(layout)){
            throw new IllegalArgumentException();
        }
        this.layout = layout;
    }

    public Room(RoomType roomType){
        generateRoomTemplates();
        this.layout = roomTemplates.get(roomType);
    }

    //Will be moved
    private void generateRoomTemplates(){
        roomTemplates.put(RoomType.DEFAULT_ROOM, roomWithWalls());
    }

    private char[][] roomWithWalls(){
        char[][] newLayout = new char[HEIGHT][WIDTH];

        for (int i = 0; i < WIDTH; i++) {
            newLayout[0][i] = '#';
        }
        for (int i = 0; i < HEIGHT; i++) {
            newLayout[i][0] = '#';
            newLayout[i][WIDTH-1] = '#';
        }
        for (int i = 0; i < WIDTH; i++) {
            newLayout[HEIGHT-1][i] = '#';
        }

        return newLayout;
    }

    private boolean dimentionsAreOk(char[][] layout) {
        if (layout.length != HEIGHT) {
            return false;
        }

        for (char[] chars : layout) {
            if (chars.length != WIDTH) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : layout) {
            for (char aChar : chars) {
                sb.append(aChar);
                sb.append(' ');
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
