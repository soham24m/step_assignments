/**
 * Category C - Problem 3: The Nickname Tag
 * An immutable NameTag that builds a nickname from a full name once,
 * at construction time.
 */
public class NicknameTagManagement {

    static class NameTag {
        private final String firstName;
        private final String lastName;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            this.firstName = parts[0];
            this.lastName = parts[1];
        }

        public String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
        // No setters at all - every field is final and set once, in the constructor
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\"");
    }
}
