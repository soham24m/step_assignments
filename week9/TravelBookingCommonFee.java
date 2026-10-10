import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 5: Travel Booking with a Common Fee (template method). */
public class TravelBookingCommonFee {
    static abstract class Booking {
        // The booking fee lives in exactly one place.
        static final double BOOKING_FEE = 50;
        protected final double distanceKm;
        Booking(double distanceKm) { this.distanceKm = distanceKm; }
        abstract double baseFare();
        abstract String mode();
        final double total() { return baseFare() + BOOKING_FEE; }
    }
    static class Bus extends Booking {
        Bus(double d) { super(d); }
        double baseFare() { return 2 * distanceKm; }
        String mode() { return "BUS"; }
    }
    static class Train extends Booking {
        Train(double d) { super(d); }
        double baseFare() { return 1.5 * distanceKm; }
        String mode() { return "TRAIN"; }
    }
    static class Flight extends Booking {
        Flight(double d) { super(d); }
        double baseFare() { return 2500 + 4 * distanceKm; }
        String mode() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = in.next().toUpperCase();
            double d = in.nextDouble();
            Booking b;
            switch (mode) {
                case "BUS": b = new Bus(d); break;
                case "TRAIN": b = new Train(d); break;
                case "FLIGHT": b = new Flight(d); break;
                default: throw new IllegalArgumentException("Unknown mode: " + mode);
            }
            System.out.printf("%s: %.2f%n", b.mode(), b.total());
        }
    }
}
