package character;

public class StatEquipment {
    private int condition;
    private int mana;

    public StatEquipment(int condition, int mana) {
        if (condition < 0 || condition > 10) {
            throw new IllegalArgumentException();
        } else {
            this.condition = condition;
        }
        if (mana < 0 || mana > 10) {
            throw new IllegalArgumentException();
        } else {
            this.mana = mana;
        }

    }

    public int getCondition() {
        return condition;
    }

    public int getMana() {
        return mana;
    }
}
