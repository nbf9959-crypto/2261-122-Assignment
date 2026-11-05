public class RunnableRacer extends Racer implements Runnable {
    private final int id; 

    public RunnableRacer(String name, int numLaps, boolean debug, int id) {
        super(name, numLaps, debug);
        this.id = id; 
    }

    public RunnableRacer(String name, int numLaps, int id) {
        super(name, numLaps);
        this.id = id; 
    }

    @Override 
    public void run() {
        race();
    }
}
