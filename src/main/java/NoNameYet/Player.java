package NoNameYet;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Stat playerStats;
    private int speed;
    private String name;
    private List<Equipment> equipments = new ArrayList<>();

    public Player(String name) { // En spelar spawnar med ett svärd i sin inventory
        this.name = name;
        equipments.add(new Sword(new StatEquipment(10,0)));
        playerStats = new Stat(100,50);
        //equipment = new Sword(new StatEquipment(10, 0));
    }

    public void dismantle(Equipment equipment) {

    }

    public Equipment getEquipment() {
        return null;
    }

    public void putOn(Equipment equipment) {
        if (equipment.isEquipped()) {
            //kasta undantag elr nåt. men svärd kan man ha två stycken equippade
            throw new IllegalArgumentException();
        } else {
            equipment.setEquipped(true);
        }
    }

}
