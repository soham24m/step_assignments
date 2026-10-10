import java.util.Scanner;

/** Category C - Problem 3: Even and Odd Numbers in a List. Input like: [3, 8, 12, 5, 7, 10] */
public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().replaceAll("[\\[\\],]", " ").trim();
        int even = 0, odd = 0;
        if (!line.isEmpty()) {
            for (String token : line.split("\\s+")) {
                int num = Integer.parseInt(token);
                if (num % 2 == 0) even++; else odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
