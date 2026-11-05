package unit07.skills;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Rest {
    

    public static void main(String[] args) {
        int numberOfAnimals = 3;
        int maxRestTime = 10; 

        Random generator = new Random();

        ExecutorService execSvc = Executors.newFixedThreadPool(numberOfAnimals); 

        for(int x = 0; x < numberOfAnimals; x++) {
            Animal animal = new Animal(String.format("Animal %s", x), 0);

            int restTime = generator.nextInt(1, maxRestTime);
            execSvc.submit(() -> {
                    System.out.println(String.format("%s is going to rest for %s ms", animal.getName(), restTime * 1000));

                    try {
                        Thread.sleep(restTime * 1000);
                    } catch (Exception e) {}

                    System.out.println(animal.getName() + "woke up feeling refreshed!");
            });  

            execSvc.shutdown();
            try {
                execSvc.awaitTermination(1, TimeUnit.SECONDS);
            } catch (Exception e) {
                System.out.println("Interrupted!");
            }

            System.out.println("All animals finished resting!");
            
        }
    }
}
