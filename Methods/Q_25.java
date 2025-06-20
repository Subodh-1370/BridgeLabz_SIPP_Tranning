import java.util.Random;

public class Q_25 {
    public static int sum(int[] heights) {
        int total = 0;
        for (int h : heights) total += h;
        return total;
    }

    public static double mean(int[] heights) {
        return sum(heights) / (double) heights.length;
    }

    public static int findMin(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) min = h;
        }
        return min;
    }

    public static int findMax(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) max = h;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        System.out.println("Player Heights:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
            System.out.println("Player " + (i + 1) + ": " + heights[i] + " cm");
        }

        System.out.println("\nShortest Player: " + findMin(heights) + " cm");
        System.out.println("Tallest Player: " + findMax(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm\n", mean(heights));
    }
}
