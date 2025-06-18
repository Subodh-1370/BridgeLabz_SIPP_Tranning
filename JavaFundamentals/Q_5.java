import java.util.*;

class Marks {
    public static void main(String[] args) {
        double Pens = 14.0;
        double Students = 3.0;
        double equallyPenDistributed = Pens%Students;
        double UndistributedPen = Pens - equallyPenDistributed; 
        System.out.println("equallyPenDistributed - "+equallyPenDistributed);
        System.out.println("UndistributedPen - "+UndistributedPen);
    }
}

