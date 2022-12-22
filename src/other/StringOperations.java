package other;

public class StringOperations {

    public static String reverseString(String string) {
        String result = "";

        for (int i = string.length() - 1; i >= 0; i--)
            result += string.charAt(i);

        return result;
    }
}
