package unit07.skills;

import java.util.Random;

public class Race implements Runnable{

    public Animal animal; 

    public Race(Animal animal) {
        this.animal = animal; 
    }

    @Override 
    public void run() {
        for(int x = 0; x <= animal.getTotalMiles(); x++) {
            try {
                animal.showProgress(x); 
                Thread.sleep(200);
            } catch (Exception e) {}
        }

        System.out.println(String.format("%s finished the warm-up!", this.animal.getName()));
    }

    public static void main() {
        int numberOfAnimals = 3; 
        int maxTotalMiles = 10;

        Random generator = new Random();

        for(int x = 0; x < numberOfAnimals; x++) {
            int totalMiles = generator.nextInt(maxTotalMiles); 
            Animal animal = new Animal(String.format("Animal %s", x), totalMiles);
            Race instance = new Race(animal);

            Thread thread = new Thread(instance::run);
            thread.run();
        }
    }
}
