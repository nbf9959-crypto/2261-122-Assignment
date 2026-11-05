package datastructure; 

public class ArrayQuene implements Quene{

    private int front; 
    private int back;  
    private int size; 

    private int INITIAL_CAPACITY = 10; 

    private String[] elements; 


    public ArrayQuene() {
        this.size = this.front = this.back = 0; 
        this.collection = new String[INITIAL_CAPACITY]; 
    }
 
    @Override 
    public void enquene(String value) {
        
    }; 
    
    @Override 
    public String dequene() {
       

        
    }; 

    @Override 
    public int size() {
        return size; 
    }

    @Override
    public String toString() {
        String details = ""; 
        
        

        for (String element : elements) {
            details += element; 
        }

        return details; ;    }
}
