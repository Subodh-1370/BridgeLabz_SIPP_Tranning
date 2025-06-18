import java.util.*;
class CKTM{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float Kilometers = sc.nextInt();
        double Miles = Kilometers * 0.621371;
        System.out.println(Miles);
    }
}