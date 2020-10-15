package NoNameYet;

public class Player {
    private Stat playerStats;
    private int speed;
    private String name;
    private Equipment equipment;

    public Player(String name) {
        this.name = name;
        playerStats = new Stat(100,50);
        equipment = new Sword();
    }
}
