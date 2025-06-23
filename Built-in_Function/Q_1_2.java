import java.util.Scanner;

public class Q_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        while (!correct && low <= high) {
            int guess = (low + high) / 2;
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = sc.nextLine().toLowerCase();

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("correct")) {
                System.out.println("Yay! The computer guessed your number.");
                correct = true;
            }
        }
    }
}
