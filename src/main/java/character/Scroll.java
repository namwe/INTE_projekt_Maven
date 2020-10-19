package character;

public class Scroll extends Equipment {


    public Scroll(StatEquipment stats) {
        super(stats);
        if (stats.getCondition() != 10 || stats.getCondition() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void damage() {

    }

    public void durability() {

    }
}
