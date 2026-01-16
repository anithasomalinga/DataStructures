package sorting.recursion;

import java.util.Arrays;

public class QuickSort_Try1 {
    public static void main(String[] args) {
        int[] arr = new int[] {9, 8, 7, 6, 5, 4, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIdx = qs(arr, low, high);
            if ((pIdx - 1) >= 0 && (pIdx - 1) <= (high))
                quickSort(arr, low, pIdx - 1);
            if ((pIdx + 1) >= 0 && (pIdx + 1) <= (high))
                quickSort(arr, (pIdx + 1), high);
        }
    }

    private static int qs(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i <= (high - 1)) {
                i++;
            }
            while (arr[j] > pivot && j >= (low + 1)) {
                // 9 13 10 21 78
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
