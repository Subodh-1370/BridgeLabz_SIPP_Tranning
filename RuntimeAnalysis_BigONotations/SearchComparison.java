import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void testSearch(int dataSize, int target) {
        int[] data = new int[dataSize];
        Random rand = new Random();

        for (int i = 0; i < dataSize; i++) {
            data[i] = rand.nextInt(dataSize * 10);
        }

        // Linear Search
        long start = System.nanoTime();
        linearSearch(data, target);
        long end = System.nanoTime();
        double linearTime = (end - start) / 1e6;

        // Binary Search (sort first)
        Arrays.sort(data);
        start = System.nanoTime();
        binarySearch(data, target);
        end = System.nanoTime();
        double binaryTime = (end - start) / 1e6;

        System.out.printf("Dataset Size: %,d\n", dataSize);
        System.out.printf("Linear Search Time: %.4f ms\n", linearTime);
        System.out.printf("Binary Search Time: %.4f ms (after sorting)\n", binaryTime);
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        int target = 9999; // target value to search

        testSearch(1_000, target);
        testSearch(10_000, target);
        testSearch(1_000_000, target);
    }
}
