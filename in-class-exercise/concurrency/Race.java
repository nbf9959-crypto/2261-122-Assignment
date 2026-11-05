public class Race {
    public static void main(String[] args) { 

        Racer racer_1 = new Racer("Bob", 10, true); 
        Racer racer_2 = new Racer("Ayssia", 12, true); 
        Racer racer_3 = new Racer("Kyle",5, true);

        racer_1.race(); racer_2.race(); racer_3.race();

        System.out.println("\n" + racer_1.getName() + " Finished in " +  racer_1.getFinishTime() +" seconds\n");
        System.out.println(racer_2.getName() + " Finished in " +  racer_2.getFinishTime() +" seconds\n");
        System.out.println(racer_3.getName() + " Finished in " +  racer_3.getFinishTime() +" seconds");
    }
}
