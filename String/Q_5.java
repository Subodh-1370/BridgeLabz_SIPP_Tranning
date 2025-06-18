import java.util.Scanner;

public class Q_5 {

    public static String manualSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String builtInSubstring = "";
        if (start >= 0 && end <= input.length() && start < end) {
            builtInSubstring = input.substring(start, end);
        } else {
            System.out.println("Invalid start or end index.");
            return;
        }

        String manualSub = manualSubstring(input, start, end);
        boolean isEqual = compareUsingCharAt(manualSub, builtInSubstring);

        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Manual substring: " + manualSub);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
