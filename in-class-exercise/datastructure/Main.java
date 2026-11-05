import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Quene<String> instance = new NodeQuene<String>(); 
        String[] samples = {"Boeing 707-200", "Boeing 737-400", "Boeing 747-100SUD"};
        
        ArrayList<String> discarded = new ArrayList<>(); 

        for (String sample : samples) {
            instance.enquene(sample); 
        }

        System.out.println(instance.size());

        discarded.add(instance.dequene());
        discarded.add(instance.dequene());

        System.out.println(instance.size());
        System.out.println(String.format("\ndiscarded items: %s", discarded.toString()));
    }

}
