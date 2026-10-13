package unit05.skills;

import java.util.Queue;
import java.util.LinkedList;

public class Packing {
    public static void main(String[] args) {

        Queue<Box<String>> productionQueue = new LinkedList<>(); 

        productionQueue.add(new Box<String>("RIT T-shirt")); 
        productionQueue.add(new Box<String>("RIT Jacket")); 
        productionQueue.add(new Box<String>("J Laptop")); 

        System.out.println("\n");
        while(!productionQueue.isEmpty()) {
            Box<String> item = productionQueue.remove(); 
            System.out.println(String.format("* Removing the '%s' item from the queue *", item));
        }
    }
}
