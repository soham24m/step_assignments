import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Category C - Problem 5 (Advanced)
 * Topics Integrated: Arrays, Method Overloading, Static Methods,
 * Arrays.sort, Constructors & Encapsulation.
 *
 * Decides eligibility for a placement drive and ranks shortlisted
 * candidates by a composite score.
 */
public class PlacementDriveRankingEngine {

    /**
     * A candidate for the placement drive. Implements Comparable so that
     * Arrays.sort(...) alone can rank a shortlisted array by composite
     * score, descending.
     */
    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;
        private final double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            // Composite score weights CGPA (x10) and coding test (x0.5)
            this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Descending order by composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    /** CGPA-only quick filter: a strong CGPA alone is enough. */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Combined filter for borderline CGPA candidates: a genuinely good
     * coding-test score can still qualify them.
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && cgpa < 7.5 && codingScore >= 60;
    }

    /**
     * Shortlists eligible candidates and ranks them by composite score,
     * descending, using Arrays.sort(...) alone.
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ")
                  .append(shortlistedArray[i].name)
                  .append(" (").append(shortlistedArray[i].getCompositeScore()).append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
