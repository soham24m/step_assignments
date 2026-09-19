/**
 * Category C - M3: Course Credit Management
 * Supports courses with or without a lab component without duplicating
 * setup logic, using constructor chaining via this(...).
 */
public class CourseCreditManagement {

    static class Course {
        private final String code;
        private final String title;
        private final int credits;
        private final int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Theory-only constructor chains to the four-argument constructor
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }

        public String getCode() {
            return code;
        }
    }

    public static void main(String[] args) {
        Course theoryOnly = new Course("21CSC201J", "Data Structures", 4);
        Course withLab = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryOnly.getCode() + " total credits: " + theoryOnly.totalCredits());
        System.out.println(withLab.getCode() + " total credits: " + withLab.totalCredits());
    }
}
