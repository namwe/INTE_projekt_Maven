package level;

import java.util.HashMap;

public class Map {

    private java.util.Map<RoomType, RoomTile[][]> roomTemplates = new HashMap<>();

    private RoomTile[][] getRoomTemplate(RoomType type){
        if (roomTemplates.isEmpty()) {
            generateRoomTemplates();
        }
        return roomTemplates.get(type);
    }

    private void generateRoomTemplates() {
        roomTemplates.put(RoomType.DEFAULT_ROOM, roomWithWalls());
    }

    private RoomTile[][] roomWithWalls() {
        RoomTile[][] newLayout = new RoomTile[Room.HEIGHT][Room.WIDTH];

        for (int i = 0; i < Room.WIDTH; i++) {
            newLayout[0][i] = new Wall();
        }
        for (int i = 1; i < Room.HEIGHT - 1; i++) {
            newLayout[i][0] = new Wall();
            for (int j = 1; j < Room.WIDTH - 1; j++) {
                newLayout[i][j] = new Air();
            }
            newLayout[i][Room.WIDTH - 1] = new Wall();
        }
        for (int i = 0; i < Room.WIDTH; i++) {
            newLayout[Room.HEIGHT - 1][i] = new Wall();
        }

        return newLayout;
    }

}
