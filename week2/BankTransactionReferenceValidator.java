/**
 * Day 2 Live-Coding Session - Problem 5
 * Fintech onboarding module: normalizes and validates transaction
 * reference codes (3 letters + 6-digit date + 5-digit sequence).
 */
public class BankTransactionReferenceValidator {

    /**
     * Trims whitespace and uppercases only the first 3 characters,
     * leaving the rest of the string untouched.
     */
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    /**
     * Validates a normalized reference and, if valid, builds a formatted
     * display line. If invalid, returns the specific reason.
     */
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] DATE: ")
               .append(dd).append("/").append(mm).append("/").append(yy)
               .append(" | SEQ: ").append(seq);

        return display.toString();
    }

    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(normalized1));

        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
