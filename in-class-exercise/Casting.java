//8-31-2026
import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in); 

    System.out.println("\nDemonstration 1#: Converting long to int");

    System.out.print("Enter a 'long' value: "); long insertion_long = input.nextLong(); 
    System.out.print("Inserted long value: " + insertion_long); int long_int_converted = (int)insertion_long; 

    System.out.println("Demonstration 1#'s Converted to int - result: " + long_int_converted);

    System.out.println("\nDemonstration 2#: Converting char to int");

    System.out.print("Enter a 'boolean' value: "); Boolean insertion_boolean = input.nextBoolean(); 
    System.out.print("Inserted boolean value: " + insertion_boolean); int boolean_int_converted = insertion_boolean ? 1 : 0; 

    System.out.println("Demonstration 2#'s Converted to int - result: " + boolean_int_converted);

}