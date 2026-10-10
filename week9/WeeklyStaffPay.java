import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 2: Weekly Staff Pay (abstract base class cannot be instantiated). */
public class WeeklyStaffPay {
    static abstract class Staff {
        protected final String name;
        Staff(String name) { this.name = name; }
        String getName() { return name; }
        abstract double pay();
    }
    static class FullTime extends Staff {
        private final double weeklySalary;
        FullTime(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
        double pay() { return weeklySalary; }
    }
    static class Hourly extends Staff {
        private final double hours, rate;
        Hourly(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        double pay() {
            double regular = Math.min(hours, 40);
            double overtime = Math.max(0, hours - 40);
            return regular * rate + overtime * 1.5 * rate;
        }
    }
    static class Intern extends Staff {
        private final double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase();
            String name = in.next();
            switch (type) {
                case "FULLTIME": staff.add(new FullTime(name, in.nextDouble())); break;
                case "HOURLY": { double h = in.nextDouble(); double r = in.nextDouble(); staff.add(new Hourly(name, h, r)); break; }
                case "INTERN": staff.add(new Intern(name, in.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }
        double total = 0;
        for (Staff s : staff) {
            System.out.printf("%s: %.2f%n", s.getName(), s.pay());
            total += s.pay();
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
