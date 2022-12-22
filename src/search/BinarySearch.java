package search;

public class BinarySearch {

    //O = Log(n)
    public static int run(int[] array, int searchKey) {
        int bottomIndex = 0;
        int topIndex = array.length - 1;

        while (bottomIndex <= topIndex) {
            int middleIndex = (bottomIndex + topIndex) / 2;
            int middleValue = array[middleIndex];

            if (middleValue < searchKey)
                bottomIndex = middleIndex + 1;
            else if (middleValue > searchKey)
                topIndex = middleIndex - 1;
            else
                return middleIndex;
        }
        return -(bottomIndex + 1);
    }
}
