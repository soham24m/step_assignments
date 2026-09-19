/**
 * Day 1 Live-Coding Session - Problem 2
 * The QA Text Verification Toolkit: verifies palindrome logic using
 * three independent approaches.
 */
public class PalindromeChecker {

    /** Iterative approach: compare characters from both ends moving inward. */
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /** Recursive approach: compare first/last characters, shrink the substring. */
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        int lastIndex = text.length() - 1;
        if (text.charAt(0) != text.charAt(lastIndex)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, lastIndex));
    }

    /** Array-reversal approach: reverse the char array and compare to original. */
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    private static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello"};

        for (String input : inputs) {
            boolean iterative = isPalindromeIterative(input);
            boolean recursive = isPalindromeRecursive(input);
            boolean arrayReversal = isPalindromeArrayReversal(input);

            System.out.println("\"" + input + "\" -> Iterative: " + label(iterative) +
                    " | Recursive: " + label(recursive) +
                    " | Array Reversal: " + label(arrayReversal));
        }
    }
}
