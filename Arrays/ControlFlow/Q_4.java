import java.util.*;

public class Q_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        if (number1 == number2 && number2 == number3) {
            System.out.println("AllAreEqual");
        } else if (number1 >= number2 && number1 >= number3) {
            System.out.println("Largest : " + number1);
        } else if (number2 >= number1 && number2 >= number3) {
            System.out.println("Largest : " + number2);
        } else {
            System.out.println("Largest : " + number3);
        }
    }
}
