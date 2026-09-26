import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 1: Payment System Fee Calculation. */
public class PaymentSystemFeeCalculation {
    interface PaymentMethod {
        double finalAmount(double amount);
        String name();
    }

    static class Card implements PaymentMethod {
        public double finalAmount(double amount) { return amount * 1.02; }
        public String name() { return "CARD"; }
    }
    static class Wallet implements PaymentMethod {
        public double finalAmount(double amount) { return amount * 1.01; }
        public String name() { return "WALLET"; }
    }
    static class BankTransfer implements PaymentMethod {
        public double finalAmount(double amount) { return amount; }
        public String name() { return "BANKTRANSFER"; }
    }
    static class Transaction {
        private final PaymentMethod method;
        private final double amount;
        Transaction(PaymentMethod method, double amount) { this.method = method; this.amount = amount; }
        double adjustedAmount() { return method.finalAmount(amount); }
        String type() { return method.name(); }
    }

    private static PaymentMethod methodFor(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "CARD": return new Card();
            case "WALLET": return new Wallet();
            case "BANKTRANSFER": return new BankTransfer();
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) transactions.add(new Transaction(methodFor(in.next()), in.nextDouble()));
        double total = 0;
        for (Transaction tx : transactions) {
            double adjusted = tx.adjustedAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", tx.type(), adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
