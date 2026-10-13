import java.sql.Array;
import java.util.Arrays;

public class Student{
    private String firstName; 
    private String lastName; 

    public Student(String firstName, String lastName) {
        this.firstName = firstName; 
        this.lastName = lastName; 
    }

    @Override 
    public String toString() {
        return String.format("{%s, %s}", firstName, lastName); 
    }

    public static void main(String arg[]) {
    Student[] students = {
            new Student("Bob", "Jeire"),
            new Student("Ahmed", "Sharif"),
            new Student("SHawn", "Peter")
        };
        
        System.out.println(Arrays.toString(students));

      
        
        Arrays.stream(students).filter(student -> student.firstName.toLowerCase().startsWith("s") || student.lastName.toLowerCase().startsWith("s")).filter(student -> student.firstName.startsWith("A")).forEach(student -> {System.out.println(student);});; 
    }
}

