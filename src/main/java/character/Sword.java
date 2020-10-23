package character;
import monster.*;


public class Sword extends Equipment  {
private boolean secondEquipped;

    public Sword(StatEquipment stats) {
        super(stats);
        secondEquipped = false;
    }

    public boolean isSecondEquipped() {
        return secondEquipped;
    }

    public void setSecondEquipped(boolean secondEquipped) {
        this.secondEquipped = secondEquipped;
    }

}
