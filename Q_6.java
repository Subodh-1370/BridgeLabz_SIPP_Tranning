import java.util.Scanner;

public class Q_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println(num + " is Zero");
            }
        }

        // 4. Compare first and last element
        int first = numbers[0];
        int last = numbers[4];
        System.out.println("\n--- Comparison of First and Last Element ---");
        if (first == last) {
            System.out.println("First and Last elements are Equal.");
        } else if (first > last) {
            System.out.println("First element is Greater than Last element.");
        } else {
            System.out.println("First element is Less than Last element.");
        }
    }
}
