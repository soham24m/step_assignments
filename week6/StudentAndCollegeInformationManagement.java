/**
 * Category C - M5: Student and College Information Management
 * Fixes a design where every student object wastefully carried its own
 * copy of the college name, by using static fields shared across all
 * instances.
 */
public class StudentAndCollegeInformationManagement {

    static class Student {
        private String name;
        private int attendance;

        private static final String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        // Must not reference any instance field
        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 85);

        Student.printCollegeInfo();
    }
}
