/**
 * Day 2 Live-Coding Session - Problem 4
 * Student-support call center: masks a phone number, revealing only the
 * last 4 digits.
 */
public class MaskedPhoneNumberFormatter {

    /**
     * Masks a 10-digit phone number as "XXXXXX-####", showing only the
     * last 4 digits.
     */
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
            return "Invalid phone number";
        }

        String lastFour = phone.substring(phone.length() - 4);

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.insert(masked.length(), "-");
        masked.append(lastFour);

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
