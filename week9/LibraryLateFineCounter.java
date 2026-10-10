import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 3: Library Late Fine Counter. */
public class LibraryLateFineCounter {
    static abstract class LibraryItem {
        protected final String title;
        protected final int daysLate;
        LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        String getTitle() { return title; }
        abstract double fine();
    }
    static class Book extends LibraryItem {
        Book(String t, int d) { super(t, d); }
        double fine() { return 2.0 * daysLate; }
    }
    static class Dvd extends LibraryItem {
        Dvd(String t, int d) { super(t, d); }
        double fine() { return Math.min(5.0 * daysLate, 50.0); }
    }
    static class Magazine extends LibraryItem {
        Magazine(String t, int d) { super(t, d); }
        double fine() { return 1.0 * daysLate; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase();
            String title = in.next();
            int days = in.nextInt();
            switch (type) {
                case "BOOK": items.add(new Book(title, days)); break;
                case "DVD": items.add(new Dvd(title, days)); break;
                case "MAGAZINE": items.add(new Magazine(title, days)); break;
                default: throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            System.out.printf("%s: %.2f%n", item.getTitle(), item.fine());
            total += item.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
