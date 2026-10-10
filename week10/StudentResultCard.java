import java.util.Locale;
import java.util.Scanner;

/** Category C - Problem 10: Student Result Card Generator. Input lines like: Asha [80, 90, 70] */
public class StudentResultCard {
    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) { this.name = name; this.marks = marks; }

        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return marks.length == 0 ? 0 : (double) sum / marks.length;
        }

        // B: >= 75, C: 60-74, D: 40-59, F: below 40 (as per the specified rules; C and F chosen by design)
        char grade() {
            double avg = average();
            if (avg >= 75) return 'B';
            else if (avg >= 60) return 'C';
            else if (avg >= 40) return 'D';
            else return 'F';
        }

        void print() {
            System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) continue;
            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());
            new Student(name, marks).print();
        }
    }
}
