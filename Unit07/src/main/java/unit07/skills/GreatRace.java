package unit07.skills;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GreatRace {
    public static void main(String[] args) {
        int raceDistance = 10; 

        Animal tina = new Animal("Tina the Tortoise", raceDistance);
        Animal harry = new Animal("Harry the Hare", raceDistance);

        ExecutorService execSvc = Executors.newFixedThreadPool(2); 

        CountDownLatch start = new CountDownLatch(1); 
        CountDownLatch end = new CountDownLatch(4); 

        execSvc.submit(() -> {
            try {
                start.await();

                for(int x = 0; x <= tina.getTotalMiles(); x++) {
                    try {
                        tina.showProgress(x); 
                        Thread.sleep(1000);
                    } catch (Exception e) {}  
                }

                end.countDown();
                System.out.println("Tina had finished the race.");
            } catch (Exception e) {
                // TODO: handle exception
            }
        });

        execSvc.submit(() -> {
            int halfway = harry.getTotalMiles() / 2; 

            try {
                start.await();

                for(int x = 0; x <= tina.getTotalMiles(); x++) {
                    try {
                        harry.showProgress(x); 
                        
                        if(x == halfway) {
                            System.out.println(String.format("%s is taking a nap for 7 seconds!", harry.getName()));
                            Thread.sleep(7000);

                            System.out.println(String.format("%s is taking a nap for 7 seconds!", harry.getName()));
                        }

                        Thread.sleep(300);
                    } catch (Exception e) {}  
                }

                end.countDown();
                System.out.println("Harry had finished the race.");
            } catch (Exception e) {
                // TODO: handle exception
            }
        });

        execSvc.shutdown(); 
        
        System.out.println("Runners, on your marks, get set, go!");
        start.countDown();
        try {
             end.await();
        } catch (Exception e) {}
       
        System.out.println("The race is over!");
    }
}
