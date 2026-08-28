
void main () {
    System.out.println(String.format("\nAddition dispatching: [4 + 12] --> %d", add(4, 12))); 
    System.out.println(String.format("Substraction dispatching: [2 - 18] --> %d", substract(2, 18)));
    System.out.println(String.format("Multiplication dispatching: [3 * 3] --> %d", multiply(3, 3)));
    System.out.println(String.format("Division dispatching: [80 / 8] --> %d", divide(80, 8)));

    return ;
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