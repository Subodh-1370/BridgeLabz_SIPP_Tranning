import java.util.Scanner;

public class Q_2 {
    public static int sumloop(int number){
        int sumloop=0;
        int i=1;
        while(i<=number){
            sumloop+=i;
            i++;
        }
        return sumloop;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the netural num: ");
        int number=sc.nextInt();

        if(number<=1){
            System.out.println("plese enter positive num");
            return;
        }
        int sum=number*(number+1)/2;
        System.out.println("sum"+sum);

        int sumloop=sumloop(number);
        System.out.println("sumloop"+sumloop);
        if(sumloop==sum){
            System.out.println("both result correct and matched");
        }
        else{
            System.out.println("both result are not correct");
        }

    }

}
