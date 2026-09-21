public class Troll {
    private String name; 
    private int maxHP; 
    private int currentHP;

    public Troll(String name, int maxHP) {
        this.name = name; 
        this.maxHP = maxHP; 
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

    public regenerate() {

    }

    protected adjustHP(int amount) {

    }
}
