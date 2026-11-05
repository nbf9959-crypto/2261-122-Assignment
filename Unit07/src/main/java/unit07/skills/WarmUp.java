package unit07.skills;

import java.util.Random;

public class WarmUp implements Runnable{

    public Animal animal; 

    public WarmUp(Animal animal) {
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
        int numberOfAnimals = 2; 
        int maxTotalMiles = 10; 

        Random generator = new Random();
        
        for(int x = 0; x < numberOfAnimals; x++) {
            int totalMiles = generator.nextInt(maxTotalMiles); 
            WarmUp instance = new WarmUp(new Animal(String.format("Animal %s", x), totalMiles));

            Thread thread = new Thread(instance::run);
            thread.start();
        }
    }
}
