package unit05.skills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProductionLineProcessor<T> {
    
    public void processQueue(Queue<Box<T>> queue, ArrayList<Box<T>> boxes) {
        System.out.println("\nProcessing....\n");
        while(!queue.isEmpty()) {
            Box<T> item = queue.remove(); 
            boxes.add(item); 

            System.out.println(String.format("Processing generic box: %s", item));
        }
    }

    public static void main(String[] args) {
        ProductionLineProcessor<String> stringProcessor = new ProductionLineProcessor<>(); 
        ProductionLineProcessor<Integer> intProcessor = new ProductionLineProcessor<>(); 
        
        Queue<Box<String>> productQueue = new LinkedList<>(); 
        ArrayList<Box<String>> productBoxes = new ArrayList<>(); 

        Queue<Box<Integer>> serialQueue = new LinkedList<>(); 
        ArrayList<Box<Integer>> serialBoxes = new ArrayList<>(); 

        productQueue.add(new Box<String>("RIT bag")); 
        productQueue.add(new Box<String>("Head First Java book")); 
        productQueue.add(new Box<String>("Tiger keychain")); 

        serialQueue.add(new Box<Integer>(1001)); 
        serialQueue.add(new Box<Integer>(1002)); 
        serialQueue.add(new Box<Integer>(1003)); 

        stringProcessor.processQueue(productQueue, productBoxes);
        intProcessor.processQueue(serialQueue, serialBoxes);

        System.out.println("\nserialBoxes content:\n");
        for (Box<Integer> serialItem : serialBoxes) {
            System.out.println(serialItem);
        }
    }
}
