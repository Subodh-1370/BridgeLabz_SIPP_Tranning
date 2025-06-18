import java.util.*;
class Student{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int fee = sc.nextInt();
        int DP = sc.nextInt();
        int discountAmount = (fee*DP)/100;
        int discountFee = fee - discountAmount;
        System.out.println("DiscountAmount"+discountAmount);
        System.out.println("DiscountFee"+discountFee);
    }
}