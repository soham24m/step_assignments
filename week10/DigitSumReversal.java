import java.util.Scanner;

/** Category C - Problem 5: Digit Sum and Number Reversal. */
public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long sum = 0, reverse = 0;
        while (n > 0) {
            long digit = n % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }
}
