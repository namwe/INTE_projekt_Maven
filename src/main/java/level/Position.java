package level;

public class Position {
    private int roomRow, roomColumn, tileRow, tileColumn;

    public Position(int roomRow, int roomColumn, int tileRow, int tileColumn) {
        this.roomRow = roomRow;
        this.roomColumn = roomColumn;
        this.tileRow = tileRow;
        this.tileColumn = tileColumn;
    }

    public int getRoomRow() {
        return roomRow;
    }

    public int getRoomColumn() {
        return roomColumn;
    }

    public int getTileRow() {
        return tileRow;
    }

    public int getTileColumn() {
        return tileColumn;
    }
}

