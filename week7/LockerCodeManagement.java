/**
 * Category C - Problem 4: The Locker Code
 * The combination can be changed, but never read back from outside
 * the class (write-only).
 */
public class LockerCodeManagement {

    static class Locker {
        private String combination;
        private final int lockerNumber;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.combination = initialCode;
        }

        public void changeCode(String currentCode, String newCode) {
            if (!currentCode.equals(combination)) {
                System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code unchanged");
                return;
            }
            combination = newCode;
            System.out.println("l.changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
        }
        // No getter for the combination anywhere - it is write-only
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
