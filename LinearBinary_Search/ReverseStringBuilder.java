import java.util.Scanner;

public class ReverseStringBuilder {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String reversed = reverse(str);
        System.out.println(reversed);
        sc.close();
    }
}
