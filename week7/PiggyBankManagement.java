/**
 * Category C - Problem 1: The Piggy Bank
 * Savings can only be changed through deposit/withdraw - never set directly.
 */
public class PiggyBankManagement {

    static class PiggyBank {
        private double savings;
        private final String id;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        public void deposit(double amount) {
            savings += amount;
            System.out.println("pb.deposit(" + (int) amount + ") -> savings = " + savings);
        }

        public void withdraw(double amount) {
            if (amount > savings) {
                System.out.println("pb.withdraw(" + (int) amount + ") -> rejected, savings stays " + savings);
                return;
            }
            savings -= amount;
            System.out.println("pb.withdraw(" + (int) amount + ") -> savings = " + savings);
        }

        public double getSavings() {
            return savings;
        }
        // Note: no setter for savings - it can only change via deposit/withdraw
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
