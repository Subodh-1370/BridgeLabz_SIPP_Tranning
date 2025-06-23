import java.util.Scanner;

public class Q_2_2{
    public static void main(String[] args) {
        int a = input("Enter first number: ");
        int b = input("Enter second number: ");
        int c = input("Enter third number: ");
        System.out.println("Maximum is: " + maxOfThree(a, b, c));
    }

    public static int input(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextInt();
    }

    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
