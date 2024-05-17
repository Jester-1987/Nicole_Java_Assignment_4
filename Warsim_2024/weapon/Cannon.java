package weapon;

public class Cannon extends Weapon {
    private int damageAmount = 100; // overpowered
    private int deterityCost = 1; // *very* easy to use
    private int baseHitChance = 100; // did I say overpowered?

    public Cannon() {
        super();
        super.setDamageAmount(damageAmount);
        super.setDexterityCost(deterityCost);
    } // construcor

    public int strike(int attackType, int dexterity, int strength) {
        int damage = 0;
        int roll = super.randNum.nextInt(100) + 1;

        if((roll - attackType * 5) + (dexterity / 10 - this.deterityCost)
                <=baseHitChance) { // hit
            damage = this.damageAmount + (strength / 10) + (attackType * 5);
        }
        else { // miss
            damage = 0;
        }
        return damage;
    } // strike 
} // class