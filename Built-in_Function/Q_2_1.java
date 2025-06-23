import java.time.LocalDate;
import java.util.Scanner;

public class Q_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input);

        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);

        System.out.println("Final date after arithmetic: " + result);
    }
}
