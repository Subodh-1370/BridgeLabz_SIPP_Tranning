import java.util.Scanner;

public class Q_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        int factorial = 1;

        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
           for(int i =1;i<=number;i++) {
               factorial *= i;
           }
            System.out.println("Factorial: " + factorial);
        }
    }
}
