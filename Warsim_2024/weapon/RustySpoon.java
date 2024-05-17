package weapon;

public class RustySpoon extends Weapon { // you never said it had to be a *good* weapon lol. Full Weapon name is Trusty Rusty Spoon... but that was a lot to type each time so I shortened it for code readability.
    private int damageAmount = 1; 
    private int dexterityCost = 5;
    private int baseHitChance = 75; // 75% hit rate

    public RustySpoon() {
        super();
        super.setDamageAmount(damageAmount);
        super.setDexterityCost(dexterityCost);
    } // constructor

    public int strike(int attackType, int dexterity, int strength) {
        int damage = 0;
        int roll = super.randNum.nextInt(100) + 1;

        if ((roll - attackType * 5) + (dexterity /10 - this.dexterityCost)
                <= baseHitChance) { // hit
            damage = this.damageAmount + (strength / 10) + (attackType * 5);
        }
        else { // miss
            damage = 0;
        }
        return damage;
    } // strike
} // class