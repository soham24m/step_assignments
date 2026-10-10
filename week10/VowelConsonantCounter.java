import java.util.Scanner;

/** Category C - Problem 1: Vowel and Consonant Counter. */
public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next().toLowerCase();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetter(c)) continue;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
