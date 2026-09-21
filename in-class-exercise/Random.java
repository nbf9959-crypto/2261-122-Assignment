import java.util.Random; 

public class Main {

    private static final int MAX = 10; 
    private static final int MIN = 2;
    public static void main(String[] args) {
        long seed = 12345; 
        Random random = new Random(seed); 

        for(int i = 0; i < 10; i++) {
            int pick = random(MIN, MAX); 
        }
    }
} 
