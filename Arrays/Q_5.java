import java.util.*;

public class Q_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 numbers (enter 0 or a negative number to stop):");

        while (true) {
            double value = sc.nextDouble();

            if (value <= 0) {
                break;
            }

            if (index == 10) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        System.out.println("You entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Total sum: " + total);
    }
}
