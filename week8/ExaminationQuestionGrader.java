import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Category C - Problem 4: Examination Question Grader. */
public class ExaminationQuestionGrader {
    private static final Pattern QUESTION = Pattern.compile(
            "^\\s*(\\S+)\\s+\\\"(.*?)\\\"\\s+\\\"(.*?)\\\"\\s+\\\"(.*?)\\\"\\s+(\\d+)\\s*$");

    interface Question {
        double score();
        String type();
    }
    static class ObjectiveQuestion implements Question {
        private final String type, correct, answer;
        private final double points;
        ObjectiveQuestion(String type, String correct, String answer, double points) {
            this.type = type; this.correct = correct; this.answer = answer; this.points = points;
        }
        public double score() { return correct.equals(answer) ? points : 0; }
        public String type() { return type; }
    }
    static class EssayQuestion implements Question {
        private final String correctKeywords, answer;
        private final double points;
        EssayQuestion(String correctKeywords, String answer, double points) {
            this.correctKeywords = correctKeywords; this.answer = answer; this.points = points;
        }
        public double score() {
            String lowerAnswer = answer.toLowerCase(Locale.ROOT);
            int found = 0;
            for (String keyword : correctKeywords.split(",")) {
                String cleaned = keyword.trim().toLowerCase(Locale.ROOT);
                if (!cleaned.isEmpty() && lowerAnswer.contains(cleaned)) found++;
            }
            if (found >= 2) return points * .75;
            if (found == 1) return points * .50;
            return 0;
        }
        public String type() { return "ESSAY"; }
    }

    private static Question parseQuestion(String line) {
        Matcher m = QUESTION.matcher(line);
        if (!m.matches()) throw new IllegalArgumentException("Invalid question line: " + line);
        String type = m.group(1).toUpperCase(Locale.ROOT);
        double points = Double.parseDouble(m.group(5));
        if (type.equals("ESSAY")) return new EssayQuestion(m.group(3), m.group(4), points);
        if (type.equals("MCQ") || type.equals("TF")) return new ObjectiveQuestion(type, m.group(3), m.group(4), points);
        throw new IllegalArgumentException("Unknown question type: " + type);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) questions.add(parseQuestion(in.nextLine()));
        double total = 0;
        for (Question question : questions) {
            double score = question.score();
            System.out.printf(Locale.US, "%s: %.2f%n", question.type(), score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
