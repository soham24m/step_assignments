import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 4: Electricity Connection Billing. */
public class ElectricityConnectionBilling {
    static abstract class Connection {
        protected final double units;
        Connection(double units) { this.units = units; }
        abstract double bill();
        abstract String type();
    }
    static class Home extends Connection {
        Home(double u) { super(u); }
        double bill() { return units <= 100 ? units * 5 : 100 * 5 + (units - 100) * 7; }
        String type() { return "HOME"; }
    }
    static class Shop extends Connection {
        Shop(double u) { super(u); }
        double bill() { return units * 8 + 100; }
        String type() { return "SHOP"; }
    }
    static class Factory extends Connection {
        Factory(double u) { super(u); }
        double bill() { return Math.max(units * 6, 1000); }
        String type() { return "FACTORY"; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Connection> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase();
            double units = in.nextDouble();
            switch (type) {
                case "HOME": list.add(new Home(units)); break;
                case "SHOP": list.add(new Shop(units)); break;
                case "FACTORY": list.add(new Factory(units)); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }
        double total = 0;
        for (Connection c : list) {
            System.out.printf("%s: %.2f%n", c.type(), c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
