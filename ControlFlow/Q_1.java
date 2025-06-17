import java.sql.SQLOutput;
import java.util.*;
public class Q_1 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         if(n%5==0){
             System.out.println("This no. is divisible by 5");
         }else{
             System.out.println("This no.is not divisible by 5");
         }
    }
}
