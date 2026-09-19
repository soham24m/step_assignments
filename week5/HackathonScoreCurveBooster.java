import java.util.Arrays;

/**
 * Category C - Problem 1 (Easy)
 * Boosts every score in the caller's array in place.
 */
public class HackathonScoreCurveBooster {

    /**
     * Adds {@code bonus} to every score directly inside the caller's array.
     * Modifies the array in place; returns nothing.
     */
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
    }
}
