package sort;

public class BubbleSort {

    //O = n2
    public static int[] run(int[] array) {
        int[] tempArray = array;
//        boolean needSwap = true;
//        int i = 0;
        for (int j = 0; j < tempArray.length; j++) {
            for (int k = j + 1; k < tempArray.length; k++) {
                if (tempArray[j] > tempArray[k]) {
                    int temp = tempArray[k];
                    tempArray[k] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }
//        for (int i = 0; i < tempArray.length; i++) {
//            for (int j = 1; j < (tempArray.length - i); j++) {
//                if (tempArray[j - 1] > tempArray[j]) {
//                    int temp = tempArray[j - 1];
//                    tempArray[j - 1] = tempArray[j];
//                    tempArray[j] = temp;
//                }
//
//            }
//        }
//        while (i < array.length - 1 && needSwap) {
//            needSwap = false;
//            for (int j = 1; j < tempArray.length - i; j++) {
//                if (tempArray[j - 1] > tempArray[j]) {
//                    int temp = tempArray[j];
//                    tempArray[j] = tempArray[j - 1];
//                    tempArray[j - 1] = temp;
//                    needSwap = true;
//                }
//            }
//            i++;
//        }
        return tempArray;



    }
}
