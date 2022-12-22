package sort;

public class QuickSort {

    //O = n * Log(n)
    public static void run(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            //сортировка левой части массива
            run(arr, begin, partitionIndex - 1);
            //сортировка правой части массива
            run(arr, partitionIndex + 1, end);
        }
    }

    //поиск опорного элемента и разделение массива на большие и меньшие числа чем опорный элемент
    private static int partition(int[] arr, int begin, int end) {
        //берется конечный элемент
        int pivot = arr[end];
        //начало с -1 (текущий индекс элемента большего чем опорный)
        int i = (begin - 1);

        //каждый элемент сравнивается с опорным индексом
        for (int j = begin; j < end; j++) {
            //если j элемент меньше опорного, то он меняется местами с элементом i который больше опорного
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        //текущий индекс большего элемента чем опорный (меняются местами с опорным)
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        //возвращется индекс опорного элемента
        return i + 1;
    }
}
