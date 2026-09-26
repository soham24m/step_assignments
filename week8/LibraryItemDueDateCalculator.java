import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Category C - Problem 2: Library Item Due Date Calculator. */
public class LibraryItemDueDateCalculator {
    private static final LocalDate BORROW_DATE = LocalDate.of(2023, 10, 26);
    private static final Pattern INPUT_LINE = Pattern.compile("^\\s*(\\S+)\\s+\\\"(.*)\\\"\\s*$");

    interface LibraryItem {
        int borrowingDays();
        String type();
    }
    static class Book implements LibraryItem {
        public int borrowingDays() { return 14; }
        public String type() { return "BOOK"; }
    }
    static class DVD implements LibraryItem {
        public int borrowingDays() { return 7; }
        public String type() { return "DVD"; }
    }
    static class Magazine implements LibraryItem {
        public int borrowingDays() { return 3; }
        public String type() { return "MAGAZINE"; }
    }
    static class Loan {
        private final LibraryItem item;
        private final String title;
        Loan(LibraryItem item, String title) { this.item = item; this.title = title; }
        LocalDate dueDate() { return BORROW_DATE.plusDays(item.borrowingDays()); }
        String title() { return title; }
    }

    private static LibraryItem itemFor(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BOOK": return new Book();
            case "DVD": return new DVD();
            case "MAGAZINE": return new Magazine();
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Loan> loans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher matcher = INPUT_LINE.matcher(line);
            if (!matcher.matches()) throw new IllegalArgumentException("Expected TYPE \"title\": " + line);
            loans.add(new Loan(itemFor(matcher.group(1)), matcher.group(2)));
        }
        for (Loan loan : loans) System.out.println(loan.title() + ": " + loan.dueDate());
    }
}
