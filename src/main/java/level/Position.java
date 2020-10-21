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

    public Position getAdjacentPosition(Direction direction) {
        int tileRowChange = 0;
        int tileColumnChange = 0;

        switch (direction) {
            case NORTH:
                tileRowChange = -1;
                break;
            case EAST:
                tileColumnChange = 1;
                break;
            case WEST:
                tileColumnChange = -1;
                break;
            case SOUTH:
                tileRowChange = 1;
                break;
        }


        return new Position(roomRow, roomColumn, tileRow + tileRowChange, tileColumn + tileColumnChange);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (roomRow != position.roomRow) return false;
        if (roomColumn != position.roomColumn) return false;
        if (tileRow != position.tileRow) return false;
        return tileColumn == position.tileColumn;
    }

    @Override
    public int hashCode() {
        int result = roomRow;
        result = 31 * result + roomColumn;
        result = 31 * result + tileRow;
        result = 31 * result + tileColumn;
        return result;
    }
}

