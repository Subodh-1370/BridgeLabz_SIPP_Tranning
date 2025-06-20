import java.util.Scanner;

public class Q_5 {

    public static int perameter(int a,int b,int c){

        int result=a+b+c;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the side 1: ");
        int a = sc.nextInt();
        System.out.println("enter the side 1: ");
        int b = sc.nextInt();
        System.out.println("enter the side 1: ");
        int c = sc.nextInt();
         int km=5;
         int kmTOm=5*1000;
         int rounds=kmTOm/perameter(a,b,c);
        System.out.println("number of rounds athlete run: "+rounds);


    }
}
