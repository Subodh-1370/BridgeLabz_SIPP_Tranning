public class StudentQuizGreader {

    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        System.out.println("🔍 Feedback per question:\n");

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
                System.out.printf("Question %d: ✅ Correct%n", i + 1);
            } else {
                System.out.printf("Question %d: ❌ Incorrect (Your Answer: %s, Correct: %s)%n",
                        i + 1, student[i], correct[i]);
            }
        }

        return score;
    }

    public static void main(String[] args) {
        // Sample correct answers
        String[] correctAnswers = {
                "A", "C", "B", "D", "A",
                "B", "C", "A", "D", "B"
        };

        // Simulated student answers
        String[] studentAnswers = {
                "a", "c", "D", "d", "A",
                "b", "c", "a", "C", "b"
        };

        System.out.println("📘 EDUQUIZ – STUDENT QUIZ GRADER\n");
        int score = calculateScore(correctAnswers, studentAnswers);

        System.out.println("\n=========================");
        System.out.printf("✅ Total Score: %d out of %d%n", score, correctAnswers.length);
        System.out.println("=========================");
    }
}
