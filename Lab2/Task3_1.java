import java.util.regex.*;

public class Task3_1 {

    public static int countWithSplit(String text, String target) {
        String[] words = text.split("[ .]");
        int occurrences = 0;

        for (String word : words) {
            if (target.equals(word)) {
                occurrences++;
            }
        }

        return occurrences;
    }

    public static int countWithIndexOf(String text, String target) {
        int occurrences = 0;
        int position = 0;

        while ((position = text.indexOf(target, position)) != -1) {
            occurrences++;
            position += target.length();
        }

        return occurrences;
    }

    public static int countWithRegex(String text, String target) {
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(target) + "\\b");
        Matcher matcher = pattern.matcher(text);

        int occurrences = 0;
        while (matcher.find()) {
            occurrences++;
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "this is ITI test for ITI ITI.";
        String word = "ITI";

        // Count and display the occurrences using each method
        System.out.println("Occurrences using indexOf: " + countWithIndexOf(text, word));
        System.out.println("Occurrences using split: " + countWithSplit(text, word));
        System.out.println("Occurrences using regex: " + countWithRegex(text, word));
    }
}

