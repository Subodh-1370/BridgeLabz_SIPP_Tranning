import java.util.Scanner;

public class Q_7 {

    public static char[] customToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();
        char[] customArray = customToCharArray(input);
        char[] builtInArray = input.toCharArray();
        boolean areEqual = compareCharArrays(customArray, builtInArray);
        System.out.println("Custom Array: " + new String(customArray));
        System.out.println("Built-in Array: " + new String(builtInArray));
        System.out.println("Are both arrays equal? " + areEqual);
    }
}
