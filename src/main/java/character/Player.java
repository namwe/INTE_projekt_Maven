package character;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Stat playerStats;
    private int speed = 1;
    private String name;
    private List<Equipment> equipments = new ArrayList<>();

    public Player(String name) { // En spelar spawnar med ett svärd i sin inventory
        this.name = name;
        equipments.add(new Sword(new StatEquipment(10,0)));
        playerStats = new Stat(100,50);
    }

    public void dismantle(Equipment equipment) {

    }

    public void increaseSpeed() {
        if (speed == 10) {
            throw new IllegalStateException();
        } else {
            speed++;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getSizeOfInventory() {
        return equipments.size();
    }

    public void addToInventory(Equipment equipment) {
        equipments.add(equipment);
    }

    public Equipment getSpecificEquipment(Equipment eq) {
        for (Equipment equipment : equipments) {
            if (eq.getStats().getCondition() == equipment.getStats().getCondition() && eq.getStats().getMana() == equipment.getStats().getMana()) {
                return equipment;
            }
        }
        throw new IllegalArgumentException();
    }

    public void putOn(Equipment eq) {
        Equipment equipment = getSpecificEquipment(eq);



        if (equipment.isEquipped()) {
            //kasta undantag elr nåt. men svärd kan man ha två stycken equippade
            throw new IllegalArgumentException();
        } else {
            equipment.setEquipped(true);
        }
    }

}
