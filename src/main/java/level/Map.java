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
        roomTemplates.put(RoomType.DEFAULT_ROOM, Room.generateRoomWithWalls());
    }



}
