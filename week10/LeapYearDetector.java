import java.util.Scanner;

/** Category C - Problem 9: Leap Year Detector. */
public class LeapYearDetector {
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(isLeap(in.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }
}
