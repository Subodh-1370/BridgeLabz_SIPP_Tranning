import java.util.Scanner;

public class Q_6_2 {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        System.out.println("Factorial: " + factorial(num));
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
