import java.util.*;

class Marks {
    public static void main(String[] args) {
        int Math = 94;
        int Physics = 95;
        int Chemistry = 96;
        int sum = Math + Physics + Chemistry;
        float avg = sum / 3.0f; 
        float percent = (sum / 300.0f) * 100; 
        System.out.println("Average Marks: " + avg);
        System.out.println("Percentage: " + percent + "%");
    }
}

