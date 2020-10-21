package character;

import monster.Frankenstein;
import monster.Ghost;
import monster.Monster;
import monster.Vampire;

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

    public void takeDmg(Monster monster) {
        if (monster instanceof Ghost) {
            System.out.println("spoke");
            condition = condition - 1;
        } else if (monster instanceof Frankenstein) {
            condition = condition - 2;
        } else if (monster instanceof Vampire) {
            condition = condition - 3;
        }
    }


    public int getCondition() {
        return condition;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return "condition = " + condition + " mana = " + mana;
    }
}
