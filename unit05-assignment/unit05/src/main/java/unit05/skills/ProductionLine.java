package unit05.skills;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {
    public static void main(String[] args) {
        
        Queue<Box<String>> productionQueue = new LinkedList<>();
        ArrayList<Box<String>> packedBoxes = new ArrayList<>(); 

        productionQueue.add(new Box<String>("RIT Plushie")); 
        productionQueue.add(new Box<String>("Richie costume")); 
        productionQueue.add(new Box<String>("Nathan's soup")); 

        System.out.println("\n");
        while(!productionQueue.isEmpty()) {
            Box<String> item = productionQueue.remove(); 
            packedBoxes.add(item); 

            System.out.println(String.format("Packing box: %s", item));
        }

        System.out.println("\nPacked boxes in order:\n");
        for(Box<String> item : packedBoxes) {
            System.out.println(item);
        }
    }
}
