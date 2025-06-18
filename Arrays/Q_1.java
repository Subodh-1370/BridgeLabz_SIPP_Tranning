import java.util.*;
public class Q_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] age = new int[n];
        for(int i=0;i<n;i++){
            age[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            if(age[i]<0){
                System.out.println("Invalid Age");
            }else if(age[i]>=18){
                System.out.println("Students can vote");
            }else{
                System.out.println("Students can't vote");
            }
        }
    }
}
