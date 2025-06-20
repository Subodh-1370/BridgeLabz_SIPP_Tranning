import java.util.HashSet;

public class Q_24 {
    public static String generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000; // ensures 6-digit
        return String.valueOf(otp);
    }

    public static boolean areUnique(String[] otps) {
        HashSet<String> set = new HashSet<>();
        for (String otp : otps) {
            set.add(otp);
        }
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        String[] otpList = new String[10];
        for (int i = 0; i < otpList.length; i++) {
            otpList[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpList[i]);
        }

        if (areUnique(otpList)) {
            System.out.println("All OTPs are unique. ✅");
        } else {
            System.out.println("Some OTPs are repeated. ❌");
        }
    }
}
