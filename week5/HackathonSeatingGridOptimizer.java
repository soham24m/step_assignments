/**
 * Category C - Problem 4 (Intermediate)
 * Classifies each seating row as "Quiet Zone" or "Buzzing Zone" based on
 * its average score, using one reusable helper method.
 */
public class HackathonSeatingGridOptimizer {

    /**
     * Computes the average of a single row. This is the only place
     * where an average is computed.
     */
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies every row in the (possibly jagged) grid.
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average < threshold) ? "Quiet Zone" : "Buzzing Zone";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };

        System.out.println(classifyRows(seatingScores, 60));
    }
}
