import java.util.function.Predicate;

public class Lamb2 {
    public static boolean isAlphabetic(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }

    public static void main(String[] args) {
        String input1 = "HelloWorld";
        String input2 = "Hello123";

        Predicate<String> isAlphabetic = s -> {
            for (char ch : s.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    return false;
                }
            }
            return true;
        };

        System.out.println("Is input1 alphabetic? " + isAlphabetic(input1, isAlphabetic));
        System.out.println("Is input2 alphabetic? " + isAlphabetic(input2, isAlphabetic));
    }
}

