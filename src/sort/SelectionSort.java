package sort;

public class SelectionSort {

    //O = n^2
    public static String[] run(String[] strings) {
        String[] result = new String[strings.length];
        int counter = 0;
        String longestString = strings[0];

        for (int i = 0; i < strings.length; i++) {
            int longestStringIndex = 0;
            for (int j = 0; j < strings.length; j++) {
                if (strings[j] != null && counter < strings[j].length()) {
                    longestString = strings[j];
                    counter = strings[j].length();
                    longestStringIndex = j;
                }
            }
            counter = 0;
            strings[longestStringIndex] = null;
            result[i] = longestString;
        }
        return result;
    }
}
