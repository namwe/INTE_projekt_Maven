package NoNameYet;

public class Player {
    private Stat playerStats;
    private int speed;
    private String name;
    private Equipment equipment;

    public Player(String name) { // En spelar spawnar med ett svärd i sin inventory
        this.name = name;
        playerStats = new Stat(100,50);
        equipment = new Sword(new StatEquipment(10, 0));
    }

    public void dismantle(Equipment equipment) {

    }

    public void putOn(Equipment equipment) {

    }

    public Equipment getEquipment() {
        return equipment;
    }
}
