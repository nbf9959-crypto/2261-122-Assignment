package inheritancerpg;
public class Fighter {
    private String name; 
    private int MaximumHP; 
    private int currentHP; 

    public Fighter(String name) {
        this.name = name; 
        this.MaximumHP = this.currentHP = 150; 
    }

    public Attack attack() {
        int[] hits = {9,9,9,9}; 
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL); 
    }

    public void takeDamage(Attack attack) {
        for(int hit : attack.getHits()) {
            if(currentHP <= 0) {
                currentHP = 0; break; 
            } else {
                if(attack.getType() == DamageType.MAGICAL) {
                    currentHP = (int) (currentHP - (hit - (hit * 0.25))); 
                } 

                if(attack.getType() == DamageType.PHYSICAL) {
                    currentHP = (int) (currentHP - (hit + (hit * 0.25))); 
                } 
            }
        }
    }

    public void heal(int amount) {

    }

    public Boolean isConscious() {
        return currentHP > 0; 
    }

    @Override
    public String toString() {
        return String.format("Goat: name: %s, current hp: %d", name, currentHP);
    }
}
