package character;
import monster.*;

public class Sword extends Equipment {


    public Sword(StatEquipment stats) {
        super(stats);

    }


    public void damage(Monster monster) {
        if (monster instanceof Ghost) {

        } else if (monster instanceof Frankenstein) {

        } else if (monster instanceof Vampire) {

        }
    }

    public void durability(Monster monster) {

    }
}
