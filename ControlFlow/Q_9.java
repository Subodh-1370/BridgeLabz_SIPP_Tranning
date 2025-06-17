import java.util.*;
public class Q_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            System.out.println("Not a natural Number");
        }
        for(int i=1;i<n;i++){
            System.out.println(i);
        }
        int Sum = n*(n+1)/2;
        System.out.println(Sum);
    }
}
