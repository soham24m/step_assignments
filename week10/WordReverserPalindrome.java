import java.util.Scanner;

/** Category C - Problem 2: Word Reverser and Palindrome Checker. */
public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String word = in.next();
            String reversed = new StringBuilder(word).reverse().toString();
            // Case-sensitive comparison (not specified otherwise)
            boolean palindrome = word.equals(reversed);
            System.out.println(reversed + (palindrome ? " - palindrome" : " - not a palindrome"));
        }
    }
}
