package other;

public class Recursion {

    public static int findFactorial(int number) {
        if (number == 1)
            return number;
        return number * findFactorial(number - 1);
    }

    public static int findFactorialWithoutRecursion(int number) {
        if (number <= 2)
            return number;

        int counter = number;
        for (int i = 2; i < number; i++) {
            counter *= i;
        }
        return counter;
    }

    public static int findSumOfArray(int[] array) {
        if (array.length == 1)
            return array[0];
        return array[0] + findSumOfArray(removeFirstElementFromArray(array));
    }

    private static int[] removeFirstElementFromArray(int[] array) {
        if (array.length < 2)
            return array;

        int[] result = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            result[i - 1] = array[i];
        }
        return result;
    }
}
