package NoNameYet;

public abstract class Equipment implements Attackable {
    private boolean equipped;
    private StatEquipment stats;

    public Equipment(StatEquipment stats) {
        this.equipped = false;
        this.stats = stats;
    }

    public StatEquipment getStats() {
        return stats;
    }
}
