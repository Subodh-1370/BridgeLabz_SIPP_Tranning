import java.util.Scanner;

public class Q_20 {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        System.out.println(km + " Km = " + convertKmToMiles(km) + " Miles");

        System.out.print("Enter miles: ");
        double miles = sc.nextDouble();
        System.out.println(miles + " Miles = " + convertMilesToKm(miles) + " Km");

        System.out.print("Enter meters: ");
        double meters = sc.nextDouble();
        System.out.println(meters + " Meters = " + convertMetersToFeet(meters) + " Feet");

        System.out.print("Enter feet: ");
        double feet = sc.nextDouble();
        System.out.println(feet + " Feet = " + convertFeetToMeters(feet) + " Meters");

        sc.close();
    }
}
