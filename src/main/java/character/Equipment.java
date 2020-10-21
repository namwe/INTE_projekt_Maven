package character;


import monster.*;

public abstract class Equipment {
    private boolean equipped;
    private StatEquipment stats;

    public Equipment(StatEquipment stats) {
        this.equipped = false;
        this.stats = stats;
    }


    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public StatEquipment getStats() {
        return stats;
    }

    public void takeDmg(Monster monster) {
        if (monster instanceof Ghost) {
            hp = hp - 10;
        } else if (monster instanceof Frankenstein) {
            hp = hp - 20;
        } else if (monster instanceof Vampire) {
            hp = hp - 30;
        }
    }
}
