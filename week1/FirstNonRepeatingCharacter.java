/**
 * Day 1 Live-Coding Session - Problem 4
 * The Unique Letter Hunt Mini-Game: finds the first non-repeating character.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first character in the text that occurs exactly once.
     *
     * @param text the input string
     * @return the first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};

        for (String input : inputs) {
            char result = findFirstNonRepeatingChar(input);
            if (result != '\0') {
                System.out.println("\"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + input + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}
