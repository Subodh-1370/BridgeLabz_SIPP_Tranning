import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Height = sc.nextInt();
        double inches = Height/2.54;
        double feet = inches/12;
        System.out.println("Height - "+Height);
        System.out.println("inches - "+ inches);
        System.out.println("feet - "+ feet);
        
    }
}

