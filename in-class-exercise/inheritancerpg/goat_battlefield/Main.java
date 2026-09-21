package inheritancerpg;

public class Main {
    public void main() { 
        int[] hits = {9,9,9,9}; Mage goat = new Mage("Goatie"); 
        Attack attack = new Attack("Magic Missiles", hits , DamageType.MAGICAL); 

        goat.takeDamage(attack); System.out.println(goat);
    }
}
