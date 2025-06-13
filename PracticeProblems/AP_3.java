import java.util.*;
class CtoF{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Celsius = sc.nextInt();
        float Fahrenheit = (Celsius * 9/5) + 32;
        System.out.println(Fahrenheit);
    }
}