import java.util.Scanner;

public class Q_4_2 {
    public static void main(String[] args) {
        int terms = new Scanner(System.in).nextInt();
        generateFibonacci(terms);
    }

    public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}
