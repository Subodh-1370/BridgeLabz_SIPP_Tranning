import java.util.*;

public class Q_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // [weight, height, BMI]
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            personData[i][0] = readPositiveInput(sc, "Weight (kg): ");
            personData[i][1] = readPositiveInput(sc, "Height (m): ");
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            double bmi = personData[i][2];
            if (bmi <= 18.4)
                weightStatus[i] = "Underweight";
            else if (bmi <= 24.9)
                weightStatus[i] = "Normal";
            else if (bmi <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        System.out.println("\nResults:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s\n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }

    public static double readPositiveInput(Scanner sc, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = sc.nextDouble();
            if (value > 0) break;
            System.out.println("Please enter a positive value.");
        }
        return value;
    }
}