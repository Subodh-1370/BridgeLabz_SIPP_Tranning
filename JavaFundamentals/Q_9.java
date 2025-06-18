import java.util.*;

class Marks {
    public static void main(String[] args) {
        double fee = 125000.0;
        double discountPercent = 10.0;
        double discountamount = (fee*discountPercent/100);
        double discountedfee = fee - discountamount; 
        System.out.println("discountamount - " + discountamount);
        System.out.println("discountedfee - " + discountedfee);
    }
}

