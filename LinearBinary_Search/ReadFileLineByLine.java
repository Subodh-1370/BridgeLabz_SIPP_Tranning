import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Change this to your actual file path

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
