package binarytree; 

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array; 
    private int size; 

    public ArrayHeap() {
        this.array = new int[3]; this.size = 0; 
    }

    private void swap(int a, int b) {
        if(this.array[a] == this.array[b]) {
            int original = this.array[a]; 

                this.array[a] = this.array[b];
                this.array[b] = original; 
        }
    }

    @Override
    public void add(int value) {
        if(this.size == this.array.length) {
           this.array = Arrays.copyOf(this.array, this.array.length * 2); 
        }

        int child = this.size; 
        int parent = (child - 1) / 2; 

        this.array[this.size] =  value; 

        while(array[parent] > array[child]) {
            swap(child, parent);

            int original = child;
            
            child = parent; 
            parent = (original - 1) / 2; 
        }

        this.size++; 
    }; 

     @Override
    public int remove() {
        int temporary = this.array[0];
        this.array[0] = this.array[this.size]; 
        this.size--;

        int parent = 0;

        while(parent < this.size) {
            if(this.array[(parent * 2) + 1] != 0 && this.array[(parent * 2) + 2] != 0) {
                
            }
        }

        return temporary;
    }; 

    @Override
    public int size() {
        return size; 
    }; 

    @Override
    public String toString() {
        return String.format("%d, %s", this.size, this.array.toString()); 
    }
}
