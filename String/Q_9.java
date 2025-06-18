import java.util.Scanner;

public class Q_9 {

    public static void generateException(String input) {
        String result = input.substring(5, 2);
        System.out.println(result);
    }

    public static void handleException(String input) {
        try {
            String result = input.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        handleException(input);
    }
}
