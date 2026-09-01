//8-31-2026 - Author: Nathaniel Facey
import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in); 

    System.out.print("\n>>> Enter an integer to determine if it is prime or not: "); int inserted_int = input.nextInt(); String result = isPrime(inserted_int) ? "prime" : "not prime"; 
    System.out.println(String.format("> The integer '%d' is %s.", inserted_int, result)); input.close();
}

boolean isPrime(int n) { 
    for(int x = 2; x < n; x++) {
        if (n % x == 0) {
            return false;
        } 
    }

    return true; 
}

