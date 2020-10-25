package character;

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

}
