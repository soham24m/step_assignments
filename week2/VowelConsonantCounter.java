/**
 * Day 2 Live-Coding Session - Problem 1
 * Library orientation kiosk: counts vowels and consonants in a book title.
 */
public class VowelConsonantCounter {

    /**
     * Counts and prints the number of vowels and consonants in the text.
     * Spaces are ignored. Comparison is case-insensitive.
     */
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == ' ') {
                continue;
            }
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}
