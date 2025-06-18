import java.util.Scanner;

public class Q_3 {

    public static String toLowerManual(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();

        String lowerBuiltIn = input.toLowerCase();
        String lowerManual = toLowerManual(input);

        boolean isSame = compareStrings(lowerBuiltIn, lowerManual);

        System.out.println("Built-in Lowercase: " + lowerBuiltIn);
        System.out.println("Manual Lowercase: " + lowerManual);
        System.out.println("Are both same? " + isSame);
    }
}
