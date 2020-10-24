package character;


import monster.*;

import java.util.Comparator;

public class Equipment implements Comparable<Equipment> {
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

    private int getStatsCondition() {
        return stats.getCondition();
    }

    private int getStatsMana() {
        return stats.getMana();
    }


    public void combat(Monster monster, Equipment equipment) {
        if (equipment instanceof Sword) {
            stats.takeDmg(monster);
        } else if (equipment instanceof Scroll) {
            stats.takeManaDmg(monster);
        }
    }

    @Override
    public int compareTo(Equipment o) {
        return Comparator.comparingInt(Equipment::getStatsCondition).
                thenComparingInt(Equipment::getStatsMana).
                thenComparing(Equipment::isEquipped).compare(this, o);
    }


}
