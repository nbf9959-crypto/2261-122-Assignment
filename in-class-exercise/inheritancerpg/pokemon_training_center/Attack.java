public class Attack {
    private int level; 

    public Attack(String type, int level)  {
        this.type = type; this.level = level; 
    }

    public int hitting() {
        return 
    }

    @Override
    public String toString() {
        return String.format("Attack type: %s", type);
    }
}
