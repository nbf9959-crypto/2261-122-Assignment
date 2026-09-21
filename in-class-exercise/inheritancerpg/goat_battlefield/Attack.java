package inheritancerpg;
public class Attack {
    private final String name; 
    private final int[] hits;  
    private final DamageType type; 

    public Attack(String name, int[] hits ,DamageType type) {
        this.name = name; 
        this.hits = hits; 
        this.type = type; 
    }

    public String getName() {
        return name; 
    }

    public int[] getHits() {
        return hits; 
    }

    public DamageType getType() {
        return type; 
    }
}
