import java.util.Arrays;
import java.util.Scanner;

/** Category C - Problem 4: In-Place Array Reversal using two pointers. Input like: [11, 22, 33, 44] */
public class InPlaceArrayReversal {
    static void reverse(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().replaceAll("[\\[\\],]", " ").trim();
        int[] a = line.isEmpty() ? new int[0]
                : Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        reverse(a);
        System.out.println(Arrays.toString(a));
    }
}
