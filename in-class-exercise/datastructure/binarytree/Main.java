package binarytree; 

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Heap instance = new ArrayHeap(); 
        System.out.println(instance);

        Random generator = new Random(); 

        for(int x = 0; x < 8; x++) {
            instance.add(generator.nextInt(x));
        }

        System.out.println(instance);
    }
}
