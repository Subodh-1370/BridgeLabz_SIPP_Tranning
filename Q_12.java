import java.util.*;

public class Q_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            physics[i] = readValidMark(sc, "Physics");
            chemistry[i] = readValidMark(sc, "Chemistry");
            maths[i] = readValidMark(sc, "Maths");

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;
            grade[i] = calculateGrade(percentage[i]);
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) +
                    " - Physics: " + physics[i] +
                    ", Chemistry: " + chemistry[i] +
                    ", Maths: " + maths[i] +
                    ", Percentage: " + String.format("%.2f", percentage[i]) +
                    "%, Grade: " + grade[i]);
        }

        sc.close();
    }

    public static int readValidMark(Scanner sc, String subject) {
        int mark;
        while (true) {
            System.out.print(subject + " marks: ");
            mark = sc.nextInt();
            if (mark >= 0 && mark <= 100) break;
            System.out.println("Invalid mark. Please enter a value between 0 and 100.");
        }
        return mark;
    }

    public static char calculateGrade(double percentage) {
        if (percentage >= 80) return 'A';
        else if (percentage >= 70) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 50) return 'D';
        else if (percentage >= 40) return 'E';
        else return 'R';
    }
}