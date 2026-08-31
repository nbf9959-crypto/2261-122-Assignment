//8-28-2026
void main () {
    System.out.println(String.format("\nAddition dispatching: [4 + 12] --> %d", add(4, 12))); 
    System.out.println(String.format("Substraction dispatching: [2 - 18] --> %d", substract(2, 18)));
    System.out.println(String.format("Multiplication dispatching: [3 * 3] --> %d", multiply(3, 3)));
    System.out.println(String.format("Division dispatching: [80 / 8] --> %d", divide(80, 8)));

    System.out.println(String.format("\nTo the power dispatching: [10^3] --> %f", raise(10, 3)));
}

int add(int num1, int num2) {
    return num1 + num2; 
}

int substract(int num1, int num2) {
      return num1 - num2; 
}

int multiply(int num1, int num2) {
    return num1 * num2; 
}

int divide(int num1, int num2) {
    return num1/num2; 
}

float raise(float base, int exponent) { 
    float accumulation = 1; 
    for(int x = 0; x < exponent; x++) {
        accumulation = accumulation * base; 
    }

    return accumulation; 
}