import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 5: Public Transport Fare Calculator. */
public class PublicTransportFareCalculator {
    interface Transport {
        double fare(double distance);
        String type();
    }
    static class Bus implements Transport {
        public double fare(double distance) { return Math.min(10, 2 + .10 * distance); }
        public String type() { return "BUS"; }
    }
    static class Train implements Transport {
        public double fare(double distance) { return 3 + .15 * distance; }
        public String type() { return "TRAIN"; }
    }
    static class Metro implements Transport {
        private final double peakHourFactor;
        Metro(double peakHourFactor) { this.peakHourFactor = peakHourFactor; }
        public double fare(double distance) { return (1.50 + .20 * distance) * peakHourFactor; }
        public String type() { return "METRO"; }
    }
    static class Journey {
        private final Transport transport;
        private final double distance;
        Journey(Transport transport, double distance) { this.transport = transport; this.distance = distance; }
        double fare() { return transport.fare(distance); }
        String type() { return transport.type(); }
    }

    private static Transport transportFor(Scanner in, String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BUS": return new Bus();
            case "TRAIN": return new Train();
            case "METRO": return new Metro(in.nextDouble());
            default: throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = in.next();
            double distance = in.nextDouble();
            journeys.add(new Journey(transportFor(in, type), distance));
        }
        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.fare();
            System.out.printf(Locale.US, "%s: %.2f%n", journey.type(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
