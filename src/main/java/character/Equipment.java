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

    public void combat(Monster monster, Equipment equipment) {
        if (equipment instanceof Sword) {
            stats.takeDmg(monster);
        } else if (equipment instanceof Scroll) {
            stats.takeManaDmg(monster);
        }
    }
}
