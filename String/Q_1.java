import java.util.Scanner;

public class Q_1 {

    public static void generateException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (non-numeric) to generate NumberFormatException: ");
        String text = sc.nextLine();
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }

    public static void handleException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to safely parse into number: ");
        String text = sc.nextLine();

        try {
            int number = Integer.parseInt(text);
            System.out.println("Successfully converted to number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input is not a valid number.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NumberFormatException e) {
            System.out.println("Caught in main: Invalid number format.");
        }

        handleException();
    }
}
