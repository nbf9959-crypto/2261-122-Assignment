import java.lang.Thread;

public class LambaRace {
    public static void lambdas() {
        RunnableRacer racer_1 = new RunnableRacer("Bob", 10, true, 1); 
        RunnableRacer racer_2 = new RunnableRacer("Ayssia", 12, true, 2); 
        RunnableRacer racer_3 = new RunnableRacer("Kyle",5, true, 3);

        Thread thread1 = new Thread(racer_1); 
        thread1.start(); 


        Thread thread2 = new Thread(racer_2::race());                                                                                                         ); 
        thread2.start(); 

        Thread thread3 = new Thread(racer_3); 
        thread3.start(); 

        while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive()) {
            continue;
        }

        System.out.println("\n" + racer_1.getName() + " Finished in " +  racer_1.getFinishTime() +" seconds\n");
        System.out.println(racer_2.getName() + " Finished in " +  racer_2.getFinishTime() +" seconds\n");
        System.out.println(racer_3.getName() + " Finished in " +  racer_3.getFinishTime() +" seconds");
    }

    public static void main(String[] args) {
        lambdas();
    }
}
