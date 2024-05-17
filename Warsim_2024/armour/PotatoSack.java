package armour;

public class PotatoSack extends Armour {
    private int armourAmount = 5; // barely any protection
    private int dexterityCost = 5; // easy to move in at least

    public PotatoSack() {
        super();
        super.setArmourAmount(armourAmount);
        super.setDexterityCost(dexterityCost);
    } // constructor

    public int getFinalDamage(int damage) {
        return damage - (this.armourAmount / 15); // not a lot of protection at all 
    }

} // class