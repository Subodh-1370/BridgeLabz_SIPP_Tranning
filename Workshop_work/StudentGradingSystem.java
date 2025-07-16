import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradingSystem {

    private final String[] names;
    private final String[] ids;
    private final int[][] grades;

    public StudentGradingSystem(String[] names, String[] ids, int subjects) {
        if (names.length != ids.length)
            throw new IllegalArgumentException("Names and IDs length mismatch");

        this.names = names;
        this.ids = ids;
        this.grades = new int[names.length][subjects];

        for (int[] row : grades) Arrays.fill(row, -1);
    }


    public void enterGrade(int studentIdx, int subjectIdx, int grade)
            throws IllegalArgumentException {
        checkStudent(studentIdx);
        checkSubject(subjectIdx);

        if (grade < 0 || grade > 100)
            throw new IllegalArgumentException("Grade must be 0–100");
        grades[studentIdx][subjectIdx] = grade;
    }


    public int totalForStudent(int studentIdx) {
        checkStudent(studentIdx);
        return Arrays.stream(grades[studentIdx])
                .filter(g -> g != -1)
                .sum();
    }

    public double averageForStudent(int studentIdx) {
        checkStudent(studentIdx);
        return Arrays.stream(grades[studentIdx])
                .filter(g -> g != -1)
                .average()
                .orElse(Double.NaN);
    }

    public int highestInSubject(int subjectIdx) {
        checkSubject(subjectIdx);
        return Arrays.stream(grades)
                .mapToInt(row -> row[subjectIdx])
                .filter(g -> g != -1)
                .max()
                .orElse(-1);
    }

    public double overallClassAverage() {
        return Arrays.stream(grades)
                .flatMapToInt(Arrays::stream)
                .filter(g -> g != -1)
                .average()
                .orElse(Double.NaN);
    }


    private void checkStudent(int idx) {
        if (idx < 0 || idx >= names.length)
            throw new IndexOutOfBoundsException("Invalid student index");
    }

    private void checkSubject(int idx) {
        if (idx < 0 || idx >= grades[0].length)
            throw new IndexOutOfBoundsException("Invalid subject index");
    }


    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Cara"};
        String[] ids   = {"S101", "S102", "S103"};
        int subjects   = 3;

        StudentGradingSystem sgs = new StudentGradingSystem(names, ids, subjects);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter grades (‑1 to skip subject):");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("Student: %s (%s)%n", names[i], ids[i]);
            for (int j = 0; j < subjects; j++) {
                while (true) {
                    System.out.printf("  Subject %d grade: ", j + 1);
                    try {
                        int g = sc.nextInt();
                        if (g == -1) break;
                        sgs.enterGrade(i, j, g);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("  → Enter integers only!");
                        sc.next();
                    } catch (IllegalArgumentException e) {
                        System.out.println("  → " + e.getMessage());
                    }
                }
            }
        }

        System.out.println("\n=== Student Totals / Averages ===");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s: total=%d, avg=%.2f%n",
                    names[i], sgs.totalForStudent(i), sgs.averageForStudent(i));
        }

        System.out.println("\n=== Highest Grade per Subject ===");
        for (int j = 0; j < subjects; j++) {
            System.out.printf("Subject %d highest = %d%n",
                    j + 1, sgs.highestInSubject(j));
        }

        System.out.printf("%nOverall class average = %.2f%n",
                sgs.overallClassAverage());
    }
}
