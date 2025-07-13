public class FirstNegativeSearch {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {4, 7, 2, -5, 9, -3};
        int index = findFirstNegative(input);
        System.out.println("First negative number index: " + index);
    }
}
