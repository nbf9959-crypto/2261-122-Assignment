import java.util.Scanner;
import java.util.ArrayList;

public class Primes {
    public void main() {
        Scanner input = new Scanner(System.in); 

        System.out.print("\n>>> Enter an integer to determine if it is prime or not: "); 

        int insertedInt = input.nextInt(); 
        String result = isPrime(insertedInt) ? "prime" : "not prime"; 

        System.out.println(String.format("> The integer '%d' is %s.", insertedInt, result)); 
        input.close();
    }

    private Boolean isPrime(int n) {
        Boolean[] markedCollection = new Boolean[n + 1]; /*Initatize an array of boolean type */
        ArrayList<Integer> primeCollection = new ArrayList<>(); /*Initatize an array of int type that belongs to the prime number property. */

        for(int i = 0; i < markedCollection.length; i++) { /* Set the indexes of the collection to true, assuming that all the indexes are of prime number property. */
            markedCollection[i] = true; 
        }

        for(int i = 2; i < Math.sqrt(n + 1); i++) { /* Do a loop on the index of the collection and reassign the respective index to false if the index happens to contain other indexes within its multiplication. */
            if(markedCollection[i]) {
                for (int j = (int) Math.pow(i, 2); j < n + 1;) {
                    markedCollection[j] = false;
                    j = j + i; 
                }
            }
        }

        for(int x = 2; x < markedCollection.length; x++) { /* Append the numeral value of the index, if it is true, to the prime number collection */
            if(markedCollection[x]) {
                primeCollection.add(x);
            }
        }

        for (Integer x : primeCollection) { /* Check if the provided n value is contained within the prime collection; return true if found and vice versa if not found. */
            if (x.equals(n)) {
                return true; 
            }
        }

        return false; 
    }
}


