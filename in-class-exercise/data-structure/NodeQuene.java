public class NodeQuene<E> implements Quene<E>{
    private Node<E> front; 
    private Node<E> back; 
    private int size; 

    public NodeQuene() {
        this.size = 0; 
    }

    @Override 
    public void enquene(E value) {
        Node<E> element = new Node<E>(value); 

        if(this.front == null) {
            this.front = element; this.back = front; 
        } else {
            element.setNext((this.back.getNext()));

            this.back.setNext(element);
            this.back = element; 
        }

        size++; 
    }; 
    
    @Override 
    public E dequene() {
        if(this.size == 0) 
            return null;

        E element = this.front.getValue(); 

        this.front = this.front.getNext(); 

        if(this.front == null) {
            this.back = null; 
        }

        size--; 
        return element; 
    }; 

    @Override 
    public int size() {
        return size; 
    }
}
