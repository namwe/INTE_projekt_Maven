package character;

import java.util.List;

public enum Enum {
    SWORD, ARMOR, SCROLL, DEFAULT;

    private int countEquipped;

    Enum() {
        countEquipped = 0;
    }


    public Enum getType(Equipment equipment) {
        if (equipment instanceof Armor) {
            return ARMOR;
        } else if (equipment instanceof Sword) {
            return SWORD;
        } else if (equipment instanceof Scroll) {
            return SCROLL;
        }

        return DEFAULT;
    }

    public int getCounter(List<Equipment> equipmentList, Enum e) {
        for (Equipment eq : equipmentList) {
            switch (e) {
                case ARMOR:
                    if (eq.isEquipped()) {
                        countEquipped++;
                        break;
                    }
                case SWORD:
                    if (eq.isEquipped()) {
                        countEquipped++;
                        break;
                    }
                case SCROLL:
                    if (eq.isEquipped()) {
                        countEquipped++;
                        break;
                    }
            }
        }
        return countEquipped;
    }

}
