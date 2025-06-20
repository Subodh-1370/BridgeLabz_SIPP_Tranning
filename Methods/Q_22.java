import java.util.Scanner;

public class Q_22 {
    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter yards: ");
        double yards = sc.nextDouble();
        System.out.println(yards + " Yards = " + convertYardsToFeet(yards) + " Feet");

        System.out.print("Enter feet: ");
        double feet = sc.nextDouble();
        System.out.println(feet + " Feet = " + convertFeetToYards(feet) + " Yards");

        System.out.print("Enter meters: ");
        double meters = sc.nextDouble();
        System.out.println(meters + " Meters = " + convertMetersToInches(meters) + " Inches");

        System.out.print("Enter inches: ");
        double inches = sc.nextDouble();
        System.out.println(inches + " Inches = " + convertInchesToMeters(inches) + " Meters");

        sc.close();
    }
}
