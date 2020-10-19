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
        Equipment checkedEq = getSpecificEquipment(equipment);
        checkedEq.setEquipped(false);
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

    private void checkBooleanOnEquipments(Equipment equipment) {
        if (equipments.size() <= 1) {
            return;
        }

        String chooser = getChooserString(equipment);

        int count = 0;
        for (Equipment loopEq : equipments) {
            switch (chooser) {
                case "armor":
                    if (loopEq instanceof Armor) {
                        count++;
                    }
                    break;
                case "scroll":
                    if (loopEq instanceof Scroll) {
                        count++;
                    }
                    break;
                case "sword":
                    if (loopEq instanceof Sword) {
                        count++;
                    }
                    break;
            }
        }


        if (chooser.equals("sword")) {
            if (count > 2) {
                throw new IllegalStateException();
            }
        } else {
            if (count > 1) {
                throw new IllegalArgumentException();
            }
        }



    }

    private String getChooserString(Equipment equipment) {
        String chooser = "";
        if (equipment instanceof Armor) {
            chooser = "armor";
        } else if (equipment instanceof Scroll) {
            chooser = "scroll";
        } else if (equipment instanceof Sword) {
            chooser = "sword";
        }
        return chooser;
    }

    public void putOn(Equipment eq) {
        Equipment equipment = getSpecificEquipment(eq);
        checkBooleanOnEquipments(eq);


        equipment.setEquipped(true);
    }

}
