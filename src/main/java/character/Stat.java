package character;
import monster.*;

import monster.Frankenstein;
import monster.Ghost;
import monster.Vampire;

public class Stat {
    private int hp;
    private int mana;

    public Stat(int hp, int mana) {
        this.hp = hp;
        this.mana = mana;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }


}
