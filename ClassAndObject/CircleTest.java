import java.util.Scanner;

class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.println("Radius         : " + radius);
        System.out.println("Area           : " + getArea());
        System.out.println("Circumference  : " + getCircumference());
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        Circle c = new Circle(r);
        c.display();
    }
}
