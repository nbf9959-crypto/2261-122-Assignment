//8-28-2026
import java.util.Scanner;
void main() {
    reverseChars();
}

void reverseChars() {
    Scanner input = new Scanner(System.in); 
    System.out.print("\n>>> Enter a string: ");

    String result = ""; String sample = input.nextLine(); 
    for(int x = sample.length() - 1; x >= 0; x--) {
        result += sample.charAt(x); 
    }

    System.out.println("> Reversed string result: " + result); input.close();
}