import graph.DijkstraSearch;
import other.Recursion;
import other.StringOperations;
import search.BinarySearch;
import graph.BreadthSearch;
import sort.BubbleSort;
import sort.QuickSort;
import sort.SelectionSort;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) {
        int[] sortedArray = {1, 5, 12, 34, 55, 68, 82, 99, 112};
        int[] unsortedArray = {3, 5, 7, 1, 20, 9, 6, 14, 6};
        String[] strings = {"Test1", "Test222", "Test44", "Test5555", "Test0"};
        String string = "Algorithm";

        //String
        System.out.println("String reverse of \"" + string + "\" result: " + StringOperations.reverseString(string));

        //Binary (sorted)
        System.out.println("Binary Search result: " + BinarySearch.run(sortedArray, 5));

        //Selection
        System.out.println("Selection Sort result: " + Arrays.toString(SelectionSort.run(strings)));

        //Bubble
        System.out.println("Bubble Sort result: " + Arrays.toString(BubbleSort.run(unsortedArray)));

        //Recursion
        System.out.println("Recursion Factorial result: " + Recursion.findFactorial(6));
        System.out.println("Factorial result: " + Recursion.findFactorialWithoutRecursion(5));
        System.out.println("Array Sum Recursion result: " + Recursion.findSumOfArray(sortedArray));

        //Quick (unsorted)
        QuickSort.run(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("Quick Sort result: " + Arrays.toString(unsortedArray));

        //Graph
        System.out.println("Graph Breadth Search result: " + BreadthSearch.run("END"));
        System.out.println("Graph Dijkstra Search result: " + DijkstraSearch.run("END"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8, 8};
        calc(arr);
        calc2("dsfsdsdfsfdsffsffsdfsdfsfsdsdsd", "sd");

        //TODO MergeSort
        //TODO TimSort
    }

     public static Set<Integer> calc(int[] arr) {
        Set<Integer> result = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(arr).forEach(el -> map.merge(el, 1, Integer::sum));
        Arrays.stream(arr).forEach(el -> {
            Integer integer = el * 2;
            if (map.containsKey(integer) && map.get(integer) == 1)
                result.add(el);
        });
         System.out.println(result);
        return result;
     }

    public static int calc2(String string, String seq) {
        int result = 0;
        Pattern pattern = Pattern.compile("(" + seq + "){2,}");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find())
            result += matcher.group().length() / seq.length();
        System.out.println(result);
        return result;
    }
}