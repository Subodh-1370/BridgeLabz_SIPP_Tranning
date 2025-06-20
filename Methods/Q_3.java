import java.util.Scanner;

public class Q_3 {

    public static float SimpleInterest(int a,int b,int c){
        float SimpleInterest = (a * b * c) / 100;

        return SimpleInterest;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Principal : ");
        int a=sc.nextInt();
        System.out.print("Enter the Rate : ");
        int b=sc.nextInt();
        System.out.print("Enter the Time : ");
        int c=sc.nextInt();
         float simp=SimpleInterest(a,b,c);

        System.out.print(" the volume of Simple Interest  is: "+simp);
    }
}
