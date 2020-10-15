package NoNameYet;

public class Player {
    private Stat playerStats;
    private int speed;
    private String name;
    private Equipment equipment;

    public Player(String name) { // En spelar spawnar med ett svärd
        this.name = name;
        playerStats = new Stat(100,50);
        equipment = new Sword(new StatEquipment(10, 0));
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
