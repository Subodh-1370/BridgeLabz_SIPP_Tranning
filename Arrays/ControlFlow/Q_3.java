import java.util.*;
public class Q_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            System.out.println("Not a natural Number");
        }
        int i = 1;
        while(i<n){
            System.out.println(i);
            i++;
        }
        int Sum = n*(n+1)/2;
        System.out.println(Sum);
    }
}
