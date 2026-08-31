//8-31-2026
import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an int value for evaluation: ");

    evenlyDivisible(input.nextInt()); input.close();
}

void evenlyDivisible(int n) {
    if (n % 2 == 0) {
        System.out.println(String.format("The %d int is even...", n));
    } 

    else if (n % 3 == 0) {
        System.out.println(String.format("The %d int is divisible by 3...", n));
    }

    else if (n % 5 == 0) {
        System.out.println(String.format("The %d int is divisible by 5...", n));
    }

    else {
        System.out.println(String.format("The %d int is odd but not divisible either by 3 or 5...", n));
    }
}