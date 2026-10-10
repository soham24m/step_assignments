import java.math.BigInteger;
import java.util.Scanner;

/** Category C - Problem 7: Factorial Calculation (BigInteger avoids overflow for large n). */
public class FactorialCalculation {
    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE; // 0! = 1
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(factorial(in.nextInt()));
        }
    }
}
