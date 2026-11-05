public class Racer {
    private String name; 
    private int numLaps; 
    private long time; 
    private boolean debug; 

    public Racer(String name, int numLaps, boolean debug) {
        this.name = name; 
        this.numLaps = numLaps; 
        this.debug =  debug; 
    }

    public Racer(String name, int numLaps) {
        this.name = name; 
        this.numLaps = numLaps; 
    }

    public void race() {
        long initial = System.nanoTime(); 

        for(int x = 0; x < numLaps; x++) {
            if(debug)
                System.err.println((x == (numLaps -  1)) ? String.format("%s completed %s\n", this.name, x + 1) : String.format("%s completed %s", this.name, x + 1));
        }

        this.time = System.nanoTime() - initial; 
    }

    public String getName() {
        return this.name; 
    }

    public double getFinishTime() {
        return time / 1000000000; 
    }


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