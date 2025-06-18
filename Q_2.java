import java.util.*;

public class Q_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input: Not a Natural Number");
            return;
        }

        int size = (number / 2) + 1;
        int[] oddArr = new int[size];
        int[] evenArr = new int[size];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArr[evenIndex++] = i;
            } else {
                oddArr[oddIndex++] = i;
            }
        }

        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArr[i] + " ");
        }

        System.out.println();

        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArr[i] + " ");
        }
    }
}
