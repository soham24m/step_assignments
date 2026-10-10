import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 1: Garden Plot Area Report (abstract class + polymorphism). */
public class GardenPlotAreaReport {
    static abstract class Plot {
        private final String owner;
        Plot(String owner) { this.owner = owner; }
        String getOwner() { return owner; }
        abstract double area();
        abstract String shape();
    }
    static class CirclePlot extends Plot {
        private final double radius;
        CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
        String shape() { return "CIRCLE"; }
    }
    static class RectanglePlot extends Plot {
        private final double length, width;
        RectanglePlot(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
        double area() { return length * width; }
        String shape() { return "RECTANGLE"; }
    }
    static class TrianglePlot extends Plot {
        private final double base, height;
        TrianglePlot(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
        double area() { return 0.5 * base * height; }
        String shape() { return "TRIANGLE"; }
    }

    /** Only place that knows concrete shapes; the report code below never changes when a shape is added. */
    static Plot create(Scanner in) {
        String shape = in.next().toUpperCase();
        String owner = in.next();
        switch (shape) {
            case "CIRCLE": return new CirclePlot(owner, in.nextDouble());
            case "RECTANGLE": return new RectanglePlot(owner, in.nextDouble(), in.nextDouble());
            case "TRIANGLE": return new TrianglePlot(owner, in.nextDouble(), in.nextDouble());
            default: throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    static void report(List<Plot> plots) {
        double total = 0;
        for (Plot p : plots) {
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.shape(), p.area());
            total += p.area();
        }
        System.out.printf("Total Area: %.2f%n", total);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) plots.add(create(in));
        report(plots);
    }
}
