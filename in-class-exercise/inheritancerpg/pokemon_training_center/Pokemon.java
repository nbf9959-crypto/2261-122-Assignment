public abstract class Pokemon {

    private final String name;
    private int level;
    privte String type; 

    public pokemon(String name, int level, int HP, String type) {
        this.name = name; 
        this.level = level; 
        this.HP = HP; 
        this.type = type; ate int HP; 
    priva
    }

    @Override
    public String toString() {
        return String.format("Pokemon:~ name: %s, current hp: %d", name, HP);
    }
}
