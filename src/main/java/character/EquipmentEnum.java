package character;


public enum EquipmentEnum {
    SWORD, ARMOR, SCROLL, DEFAULT;


    public EquipmentEnum getType(Equipment equipment) {
        if (equipment instanceof Armor) {
            return ARMOR;
        } else if (equipment instanceof Sword) {
            return SWORD;
        } else if (equipment instanceof Scroll) {
            return SCROLL;
        } else {
            return DEFAULT;
        }

    }


}
