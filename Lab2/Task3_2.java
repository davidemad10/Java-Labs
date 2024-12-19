import java.util.StringTokenizer;

class Task3_2 {
    public static int countOccurencesUsingStringTokenizer(String word, String sentence)
    {
        int count = 0;

        StringTokenizer tokenizer = new StringTokenizer(sentence, " .,;!?");

        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equals(word)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String sentence = "ITI develops people and ITI house of developers and ITI for people";
        String word = "ITI";
        int count = countOccurencesUsingStringTokenizer(word,sentence);
        System.out.println("The word '" + word + "' occurs " + count + " times.");
    }
}
