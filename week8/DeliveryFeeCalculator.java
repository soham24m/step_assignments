import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 3: Delivery Fee Calculator. */
public class DeliveryFeeCalculator {
    interface Delivery {
        double fee(double weight, double distance);
        String type();
    }
    static class Standard implements Delivery {
        public double fee(double weight, double distance) { return 5 + .50 * weight + .10 * distance; }
        public String type() { return "STANDARD"; }
    }
    static class Express implements Delivery {
        public double fee(double weight, double distance) { return 15 + 1.00 * weight + .20 * distance; }
        public String type() { return "EXPRESS"; }
    }
    static class International implements Delivery {
        private final double customsFee;
        International(double customsFee) { this.customsFee = customsFee; }
        public double fee(double weight, double distance) { return 25 + 2.00 * weight + .50 * distance + customsFee; }
        public String type() { return "INTERNATIONAL"; }
    }
    static class Request {
        private final Delivery delivery;
        private final double weight, distance;
        Request(Delivery delivery, double weight, double distance) {
            this.delivery = delivery; this.weight = weight; this.distance = distance;
        }
        double fee() { return delivery.fee(weight, distance); }
        String type() { return delivery.type(); }
    }

    private static Delivery deliveryFor(Scanner in, String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "STANDARD": return new Standard();
            case "EXPRESS": return new Express();
            case "INTERNATIONAL": return new International(in.nextDouble());
            default: throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = in.next();
            double weight = in.nextDouble(), distance = in.nextDouble();
            Delivery delivery = deliveryFor(in, type);
            requests.add(new Request(delivery, weight, distance));
        }
        double total = 0;
        for (Request request : requests) {
            double fee = request.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", request.type(), fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
