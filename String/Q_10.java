import java.util.Scanner;

public class Q_10 {

    public static void generateException(String input) {
        char ch = input.charAt(input.length());
        System.out.println(ch);
    }

    public static void handleException(String input) {
        try {
            char ch = input.charAt(input.length());
            System.out.println(ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
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
