import java.util.Scanner;

public class HS_SortJobApplicantsSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];

        System.out.println("Enter expected salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        heapSort(salaries);

        System.out.println("Sorted salaries in ascending order:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != rootIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            heapify(arr, heapSize, largest);
        }
    }
}
