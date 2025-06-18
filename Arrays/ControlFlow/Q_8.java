import java.util.*;
public class Q_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double number;

        System.out.println("Enter numbers to add (0 to stop):");
        number = sc.nextDouble();

        while (number != 0) {
            total += number;
            System.out.println("Enter next number (0 to stop):");
            number = sc.nextDouble();
            if(number<1){
                break;
            }
        }

        System.out.println("Total sum: " + total);
    }
}
