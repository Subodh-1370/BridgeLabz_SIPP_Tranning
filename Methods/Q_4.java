import java.util.Scanner;

public class Q_4 {
    public static int handshack(int n){
        int shack= (n * (n - 1)) / 2;
        return shack;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the num of student: ");
        int numofstudent=sc.nextInt();

        System.out.println("number of HandShacks :"+handshack(numofstudent));
    }
}
