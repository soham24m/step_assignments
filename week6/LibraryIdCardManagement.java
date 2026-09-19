/**
 * Category C - M4: Library ID Card Management
 * Demonstrates that assigning an object reference to a second variable
 * does not create a new object - both variables point to the same one.
 */
public class LibraryIdCardManagement {

    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // points to the SAME object, not a new one

        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // a genuinely separate object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
