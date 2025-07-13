public class StringConcatPerformance {

    public static void testConcatenation(int count) {
        long start, end;

        // Test with String (Immutable, O(N^2))
        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "a";
        }
        end = System.nanoTime();
        double stringTime = (end - start) / 1e6;

        // Test with StringBuilder (Mutable, Fast, Not Thread-Safe)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        double sbTime = (end - start) / 1e6;

        // Test with StringBuffer (Mutable, Thread-Safe)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        double sbfTime = (end - start) / 1e6;

        System.out.printf("Operations Count: %,d\n", count);
        System.out.printf("String Time: %.2f ms\n", stringTime);
        System.out.printf("StringBuilder Time: %.2f ms\n", sbTime);
        System.out.printf("StringBuffer Time: %.2f ms\n", sbfTime);
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        testConcatenation(1_000);
        testConcatenation(10_000);
        testConcatenation(1_000_000);  // Warning: String will be very slow here
    }
}
