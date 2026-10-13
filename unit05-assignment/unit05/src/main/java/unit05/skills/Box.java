package unit05.skills;

public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item; 
    }

    public T getItem() {
        return this.item; 
    }

    public void setItem(T item) {
        this.item = item;
    }
 
    @Override
    public String toString() {
        return String.format("Box{item=%s}", this.item); 
    }

    public static void main(String[] args) {
        Box<String> book = new Box<String>("Book"); 
        Box<String> phone = new Box<String>("Phone"); 

        System.out.println(book);
        System.out.println(phone);

        Box<Integer> ten = new Box<Integer>(10); 
        Box<Integer> twenty = new Box<Integer>(20); 

        System.out.println("\n" + ten);
        System.out.println(twenty);
    }
}
