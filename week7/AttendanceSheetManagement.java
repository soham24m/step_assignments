/**
 * Category C - Problem 5: The Attendance Sheet
 * Stores present students internally but only reveals a count and a
 * yes/no lookup - never the full list.
 */
public class AttendanceSheetManagement {

    static class AttendanceSheet {
        private final String[] presentStudents;
        private int count = 0;

        public AttendanceSheet(int maxClassSize) {
            this.presentStudents = new String[maxClassSize];
        }

        public void markPresent(String name) {
            if (isPresent(name)) {
                return; // avoid counting the same student twice
            }
            if (count < presentStudents.length) {
                presentStudents[count] = name;
                count++;
            }
        }

        public int getPresentCount() {
            return count;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
        // No method returns the full presentStudents array
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
