package armour;

public class Adamantium extends Armour {
    private int armourAmount = 300; // very protective
    private int dexterityCost = 300;

    public Adamantium() {
        super();
        super.setArmourAmount(armourAmount);
        super.setDexterityCost(dexterityCost);
    } // constructor

    public int getFinalDamage(int damage) {
        return damage - (this.armourAmount / 1);
    }
} // class