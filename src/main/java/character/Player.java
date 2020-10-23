package character;

import monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Player implements Attackable {
    private Stat playerStats;
    private int speed;
    private String name;
    private List<Equipment> equipments = new ArrayList<>();

    public Player(String name) { // En spelar spawnar med ett svärd i sin inventory
        this.name = name;
        equipments.add(new Sword(new StatEquipment(10,0)));
        playerStats = new Stat(100,50);
        speed = 1;
    }


    public void dismantle(Equipment equipment) {
        Equipment checkedEq = getEquipmentWithSpecificStats(equipment);
        checkedEq.setEquipped(false);
    }

    public List<Equipment> getEquipments() {
        List<Equipment> copy = new ArrayList<>();
        copy.addAll(equipments);
        return copy;
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

    public Equipment getEquipmentWithSpecificStats(Equipment eq) {
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

        int count = getCounterForEquipments(chooser);


        if (chooser.equals("sword")) {
            if (count >= 2) {
                throw new IllegalStateException();
            }
        } else {
            if (count >= 1) {
                throw new IllegalStateException();
            }
        }



    }

    private int getCounterForEquipments(String chooser) {
        int count = 0;
        for (Equipment loopEq : equipments) {
            switch (chooser) {
                case "armor":
                    if (loopEq instanceof Armor) {
                        if (loopEq.isEquipped()) {
                            count++;
                        }
                    }
                    break;
                case "scroll":
                    if (loopEq instanceof Scroll) {
                        if (loopEq.isEquipped()) {
                            count++;
                        }
                    }
                    break;
                case "sword":
                    if (loopEq instanceof Sword) {
                        if (loopEq.isEquipped()) {
                            count++;
                        }
                    }
                    break;
            }
        }
        return count;
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

    //*** En metod som kollar om det går att sätta på ett equipment ***//
    public void putOn(Equipment eq) {

        eq = getEquipmentWithSpecificStats(eq);
        checkBooleanOnEquipments(eq);


        eq.setEquipped(true);
    }

    public void damage(Monster monster) {
        playerStats.takeDmg(monster);
        int count = 0;
        for (Equipment equipment : equipments) {
            if (equipment.isEquipped()) {
                if (equipment instanceof Sword) {
                    count++;
                    equipment.combat(monster, equipment);
                } else if (equipment instanceof Scroll) {
                    count++;
                    equipment.combat(monster, equipment);

                }
            }
        }
        if (count == 0) {
            throw new IllegalStateException();
        }
    }

}
