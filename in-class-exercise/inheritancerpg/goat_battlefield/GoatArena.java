public class GoatArena {
    static void battle(Mage goat1, Fighter goat2) {
        while(goat1.isConscious() && goat2.isConscious()) {
            goat1.takeDamage(goat2.attack()); goat2.takeDamage(goat1.attack());
        }
    }

    static void battle(Mage goat1, Mage goat2) {
        while(goat1.isConscious() && goat2.isConscious()) {
            goat1.takeDamage(goat2.attack()); goat2.takeDamage(goat1.attack());
        }
    }
}
