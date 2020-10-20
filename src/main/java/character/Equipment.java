package character;

public abstract class Equipment implements Attackable {
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
}
