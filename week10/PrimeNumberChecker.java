import java.util.Scanner;

/** Category C - Problem 6: Prime Number Checker (trial division up to sqrt(n)). */
public class PrimeNumberChecker {
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long n = in.nextLong();
            System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
        }
    }
}
