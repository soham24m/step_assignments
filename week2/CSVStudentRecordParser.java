/**
 * Day 2 Live-Coding Session - Problem 2
 * T&P team CSV parser: splits a CSV line into fields and prints a record.
 */
public class CSVStudentRecordParser {

    /**
     * Parses a CSV line of the form "Name,RollNumber,Department" and
     * prints a formatted record, or "Invalid Record" if malformed.
     */
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
