import java.util.Scanner;

public class Q_5_2 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        System.out.println(isPalindrome(str) ? "Palindrome" : "Not Palindrome");
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
