@FunctionalInterface
interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}

class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate predicate) {
        return predicate.isBetter(s1, s2) ? s1 : s2;
    }
}

public class Lamb1 {
    public static void main(String[] args) {
        String string1 = "Apple";
        String string2 = "Banana";

        // Prefer the longer string
        String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longer);

        // Prefer the smaller string
        String smaller = StringUtils.betterString(string1, string2, (s1, s2) -> s1.compareTo(s2) < 0);
        System.out.println("Smaller string: " + smaller);
    }
}

