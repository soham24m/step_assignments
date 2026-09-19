/**
 * Category C - Problem 2: The Quiz Scorecard
 * Stores each answer's result privately, revealing only the final score.
 */
public class QuizScorecardManagement {

    static class Scorecard {
        private final boolean[] results;
        private final int totalQuestions;
        private int answered = 0;

        public Scorecard(int totalQuestions) {
            this.totalQuestions = totalQuestions;
            this.results = new boolean[totalQuestions];
        }

        public void recordAnswer(boolean correct) {
            if (answered < totalQuestions) {
                results[answered] = correct;
                answered++;
            }
            // Extra answers beyond the fixed question count are ignored
        }

        // Only the total score is exposed - never the raw array
        public int getScore() {
            int score = 0;
            for (int i = 0; i < answered; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}
