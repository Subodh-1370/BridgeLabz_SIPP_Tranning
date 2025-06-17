import java.util.*;
public class Q_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if(age<=18){
            System.out.println("The person can't vote");
        }else{
            System.out.println("The person can vote");
        }
    }
}
