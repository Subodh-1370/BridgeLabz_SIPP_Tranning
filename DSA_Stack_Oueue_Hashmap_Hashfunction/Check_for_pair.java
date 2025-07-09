import java.util.HashSet;

public class Check_for_pair {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists");
        } else {
            System.out.println("No such pair exists");
        }
    }
}
