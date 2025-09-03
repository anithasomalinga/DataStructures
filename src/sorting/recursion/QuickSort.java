package sorting.recursion;

import java.util.Arrays;

// Divide and conquer algorithm
// Pick a pivot
// Time Complexity n*log n
// Space complexity o(n)
public class QuickSort {
    public static void main(String[] args) {
        final int[] inputArray = {13, 46, 24, 52, 20, 9};
        quickSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void quickSort(int[] inputArray, int low, int high) {
        if (low < high) {
            int pIdx = partition(inputArray, low, high);
            quickSort(inputArray, low, pIdx - 1);
            quickSort(inputArray, pIdx + 1, high);
        }
    }

    private static int partition(int[] inputArray, int low, int high) {
        int pivot = inputArray[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (inputArray[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (inputArray[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }
        int temp = inputArray[low];
        inputArray[low] = inputArray[j];
        inputArray[j] = temp;
        return j;
    }
}
