import java.util.Scanner;

public class Q_1 {
    public static  boolean isSpring(int month,int day){
        return (month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1 && day <= 30) ||
                (month == 5 && day >= 1 && day <= 31) ||
                (month == 6 && day >= 1 && day <= 20);

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the month:");
        int month=sc.nextInt();
        System.out.print("Enter the day: ");
        int day=sc.nextInt();

        if(isSpring(month,day)){
            System.out.println("It's spring season ");
        }
        else{
            System.out.println("not spring season");
        }


    }
}
