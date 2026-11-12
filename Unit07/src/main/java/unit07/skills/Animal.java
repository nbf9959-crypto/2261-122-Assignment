package unit07.skills;

public class Animal {
    private String name; 
    private int totalMiles; 

    public Animal(String name, int mile) {
        this.name = name;
        this.totalMiles = mile; 
    }

    public String getName() {
        return this.name; 
    }

    public int getTotalMiles() {
        return this.totalMiles; 
    }

    public void showProgress(int mile) {
        System.out.println(String.format("%s : mile %s of %s", this.name, mile, this.totalMiles));
    }
    
}
