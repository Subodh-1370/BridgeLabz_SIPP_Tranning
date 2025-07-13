public class ConcatenateStringsBuffer {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"Java", " ", "is", " ", "awesome!"};
        String result = concatenate(input);
        System.out.println(result);
    }
}
