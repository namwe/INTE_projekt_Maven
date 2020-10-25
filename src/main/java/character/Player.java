package character;

import monster.Monster;
import level.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends Movable implements Attackable {
    private Stat playerStats;
    private int speed;
    private String name;
    private List<Equipment> equipments = new ArrayList<>();

    public Player(String name, char charRepresentation, Position position, Map map) {
        super(charRepresentation, position, map);
        if (name == null) { throw new IllegalArgumentException(); } else { this.name = name; }
        equipments.add(new Sword(new StatEquipment(10,0))); // En spelar spawnar med ett svärd i sin inventory
        playerStats = new Stat(100,50);
        speed = 1;
    }


    public void unEquip(Equipment equipment) {
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

    public Stat getPlayerStats() {
        return playerStats;
    }

    public void addToInventory(Equipment equipment) {
        equipments.add(equipment);
    }

    public Equipment getEquipmentWithSpecificStats(Equipment eq) {
        for (Equipment equipment : equipments) {
            if (eq.equals(equipment)) {
                return equipment;
            }
        }
        throw new IllegalArgumentException();
    }

    private void checkHowManyEquipmentsAreEquipped(Equipment equipment) {
        if (equipments.size() <= 1) {
            return;
        }

        EquipmentEnum eqType = EquipmentEnum.DEFAULT;
        eqType = eqType.getType(equipment);

        int count = getCounterForEquipments(eqType);

        if (eqType == EquipmentEnum.SWORD) {
            if (count >= 2) {
                throw new IllegalStateException();
            }
        } else {
            if (count >= 1) {
                throw new IllegalStateException();
            }
        }
    }

    private int getCounterForEquipments(EquipmentEnum equipmentEnum) {
        int count = 0;
        for (Equipment loopEq : equipments) {
            switch (equipmentEnum) {
                case ARMOR:
                    if (loopEq instanceof Armor) {
                        if (loopEq.isEquipped()) {
                            count++;
                        }
                    }
                    break;
                case SCROLL:
                    if (loopEq instanceof Scroll) {
                        if (loopEq.isEquipped()) {
                            count++;
                        }
                    }
                    break;
                case SWORD:
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


    //*** En metod som kollar om det går att sätta på ett equipment och om det stämmer sätter då på det ***//
    public void putOn(Equipment eq) {

        eq = getEquipmentWithSpecificStats(eq);
        checkHowManyEquipmentsAreEquipped(eq);


        eq.setEquipped(true);
    }

    public void damage(Monster monster) {
        playerStats.takeDmg(monster);
        boolean hasEquippedEquipments = false;
        for (Equipment equipment : equipments) {
            if (equipment.isEquipped()) {
                if (equipment instanceof Sword) {
                    hasEquippedEquipments = true;
                    equipment.combat(monster, equipment);
                } else if (equipment instanceof Scroll) {
                    hasEquippedEquipments = true;
                    equipment.combat(monster, equipment);

                }
            }
        }
        if (!hasEquippedEquipments) {
            throw new IllegalStateException();
        }

    }


}
